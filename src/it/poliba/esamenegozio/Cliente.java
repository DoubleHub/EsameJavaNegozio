package it.poliba.esamenegozio;

import it.poliba.esamenegozio.exceptions.ArticleNotFoundException;
import it.poliba.esamenegozio.exceptions.InsufficientBudgetException;
import it.poliba.esamenegozio.exceptions.InsufficientQuantityException;

public class Cliente extends Persona {

    private float budget;

    public Cliente(String nome, String cognome, int budget) {
        super(nome, cognome);
        this.budget = budget;
    }

    public void compraArticolo(String nomeArticolo, Venditore venditore) {
        try {
            compraArticolo(
                venditore.getDirettoreAssociato().getArticoloByNome(nomeArticolo)
                    .orElseThrow(() -> new ArticleNotFoundException(venditore, nomeArticolo)),
                venditore
            );
        } catch (InsufficientBudgetException | ArticleNotFoundException | InsufficientQuantityException e) {
            System.err.println(e.getMessage());
        }
    }

    public void compraArticolo(Articolo articolo, Venditore venditore)
        throws InsufficientBudgetException, InsufficientQuantityException, ArticleNotFoundException
    {
        if (budget < articolo.getCosto()) {
            throw new InsufficientBudgetException(this, articolo);
        }

        venditore.vendiArticolo(articolo);
        budget -= articolo.getCosto();
    }

    public float getBudget() {
        return budget;
    }

    public void setBudget(float budget) {
        this.budget = budget;
    }

    @Override
    public String getInfo() {
        return "[CLIENT] " + getNome() + " " + getCognome() + " | Budget = " + getBudget() + " euro";
    }

}
