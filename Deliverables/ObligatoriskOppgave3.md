# Oblig 2 - *Scuffed Mario*
**Team *relish-earshot-voice* (Gruppe 8: Belmin Husanovic, Stian Munkejord, Sander Kavli, Magne Stenseng)**

# **Deloppgave 1: Team og prosjekt**

**Hvordan fungerer rollene i teamet? Trenger dere å oppdatere hvem som er teamlead eller kundekontakt?**

Vi beholder de nye rollene fra forrige gang, ettersom vi mener de fungerer veldig bra. 


**Trenger dere andre roller? Skriv ned noen linjer om hva de ulike rollene faktisk innebærer for dere.**

De nye rollene fungerer bra. Folk jobber for det meste med bare rollen de har fått tilført.

**Er det noen erfaringer enten team-messig eller mtp prosjektmetodikk som er verdt å nevne? Synes teamet at de valgene dere har tatt er gode? Hvis ikke, hva kan dere gjøre annerledes for å forbedre måten teamet fungerer på?**

Har nå blitt satt større fokus på Test-Driven Development (TTD). Vi begynner å bli flinkere på dette, men fortsatt en lang vei å gå. For øyeblikket så må man starte spillet for at testene skal bli kjørt, dette har test-leader fått beskjed om, og blir sett på for øyeblikket.

Vi jobber med Git/GitLab, og mener branches fungerer veldig godt. Etter vi ble "strengere", dvs. oftere møter og bedre fordeling av issues føler vi at vi har fått gjort mer.


**Hvordan er gruppedynamikken?**

Vi mener at gruppedynamikken er bra. Vi har aldri hatt noen konflikter eller uenigheter. Det har oppstått misforståelser, men dette blir fort ordnet opp i.


**Hvordan fungerer kommunikasjonen for dere?**

Vi har sånn omtrent 50/50 når det gjelder digital- og i person-informasjon. Alle er godt kjent med Discord, og vi prøver å møte i person for gruppetimene på tirsdagene. I chatten så er vi ganske "seriøse", blir bare sendt viktige meldinger.


**Gjør et kort retrospektiv hvor dere vurderer hva dere har klart til nå, og hva som kan forbedres. Dette skal handle om prosjektstruktur, ikke kode. Dere kan selvsagt diskutere kode, men dette handler ikke om feilretting, men om hvordan man jobber og kommuniserer.**
Til nå har vi klart å legge opp prosjektet bra via issue board på GitLab. Holder på nå å implemenere GitLab CI CD Pipeline for automatisk testing. 

Som nevnt fra oblig 2 så var det nevnt at folk har det veldig travelt med andre fag. Team-leader bestemte seg for å bli "strengere", dvs. oftere møter, slik at resten av teamet vet hva alle gjør. Dette har fungert veldig bra, og vi fortsetter slik.

**Under vurdering vil det vektlegges at alle bidrar til kodebasen. Hvis det er stor forskjell i hvem som committer, må dere legge ved en kort forklaring for hvorfor det er sånn. Husk å committe alt. (Også designfiler)**

Vi lager en branch, og deretter merger den branchen inn til development. Hvis man går inn på development så ser det for øyeblikket ikke særlig fordelt av antalls commits. Belmin, Stain og Magne har "trippel-par-programmert" over på test-development branchen. 

**Referat fra møter siden forrige leveranse skal legges ved (mange av punktene over er typisk ting som havner i referat)..**

Vi legger alltid møtene inn i wikien på git. Her er møtene vi har hatt etter oblig 2:

