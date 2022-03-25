# Oblig 2 - *Scuffed Mario*
* Team *relish-earshot-voice* (Gruppe 8: Belmin Husanovic, Stian Munkejord, Sander Kavli, Magne Stenseng) *

# **Deloppgave 1: Team og prosjekt**

**Hvordan fungerer rollene i teamet? Trenger dere å oppdatere hvem som er teamlead eller kundekontakt?**

Vi gjør noen små endringer til rollene, Stian går fra Test-leder til Design-leder, og Magne går fra design til Tester.  Alle på gruppen er enig i rollefordelingen og er fornøyd med sine tildelte oppgaver. 


**Trenger dere andre roller? Skriv ned noen linjer om hva de ulike rollene faktisk innebærer for dere.**

De nye rollene fungerer bra. Hovedsakelig så jobber alle nå i begynnelsen litt med alt, men begynner nå gå mer og mer i sine tildelte roller. F.eks. hvis det er en person som skal ha kontroll på libGDX, men så trenger faktisk flere personer på gruppen å jobbe med libGDX også, og det er derfor flere som jobber på det da. 


**Er det noen erfaringer enten team-messig eller mtp prosjektmetodikk som er verdt å nevne? Synes teamet at de valgene dere har tatt er gode? Hvis ikke, hva kan dere gjøre annerledes for å forbedre måten teamet fungerer på?**

Test-Driven Development (TTD) fungerer dårlig. Vi har ikke vært flinke på dette, ettersom vi har hatt interne problemer med koden (blir forklart senere). Vi mener at mye av koden ikke er særlig relatert til forretningslogikken, som gjør det å lage tester vanskelig. 

Vi jobber med Git/GitLab, og mener branches fungerer veldig godt. Merker veldig godt at teamet har veldig lite tid, ettersom alle har "tunge" fag, og det fører til at vi ligger litt bak for denne innleveringen. 


**Hvordan er gruppedynamikken?**

Vi mener at gruppedynamikken er bra. Vi har aldri hatt noen konflikter eller uenigheter. Det har oppstått misforståelser, men dette blir fort ordnet opp i.


**Hvordan fungerer kommunikasjonen for dere?**

Vi har sånn omtrent 50/50 når det gjelder digital- og i person-informasjon. Alle er godt kjent med Discord, og vi prøver å møte i person for gruppetimene på tirsdagene. I chatten så er vi ganske "seriøse", blir bare sendt viktige meldinger.


**Gjør et kort retrospektiv hvor dere vurderer hva dere har klart til nå, og hva som kan forbedres. Dette skal handle om prosjektstruktur, ikke kode. Dere kan selvsagt diskutere kode, men dette handler ikke om feilretting, men om hvordan man jobber og kommuniserer.**
Til nå har vi klart å legge opp prosjektet bra via issue board på GitLab. Holder på nå å implemenere GitLab CI CD Pipeline for automatisk testing. 

Som nevnt tidligere å har folk det veldig travelt med andre fag, og det blir ikke mye gjort her. Løsningen til dette er at Belmin (teamleader) må ha mer oppfølgning av hva folk jobber på, og at vi trenger å ha en gruppe time til i uken. Gruppen burde være flinkere til å jobbe med issues. Som en gruppe må vi jobbe jevnt fremover med prosjektet, men er litt vanskelig nå for tiden, ettersom dette faget krasjer litt med timeplaner til folk. Belmin skal nå ha ansvar for å pushe gruppen for å ta igjen det vi ikke klarte til neste oblig. 

**Under vurdering vil det vektlegges at alle bidrar til kodebasen. Hvis det er stor forskjell i hvem som committer, må dere legge ved en kort forklaring for hvorfor det er sånn. Husk å committe alt. (Også designfiler)**

Vi lager en branch, og deretter merger den branchen inn til development. Hvis man går inn på development så ser det for øyeblikket ikke særlig fordelt av antalls commits. Belmin og Stian har jobbet mye ved å "oppgradere" back-end på prosjektet ettersom vi hadde store problemer med dette. Belmin og Stian har derfor parprogrammert mye sammen. 

