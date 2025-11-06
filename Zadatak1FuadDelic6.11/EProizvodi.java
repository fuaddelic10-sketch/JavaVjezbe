package udg.edu.me;

public class EProizvodi {
    protected String opis;
    protected String sifra;
    protected double uvoznaCijena;

    public EProizvodi(String opis, String sifra, double uvoznaCijena) {
        this.opis = opis;
        this.sifra = sifra;
        this.uvoznaCijena = uvoznaCijena;
    }

    // Osnovna metoda za računanje maloprodajne cijene (+5%)
    public double maloprodajnaCijena() {
        return uvoznaCijena * 1.05;
    }

    // Određuje tip uređaja na osnovu šifre
    public String getTip() {
        if (sifra.startsWith("RA")) return "Racunari";
        else if (sifra.startsWith("TE")) return "Telefoni";
        else if (sifra.startsWith("TV")) return "TV";
        else return "Nepoznat";
    }

    @Override
    public String toString() {
        return "Opis: " + opis + ", Šifra: " + sifra + ", Uvozna cijena: " + uvoznaCijena;
    }
}