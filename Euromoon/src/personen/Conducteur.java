package personen;

import java.time.LocalDate;

/** Deze klasse gaat over een conducteur van Euromoon.
 * De conducteur is de hoofdverantwoordelijke van de trein.
 * @author Hisham Boussof
 */

public class Conducteur extends Personeelslid{
    public Conducteur(String voornaam, String achternaam, String rijksregisternummer, LocalDate geboortedatum){
        super(voornaam, achternaam, rijksregisternummer, geboortedatum);
    }

    @Override
    public String toString() {
        return "Conducteur: " +  super.toString();
    }
}
