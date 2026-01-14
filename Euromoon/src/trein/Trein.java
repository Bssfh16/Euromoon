package trein;

import main.Euromoon;

import java.util.ArrayList;

/** Deze klasse geeft alle onderdelen en specifieke kenmerken van een trein weer.
 * Een trein bestaat uit een locomotief en een groep wagons.
 * De totale passagierscapaciteit kan berekend worden.
 * @author Hisham Boussof
 */

public class Trein {
    private Locomotief locomotief;

    public ArrayList<Wagon> wagons;

    private static ArrayList<Trein> treinen = new ArrayList<>();
    public static ArrayList<Trein> getTreinen() {
        return treinen;
    }

    public Trein(Locomotief locomotief) {
        this.locomotief = locomotief;
        this.wagons = new ArrayList<>();
    }

    /** De methode beneden voegt een wagon toe.
     * @param nieuweWagon Het wagon-object dat aan de locomotief moet worden gekoppeld
     */

    public void voegWagonToe(Wagon nieuweWagon) {
        int maximumWagons = locomotief.getMaxWagons();
        int huidigAantal = wagons.size();

        if (huidigAantal < maximumWagons) {
            wagons.add(nieuweWagon);
            System.out.println("Wagon succesvol toegevoegd. Totaal aantal wagons: " + (huidigAantal + 1));
        } else {
            System.out.println("Wagon niet succesvol toegevoegd. Het maximum aantal wagons bedraagt: " + maximumWagons);
        }
    }

    public int getTotaalCapaciteit() {
        int totaalCapaciteit = locomotief.getPassagiersCapaciteit();

        for (Wagon w : wagons) {
            totaalCapaciteit += w.getAantalStoelen();
        }

        return totaalCapaciteit;
    }

    @Override
    public String toString() {
        return "De trein bestaat uit: " + wagons.size() + " wagons en heeft een maximum aantal stoelen van: " + getTotaalCapaciteit();
    }

    /** De methode juist beneden stelt een trein op door een locomotief te koppelen aan wagons.
     * @return Een nieuw gemaakte trein is klaar om aan een reis gekoppeld te worden.
     */

    public static Trein maakTreinAan() {

        TypeLocomotief locomotiefKeuze = null;

        while (locomotiefKeuze == null) {

            System.out.println("Nieuwe trein aanmaken");
            System.out.println("Kies een type locomotief");
            System.out.println("1. CLASS_373 (max. 12 wagons)");
            System.out.println("2. CLASS_374 (max. 14 wagons)");

            int keuze = Euromoon.getIntInput("Keuze: ");

            if (keuze == 1) {
                locomotiefKeuze = TypeLocomotief.CLASS_373;
            } else if (keuze == 2) {
                locomotiefKeuze = TypeLocomotief.CLASS_374;
            } else {
                System.err.println("Ongeldige keuze");
                return null;
            }
        }

        Locomotief locomotief = new Locomotief(locomotiefKeuze);

        Trein trein = new Trein(locomotief);

        int maxWagons = locomotiefKeuze.getMaxWagons();
        int aantalWagons = -1;

        while (aantalWagons < 0 || aantalWagons > maxWagons) {
            aantalWagons = Euromoon.getIntInput("Hoeveel wagons? Het maximaal aantal is: " +  maxWagons);

            if (aantalWagons > maxWagons) {
                System.out.println("Te veel wagons. Het maximaal aantal is: " + maxWagons);
            }
        }

        for (int i = 0; i < aantalWagons; i++) {
            int capaciteit = -1;
            while (capaciteit <= 0) {
                capaciteit = Euromoon.getIntInput("Capaciteit voor wagon: " + (i + 1) + ": ");
                if (capaciteit <= 0) {
                    System.out.println("Capaciteit moet positief zijn");
                }
            }

            Wagon wagon  = new Wagon(capaciteit);
            trein.voegWagonToe(wagon);
        }

        treinen.add(trein);

        System.out.println("Trein succesvol aangemaakt");
        return trein;
    }

    /** De methode hierbeneden toont een overzicht van alle gevormde treinen in het systeem.
     */

    public static void bekijkAlleTreinen() {
        System.out.println("Alle treinen: ");
        if (treinen.isEmpty()) {
            System.out.println("Geen treinen beschikbaar.");
        } else {
            for (Trein t : treinen) {
                System.out.println(t);
            }
        }
    }
}