package personen;

import java.time.LocalDate;
import java.util.Objects;

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

//    public void setVoornaam(String voornaam) {
//        this.voornaam = voornaam;
//    }
//
//    public void setAchternaam(String achternaam) {
//        this.achternaam = achternaam;
//    }
//
//    public void setRijksregisternummer(String rijksregisternummer) {
//        this.rijksregisternummer = rijksregisternummer;
//    }
//
//    public void setGeboortedatum(LocalDate geboortedatum) {
//        this.geboortedatum = geboortedatum;
//    }

    @Override
    public String toString() {
        return achternaam + " " + voornaam + " " + ", geboren op: " + geboortedatum + ", rijksregisternummer:  " +  rijksregisternummer;
    }

    /* @Override
    public boolean equals(Object o) {
        if (!(o instanceof Persoon persoon)) return false;
        return Objects.equals(getRijksregisternummer(), persoon.getRijksregisternummer());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getRijksregisternummer());
    } */

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


