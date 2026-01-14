package personen;

import java.time.LocalDate;
import java.util.Objects;

/** De hoofdklasse voor gegevens van elk individu in het systeem
 * Deze klasse is abstract want wordt altijd extended.
 * @author Hisham Boussof
 */

public abstract class Persoon {

    private String voornaam;
    private String achternaam;
    private String rijksregisternummer;
    private LocalDate geboortedatum;

    public Persoon(String voornaam, String achternaam, String rijksregisternummer, LocalDate geboortedatum) {
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.rijksregisternummer = rijksregisternummer;
        this.geboortedatum = geboortedatum;
    }

    public LocalDate getGeboortedatum() {
        return geboortedatum;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public String getRijksregisternummer() {
        return rijksregisternummer;
    }

    @Override
    public String toString() {
        return achternaam + " " + voornaam + " " + ", geboren op: " + geboortedatum + ", rijksregisternummer:  " +  rijksregisternummer;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;

        if (o instanceof Persoon) {
            Persoon anderePersoon = (Persoon) o;
            return this.rijksregisternummer.equals(anderePersoon.rijksregisternummer);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rijksregisternummer);
    }
}


