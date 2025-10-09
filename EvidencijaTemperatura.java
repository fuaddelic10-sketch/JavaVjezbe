package udg.edu.me;

import java.util.Scanner;

public class EvidencijaTemperatura {
	private double[] temperature;

    public EvidencijaTemperatura(double[] temperature) {
        this.temperature = temperature;
    }

    public double[] getTemperature() {
        return temperature;
    }

    public void setTemperature(double[] temperature) {
        this.temperature = temperature;
    }

    public static double prosjecnaTemperatura(double[] niz) {
        double suma = 0;
        for (double t : niz) suma += t;
        return suma / niz.length;
    }

    public static double maksimalnaTemperatura(double[] niz) {
        double max = niz[0];
        for (double t : niz) if (t > max) max = t;
        return max;
    }

    public static String nizToString(double[] niz) {
        String rezultat = "[";
        for (int i = 0; i < niz.length; i++) {
            rezultat += niz[i];
            if (i < niz.length - 1) rezultat += ", ";
        }
        rezultat += "]";
        return rezultat;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] temp = new double[5];

        System.out.println("Unesite 5 temperatura:");
        for (int i = 0; i < temp.length; i++) {
            System.out.print("Temperatura " + (i + 1) + ": ");
            temp[i] = sc.nextDouble();
        }

        EvidencijaTemperatura evidencija = new EvidencijaTemperatura(temp);

        System.out.println("\nDuzina niza: " + evidencija.getTemperature().length);
        System.out.println("Unesene temperature: " + nizToString(evidencija.getTemperature()));

        System.out.print("\nUnesite temperaturu koju zelite provjeriti: ");
        double trazena = sc.nextDouble();

        boolean postoji = false;
        for (double t : evidencija.getTemperature()) {
            if (t == trazena) {
                postoji = true;
                break;
            }
        }

        if (postoji) System.out.println("Temperatura " + trazena + " postoji u nizu.");
        else System.out.println("Temperatura " + trazena + " ne postoji u nizu.");

        int count = 0;
        for (double t : evidencija.getTemperature()) if (t == trazena) count++;

        if (count > 0) {
            double[] noviNiz = new double[evidencija.getTemperature().length - count];
            int index = 0;
            for (double t : evidencija.getTemperature()) {
                if (t != trazena) {
                    noviNiz[index] = t;
                    index++;
                }
            }
            evidencija.setTemperature(noviNiz);
        }

        System.out.println("\nAzurirani niz temperatura: " + nizToString(evidencija.getTemperature()));

        System.out.printf("\nProsjecna temperatura: %.2f", prosjecnaTemperatura(evidencija.getTemperature()));
        System.out.printf("\nMaksimalna temperatura: %.2f", maksimalnaTemperatura(evidencija.getTemperature()));

        sc.close();
	}

}
