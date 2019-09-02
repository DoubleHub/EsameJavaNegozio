package it.poliba.esamenegozio.exceptions;

import it.poliba.esamenegozio.Articolo;
import it.poliba.esamenegozio.Venditore;

public class ArticleNotFoundException extends Exception {

    public ArticleNotFoundException(Venditore venditore, String nomeArticolo) {
        super(venditore.getInfo() + " non può vendere l'articolo '" + nomeArticolo + "' perché il suo direttore non lo possiede!");
    }

}
