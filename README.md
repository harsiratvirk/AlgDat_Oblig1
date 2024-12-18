[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/VjzRkYWj)
# Compulsory Assignment 1 in DATS2300 - Algorithms and Data Structures

This assignment is a submission in Algorithms and Data Structures (in Norwegian).

## Oppgavebeskrivelser
### Oppgave 1
a) For hver iterasjon utføres en sammenligning og antall iterasjoner er n-1, hvor n er tabellens lengde. 
b) Best-case: O(n). Allerede sortert liste, en iterasjon, 0 ombyttinger.
c) Worst-case: O(n^2). Omvendt sortert liste. Antall ombyttinger: n(n − 1)/2.
d) Average-case: O(n^2). Antall ombyttinger: n(n − 1)/4.
Boblesortering er minst effektiv av de metodene vi har sett på. Brukes normalt ikke, særlig ikke på store tabeller.

I oppgave 1 begynte jeg med å sjekke om listen var tom, og ga en passende tilbakemelding hvis det var tilfelle. 
Deretter sammenlignet jeg de to første elementene, og byttet dem om hvis det første var større. Denne prosessen 
fortsetter gjennom hele listen, slik at den største verdien til slutt havner bakerst, og det er denne verdien som returneres.

For metoden ombyttinger() brukte jeg samme logikk som i maks-metoden, men med en hjelpevariabel for å holde 
oversikt over antall ombyttinger som utføres for en tilfeldig permutasjon av tall.
 
### Oppgave 2
I oppgave 2 startet jeg med å sjekke om listen var tom, og returnerte 0 hvis det var tilfelle. 
Deretter opprettet jeg en variabel for å telle unike elementer, satt til 1 siden første element alltid er unikt.
Jeg benyttet en løkke og if-setning for å sjekke om  listen var sortert, ved å sammenligne hvert element med 
det forrige, og kastet en IllegalStateException hvis listen ikke var sortert. For hvert unike element økte telleren, 
og til slutt returnerte metoden antallet unike elementer.

### Oppgave 3
I oppgave 3 sjekket jeg først om tabellen var tom, og returnerte 0 i så fall, da det ikke er noen unike elementer i en tom tabell.
Deretter opprettet jeg en variabel for å telle unike elementer og en boolean-variabel for å spore om et element er unikt.

Videre brukte jeg en ytre løkke for å iterere gjennom tabellen fra andre element til slutten. For hvert element benyttet 
jeg en indre løkke for å sjekke om det nåværende elementet allerede fantes blant de tidligere elementene. 
Hvis et duplikat ble funnet (a[i] == et tidligere element a[j]), ble erUnik satt til false og den indre 
løkken avsluttet med break, siden videre sammenligning er unødvendig.
Hvis erUnik forblir true etter at den indre løkken er ferdig, økes antUnike. Til slutt returneres denne variabelen
som holder antall unike elementer i tabellen.

### Oppgave 4
I oppgave 4 deklarerte jeg først pekere for å omorganisere tabellen ved å flytte oddetall til venstre og partall til høyre.
Venstrepekeren blir flyttet fremover til den finner et partall, og høyrepekeren bakover for oddetall, og elementene byttes.
Når pekerne møtes og hele tabellen består av kun oddetall eller partall, brukes kvikksortering på hele tabellen.
Hvis ikke, brukes kvikksortering separat på de to delene.

### Oppgave 5
I oppgave 5 gikk jeg frem ved å først håndtere spesialtilfeller der tabellen er tom eller inneholder ett element.
Alle elementer i tabellen ble flyttet ett steg mot høyre med en løkke som byttet det første elementet med hvert 
påfølgende element helt til siste element ble satt på første plass.

### Oppgave 7
I oppgave 7a gikk jeg frem ved å bruke en variabel til å holde styr på lengden til den korteste av de to strengene, 
og en StringBuilder for å bygge opp den nye flettede strengen på en effektiv måte. For å håndtere tilfeller der en 
av strengene er lengre enn den andre, la jeg til de gjenværende tegnene fra den lengste strengen til slutt. 
For 7b utvidet jeg løsningen for å håndtere et antall strenger ved å bruke en StringBuilder og en løkke. 
Jeg gikk gjennom hver streng, hentet tegn basert på den nåværende posisjonen, og hoppet over strenger som var «oppbrukt». 
Løkken avsluttes når alle tegnene fra den lengste strengen er flettet inn.