**Referat fra møter siden forrige leveranse skal legges ved (mange av punktene over er typisk ting som havner i referat)..**

Vi legger alle møtene inn i wikien på git. Her er møtene vi har hatt etter oblig 1:
[Møtereferat 1](https://git.app.uib.no/relish-earshot/scuffed-mario/-/wikis/M%C3%B8tereferat-22.feb-2022)
[Møtereferat 2](https://git.app.uib.no/relish-earshot/scuffed-mario/-/wikis/M%C3%B8tereferat-11.mars-2022)
[Møtereferat 3](https://git.app.uib.no/relish-earshot/scuffed-mario/-/wikis/M%C3%B8tereferat-15.mars-2022)

**Bli enige om maks tre forbedringspunkter fra retrospektivet, som skal følges opp under neste sprint.**

**Jevnere Arbeid** -  Sette av mer til i uken til å jobbe med prosjektet.

**Issue Board** - Bli bedre på å jobbe mer med issues. 

**Fordele commits** - Fordele commits, eller iallefall skriver i commit meldinger hvis vi parprogrammerer, slik at arbeidsfordelingen ser mer realistisk ut.


# **Deloppgave 2: Krav**

**«Stretch goal»**

**Bestem dere for én litt mer avansert ting som dere vil prøve å få til utover et vanlig single-player platform spill. Dette kan være f.eks.: multiplayer (på samme maskin eller over nett), å porte til en annen platform (Android eller Web, f.eks.), å bytte ut grafikk-frontenden, e.l.**
For øyeblikket så skal spillet være et "single-player" spill. Dette kan selvsagt bli forandret i etterkant, men da vil det bli det bli oppdatert. 

**Prioritér MVP og å få de enklere delene av spillet til å fungere – det er mye viktigere å ha et bra enspiller-spill for desktop med høy kodekvalitet, enn å ha noe som funker dårlig i med både én og flere spillere og på flere platformer.**
Som nevnt ovenfor så fokuserer vi på få single-player til å fungere først. 

**Det er likevel et poeng i å tenke på dette tidlig i prosessen, så man ikke låser seg i dårlige løsninger. (Forøvrig, godt design, bra skille mellom model / view / controller, og klare abstraksjoner gjør det mye enklere å oppnå «stretch»-forslagene over.)**
For øyeblikket så har vi ikke en "main character", ettersom vi ikke ble helt ferdig med design. Blir selvsagt fikset til neste gang. 


**MVP og annet**
For øyeblikket så prioriterer vi kjeren til spillet dvs. kollisjon, bevegelse, fiender osv. Siden sist gang så har vi byttet ut "placeholder"-bilder med mer permentant bilder. Vi har også begynt å bygge på vårt design. Vi går fremover ved å bygge på kjernen til spillet, ved å lage score, spiller må kunne dø, og selvsagt så må spiller kunne vinne. Det er vårt neste steg nå. 


Vi hadde store problemer med back-end og dependencies, dette tok desverre mye lengre til enn forventet å fått ordnet dette. Vi ligger derfor litt bak på hvor vi hadde ønsket å ligget, men gruppen er motivert å ta dette igjen for neste oblig. Dette skal Belmin følge veldig godt med i tiden fremover nå. Problemet som startet dette var kollisjon. Back-end våres støttet rett og slett ikke hva vi prøvde å implementere, noe som gjorde at vi trengte en back-end oppgradering. Vi mener at dette kommer vi til å få mer utnytte fremover nå, ettersom vi nå setter fokus på å bli ferdig med MVP. 
Enemy blir jobbet på nå, men desverre ikke klar for denne obligen. 

Vi beholder MVP kravene fra forrige gang, ettersom vi går for høyere kodekvalitet.


# **Deloppgave 3: Krav**

![Class Diagram](klasseDiagarm.png?raw=true "Class Diagram")
