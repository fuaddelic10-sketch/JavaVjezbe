package udg.edu.me;

public class Racunari extends EProizvodi {
    private String procesor;
    private int memorija;

    public Racunari(String opis, String sifra, double uvoznaCijena, String procesor, int memorija) {
        super(opis, sifra, uvoznaCijena);
        this.procesor = procesor;
        this.memorija = memorija;
    }

    @Override
    public double maloprodajnaCijena() {
        double cijena = super.maloprodajnaCijena();
        cijena *= 1.05; // dodatnih 5% za računare
        return cijena;
    }

    @Override
    public String toString() {
        return super.toString() + ", Procesor: " + procesor + ", Memorija: " + memorija + "GB, Maloprodajna cijena: " + maloprodajnaCijena();
    }
}