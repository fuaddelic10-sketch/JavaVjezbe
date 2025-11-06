package udg.edu.me;

public class Telefoni extends EProizvodi {
    private String operativniSistem;
    private double velicinaEkrana;

    public Telefoni(String opis, String sifra, double uvoznaCijena, String operativniSistem, double velicinaEkrana) {
        super(opis, sifra, uvoznaCijena);
        this.operativniSistem = operativniSistem;
        this.velicinaEkrana = velicinaEkrana;
    }

    @Override
    public double maloprodajnaCijena() {
        double cijena = super.maloprodajnaCijena();
        if (velicinaEkrana > 6) {
            cijena *= 1.03; // dodatnih 3% ako je ekran > 6 inča
        }
        return cijena;
    }

    @Override
    public String toString() {
        return super.toString() + ", OS: " + operativniSistem + ", Ekran: " + velicinaEkrana + " inča, Maloprodajna cijena: " + maloprodajnaCijena();
    }
}
