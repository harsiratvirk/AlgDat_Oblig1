package no.oslomet.cs.algdat;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.Random;
import java.util.stream.IntStream;
import java.time.Duration;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Oppgave1Tests {
    @Test
    void maksTom() {
        int[] tom = {};
        assertThrows(NoSuchElementException.class, () -> Oblig1.maks(tom), "Feil eller ingen unntak for tom tabell.");
    }

    @Test
    void maksVerdi() {
        int[] a = {3};
        assertEquals(3, Oblig1.maks(a), "Feil maksimum for tabellen {3}.");

        int[] b = {5, 2, 8, 4, 7, 6};
        assertEquals(8, Oblig1.maks(b), "Feil maksimum for tabellen {5, 2, 8, 4, 7, 6}.");

        int[] c = {5, 4, 3, 2, 1};
        assertEquals(5, Oblig1.maks(c), "Feil maksimum for tabellen {5, 4, 3, 2, 1}.");

        int[] d = {1, 2, 3, 4, 5};
        assertEquals(5, Oblig1.maks(d), "Feil maksimum for tabellen {1, 2, 3, 4, 5}");
    }

    @Test
    void maksOmbytting() {
        int[] a = {1, 4, 3, 7, 6, 5, 10, 2, 9, 8};
        int[] b = {1, 3, 4, 6, 5, 7, 2, 9, 8, 10};
        Oblig1.maks(a);
        assertArrayEquals(b, a, "Feil ombyttinger i maks-metoden.");
    }

    @Test
    void ombyttingerAntall() {
        int[] a = {6, 5, 4, 3, 2, 1};
        assertEquals(5, Oblig1.ombyttinger(a), "Feil antall ombyttinger på tabellen {6, 5, 4, 3, 2, 1}.");

        int[] b = {1, 2, 3, 4, 5};
        assertEquals(0, Oblig1.ombyttinger(b), "Feil antall ombyttinger på tabellen {1, 2, 3, 4, 5}.");

        int[] c = {4, 9, 3, 6, 1, 5, 7, 8, 10, 2};
        assertEquals(7, Oblig1.ombyttinger(c), "Feil antall ombyttinger på tabellen {4, 9, 3, 6, 1, 5, 7, 8, 10, 2}.");

        int[] d = {2, 5, 8, 4, 3, 10, 1, 7, 6, 9};
        assertEquals(6, Oblig1.ombyttinger(d), "Feil antall ombyttinger på tabellen {2, 5, 8, 4, 3, 10, 1, 7, 6, 9}.");
    }
}

class Oppgave2Tests {
    @Test
    void antallUlikeSortertTom() {
        int[] tom = {};
        assertDoesNotThrow(() -> {Oblig1.antallUlikeSortert(tom);}, "Gir feilmelding for tom tabell.");
        assertEquals(0, Oblig1.antallUlikeSortert(tom), "Gir feil svar om tom tabell.");
    }

    @Test
    void antallUlikeSortertEttElement() {
        int[] ettElement = {3};
        assertDoesNotThrow(() -> {Oblig1.antallUlikeSortert(ettElement);}, "Gir feilmelding for tabell med ett element.");
        assertEquals(1, Oblig1.antallUlikeSortert(ettElement), "Gir feil svar om tabellen inneholder ett element.");
    }

    @Test
    void antallUlikeSortertUsortert() {
        int[] usortert = {1, 2, 3, 4, 5, 4};
        assertThrows(IllegalStateException.class, () -> Oblig1.antallUlikeSortert(usortert), "Gir ingen eller gal feilmelding om usortert tabell.");
    }

