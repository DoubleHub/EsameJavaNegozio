package it.poliba.esamenegozio.exceptions;

import it.poliba.esamenegozio.Articolo;
import it.poliba.esamenegozio.Cliente;

public class InsufficientBudgetException extends Exception {

    public InsufficientBudgetException(Cliente cliente, Articolo articolo) {
        super(cliente.getInfo() + " non può acquistare l'articolo '" + articolo.getNome() + "' per mancanza di fondi!");
    }

}