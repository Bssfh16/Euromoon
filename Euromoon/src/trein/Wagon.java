package trein;

/** Deze klasse geeft een individuele wagon weer die aan een trein gekoppeld kan worden.
 * Elke wagon heeft zijn eigen aantal zitplaatsen om te resulteren in de maximale capaciteit van de trein.
 * @author Hisham Boussof
 */

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
