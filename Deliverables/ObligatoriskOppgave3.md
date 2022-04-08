# Oblig 2 - *Scuffed Mario*
**Team *relish-earshot-voice* (Gruppe 8: Belmin Husanovic, Stian Munkejord, Sander Kavli, Magne Stenseng)**

# **Deloppgave 1: Team og prosjekt**

**Hvordan fungerer rollene i teamet? Trenger dere å oppdatere hvem som er teamlead eller kundekontakt?**

Vi beholder de nye rollene fra forrige gang, ettersom vi mener de fungere veldig bra. 


**Trenger dere andre roller? Skriv ned noen linjer om hva de ulike rollene faktisk innebærer for dere.**

De nye rollene fungerer bra. Folk jobber for det meste med bare rollen de har fått tilført.

**Er det noen erfaringer enten team-messig eller mtp prosjektmetodikk som er verdt å nevne? Synes teamet at de valgene dere har tatt er gode? Hvis ikke, hva kan dere gjøre annerledes for å forbedre måten teamet fungerer på?**

Har blitt satt større fokus på Test-Driven Development (TTD). Vi begynner å bli flinkere på dette. For øyeblikket så må man starte spillet for at testene skal bli kjørt, dette har test-leader fått beskjed om, og blir sett på. 

Vi jobber med Git/GitLab, og mener branches fungerer veldig godt. Etter vi ble "strengere", oftere møter og bedre fordeling av issues føler vi at vi har fått gjort en del.


**Hvordan er gruppedynamikken?**

Vi mener at gruppedynamikken er bra. Vi har aldri hatt noen konflikter eller uenigheter. Det har oppstått misforståelser, men dette blir fort ordnet opp i.


**Hvordan fungerer kommunikasjonen for dere?**

Vi har sånn omtrent 50/50 når det gjelder digital- og i person-informasjon. Alle er godt kjent med Discord, og vi prøver å møte i person for gruppetimene på tirsdagene. I chatten så er vi ganske "seriøse", blir bare sendt viktige meldinger.


**Gjør et kort retrospektiv hvor dere vurderer hva dere har klart til nå, og hva som kan forbedres. Dette skal handle om prosjektstruktur, ikke kode. Dere kan selvsagt diskutere kode, men dette handler ikke om feilretting, men om hvordan man jobber og kommuniserer.**
Til nå har vi klart å legge opp prosjektet bra via issue board på GitLab. Holder på nå å implemenere GitLab CI CD Pipeline for automatisk testing. 

Som nevnt fra oblig 2 så var det nevnt at folk har det veldig travelt med andre fag. Team-leader bestemte seg for å bli "strengere", dvs. oftere møter, slik at resten av teamet vet hva alle gjør. Dette har fungert veldig bra. 

**Under vurdering vil det vektlegges at alle bidrar til kodebasen. Hvis det er stor forskjell i hvem som committer, må dere legge ved en kort forklaring for hvorfor det er sånn. Husk å committe alt. (Også designfiler)**

Vi lager en branch, og deretter merger den branchen inn til development. Hvis man går inn på development så ser det for øyeblikket ikke særlig fordelt av antalls commits. Belmin, Stain og Magne har "par-programmert" over på test-development branchen. 

**Referat fra møter siden forrige leveranse skal legges ved (mange av punktene over er typisk ting som havner i referat)..**

Vi legger alle møtene inn i wikien på git. Her er møtene vi har hatt etter oblig 1:
[Møtereferat 1](https://git.app.uib.no/relish-earshot/scuffed-mario/-/wikis/M%C3%B8tereferat-29.mars-2022)
[Møtereferat 2](https://git.app.uib.no/relish-earshot/scuffed-mario/-/wikis/M%C3%B8tereferat-1.april-2022)
[Møtereferat 3](https://git.app.uib.no/relish-earshot/scuffed-mario/-/wikis/M%C3%B8tereferat-5.april-2022)
[Møtereferat 4](https://git.app.uib.no/relish-earshot/scuffed-mario/-/wikis/M%C3%B8tereferat-8.april-2022)

**Bli enige om maks tre forbedringspunkter fra retrospektivet, som skal følges opp under neste sprint.**

**Jevnere Arbeid** -  Sette av mer til i uken til å jobbe med prosjektet.

**Issue Board** - Bli bedre på å jobbe mer med issues, og skrive 

**Fordele commits** - Fordele commits, eller iallefall skriver i commit meldinger hvis vi parprogrammerer, slik at arbeidsfordelingen ser mer realistisk ut.


# **Deloppgave 2: Krav**

**«Stretch goal»**

**Bestem dere for én litt mer avansert ting som dere vil prøve å få til utover et vanlig single-player platform spill. Dette kan være f.eks.: multiplayer (på samme maskin eller over nett), å porte til en annen platform (Android eller Web, f.eks.), å bytte ut grafikk-frontenden, e.l.**
For øyeblikket er spillet et "single-player" spill, men vi har ambisjoner om å implementere mulighet for lokal multiplayer. Vi tenker å begynne på dette når all singelplayer-funksjonalitet fungerer.

**Prioritér MVP og å få de enklere delene av spillet til å fungere – det er mye viktigere å ha et bra enspiller-spill for desktop med høy kodekvalitet, enn å ha noe som funker dårlig i med både én og flere spillere og på flere platformer.**
Som nevnt ovenfor så fokuserer vi på få single-player til å fungere først, før vi begynner på støtte for multiplayer. 

**Det er likevel et poeng i å tenke på dette tidlig i prosessen, så man ikke låser seg i dårlige løsninger. (Forøvrig, godt design, bra skille mellom model / view / controller, og klare abstraksjoner gjør det mye enklere å oppnå «stretch»-forslagene over.)**
For tida fokuserer vi på design, ryddig kode og kode med høy kvalitet, slik at vi senere kan utvikle ønsket stretch "mål" fra et solid grunnlag.


**MVP og annet**
For øyeblikket så prioriterer vi kjeren til spillet dvs. kollisjon, bevegelse, fiender osv. 

Siden siten gang så har vi implementert at spiller kan dø hvis man detter ut av banen. Fienden har nå fått kollisjon, og flytter seg automatisk til høyre og venstre. Fiender kan nå skyte. Spiller kan dø hvis man blir skytt på. Hvis man dette ut av banen, eller blir skytt på, så "re-spawner" man. Har også implementert tester, selv om disse for øyeblikket er ikke "automatisk".

Vi beholder MVP kravene fra forrige gang, ettersom vi går for høyere kodekvalitet.

Neste steg er å sette bilder for alle objektene, lage score, enda mer implementering av fiende, "mål"


# **Deloppgave 3: Krav**
For øyeblikket så har vi en CI/CD, men vi har litt problemer med å få satt den opp riktig. Dette må vi se på mer for neste gang.  

![Class Diagram]( "Class Diagram")
