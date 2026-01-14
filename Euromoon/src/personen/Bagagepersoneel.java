package personen;

import java.time.LocalDate;

public class Bagagepersoneel extends Personeelslid{
    public Bagagepersoneel(String voornaam, String achternaam, String rijksregisternummer, LocalDate geboortedatum){
        super(voornaam, achternaam, rijksregisternummer, geboortedatum);
    }

    @Override
    public String toString() {
        return "Bagagepersoneel: " +  super.toString();
    }
}