    @Test
    void antallUlikeSortertVerdi() {
        int[] a = {2,2};
        assertEquals(1, Oblig1.antallUlikeSortert(a), "Feil antall ulike på tabellen {1, 1}.");

        int[] b = {1, 2, 3, 4, 5, 6, 7};
        assertEquals(7, Oblig1.antallUlikeSortert(b), "Feil antall ulike på tabellen {1, 2, 3, 4, 5, 6, 7}.");

        int[] c = {1, 1, 2, 2, 2, 3, 4, 4, 5, 6, 6, 6, 6, 8};
        assertEquals(7, Oblig1.antallUlikeSortert(c), "Feil antall ulike på tabellen {1, 1, 2, 2, 2, 3, 4, 4, 5, 6, 6, 6, 6, 7}.");
    }
}

class Oppgave3Tests {
    @Test
    void antallUlikeUsortertTom() {
        int[] tom = {};
        assertDoesNotThrow(() -> {Oblig1.antallUlikeUsortert(tom);}, "Gir feilmelding for tom tabell.");
        assertEquals(0, Oblig1.antallUlikeUsortert(tom), "Gir feil svar for tom tabell.");
    }

    @Test
    void antallUlikeUsortertEttElement() {
        int[] ettElement = {2};
        assertDoesNotThrow(() -> {Oblig1.antallUlikeUsortert(ettElement);}, "Gir feilmelding for tabell med ett element.");
        assertEquals(1, Oblig1.antallUlikeUsortert(ettElement), "Gir feil svar for tabell med ett element.");
    }

    @Test
    void antallUlikeUsortertVerdi() {
        int[] a = {2, 2};
        assertEquals(1, Oblig1.antallUlikeUsortert(a), "Gir feil resultat på tabellen {2, 2}.");

        int[] b = {6, 2, 4, 6, 9, 1, 4, 9, 10};
        int[] bkopi = {6, 2, 4, 6, 9, 1, 4, 9, 10};
        assertEquals(6, Oblig1.antallUlikeUsortert(b), "Gir feil resultat på tabellen {6, 2, 4, 6, 9, 1, 4, 9, 10}.");
        assertArrayEquals(bkopi, b, "Metoden endrer på den innsendte tabellen.");

        int[] c = {5, 4, 3, 2, 1};
        assertEquals(5, Oblig1.antallUlikeUsortert(c), "Gir feil resultat på tabellen {5, 4, 3, 2, 1}.");

        int[] d = {1, 2, 2, 2, 2, 2, 5};
        assertEquals(3, Oblig1.antallUlikeUsortert(d), "Gir feil resultat på tabellen {1, 2, 2, 2, 2, 2, 5}.");
    }
}

class Oppgave4Tests {
    @Test
    void delsorteringTom() {
        int[] tom = {};
        assertDoesNotThrow(() -> Oblig1.delsortering(tom), "Metoden kaster feilmelding på tom tabell.");
    }

    @Test
    void delsorteringEttElement() {
        int[] ettElement = {5};
        assertDoesNotThrow(() -> Oblig1.delsortering(ettElement), "Metoden kaster feilmelding på tabell med ett element.");
        assertArrayEquals(new int[]{5}, ettElement);
    }

    @Test
    void delsorteringKunPartall() {
        int[] partall = {4, 2, 6, 10, 8};
        assertDoesNotThrow(() -> Oblig1.delsortering(partall), "Metoden kaster feilmelding om kun partall i tabellen.");
        assertArrayEquals(new int[]{2, 4, 6, 8, 10}, partall, "Metoden sorterer feil om kun partall i tabellen.");
    }

    @Test
    void delsorteringKunOddetall() {
        int[] oddetall = {9, 5, 3, 1, 7};
        assertDoesNotThrow(() -> Oblig1.delsortering(oddetall), "Metoden kaster feilmelding om kun oddetall i tabellen.");
        assertArrayEquals(new int[]{1, 3, 5, 7, 9}, oddetall, "Metoden sorterer feil om kun oddetall i tabellen.");
    }

