package reis;

import main.Euromoon;
import personen.Conducteur;
import personen.Passagier;
import personen.Steward;
import ticket.Ticket;
import trein.Trein;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Reis {

    private static int reisOpteller = 0;
    private final int reisID;

    private String vertrekStation;
    private String aankomstStation;
    private LocalDateTime vertrekTijd;

    private Trein trein;
    private Conducteur conducteur;
    private ArrayList<Steward> stewards;

    private static ArrayList<Reis> reizen = new ArrayList<>();
    public static ArrayList<Reis> getReizen() {
        return reizen;
    }

    private static Scanner scanner = new Scanner(System.in);

    public Reis(String vertrekStation, String aankomstStation, LocalDateTime vertrekTijd) {
        this.reisID = ++reisOpteller;
        this.vertrekStation = vertrekStation;
        this.aankomstStation = aankomstStation;
        this.vertrekTijd = vertrekTijd;
        this.stewards = new ArrayList<>();
    }

    public void setTrein(Trein trein) {
        this.trein = trein;
    }

    public void setConducteur(Conducteur conducteur) {
        this.conducteur = conducteur;
    }

    public boolean voegStewardToe(Steward steward) {
        if (!stewards.contains(steward)) {
            stewards.add(steward);
            System.out.println("Steward: "  + steward.getVoornaam() + " " + steward.getAchternaam() + " werd succesvol toegevoegd.");
            return true;
        }
        System.out.println("Er is een fout opgetreden! Probeer opnieuw.");
        return false;
    }

    public boolean gaatVertrekken() {
        return trein != null && conducteur != null && stewards.size() >= 3;
    }

//    public int getReisID() {
//        return reisID;
//    }

    public String getVertrekstation() {
        return vertrekStation;
    }

    public String getAankomststation() {
        return aankomstStation;
    }

    public LocalDateTime getVertrektijd() {
        return vertrekTijd;
    }

    public Trein getTrein() {
        return trein;
    }

//    public Conducteur getConducteur() {
//        return conducteur;
//    }
//
//    public ArrayList<Steward> getStewards() {
//        return stewards;
//    }

    public String getFileName() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm");
        return vertrekStation + " - " + aankomstStation + " " + vertrekTijd.format(formatter) + ".txt";
    }

    @Override
    public String toString() {

        String infoTrein = (trein != null) ? trein.toString() : "Geen trein gekoppeld";
        String infoConducteur = (conducteur != null) ? conducteur.getVoornaam() + " " + conducteur.getAchternaam() : "Geen conducteur toegewezen.";

        return "Informatie over REIS #" + reisID + "\n" +
                "================================" + "\n" +
                "Reistraject: " + vertrekStation + " -> "  + aankomstStation + "\n" +
                "Vertrek: " + vertrekTijd + "\n" +
                "Trein: " + infoTrein + "\n" +
                "Conducteur: " + infoConducteur + "\n" +
                "Stewards: " + stewards + "\n" +
                "Status: " + (gaatVertrekken() ? "Volzet" : "Niet Volzet");

    }


    public static void maakReis() {
        System.out.println("Reis aanmaken");

        System.out.print("Vertrekstation: ");
        String vertrek = scanner.nextLine();

        System.out.print("Aankomststation: ");
        String aankomst = scanner.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm");

        LocalDateTime vertrekTijd = null;
        while (vertrekTijd == null) {
            System.out.print("Vertrektijd: (yyyy-MM-dd_HH-mm)");
            String tijdStr = scanner.nextLine();
            try {
                vertrekTijd = LocalDateTime.parse(tijdStr, formatter);
            } catch (DateTimeParseException e) {
                System.err.println("Ongeldige datum/tijd. Gebruik formaat yyyy-MM-dd_HH-mm");
            }
        }

        Reis reis = new Reis(vertrek, aankomst, vertrekTijd);
        reizen.add(reis);
        System.out.println("Reis succesvol aangemaakt");
    }



    public static void koppelTreinenAanReis() {
        System.out.println("Trein aan een reis koppelen");

        if (reizen.isEmpty()) {
            System.out.println("Geen reizen beschikbaar. Maak eerst een reis aan.");
            return;
        }

        System.out.println("Beschikbare reizen");
        for (int i = 0; i < reizen.size(); i++) {
            System.out.println((i +1) + ". " + reizen.get(i));
        }

        int reisIndex = Euromoon.getIntInput("Kies reisnummer") -1;
        if (reisIndex < 0 || reisIndex >= reizen.size()) {
            System.err.println("Ongeldige reis");
            return;
        }

        Reis reis = reizen.get(reisIndex);

        System.out.println("Beschikbare treinen");
        if (Trein.getTreinen().isEmpty()) {
            System.out.println("Geen treinen beschikbaar. Maak eerst een trein.");
            System.out.print("Wil je een train aanmaken? (j/n): ");
            String antwoord = scanner.nextLine();
            if (antwoord.equalsIgnoreCase("j")) {
                Trein newtrein  = Trein.maakTreinAan();
                if (newtrein != null) {
                    Trein.getTreinen().add(newtrein);
                } else {
                    return;
                }
            } else {
                return;
            }
        }

        for (int i = 0; i < Trein.getTreinen().size(); i++) {
            System.out.println((i + 1) + ". " + Trein.getTreinen().get(i));
        }

        int treinIndex = Euromoon.getIntInput("Kies treinnummer: ") -1;
        if (treinIndex < 0 || treinIndex >= Trein.getTreinen().size()) {
            System.err.println("Ongeldige trein");
            return;
        }

        Trein trein = Trein.getTreinen().get(treinIndex);
        reis.setTrein(trein);

        System.out.println("Trein succesvol aan reis gekoppeld");
    }


    public static void drukBoardinglijstAf() {
        System.out.println("Boardinglijst aanmaken");

        if (reizen.isEmpty()) {
            System.out.println("Geen reis beschikbaar! Maak een reis aan.");
            return;
        }

        System.out.println("Beschikbare reizen");
        for (int i = 0; i < reizen.size(); i++) {
            System.out.println((i + 1) + ". " + reizen.get(i).getVertrekstation() +
                    " -> " + reizen.get(i).getAankomststation() +
                    " op " + reizen.get(i).getVertrekstation());
        }

        int reisIndex = Euromoon.getIntInput("Kies een reisnummer: ") - 1;
        if (reisIndex < 0 || reisIndex >= reizen.size()) {
            System.err.println("Ongeldige reis");
            return;
        }

        Reis reis = reizen.get(reisIndex);
        ArrayList<Ticket> reistickets = new ArrayList<Ticket>();

        for (Ticket ticket : Ticket.getTickets()) {
            if (ticket.getReis().equals(reis)) {
                reistickets.add(ticket);
            }
        }

        if (reistickets.isEmpty()) {
            System.err.println("Geen tickets verkocht voor deze reis.");
            return;
        }

        String filename = reis.getFileName();

        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("==================================" + "\n");
            writer.write("Boardinglijst Euromoon" + "\n");
            writer.write("==================================" + "\n");
            writer.write("Reis: " + reis.getVertrekstation() + " -> " + reis.getAankomststation() + "\n");
            writer.write("Vertrektijd: " + reis.getVertrektijd() + "\n");
            writer.write("Aantal passagiers: " + reistickets.size() + "\n");
            writer.write("==================================" + "\n");
            writer.write("Passagierslijst" + "\n");
            writer.write("==================================" + "\n");

            for (Ticket ticket : reistickets) {
                Passagier p = ticket.getPassagier();
                writer.write("Ticket #" + ticket.getTicketId() + "\n");
                writer.write("Naam: " + p.getVoornaam() + " " + p.getAchternaam() + "\n");
                writer.write("Rijksregisternummer: " + p.getRijksregisternummer() + "\n");
                writer.write("Geboortedatum: " + p.getGeboortedatum() + "\n");
                writer.write("Klasse: " + ticket.getTicketClass() + "\n");
                writer.write("==============================" + "\n");
            }

            System.out.println("Boardinglijst succesvol aangemaakt");
        } catch (IOException e) {
            System.err.println("Fout bij het aanmaken van het bestand: " + e.getMessage());
        }
    }


    public static void bekijkAlleReizen() {
        System.out.println("Alle reizen:");
        if (Trein.getTreinen().isEmpty()) {
            System.out.println("Geen treinen beschikbaar");
        } else {
            for (Trein t : Trein.getTreinen()) {
                System.out.println(t);
            }
        }
    }

}
