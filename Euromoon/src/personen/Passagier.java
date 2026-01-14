package personen;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

/** Deze klasse beheert de gegevens van alle passagiers van Euromoon.
 * @author Hisham Boussof
 */

public class Passagier extends Persoon{

    private static Scanner scanner = new Scanner(System.in);

    private static ArrayList<Passagier> passagiers = new ArrayList<>();
    public static ArrayList<Passagier> getPassagiers() {
        return passagiers;
    }

    public Passagier(String voornaam, String achternaam, String rijksregisternummer, LocalDate geboortedatum){
        super(voornaam, achternaam, rijksregisternummer, geboortedatum);
    }

    @Override
    public String toString() {
        return "Passagier: " + super.toString();
    }

    /** De methode juist beneden wordt gebruikt om een passagier te registreren.
     * Deze is interactief.
     * Er wordt ook gecontroleerd als er juist 11 cijfers in rijksregisternummer zitten.
     */

    public static void registreerPassagier() {
        System.out.println("Passagier registreren: ");

        System.out.print("Voornaam: ");
        String voornaam = scanner.nextLine();

        System.out.print("Achternaam: ");
        String achternaam = scanner.nextLine();


        String rijksregisternummer = "";
        boolean RRnummer = false;

        while (!RRnummer) {
            System.out.print("Rijksregisternummer: (11 cijfers) ");
            rijksregisternummer = scanner.nextLine();

            if (rijksregisternummer.length() == 11) {
                boolean geldig = true;
                for (int i = 0; i < rijksregisternummer.length(); i++) {
                    if (!Character.isDigit(rijksregisternummer.charAt(i))) {
                        geldig = false;
                        break;
                    }
                }
                if (geldig) {
                    RRnummer = true;
                }  else {
                    System.err.println("Ongeldig. Gebruik alleen maar cijfers, geen letters/streepjes! ");
                }
            } else {
                System.err.println("Ongeldig. Het nummer moet exact 11 cijfers bevatten");
            }
        }

        LocalDate geboortedatum = null;
        while (geboortedatum == null) {
            System.out.print("Geboortedatum: (yyyy-MM-dd)");
            String datumStr = scanner.nextLine();
            try {
                geboortedatum = LocalDate.parse(datumStr);
            } catch (DateTimeParseException e) {
                System.err.println("Ongeldige datum. Gebruik formaat yyyy-MM-dd");
            }
        }

        Passagier passagier = new Passagier(voornaam, achternaam, rijksregisternummer, geboortedatum);
        passagiers.add(passagier);
        System.out.println("Passagier succesvol geregistreerd");
    }

    /** De methode juist beneden toont een overzicht van alle geregistreerde passagiers.
     *  Als de lijst leeg is, verschijnt er een melding in de console.
     */

    public static void bekijkAllePassagiers() {
        System.out.println("Alle passagiers:");
        if (passagiers.isEmpty()) {
            System.out.println("Geen passagiers geregistreerd");
        } else {
            for (Passagier p : passagiers) {
                System.out.println(p);
            }
        }
    }
}
