package personen;

import java.time.LocalDate;

public class Steward extends Personeelslid{
    public Steward(String voornaam, String achternaam, String rijksregisternummer, LocalDate geboortedatum){
        super(voornaam, achternaam, rijksregisternummer, geboortedatum);
    }

    @Override
    public String toString() {
        return "Steward: " +  super.toString();
    }
}