    @Test
    void delsorteringBlandet() {
        int[] a = {1, 2, 3, 4, 5, 6};
        int[] svar = {1, 3, 5, 2, 4, 6};

        do {
            int[] c = a.clone();
            Oblig1.delsortering(c);

            assertArrayEquals(svar, c, String.format("Gitt tabellen %s skulle svaret blitt %s, men du fikk %s.", Arrays.toString(a), Arrays.toString(svar), Arrays.toString(c)));
        } while (Hjelpemetoder.nestePermutasjon(a));
    }

    @Test
    void delsorteringNegative() {
        int[] a = {-4, -1, 3, 0, 2, -3, -2, 4, 1};
        int[] svar = {-3, -1, 1, 3, -4, -2, 0, 2, 4};

        assertDoesNotThrow(() -> Oblig1.delsortering(a));
        assertArrayEquals(svar, a, "Gir feil resultat: Fikk " + Arrays.toString(a));
    }

    @Test
    void delsorteringTid() {
        int[] a = Hjelpemetoder.randPerm(100_000);

        IntStream svar1 = IntStream.iterate(1,n->n+2).limit(50_000);
        IntStream svar2 = IntStream.iterate(2,n->n+2).limit(50_000);
        int[] svar = IntStream.concat(svar1, svar2).toArray();

        assertTimeout(Duration.ofMillis(100), () -> Oblig1.delsortering(a), "Metoden brukte mer enn 100ms og er for ineffektiv!");

        assertArrayEquals(svar, a, "Feil resultat for stor tabell.");
    }
}

class Oppgave5Tests {
    @Test
    void rotasjonTom() {
        char[] tom = {};
        assertDoesNotThrow(() -> Oblig1.rotasjon(tom), "Metoden kaster feilmelding på tom tabell.");
        assertArrayEquals(new char[]{}, tom, "Metoden endrer på tom tabell.");
    }

    @Test
    void rotasjonEttElement() {
        char[] ettElement = {'A'};
        assertDoesNotThrow(() -> Oblig1.rotasjon(ettElement), "Metoden kaster feilmelding på tabell med ett element.");
        assertArrayEquals(new char[]{'A'}, ettElement, "Metoden gir feil svar på tabellen {'A'}.");
    }

    @Test
    void rotasjonToElement() {
        char[] toElement = {'A', 'B'};
        Oblig1.rotasjon(toElement);
        assertArrayEquals(new char[]{'B', 'A'}, toElement, "Metoden gir feil svar på tabellen {'A', 'B'}.");
    }

    @Test
    void rotasjonFlereElement() {
        char[] a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        char[] svar1 = {'J', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I'};
        Oblig1.rotasjon(a);
        assertArrayEquals(svar1, a, "Metoden gir feil svar på en lengre tabell.");
    }
}

class Oppgave6Tests {
    @Test
    void rotasjonTom() {
        if (Oblig1.gruppeMedlemmer() == 1) return;

        char[] tom = {};
        assertTimeout(Duration.ofMillis(10), () -> Oblig1.rotasjon(tom, 1), "Metoden ser ut til å gå evig på tom tabell.");
        assertDoesNotThrow(() -> Oblig1.rotasjon(tom, 1), "Metoden kaster feilmelding på tom tabell.");
        assertArrayEquals(new char[]{}, tom, "Metoden endrer på tom tabell.");
    }

    @Test
    void rotasjonEttElement() {
        if (Oblig1.gruppeMedlemmer() == 1) return;

        char[] ettElement = {'A'};
        char[] svar = {'A'};
        for (int i = -1; i < 2; ++i) {
            Oblig1.rotasjon(ettElement, i);
            assertArrayEquals(svar, ettElement, "Metoden gir feil svar på tabell med ett element og " + i + " rotasjoner.");
        }
    }

