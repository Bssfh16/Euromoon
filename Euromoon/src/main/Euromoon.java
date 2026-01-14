package main;

import personen.Passagier;
import reis.Reis;
import ticket.Ticket;
import trein.Trein;
import java.util.Scanner;

public class Euromoon {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        boolean running = true;
        while (running) {
            try {
                toonMenu();

                int keuze = getIntInput("Kies een optie: ");

                switch (keuze) {
                    case 1:
                        Passagier.registreerPassagier();
                        break;
                    case 2:
                        Reis.maakReis();
                        break;
                    case 3:
                        Reis.koppelTreinenAanReis();
                        break;
                    case 4:
                        Ticket.verkoopTicket();
                        break;
                    case 5:
                        Reis.drukBoardinglijstAf();
                        break;
                    case 6:
                        Passagier.bekijkAllePassagiers();
                        break;
                    case 7:
                        Reis.bekijkAlleReizen();
                        break;
                    case 8:
                        Trein.bekijkAlleTreinen();
                        break;
                    case 0:
                        running = false;
                        System.out.println("Euromoon bedankt u!");
                        break;
                    default:
                        System.out.println("Ongeldige keuze. Probeer opnieuw!");
                }
        } catch (Exception e) {
            System.err.println("Een fout is opgetreden: " + e.getMessage());
            scanner.nextLine();
        }

        if (running) {
            System.out.println("Druk op Enter om verder te gaan.");
            scanner.nextLine();
        }
    }
}

private static void toonMenu() {
    System.out.println(" Euromoon Train System ");
    System.out.println("=======================");
    System.out.println("1. Passagier registreren");
    System.out.println("2. Reis aanmaken");
    System.out.println("3. Trein aan reis koppelen");
    System.out.println("4. Ticket verkopen");
    System.out.println("5. Boardinglijst afdrukken");
    System.out.println("6. Bekijk alle pasagiers");
    System.out.println("7. Bekijk alle reizen");
    System.out.println("8. Bekijk alle treinen");
    System.out.println("0. Afsluiten");
    System.out.println("=======================");
    }

public static int getIntInput(String prompt) {
    while (true) {
        try {
            System.out.print(prompt);
            int waarde = Integer.parseInt(scanner.nextLine());
            return waarde;
        } catch (NumberFormatException e) {
            System.err.println("Ongeldige invoer. Voer een geldig getal in.");
            }
        }
    }
}