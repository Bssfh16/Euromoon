package trein;

public class Wagon {
    private String klasse;
    private int aantalStoelen;
    private int capaciteit;

    /*public Wagon(String klasse, int aantalStoelen) {
        this.klasse = klasse;
        this.aantalStoelen = aantalStoelen;
    } */

    public Wagon(int capaciteit) {
        this.capaciteit = capaciteit;
    }

    /* public String getKlasse() {
        return klasse;
    } */

    public int getAantalStoelen() {
        return aantalStoelen;
    }

//    public int getCapaciteit() {
//        return capaciteit;
//    }

    @Override
    public String toString() {
        return "Wagon, klasse:  " + klasse + ", aantalStoelen: " + aantalStoelen;
    }
}
