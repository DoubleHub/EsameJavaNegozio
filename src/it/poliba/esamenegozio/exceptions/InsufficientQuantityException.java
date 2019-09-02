package it.poliba.esamenegozio.exceptions;

import it.poliba.esamenegozio.Articolo;
import it.poliba.esamenegozio.Venditore;

public class InsufficientQuantityException extends Exception {

    public InsufficientQuantityException(Venditore venditore, Articolo articolo) {
        super(venditore.getInfo() + " non può vendere l'articolo '" + articolo.getNome() + "' per mancanza di disponibilità!");
    }

}
