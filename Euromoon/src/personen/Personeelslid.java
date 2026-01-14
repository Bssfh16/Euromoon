package personen;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Personeelslid extends Persoon{

    private ArrayList<Certificatie> certificaties;

    public Personeelslid(String voornaam, String achternaam, String rijksregisternummer, LocalDate geboortedatum){
        super(voornaam, achternaam, rijksregisternummer, geboortedatum);
        this.certificaties = new ArrayList<>();
    }

    public void voegCertificatieToe(Certificatie certificatie) {
        if (!certificaties.contains(certificatie)) {
            certificaties.add(certificatie);
        }
    }

    public ArrayList<Certificatie> getCertificaties() {
        return this.certificaties;
    }

    public boolean heeftCertificatie(Certificatie certificatie) {
        return this.certificaties.contains(certificatie);
    }

    @Override
    public String toString() {
        return super.toString() + ", Certifacties: " + certificaties;
    }
}
