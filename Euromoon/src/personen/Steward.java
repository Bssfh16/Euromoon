package personen;

import java.time.LocalDate;

/** Deze klasse stelt een steward voor.
 * Een steward is een personeelslid dat verantwoordelijk is voor het welzijn van de passagiers tijdens de reis.
 * @author Hisham Boussof
 */

public class Steward extends Personeelslid{
    public Steward(String voornaam, String achternaam, String rijksregisternummer, LocalDate geboortedatum){
        super(voornaam, achternaam, rijksregisternummer, geboortedatum);
    }

    @Override
    public String toString() {
        return "Steward: " +  super.toString();
    }
}
