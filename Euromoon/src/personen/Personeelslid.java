package personen;

import java.time.LocalDate;
import java.util.ArrayList;

/** Deze abstracte klasse vormt de basis voor alle werknemers van Euromoon.
 * Het is een uitbreiding van de hoofdklasse Persoon.
 * @author Hisham Boussof
 */

public abstract class Personeelslid extends Persoon{

    private ArrayList<Certificatie> certificaties;

    public Personeelslid(String voornaam, String achternaam, String rijksregisternummer, LocalDate geboortedatum){
        super(voornaam, achternaam, rijksregisternummer, geboortedatum);
        this.certificaties = new ArrayList<>();
    }

    /** Deze methode voegt een certificatie toe aan de lijst van het personeelslid.
     * Dit wordt gebruikt om aan te duiden als een medewerker over de juiste kwalificaties beschikt.
     * @param certificatie is de certificatie die toegevoegd wordt uit de enum-certificatie.
     */

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
