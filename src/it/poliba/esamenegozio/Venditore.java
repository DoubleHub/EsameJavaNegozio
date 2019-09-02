package it.poliba.esamenegozio;

import it.poliba.esamenegozio.exceptions.ArticleNotFoundException;
import it.poliba.esamenegozio.exceptions.InsufficientQuantityException;

public class Venditore extends Persona {

    private Manager direttoreAssociato;
    private float incasso = 0;

    public Venditore(String nome, String cognome, Manager direttoreAssociato) {
        super(nome, cognome);
        this.direttoreAssociato = direttoreAssociato;
        this.direttoreAssociato.aggiungiVenditore(this);
    }

    public void vendiArticolo(Articolo articolo) throws ArticleNotFoundException, InsufficientQuantityException {
        Articolo articoloDaVendere = direttoreAssociato.getArticoloByNome(articolo.getNome())
            .orElseThrow(() -> new ArticleNotFoundException(this, articolo.getNome()));

        if (articoloDaVendere.getDisponibilita() <= 0) {
            throw new InsufficientQuantityException(this, articolo);
        }

        incasso += articoloDaVendere.getCosto();
        direttoreAssociato.rimuoviArticolo(articolo);
    }

    public Manager getDirettoreAssociato() {
        return direttoreAssociato;
    }

    public float getIncasso() {
        return incasso;
    }

    @Override
    public String getInfo() {
        return "[SELLER] " + getNome() + " " + getCognome() + " | Incasso totale = " + getIncasso() + " euro";
    }

}
