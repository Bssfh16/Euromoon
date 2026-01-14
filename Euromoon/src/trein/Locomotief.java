package trein;

/** Deze klasse gaat over de locomotief van een Euromoon-trein.
 * De locomotief bepaalt welk type trein het is en hoeveel wagons er maximaal kunnen zijn.
 * @author Hisham Boussof
 */

public class Locomotief {

    private TypeLocomotief typeLocomotief;

    public Locomotief(TypeLocomotief typeLocomotief) {
        this.typeLocomotief = typeLocomotief;
    }

    public int getMaxWagons() {
        return this.typeLocomotief.getMaxWagons();
    }

    public int getPassagiersCapaciteit() {
        return this.typeLocomotief.getLocomotiefCapaciteit();
    }

    @Override
    public String toString() {
        return "Locomotief, type: " + typeLocomotief + ", capaciteit: " + getPassagiersCapaciteit();
    }
}
