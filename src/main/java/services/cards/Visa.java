package services.cards;

public class Visa {
    String kortNummer;
    String edMnd;
    String edAar;
    String etterNavn;
    String forNavn;
    int cvc;

    public String getKortNummer() {
        return kortNummer;
    }

    public void setKortNummer(String kortNummer) {
        this.kortNummer = kortNummer;
    }

    public String getEdMnd() {
        return edMnd;
    }

    public void setEdMnd(String edMnd) {
        this.edMnd = edMnd;
    }

    public String getEdAar() {
        return edAar;
    }

    public void setEdAar(String edAar) {
        this.edAar = edAar;
    }

    public String getEtterNavn() {
        return etterNavn;
    }

    public void setEtterNavn(String etterNavn) {
        this.etterNavn = etterNavn;
    }

    public String getForNavn() {
        return forNavn;
    }

    public void setForNavn(String forNavn) {
        this.forNavn = forNavn;
    }

    public int getCvc() {
        return cvc;
    }

    public void setCvc(int cvc) {
        this.cvc = cvc;
    }
}
