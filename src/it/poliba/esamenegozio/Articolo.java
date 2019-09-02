package it.poliba.esamenegozio;

public class Articolo {

    private String nome;
    private float costo;
    private int disponibilita;
    private Tipo tipo;

    public Articolo(String nome, float costo, int disponibilita, Tipo tipo) {
        this.nome = nome;
        this.costo = costo;
        this.disponibilita = disponibilita;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public int getDisponibilita() {
        return disponibilita;
    }

    public void setDisponibilita(int disponibilita) {
        this.disponibilita = disponibilita;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public enum Tipo {
        PICCOLO, MEDIO, GRANDE
    }

    public static Tipo strToType(String type) throws IllegalArgumentException {
        switch (type) {
            case "PICCOLO": return Tipo.PICCOLO;
            case "MEDIO": return Tipo.MEDIO;
            case "GRANDE": return Tipo.GRANDE;
            default: throw new IllegalArgumentException("Il tipo '" + type + "' non è PICCOLO, MEDIO, o GRANDE!");
        }
    }

}
