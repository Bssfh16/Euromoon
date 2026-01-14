package trein;

public class Wagon {

    private int aantalStoelen;

    public Wagon(int capaciteit) {
        this.aantalStoelen = capaciteit;
    }

    public int getAantalStoelen() {
        return aantalStoelen;
    }

    @Override
    public String toString() {
        return "Aantal stoelen: " + aantalStoelen;
    }
}
