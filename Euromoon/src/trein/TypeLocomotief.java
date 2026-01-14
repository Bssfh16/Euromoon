package trein;

/** Deze Enum bevat de beschikbare types locomotieven voor de treinen.
 * Elk type bepaalt de maximale passagierscapaciteit en het maximaal aantal wagons.
 * @author Hisham Boussof
 */

public enum TypeLocomotief {
    CLASS_373(12, 80),
    CLASS_374(14, 80);

    private final int maxWagons;
    private final int locomotiefCapaciteit;

    TypeLocomotief(int maxWagons, int locomotiefCapaciteit) {
        this.maxWagons = maxWagons;
        this.locomotiefCapaciteit =locomotiefCapaciteit;
    }

    public int getMaxWagons() {
        return maxWagons;
    }

    public int getLocomotiefCapaciteit() {
        return locomotiefCapaciteit;
    }
}
