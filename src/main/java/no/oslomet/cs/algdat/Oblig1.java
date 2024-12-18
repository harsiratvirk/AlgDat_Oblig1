package no.oslomet.cs.algdat;

import java.util.NoSuchElementException;

public class Oblig1 {
    private Oblig1() { }

    // HJELPEMETODER

    // Metode som bytter plass på to tall
    public static void bytt(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // Metode som bytter plass på to bokstaver
    public static void bytt(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // Metode for kvikksortering
    public static void kvikksortering(int[] a) {
        kvikksortering(a, 0, a.length - 1);
    }
    private static void kvikksortering(int[] a, int v, int h) {
        if (v >= h) return; // Tomt eller har ett element
        int k = sParter(a, v, h, (v + h)/2); // Midtverdi som skilleverdi
        // Sorterer venstre og høyre intervall
        kvikksortering(a, v, k - 1);
        kvikksortering(a, k + 1, h);
    }
    // Partisjonerer tabellen rundt en skilleverdi og returnerer dens posisjon
    public static int sParter(int[] a, int v, int h, int indeks) {
        bytt(a, indeks, h); // Skilleverdi a[indeks] flyttes bakerst
        int pos = parter(a, v, h - 1, a[h]);
        bytt(a, pos, h); // Bytter for å få skilleverdien tilbake på rett plass
        return pos;
    }
    // Verdier mindre enn skilleverdi legges før og større enn skilleverdi etter
    public static int parter(int[] a, int v, int h, int skilleverdi) {
        while (true) { // Stopper når v > h
            while (v <= h && a[v] < skilleverdi) // v fremover
                v++;
            while (v <= h && a[h] >= skilleverdi) // h bakover
                h--;
            if (v < h) {
                bytt(a,v++,h--);
            } else return v;  // a[v] er nå den første som ikke er mindre enn skilleverdi
        }
    }

    // Oppgave 0
    public static int gruppeMedlemmer() {
        // throw new UnsupportedOperationException();
        return 1; // antall medlemmer i gruppen
    }

    // Oppgave 1
    /* a) For hver iterasjon utføres en sammenligning og antall iterasjoner er n-1 (n = tabellens lengde).
     * b) Best-case: O(n). Sortert liste, en iterasjon, 0 ombyttinger.
     * c) Worst-case: O(n^2). Omvendt sortert liste. Antall ombyttinger: n(n − 1)/2.
     * d) Average-case: O(n^2). Antall ombyttinger: n(n − 1)/4 stykker
     * Boblesortering er minst effektiv av de metodene vi har sett på. Brukes normalt ikke, særlig ikke på store tabeller. */

    // Returnere den største verdien i en tabell ved hjelp av boblesortering
    public static int maks(int[] a) {
        if (a.length == 0) { // Sjekker om tabellen er tom
            throw new NoSuchElementException("Tabellen a er tom!");
        }
        // Hvis første element er større, bytt
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] > a[i]) {
                bytt(a, i - 1, i);
            }
        }
        // Returnerer siste (største) elementet i tabellen
        return a[a.length - 1];
    }

    public static int ombyttinger(int[] a) {
        int antall = 0; // Antall ombyttinger i tabellen
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] > a[i]) {
                bytt(a, i - 1, i);
                antall++;
            }
        }
        return antall;
    }

    // Oppgave 2
    // Antall unike verdier i en sortert tabell
    public static int antallUlikeSortert(int[] a) {
        if (a.length == 0) { // Sjekker om tabellen er tom
            return 0;
        }
        int antUnike = 1; // Starter på 1 fordi første element alltid regnes som unikt
        // Sjekker om tabellen er sortert
        for (int i = 1; i < a.length; i++) {
            if (a[i-1] > a[i]) {
                throw new IllegalStateException("Tabellen a er ikke sortert!");
            } else {
                if (a[i] != a[i - 1]) { // Øker antUnike hvis elementene ikke er like
                    antUnike++;
                }
            }
        }
        return antUnike;
    }

    // Oppgave 3
    // Antall unike verdier i en usortert tabell
    public static int antallUlikeUsortert(int[] a) {
        if (a.length == 0) { // Sjekker om tabellen er tom
            return 0;
        }
        int antUnike = 1;
        boolean erUnik; // Variabel for å indikere om det nåværende elementet er unikt
        for (int i = 1; i < a.length; i++) {
            erUnik = true; // Antar at nåværende elementet (a[i]) er unikt
            // Sjekker om a[i] er lik tidligere elementer
            for (int j = 0; j < i; j++) {
                if (a[i] == a[j]) {
                    erUnik = false;
                    break; // a[i] er ikke unik, derfor unødvendig å sammenligne i videre
                }
            }
            if (erUnik) {
                antUnike++;
            }
        }
        return antUnike;
    }

    // Oppgave 4
    // Dele tabell inn i oddetall og partall
    public static void delsortering(int[] a) {
        int v = 0;
        int h = a.length - 1;
        while (v < h) {
            // Flytt venstre pekeren forbi alle oddetall
            while (v < h && a[v] % 2 != 0)
                v++;
            // Flytt høyre pekeren forbi alle partall
            while (v < h && a[h] % 2 == 0)
                h--;
            // Bytt hvis venstre peker på et partall og høyre peker på et oddetall
            bytt(a, v, h);
            }
        // v har nådd slutten og det er kun alle oddetall eller partall
        if (a.length - 1 == v) {
            kvikksortering(a);
        }
        // Sorterer hver del: odetall og partall
        kvikksortering(a, 0, v - 1);
        kvikksortering(a, v, a.length - 1);
    }

    // Oppgave 5
    // Rotasjon: Siste elementet settes først, andre elementer forskyves ett steg mot høyre
    public static void rotasjon(char[] a) {
        if (a.length <= 1) return; // Ingen rotasjon hvis tabellen er tom eller har ett element
        // Flytter alle elementer ett steg mot høyre
        for(int i = 1; i < a.length; i++) {
            // Siste element settes på første plass
            bytt(a,0,i);
        }
    }

    // Oppgave 6
    public static void rotasjon(char[] a, int k) {throw new UnsupportedOperationException(); }

    // Oppgave 7
    public static String flett(String a, String b) {
        int k = Math.min(a.length(), b.length()); // Lengden på den korteste
        // StringBuilder for å bygge strengen effektivt enn konkatenering med +
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < k; i++) {
            s.append(a.charAt(i)).append(b.charAt(i));
        }
        // Resterende tegn fra de lengre strengene
        s.append(a.substring(k)).append(b.substring(k));
        return s.toString();
    }

    public static String flett(String... s) {
        StringBuilder sb = new StringBuilder();
        int tmp = 0; // Hjelpevariabler
        int lengde = 0;
        while(true) {
            // Går gjennom alle strengene i tabellen
            for (int i = 0; i < s.length; i++){
                if (s[i].length() > tmp) // Henter et tegn fra strengen s[i] hvis tmp er innenfor strenglengden
                    sb.append(s[i].charAt(tmp));
                if (s[i].length() > lengde) // Oppdaterer lengde med den lengste strengen så langt
                    lengde = s[i].length();
            }
            if(tmp == lengde) break; // Sjekker om tmp er lik lengden på den lengste strengen, hvis; løkken avsluttes
            tmp++;
        }
        return sb.toString();
    }

    // Oppgave 8
    public static int[] indeksSortering(int[] a) {throw new UnsupportedOperationException();}

    // Oppgave 9
    public static int[] tredjeMin(int[] a) {throw new UnsupportedOperationException();}

    // Oppgave 10
    public static boolean inneholdt(String a, String b) {throw new UnsupportedOperationException();}
}