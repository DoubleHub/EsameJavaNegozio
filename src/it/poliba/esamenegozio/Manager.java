package it.poliba.esamenegozio;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Manager extends Persona {

    private ArrayList<Venditore> venditoriAssociati = new ArrayList<>();
    private ArrayList<Articolo> inventario = new ArrayList<>();

    public Manager(String nome, String cognome) {
        super(nome, cognome);
    }

    /**
     * FORMATO FILE:
     *
     * NOME_ARTICOLO\tCOSTO_ARTICOLO\tDISPONIBILITA_ARTICOLO\tTIPO_ARTICOLO
     *
     * Ricorda che TIPO_ARTICOLO deve essere PICCOLO, MEDIO o GRANDE se no tira IllegalArgumentException
     */
    public void caricaInventarioDaFile(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        String s = reader.readLine();
        while (s != null) {
            String[] infoArticolo = s.split("\\t+");

            inventario.add(new Articolo(
                infoArticolo[0],
                Float.parseFloat(infoArticolo[1]),
                Integer.parseInt(infoArticolo[2]),
                Articolo.strToType(infoArticolo[3]))
            );

            s = reader.readLine();
        }

        reader.close();
    }

    public void stampaIncassiSuFile(String filePath) throws IOException {
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(filePath)));

        pw.println("{NEGOZIO DI " + getNome() + " " + getCognome() + "}");

        float incassoTotale = 0;
        for (Venditore venditore : venditoriAssociati) {
            incassoTotale += venditore.getIncasso();
        }
        pw.println("Incasso totale: " + incassoTotale + "\n");

        pw.println("[VENDITORI ASSOCIATI ORDINATI PER INCASSO CRESCENTE]");

        ArrayList<Venditore> venditoriOrdinati = venditoriAssociati.stream().sorted(
            (v1, v2) -> Float.compare(v1.getIncasso(), v2.getIncasso())).collect(Collectors.toCollection(ArrayList::new)
        );
        venditoriOrdinati.forEach(venditore -> pw.println(venditore.getInfo()));

        pw.close();
    }

    public Optional<Articolo> getArticoloByNome(String nomeArticolo) {
        return inventario.stream().filter(articolo -> articolo.getNome().equals(nomeArticolo)).findFirst();
    }

    public void rimuoviArticolo(Articolo articolo) {
        inventario.remove(articolo);
    }

    public void aggiungiVenditore(Venditore venditore) {
        venditoriAssociati.add(venditore);
    }

    public void aggiungiVenditori(List<Venditore> venditori) {
        venditori.forEach(this::aggiungiVenditore);
    }

    public ArrayList<Venditore> getVenditoriAssociati() {
        return venditoriAssociati;
    }

    public ArrayList<Articolo> getInventario() {
        return inventario;
    }

    @Override
    public String getInfo() {
        int numVenditoriAssociati = getVenditoriAssociati().size();
        int numArticoli = getInventario().size();

        return "[MANAGER] " + getNome() + " " + getCognome() + " | " +
        numVenditoriAssociati + " venditori associat" + (numVenditoriAssociati == 1 ? "o" : "i") + ", " +
        numArticoli + " articol" + (numArticoli == 1 ? "o" : "i") + " in inventario";
    }

}
