package it.poliba.esamenegozio;

import it.poliba.esamenegozio.exceptions.ArticleNotFoundException;
import it.poliba.esamenegozio.exceptions.InsufficientBudgetException;
import it.poliba.esamenegozio.exceptions.InsufficientQuantityException;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            System.out.println("[SIMULAZIONE NEGOZIO DI ARTICOLI ELETTRONICI - Esame 02/09/2019]");

            Manager manager_Claudio = new Manager("Claudio", "Rossi");
            manager_Claudio.caricaInventarioDaFile("inventari/inventario_claudio.txt");

            Manager manager_Eligio = new Manager("Eligio", "Mansi");
            manager_Eligio.caricaInventarioDaFile("inventari/inventario_eligio.txt");

            Manager manager_Riccardo = new Manager("Riccardo", "Mondi");
            manager_Riccardo.caricaInventarioDaFile("inventari/inventario_riccardo.txt");

            Venditore seller_Flavio = new Venditore("Flavio", "Conversano", manager_Claudio);
            Venditore seller_Emanuele = new Venditore("Emanuele", "Scarcelli", manager_Claudio);

            Venditore seller_Margherita = new Venditore("Margherita", "Conversano", manager_Eligio);

            Venditore seller_Luigi = new Venditore("Luigi", "Di Bari", manager_Riccardo);
            Venditore seller_Carmine = new Venditore("Carmine", "Losito", manager_Riccardo);

            Cliente client_Francesco = new Cliente("Francesco", "Bruno", 800);
            Cliente client_Giovanni = new Cliente("Giovanni", "Genga", 500);
            Cliente client_Stefania = new Cliente("Stefania", "Di Francesco", 300);

            client_Francesco.compraArticolo("PC Fisso", seller_Flavio);
            client_Francesco.compraArticolo("Cavo VGA", seller_Emanuele);

            client_Giovanni.compraArticolo("Scheda Video", seller_Flavio);
            client_Giovanni.compraArticolo("Cavo HDMI", seller_Margherita);

            client_Stefania.compraArticolo("Scheda Madre", seller_Luigi);
            client_Stefania.compraArticolo("Cavo SATA", seller_Carmine);

            manager_Claudio.stampaIncassiSuFile("incassi_claudio.txt");
            manager_Eligio.stampaIncassiSuFile("incassi_eligio.txt");
            manager_Riccardo.stampaIncassiSuFile("incassi_riccardo.txt");

            // STAMPA STATO FINALE
            System.out.println(manager_Claudio.getInfo());
            System.out.println(manager_Eligio.getInfo());
            System.out.println(manager_Riccardo.getInfo());

            System.out.println(seller_Flavio.getInfo());
            System.out.println(seller_Emanuele.getInfo());
            System.out.println(seller_Margherita.getInfo());
            System.out.println(seller_Luigi.getInfo());
            System.out.println(seller_Carmine.getInfo());

            System.out.println(client_Francesco.getInfo());
            System.out.println(client_Giovanni.getInfo());
            System.out.println(client_Stefania.getInfo());
        } catch (IOException e) {
            System.err.println("IOException during inventory load from file!");
            e.printStackTrace();
        } catch (InsufficientBudgetException | ArticleNotFoundException | InsufficientQuantityException e) {
            System.err.println(e.getMessage());
        }
    }

}
