package udg.edu.me;

import java.util.ArrayList;
import java.util.Scanner;

public class ProdavnicaMain {

    private static ArrayList<EProizvodi> proizvodi = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    // --- Unos novog proizvoda ---
    public static void unosProizvoda() {
        System.out.print("Unesite opis proizvoda: ");
        String opis = sc.nextLine();
        System.out.print("Unesite šifru proizvoda: ");
        String sifra = sc.nextLine().toUpperCase();
        System.out.print("Unesite uvoznu cijenu proizvoda: ");
        double cijena = Double.parseDouble(sc.nextLine());

        if (sifra.startsWith("RA")) {
            System.out.print("Unesite procesor: ");
            String procesor = sc.nextLine();
            System.out.print("Unesite memoriju (GB): ");
            int memorija = Integer.parseInt(sc.nextLine());
            proizvodi.add(new Racunari(opis, sifra, cijena, procesor, memorija));

        } else if (sifra.startsWith("TE")) {
            System.out.print("Unesite operativni sistem: ");
            String os = sc.nextLine();
            System.out.print("Unesite veličinu ekrana (inča): ");
            double ekran = Double.parseDouble(sc.nextLine());
            proizvodi.add(new Telefoni(opis, sifra, cijena, os, ekran));

        } else if (sifra.startsWith("TV")) {
            System.out.print("Unesite veličinu ekrana (inča): ");
            double ekran = Double.parseDouble(sc.nextLine());
            proizvodi.add(new TV(opis, sifra, cijena, ekran));

        } else {
            System.out.println("Greška: šifra mora počinjati sa RA, TE ili TV!");
        }
    }

    // --- Prikaz svih proizvoda ---
    public static void prikaziSve() {
        if (proizvodi.isEmpty()) {
            System.out.println("Nema unesenih proizvoda.");
        } else {
            for (EProizvodi p : proizvodi) {
                System.out.println(p);
            }
        }
    }

    // --- Prikaz proizvoda po tipu ---
    public static void prikaziPoTipu(String tip) {
        boolean nadjen = false;
        for (EProizvodi p : proizvodi) {
            if (p.getTip().equalsIgnoreCase(tip)) {
                System.out.println(p);
                nadjen = true;
            }
        }
        if (!nadjen) {
            System.out.println("Nema proizvoda tipa " + tip + ".");
        }
    }

    // --- Glavni meni ---
    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- MENI ---");
            System.out.println("1. Unos uređaja");
            System.out.println("2. Pregled svih uređaja sa maloprodajnom cijenom");
            System.out.println("3. Pregled uređaja određenog tipa");
            System.out.println("0. Izlaz");
            System.out.print("Odaberite opciju: ");

            String izbor = sc.nextLine();

            switch (izbor) {
                case "1":
                    unosProizvoda();
                    break;
                case "2":
                    prikaziSve();
                    break;
                case "3":
                    System.out.print("Unesite tip uređaja (Racunari / Telefoni / TV): ");
                    String tip = sc.nextLine();
                    prikaziPoTipu(tip);
                    break;
                case "0":
                    System.out.println("Kraj programa.");
                    return;
                default:
                    System.out.println("Nepoznata opcija!");
            }
        }
    }
}