[Møtereferat 1](https://git.app.uib.no/relish-earshot/scuffed-mario/-/wikis/M%C3%B8tereferat-29.mars-2022)
[Møtereferat 2](https://git.app.uib.no/relish-earshot/scuffed-mario/-/wikis/M%C3%B8tereferat-1.april-2022)
[Møtereferat 3](https://git.app.uib.no/relish-earshot/scuffed-mario/-/wikis/M%C3%B8tereferat-5.april-2022)
[Møtereferat 4](https://git.app.uib.no/relish-earshot/scuffed-mario/-/wikis/M%C3%B8tereferat-8.april-2022)

**Bli enige om maks tre forbedringspunkter fra retrospektivet, som skal følges opp under neste sprint.**

**Prøve med par programming** -  Prøve å sette sammen de som jobber mye sammen med de som jobber litt mindre

**Issue Board** - Bli bedre på å jobbe tiitel på issue, og bedre forklaring inne på issues 

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
For øyeblikket så prioriterer vi "kjernen" til spillet dvs. kollisjon, bevegelse, fiender osv. 

- Spilleren kan nå spawne på nytt hvis man faller ut av kartet
- Fienden kan nå bevege seg på egen hånd
- Spilleren kan nå "krympe" fienden ved å hoppe på den
- spilleren kan nå "drepe fienden ved å først hoppe på den, deretter gå i den fra siden (når den er liten)
- Fienden kan nå skyte
- Spilleren kan nå dø av å bli skutt
- Hovedmeny lagt til
- Lagt til nye tester, selv om disse for øyeblikket er ikke "automatisk".

Vi beholder MVP kravene fra forrige gang, ettersom vi går for høyere kodekvalitet.

Neste steg er å sette bilder for alle objektene, lage score, enda mer implementering av fiende (flere av dem) og til slutt en form av "mål"

### Brukerhistorie for hva som har blitt jobbet på denne gang
1. Som en spiller må jeg kunne se menyen for å starte spillet.
- Akseptansekriterier: Spillet starter på "main menu" når man starter spillet.
- Arbeidsoppgaver: 
	- [x] En visuell indikasjon for start knappen
	- [x] Vise når spillet har startet

2. Som en spiller må jeg kunne stoppe spillet i menyen
- Akseptansekriterier: Spilleren må kunne stoppe spillet etter man har startet det
- Arbeidsoppgaver: 
	- [ ] Som spiller må jeg kunne få opp menyen etter jeg har startet det (etter man trykket "play")
	- [ ] Lage logikk for å vise en avslutt knapp i menyen ((etter man har trykket "play"))
	- [x] kunne avslutte spillet med å trykke "esc" etter man har startet spillet

3. Som en spiller må jeg kunne stoppe lukke(exit) i menyen
- Akseptansekriterier: Spilleren må ha mulighet til å trykke "exit" for å lukke spillet i "main menu"
- Arbeidsoppgaver: 
	- [x] Lage logikk for å vise en avslutt knapp i menyen

4. Som en spiller må jeg kunne dø
- Akseptansekriterier: Spilleren må kunne ta skade
- Arbeidsoppgaver: 
	- [ ] Som spiller må jeg se hvor mye liv jeg her
	- [x] Som spiller må jeg ha mulighet til å miste liv

5. Som en spiller må jeg kunne "respawne"
- Akseptansekriterier: Spilleren må kunne "komme tilbake"/ begynne på nytt hvis man dør
- Arbeidsoppgaver: 
	- [x] Som spiller må jeg kunne ha mulighet til å begynne på nytt hvis man dør

6. Som en spiller må jeg kunne skade fienden
- Akseptansekriterier: Spilleren må kunne fienden
- Arbeidsoppgaver: 
	- [x] Som en spiller må jeg kunne "skade" fienden på ved å hoppe på den

7. Som en fiende må jeg kunne bevege meg selv
- Akseptansekriterier: Fienden må kunne bevege seg høyre og venstre
- Arbeidsoppgaver: 
	- [x] Som en fiende må jeg ha muligheten til å bevege meg 
	- [x] Som en fiende må jeg kunne flytte på meg selv

8. Som en fiende må jeg kunne skade spiller
- Akseptansekriterier: Fienden må kunne skade spiller ved å skyte på dem
- Arbeidsoppgaver: 
	- [x] Som en fiende må jeg kunne ha mulighet til å skyte
	- [x] Som en fiende må jeg kunne oppdage at skuddet treffer spiller (kollisjons-bokser)


# **Deloppgave 3: Krav**
For øyeblikket så har vi en CI/CD, men vi har litt problemer med å få satt den 
opp riktig. Dette må vi se på mer for neste gang.  

![Class Diagram](klasseDiagram2.png?raw=true "Class Diagram")
