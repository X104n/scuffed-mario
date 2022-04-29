# Oblig 4 - *Scuffed Mario*
**Team *relish-earshot-voice* (Gruppe 8: Belmin Husanovic, Stian Munkejord, Sander Kavli, Magne Stenseng)**

# **Deloppgave 1: Team og prosjekt**

**Hvordan fungerer rollene i teamet? Trenger dere å oppdatere hvem som er teamlead eller kundekontakt?**

Vi beholder de nye rollene fra forrige gang, ettersom vi mener de fungerer veldig bra. Vi kan jobbe selvstendig med våre egne oppgaver, og merge dette til det felles prosjektet uten merge konflikter.


**Trenger dere andre roller? Skriv ned noen linjer om hva de ulike rollene faktisk innebærer for dere.**

De nye rollene fungerer bra. Folk jobber for det meste med bare rollen de har fått tilført.
Teamleader & kontaktperson - Belmin : Oppfølging av de andre rollene på gruppen, og parprogrammerer med de som sitter fast.
Testerleder - Magne : Tok ansvar for utvikling av alle nødvendige tester for vårt prosjekt. Mye av ansvaret lå i å lese seg opp på ulike måter å teste programmet på.
Designansvarlig - Stian : Stått for kart og kunst brukt i prosjektet. Stått for backend kode og oppgraderinger til denne.
LibGDX utvikler - Sander : Implementer det meste av objektklasser til spillet, og jobbet med å gjøre disse kompakte med Generic metoder og superklasser.

**Er det noen erfaringer enten team-messig eller mtp prosjektmetodikk som er verdt å nevne? Synes teamet at de valgene dere har tatt er gode? Hvis ikke, hva kan dere gjøre annerledes for å forbedre måten teamet fungerer på?**

Har nå blitt satt større fokus på Test-Driven Development (TTD). Vi begynner å bli flinkere på dette, men fortsatt en lang vei å gå. For øyeblikket så må man starte spillet for at testene skal bli kjørt, dette har test-leader fått beskjed om, og blir sett på for øyeblikket. Om noe skulle bli gjort annerledes på denne fronten, burde vi satt oss ned og lest oss opp på effektive metoder å teste på før vi gikk i gang.

Vi jobber med Git/GitLab, og mener branches fungerer veldig godt. Etter vi ble "strengere", dvs. oftere møter og bedre fordeling av issues føler vi at vi har fått gjort mer. Dette burde vi ha vært nøyere på fra starten av.




**Hvordan er gruppedynamikken?**

Vi mener at gruppedynamikken er bra. Vi har aldri hatt noen konflikter eller uenigheter. Det har oppstått misforståelser, men dette blir fort ordnet opp i takket være hyppige gruppemøter og god kommunikasjon over discord mellom møtene.


**Hvordan fungerer kommunikasjonen for dere?**

Vi har sånn omtrent 50/50 når det gjelder digital- og i person-informasjon. Alle er godt kjent med Discord, og vi prøver å møte i person for gruppetimene på tirsdagene. I chatten så er vi ganske "seriøse", blir bare sendt viktige meldinger.


**Gjør et kort retrospektiv hvor dere vurderer hva dere har klart til nå, og hva som kan forbedres. Dette skal handle om prosjektstruktur, ikke kode. Dere kan selvsagt diskutere kode, men dette handler ikke om feilretting, men om hvordan man jobber og kommuniserer.**

Vi har klart å produsere et spill, der hvert gruppemedlem har laget sitt gjennomførte aspekt som bidrar til en komplett helhet. Vi har kommunisert godt med hverandre, gitt hverandre tilbakemeldinger og oppdateringer på hvor langt i prosjektet vi har kommet.

Det vi kunne blitt flinkere på er å utarbeide en mer grundig plan, slik at alle forholder seg til en "mal", og vil kunne forstå hva de forskjellige klassene gjør selv før de er blitt implementert. Vi burde også ha utnyttet parprogrammering enda mer, ettersom at dette har vært et utrolig godt verktøy for å gi innsikt og forståelse for hverandres kode, samt samarbeide for å løse problemer innad hverandres koden.

**Under vurdering vil det vektlegges at alle bidrar til kodebasen. Hvis det er stor forskjell i hvem som committer, må dere legge ved en kort forklaring for hvorfor det er sånn. Husk å committe alt. (Også designfiler)**

Vi føler vi har arbeidsfordelt jevnt, og alle bidrar med like mye til prosjektet. Likevel vil det være vanskelig å se utad ifra, ettersom at eksempelvis Stian og Magne måtte bruke mer tid enn oss andre på å gjøre research på backend design og strategier og hjelpemidler for testing.

