package personen;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;


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

    public static void registreerPassagier() {
        System.out.println("Passagier registreren: ");

        System.out.print("Voornaam: ");
        String voornaam = scanner.nextLine();

        System.out.print("Achternaam: ");
        String achternaam = scanner.nextLine();

        System.out.print("Rijksregisternummer: ");
        String rijksregisternummer = scanner.nextLine();

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
