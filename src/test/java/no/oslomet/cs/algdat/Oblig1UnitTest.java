package no.oslomet.cs.algdat;

import static no.oslomet.cs.algdat.Hjelpemetoder.randPerm;
import static no.oslomet.cs.algdat.Oblig1.*;

// Du kan bruke denne klassen til å lage egne tester om du ønsker.
public class Oblig1UnitTest {
    public static void main(String[] args) {
        // Oppgave 1
        // Maks
        int[] a = {3, 5, 10, 9, 6, 8, 1};
        System.out.println("Den største verdien er: " + maks(a));
        // int[] b = {};
        // System.out.println("Den største verdien er: " + maks(b));
        int[] c = {3};
        System.out.println("Den største verdien er: " + maks(c));

        // Antall ombyttinger med maks metode
        int[] d = randPerm(10); // generer tilfeldig permutasjon
        System.out.println("Antall ombyttinger: " + ombyttinger(d));

        // Oppgave 2
        // Antall unike verdier i sortert tabell
        int[] e = {1, 1, 2, 4, 5, 5, 5, 6, 6, 8, 8, 9};
        System.out.println("Antall unike elementer i sortert: " + antallUlikeSortert(e));

        // Oppgave 3
        // Antall unike verdier i usortert tabell
        int[] f = {10, 5, 2, 5, 5, 6, 7, 10};
        System.out.println("Antall unike elementer i usortert: " + antallUlikeUsortert(f));

        // Oppgave 4
        // Oddetall vil venstre og partall til høyre
        int[] g = {1, 1, 2, 4, 5, 5, 5, 6, 6, 8, 8, 9};
        delsortering(g);
        System.out.print("Partall og oddetall: ");
        for (int i : g) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Oppgave 5
        // Rotasjon, alle elementer en til høyre, siste element først
        char[] h = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        rotasjon(h);
        for (char i : h) {
            System.out.print(i + " ");
        }
        System.out.println(" ");

        // Oppgave 7
        // a. Flette sammen to strenger
        System.out.print(flett("ABC", "DEF"));
        System.out.println();
        // b Flette sammen alle strengene
        System.out.print(flett("AM ", "L", "GEDS", "ORATKRR", "",
                "R TRTE", "IO", "TGAUU"));
    }
}