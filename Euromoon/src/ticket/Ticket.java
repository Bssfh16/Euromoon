package ticket;

import main.Euromoon;
import personen.Passagier;
import reis.Reis;
import trein.Trein;

import java.util.ArrayList;

public class Ticket {
    private static int ticketOpteller = 1;
    private int ticketID;
    private Passagier passagier;
    private Reis reis;
    private String klasseTicket;

    private static ArrayList<Ticket> tickets = new ArrayList<>();
    public static ArrayList<Ticket> getTickets() {
        return tickets;
    }


    public Ticket(Passagier passagier, Reis reis, String klasseTicket) {
        this.ticketID = ticketOpteller++;
        this.passagier = passagier;
        this.reis = reis;
        this.klasseTicket = klasseTicket;
    }

    public int getTicketId() {
        return ticketID;
    }

    public Passagier getPassagier() {
        return passagier;
    }

    public Reis getReis() {
        return reis;
    }

    public String getTicketClass() {
        return klasseTicket;
    }

    @Override
    public String toString() {
        return "Ticket #" + ticketID + "\n" +
                "===========================\n" +
                "Passagier: " + passagier.getVoornaam() + " " + passagier.getAchternaam() + "\n" +
                "Reis: " + reis.getVertrekstation() + " -> " + reis.getAankomststation() + "\n" +
                "Klasse: " + klasseTicket;
    }


    public static int telTicketsVoorReisOp(Reis reis) {
        int aantalTickets = 0;
        for (Ticket ticket : tickets) {
            if (ticket.getReis().equals(reis)) {
                aantalTickets++;
            }
        }
        return aantalTickets;
    }


    public static void verkoopTicket() {
        System.out.println("Ticket verkopen");

        if (Passagier.getPassagiers().isEmpty()) {
            System.out.println("Geen passagiers geregistreerd. Zorg eerst dat een passagier aangemaakt is.");
            return;
        }

        if (Reis.getReizen().isEmpty()) {
            System.out.println("Geen reis gevonden. Zorg eerst dat een reis aangemaakt is.");
            return;
        }

        System.out.println("Geregistreerde passagiers: ");
        for (int i = 0; i < Passagier.getPassagiers().size(); i++) {
            System.out.println((i + 1) + ". " + Passagier.getPassagiers().get(i));
        }

        int passagierIndex = Euromoon.getIntInput("Kies passagiernummer: ") -1;
        if (passagierIndex < 0 || passagierIndex >= Passagier.getPassagiers().size()) {
            System.err.println("Ongeldige passagiernummer.");
            return;
        }

        Passagier passagier = Passagier.getPassagiers().get(passagierIndex);

        System.out.println("Beschikbare reizen: ");
        for (int i = 0; i < Reis.getReizen().size(); i++) {
            Reis r = Reis.getReizen().get(i);

            int verkochtTickets = telTicketsVoorReisOp(r);

            int totaalCapaciteit = (r.getTrein() != null) ? r.getTrein().getTotaalCapaciteit() : 0;
            int beschikbaar = totaalCapaciteit - verkochtTickets;

            System.out.println((i + 1) + ". " + r.getVertrekstation() + " -> " + r.getAankomststation() +
                    " (" + beschikbaar + " plaatsen beschikbaar)");
        }

        int reisIndex = Euromoon.getIntInput("Kies reisnummer: ") - 1;
        if (reisIndex < 0 || reisIndex >= Reis.getReizen().size()) {
            System.err.println("Ongeldige reis");
            return;
        }

        Reis reis = Reis.getReizen().get(reisIndex);

        if (reis.getTrein() == null) {
            System.err.println("Er werd geen trein aan deze reis gekoppeld. Koppel eerst een trein aan.");
            return;
        }

        int verkochtTickets = telTicketsVoorReisOp(reis);
        int totaalCapaciteit = reis.getTrein().getTotaalCapaciteit();

        if (verkochtTickets >= totaalCapaciteit) {
            System.err.println("Deze trein is vol! Geen plaatsen meer beschikbaar.");
            return;
        }

        System.out.println("Kies een klasse: ");
        System.out.println("1. Eerste klasse");
        System.out.println("2. Eerste klasse");

        int klasseKeuze = Euromoon.getIntInput("Keuze: ");
        String klasseType = "";

        if (klasseKeuze == 1) {
            klasseType = "Eerste klasse";
        } else if (klasseKeuze == 2) {
            klasseType = "Tweede klasse";
        } else {
            System.err.println("Ongeldige keuze.");
            return;
        }

        Ticket ticket = new Ticket(passagier, reis, klasseType);
        tickets.add(ticket);

        System.out.println("Ticket succesvol verkocht!");
        System.out.println(ticket);
        System.out.println("Resterende plaatsen: " + (totaalCapaciteit - verkochtTickets - 1));
    }
}



