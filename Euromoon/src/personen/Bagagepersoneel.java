package personen;

import java.time.LocalDate;

/** Deze klasse stelt een medewerker van het bagagepersoneel voor.
 * Ze zijn verantwoordelijk voor de bagage.
 * @author Hisham Boussof
 */

public class Bagagepersoneel extends Personeelslid{
    public Bagagepersoneel(String voornaam, String achternaam, String rijksregisternummer, LocalDate geboortedatum){
        super(voornaam, achternaam, rijksregisternummer, geboortedatum);
    }

    @Override
    public String toString() {
        return "Bagagepersoneel: " +  super.toString();
    }
}
