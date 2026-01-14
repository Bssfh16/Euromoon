package trein;

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