**Referat fra møter siden forrige leveranse skal legges ved (mange av punktene over er typisk ting som havner i referat)..**

Vi legger alltid møtene inn i wikien på git. Her er møtene vi har hatt etter oblig 3:

[Møtereferat 1](https://git.app.uib.no/relish-earshot/scuffed-mario/-/wikis/M%C3%B8tereferat-19.april-2022)

[Møtereferat 2](https://git.app.uib.no/relish-earshot/scuffed-mario/-/wikis/M%C3%B8tereferat-21.april-2022)

[Møtereferat 3](https://git.app.uib.no/relish-earshot/scuffed-mario/-/wikis/M%C3%B8tereferat-25.april-2022)

[Møtereferat 4](https://git.app.uib.no/relish-earshot/scuffed-mario/-/wikis/M%C3%B8tereferat-26.april-2022)

[Møtereferat 5](https://git.app.uib.no/relish-earshot/scuffed-mario/-/wikis/M%C3%B8tereferat-28.april-2022)

[Møtereferat 6](https://git.app.uib.no/relish-earshot/scuffed-mario/-/wikis/M%C3%B8tereferat-29.april-2022)
# **Deloppgave 2: Krav**
### Brukerhistorie for hva som har blitt jobbet på denne gang
1. Som en spiller ønsker jeg evnen til å skade fiender på flere måter. 
- Akseptansekriterier: Gitt at spilleren kan plukke opp våpen, kan han beseire motstandere på flere måter.
    - Arbeidsoppgave: Implementere klasser for våpen og tilsvarende logikk for spilleren.
        - Implementere variasjon i måten å beseire motstandere på (våpen etc) og måten spilleren beveger seg på. [Issue #48](https://git.app.uib.no/relish-earshot/scuffed-mario/-/issues/48)

2. Som en spiller ønsker jeg å kunne spille flere nivåer.
- Akseptansekriterier: Gitt at spilleren kan progressere til nye nivåer, vil spilletiden forlenges og det finnes mer mulighet i forskjellig design av baner.
    - Arbeidsoppgave: Utarbeide flere kart og logikk for å bytte mellom banene.
        - Med hjelp av "Tiled" map editor kan vi lage flere tiled-filer, og bytte mellom disse for å la spiller spille ulike nivåer. [Issue #49](https://git.app.uib.no/relish-earshot/scuffed-mario/-/issues/49)

3. Som en spiller ønsker jeg å fullføre spillet.
- Akseptansekriterier: Gitt at spiller dør eller vinner, vil spillet avsluttes med en meny.
    - Arbeidsoppgave: At spillet skal kunne avsluttes på forskjellig grunnlag
        - Å implementere logikk for å avslutte spillet ved at spiller enten dør eller vinner, og hvordan applikasjonen skal navigere mellom de ulike nivåene [Issue #50](https://git.app.uib.no/relish-earshot/scuffed-mario/-/issues/50)

**«Stretch goal»**

**Bestem dere for én litt mer avansert ting som dere vil prøve å få til utover et vanlig single-player platform spill. Dette kan være f.eks.: multiplayer (på samme maskin eller over nett), å porte til en annen platform (Android eller Web, f.eks.), å bytte ut grafikk-frontenden, e.l.**
Vi prioritere ikke mulitplayer for denne innleveringen, men dette er noe vi kunne implementert hvis vi hadde mer tid. Vi ser for oss en lokal multiplayer løsning i første omgang.

**Prioritér MVP og å få de enklere delene av spillet til å fungere – det er mye viktigere å ha et bra enspiller-spill for desktop med høy kodekvalitet, enn å ha noe som funker dårlig i med både én og flere spillere og på flere platformer.**

Som nevnt tidligere ønsker vi å få single-player til å fungere. 

**Det er likevel et poeng i å tenke på dette tidlig i prosessen, så man ikke låser seg i dårlige løsninger. (Forøvrig, godt design, bra skille mellom model / view / controller, og klare abstraksjoner gjør det mye enklere å oppnå «stretch»-forslagene over.)**

For tida fokuserer vi på å utvide spillets funksjonalitet, legge til flere objekter, flere fiender og menyer til spillet for at det skal se bedre ut.

# **Deloppgave 3: Krav**
![Class Diagram](klasseDiagram2.png?raw=true "Class Diagram")

SonarQube:
![Class Diagram](sonarqube_dashboard.png?raw=true "Class Diagram")
![Class Diagram](sonarqube_bug1.png?raw=true "Sonarqube bug 1 report")
![Class Diagram](sonarqube_bug2.png?raw=true "Sonarqube bug 2 report")
![Class Diagram](sonarqube_bug3.png?raw=true "Sonarqube overall report")
