package udg.edu.me;

public class TV extends EProizvodi {
    private double velicinaEkrana;

    public TV(String opis, String sifra, double uvoznaCijena, double velicinaEkrana) {
        super(opis, sifra, uvoznaCijena);
        this.velicinaEkrana = velicinaEkrana;
    }

    @Override
    public double maloprodajnaCijena() {
        double cijena = super.maloprodajnaCijena();
        if (velicinaEkrana > 65) {
            cijena *= 1.10; // dodatnih 10% ako je ekran > 65 inča
        }
        return cijena;
    }

    @Override
    public String toString() {
        return super.toString() + ", Ekran: " + velicinaEkrana + " inča, Maloprodajna cijena: " + maloprodajnaCijena();
    }
}