    @Test
    void rotasjonToElement() {
        if (Oblig1.gruppeMedlemmer() == 1) return;

        char[] a = {'A', 'B'};
        char[] svar = {'B', 'A'};
        Oblig1.rotasjon(a, 1);
        assertArrayEquals(svar, a, "Metoden gir feil svar på tabell med to element og 1 rotasjon.");
        a = new char[] {'A', 'B'};
        Oblig1.rotasjon(a,-1);
        assertArrayEquals(svar, a, "Metoden gir feil svar på tabell med to element og -1 rotasjon.");
    }

    @Test
    void rotasjonFlereElement() {
        if (Oblig1.gruppeMedlemmer() == 1) return;

        char[] a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        char[] svar = {'G', 'H', 'I', 'J', 'A', 'B', 'C', 'D', 'E', 'F'};
        Oblig1.rotasjon(a, 4);
        assertArrayEquals(svar, a, "Metoden gir feil svar på tabell med mange element og 4 rotasjoner.");
        a = new char[] {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        Oblig1.rotasjon(a, 14);
        assertArrayEquals(svar, a, "Metoden gir feil svar på tabell med mange element og 14 rotasjoner.");
        a = new char[] {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        Oblig1.rotasjon(a, -6);
        assertArrayEquals(svar, a, "Metoden gir feil svar på tabell med mange element og -6 rotasjoner.");
        a = new char[] {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        Oblig1.rotasjon(a, -16);
        assertArrayEquals(svar, a, "Metoden gir feil svar på tabell med mange element og -16 rotasjoner.");
    }

    @Test
    void rotasjonTid() {
        if (Oblig1.gruppeMedlemmer() == 1) return;

        char[] x = new char[100_000];

        assertTimeout(Duration.ofMillis(20), () -> Oblig1.rotasjon(x, 99_999), "Metoden er ueffektiv på 99 999 rotasjoner.");

        assertTimeout(Duration.ofMillis(20), () -> Oblig1.rotasjon(x, -99_999), "Metoden er ueffektiv på -99 999 rotasjoner.");

        assertTimeout(Duration.ofMillis(20), () -> Oblig1.rotasjon(x, 199_999), "Metoden er for ueffektiv på 199 999 rotasjoner.");

        assertTimeout(Duration.ofMillis(20), () -> Oblig1.rotasjon(x, 50_000), "Metoden er for ueffektiv på 50 000 rotasjoner.");

        assertTimeout(Duration.ofMillis(20), () -> Oblig1.rotasjon(x, -40_000), "Metoden er for ueffektiv på -40 000 rotasjoner.");
    }
}

class Oppgave7Tests {
    @Test
    void flettTom() {
        assertDoesNotThrow(() -> Oblig1.flett("", ""), "Metoden gir feilmelding for to tomme strenger.");
        assertEquals("", Oblig1.flett("",""), "Metoden gir feil svar for to tomme strenger.");
    }

    @Test
    void flettTomLang() {
        assertDoesNotThrow(() -> Oblig1.flett("", "AB"), "Metoden gir feilmelding på strengene '' og 'AB'.");
        assertDoesNotThrow(() -> Oblig1.flett("AB", ""), "Metoden gir feilmelding på strengene 'AB' og ''");
        assertEquals("AB", Oblig1.flett("", "AB"), "Metoden gir feil svar på strengene '' og 'AB'.");
        assertEquals("AB", Oblig1.flett("AB", ""), "Metoden gir feil svar på strengene 'AB' og ''.");
    }

    @Test
    void flettKortLang() {
        assertDoesNotThrow(() -> Oblig1.flett("A", "BCDEF"), "Metoden gir felmelding på strengene 'A' og 'BCDEF'.");
        assertDoesNotThrow(() -> Oblig1.flett("BCDEF", "A"), "Metoden gir feilmelding på strengene 'BCDEF' og 'A'.");
        assertEquals("ABCDEF", Oblig1.flett("A", "BCDEF"), "Metoden gir feil svar på strenene 'A' og 'BCDEF'.");
        assertEquals("BACDEF", Oblig1.flett("BCDEF", "A"), "Metoden gir feil svar på strengene 'BCDEF' og 'A'.");
    }

    @Test
    void flettLange() {
        assertEquals("ABCDEFGHIJKLMN", Oblig1.flett("ACEGIK", "BDFHJLMN"), "Metoden gir feil svar på to lengre strenger.");
    }

    // del 2
    @Test
    void flettTabellTom() {
        assertDoesNotThrow(() -> Oblig1.flett(), "Metoden kaster feil på tom tabell.");
        assertEquals("", Oblig1.flett(), "Metoden gir feil svar på tom tabell.");
    }

    @Test
    void flettTabellLiten() {
        assertDoesNotThrow(() -> Oblig1.flett("", "ABC", ""), "Metoden kaster feil med tomme strenger.");
        assertEquals("ABC", Oblig1.flett("", "ABC", ""), "Metoden gir feil svar for strengene '', 'ABC', ''.");
    }

    @Test
    void flettTabellLengre() {
        assertEquals("ALGORITMER OG DATASTRUKTUKER", Oblig1.flett("AM ", "L", "GEDS", "ORATKKR", "", "R TRTE", "IO", "TGAUU"), "Metoden gir feil på lengre tabell strenger.");
    }
}

class Oppgave8Tests{
    @Test
    void indekssorteringTom() {
        if (Oblig1.gruppeMedlemmer() == 1) return;

        int[] tom = {};
        assertDoesNotThrow(() -> Oblig1.indeksSortering(tom), "Metoden kaster feil på tom tabell.");
        assertArrayEquals(new int[] {}, tom, "Metoden endrer på tom tabell.");
        assertArrayEquals(new int[] {}, Oblig1.indeksSortering(tom), "Metoden gir feil svar på tom tabell.");
    }

    @Test
    void indekssorteringEttElement() {
        if (Oblig1.gruppeMedlemmer() == 1) return;

        int[] ettElement = {5};
        assertDoesNotThrow(() -> Oblig1.indeksSortering(ettElement), "Metoden kaster feil på tabell med ett element.");
        assertArrayEquals(new int[] {0}, Oblig1.indeksSortering(ettElement), "Metoden gir feil svar på tabell med ett element.");
    }

    @Test
    void indekssorteringFlereElement() {
        if (Oblig1.gruppeMedlemmer() == 1) return;
        int[] a = {1, 2, 3, 4, 5, 6};
        int[] sortert = {1, 2, 3, 4, 5, 6};

        do {
            int[] c = a.clone();
            int[] indeks = Oblig1.indeksSortering(c);

            assertArrayEquals(a, c, "Metoden endrer på originaltabellen for tabellen " + Arrays.toString(a));

            int[] sorter = new int[a.length];
            for (int i = 0; i < sorter.length; ++i) sorter[i] = a[indeks[i]];
            assertArrayEquals(sortert, sorter, "Metoden sorterer tabellen " + Arrays.toString(a) + " feil, får " + Arrays.toString(sorter));
        } while (Hjelpemetoder.nestePermutasjon(a));
    }

    @Test
    void indekssorteringLikeElement() {
        if (Oblig1.gruppeMedlemmer() == 1) return;

        int[] a = {5, 2, 8, 3, 5, 10, 7, 5, 2, 10, 6};
        int[] c = a.clone();
        int[] sortert = {2, 2, 3, 5, 5, 5, 6, 7, 8, 10, 10};
        int[] indeks = Oblig1.indeksSortering(a);
        int[] sorter = new int[a.length];
        for (int i = 0; i < sorter.length; ++i) sorter[i] = a[indeks[i]];

        assertArrayEquals(c, a, "Metoden endrer på starttabellen om den har flere like verdier.");
        assertArrayEquals(sortert, sorter, "Metoden sorterer feil om starttabellen har flere like verdier.");

        int sum = 0;
        for (int i : indeks) sum += i;
        assertEquals((indeks.length-1)*indeks.length/2, sum, "Metoden bruker (antagelig) én indeks flere ganger.");
    }
}

class Oppgave9Tests{
    @Test
    void tredjeMinForLiten() {
        if (Oblig1.gruppeMedlemmer() < 3) return;

        int[] a = {};
        assertThrows(NoSuchElementException.class, () -> Oblig1.tredjeMin(a), "Metoden gir ingen eller gal feilmelding på tom tabell.");
        int[] b = {5};
        assertThrows(NoSuchElementException.class, () -> Oblig1.tredjeMin(b), "Metoden gir ingen eller gal feilmelding på tabell med ett element.");
        int[] c = {5, 1};
        assertThrows(NoSuchElementException.class, () -> Oblig1.tredjeMin(c), "Metoden gir ingen eller gal feilmelding på tabell med to element.");
    }

    @Test
    void tredjeMinTreElement() {
        if (Oblig1.gruppeMedlemmer() < 3) return;

        int[] a = {1, 2, 3};

        do {
            int[] c = a.clone();
            int[] indekser = Oblig1.tredjeMin(c);

            assertEquals(3, indekser.length, "Metoden gir ut feil antall indekser.");
            assertArrayEquals(a, c, "Metoden endrer på starttabellen.");

            int[] sorter = {c[indekser[0]], c[indekser[1]], c[indekser[2]]};
            assertArrayEquals(new int[] {1, 2, 3}, sorter, "Metoden sorterer ikke tabellen " + Arrays.toString(a) + " riktig");
        } while (Hjelpemetoder.nestePermutasjon(a));
    }

    @Test
    void tredjeMinSeksElement() {
        if (Oblig1.gruppeMedlemmer() < 3) return;

        int[] a = {1, 2, 3, 4, 5, 6};

        do {
            int[] c = a.clone();
            int[] indekser = Oblig1.tredjeMin(c);

            assertEquals(3, indekser.length, "Metoden gir ut feil antall indekser.");
            assertArrayEquals(a, c, "Metoden endrer på starttabellen.");

            int[] sorter = {c[indekser[0]], c[indekser[1]], c[indekser[2]]};
            assertArrayEquals(new int[] {1, 2, 3}, sorter, "Metoden sorterer ikke tabellen " + Arrays.toString(a) + " riktig");
        } while (Hjelpemetoder.nestePermutasjon(a));
    }

    @Test
    void tredjeMinTilfeldigTabell() {
        if (Oblig1.gruppeMedlemmer() < 3) return;

        for (int i = 0; i < 10; ++i) {
            int[] a = Hjelpemetoder.randPerm(10);
            int[] indekser = Oblig1.tredjeMin(a);
            assertEquals(3, indekser.length, "Metoden gir feil antall indekser.");
            assertEquals(1, a[indekser[0]], "Metoden gir feil laveste verdi på tabellen " + Arrays.toString(a));
            assertEquals(2, a[indekser[1]], "Metoden gir feil nest laveste vedi på tabellen " + Arrays.toString(a));
            assertEquals(3, a[indekser[2]], "Metoden gir feil tredje laveste verdi på tabellen " + Arrays.toString(a));
        }
    }

    @Test
    void tredjeMinTid() {
        if (Oblig1.gruppeMedlemmer() < 3) return;
        int[] a = Hjelpemetoder.randPerm(100_000);
        assertTimeout(Duration.ofMillis(100), () -> Oblig1.tredjeMin(a), "Metoden er for ueffektiv på store tabeller. Sorterer du hele tabellen?");
    }
}

class Oppgave10Tests {
    @Test
    void inneholdtToTommeOrd() {
        if (Oblig1.gruppeMedlemmer() < 3) return;

        assertDoesNotThrow(() -> Oblig1.inneholdt("", ""), "Metoden kaster feilmelding på to tomme strenger.");
        assertTrue(Oblig1.inneholdt("", ""), "Metoden gir galt svar på to tomme strenger.");
    }

    @Test
    void inneholdtEttTomtOrd() {
        if (Oblig1.gruppeMedlemmer() < 3) return;

        assertDoesNotThrow(() -> Oblig1.inneholdt("", "A"), "Metoden kaster feilmelding når første streng er tom.");
        assertTrue(Oblig1.inneholdt("", "A"),"Metoden gir feil svar om første streng er tom og siste ikke er det.");

        assertDoesNotThrow(() -> Oblig1.inneholdt("A", ""), "Metoden kaster feilmelding når siste streng er tom.");
        assertFalse(Oblig1.inneholdt("A", ""), "Metoden gir feil svar om siste streng er tom og første ikke er det.");
    }

    @Test
    void inneholdtLike() {
        if (Oblig1.gruppeMedlemmer() < 3) return;

        assertTrue(Oblig1.inneholdt("ABBA", "ABBA"), "Metoden gir feil svar når første er 'ABBA' og siste også er 'ABBA'");
    }

    @Test
    void inneholdtEksempler() {
        if (Oblig1.gruppeMedlemmer() < 3) return;

        assertTrue(Oblig1.inneholdt("XYYX", "AAAAAAAYXXY"), "Metoden gir feil svar på 'XYYX' og 'AAAAAAAYXXY'.");
        assertTrue(Oblig1.inneholdt("ABBA", "RABARBRA"), "Metoden gir feil svar på 'ABBA' og 'RABARBRA'.");
        assertFalse(Oblig1.inneholdt("ABBA", "BARBERER"), "Metoden gir feil svar på 'ABBA' og 'BARBERER'.");
        assertFalse(Oblig1.inneholdt("ABBA", "AKROBAT"), "Metoden gir feil svar på 'ABBA' og 'AKROBAT'");
        assertFalse(Oblig1.inneholdt("ØÅÅØ", "ØØÅØØ"), "Metoden gir feil svar på 'ØÅÅØ' og 'ØØÅØØ'");
        assertTrue(Oblig1.inneholdt("ØÅÅØ", "ÅØØÅØ"), "Metoden gir feil svar på 'ØÅÅØ' og 'ÅØØÅØ'");
    }

    @Test
    void inneholdtTid() {
        if (Oblig1.gruppeMedlemmer() < 3) return;

        char[] x = new char[100_000];
        for (int i = 0; i < 50_000; ++i) {
            x[2*i] = 'X';
            x[2*i+1] = 'Y';
        }
        String t = String.copyValueOf(x);

        char[] y = new char[100_000];
        for (int i = 0; i < 49_999; ++i) {
            y[2*i] = 'Y';
            y[2*i+1] = 'X';
        }
        y[99_998] = 'Z';
        y[99_999] = 'Z';
        String s = String.copyValueOf(y);

        assertTimeout(Duration.ofMillis(100), () -> Oblig1.inneholdt(s,t), "Metoden er for ueffektiv på lange strenger.");
        assertFalse(Oblig1.inneholdt(s,t), "Metoden gir feil svar på lang streng.");
    }
}

class Hjelpemetoder {
    public static void bytt(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static boolean nestePermutasjon(int[] a) {
        int n = a.length;

        int i = n-2;
        while (i >= 0 && a[i] > a[i+1]) i--;
        if (i < 0) return false;
        int verdi = a[i];

        int j = n - 1;
        while (verdi > a[j]) j--;
        bytt(a, i, j);

        i++; j = n-1;
        while (i < j) bytt(a, i++, j--);
        return true;
    }

    public static int[] randPerm(int n) {
        Random r = new Random();
        int[] a = new int[n];
        for (int i = 0; i < n; ++i) a[i] = i+1;
        for (int k = n-1; k > 0; --k) {
            int i = r.nextInt(k+1);
            bytt(a, i, k);
        }
        return a;
    }
}