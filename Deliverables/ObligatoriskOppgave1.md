# Gruppe 8 - Relish-earshot

## Oppgave 1 
Vi har valgt teamnavnet **Scuffed-Mario**
Belmin Husanovic: Er 4. semester student på datateknologi, har hatt `INF100`, `INF101` og `INF102`. 

Magne Stenseng: 8. semester, datasikkerhet, `INF100`, `INF101`, `INF102`, `INF214`, `INF226`, `INF242` og `INF240`.

Stian Munkejord: Er 4. semester student på datasikkerhet, har hatt `INF100`, `INF101` og `INF102`. 

Sander Kavli: 6. semester bioinformatikk, `INF100`, `INF101` og `INF102`

Alle i teamet har på noe erfaring med programmering. Virker alle på gruppen kan noe om Java-kode. 

## Roller 
Belmin, tar rollen som Team-Leader og kontaktperson for gruppen. Ettersom han har hatt erfaring med dette faget før. 
- Leder teammøter
- Er ansvarlig for fordeling av issue-board oppgaver
- Har ansvar for git 
- Har ansvar for at folk jobber/klarer oppgavene sine 
- Har også ansvar for skrive-delen

Magne, tar rollen som designer 
- Tar ansvar for å passe på at alle følger rett design ovenfor spillet

Stian, tar rollen som Test-leder
- Har ansvar for at vi følger testdreven metodikk 

Sander, tar rollen som LIBgdx utvikler
- Har ansvar at vi følger MVP for back-end kravene
- Har ansvar for dokumentasjonen for LIBgdx

## Oppgave 2 

### Prosjektmetodikk
Ved å bruke Kanban, parprogrammering og testing jobber vi godt sammen, men også ikke minst at alle holder samme syn for prosjektet og at koden fungerer som den skal med tester. 


### Diskuter i teamet hvilke metoder som hjelper teamet med å utvikle fungerende og veldokumentert programvare under prosjektet.
Som tidligere nevnt ovenfor er det viktig at teamet føler prosjektmetodikken. Et eksempel på dette var at vi bruker engelsk i kildekoden, variabelnavn og commit meldinger som gir mening for hverandre. Vi har også blitt enig om å skrive kommentarer/dokumentasjon for når koden blir mer komplisert, men for øyeblikket er mye informasjon i discorden og gitt muntlig under møter. Dette blir selvsagt fikset for innlevering 2. I møtene skal vi fortelle hva vi jobber med, og evt. hva man trenger hjelp med. Vi møtte relativt ofte den første uken for i å informere hverandre om prosjektet og hvordan vi skal jobbe sammen, dette kan du se i wiki på GitLab. Her kommer også Kanban godt inn ved:
- Fordele oppgaver 
- Prioritere hvilken oppgave som må bli gjort 
- Holde hverandre oppdatert på hva folk jobber med 

Disse metodene mener vi hjelper oss å utvikle fungerende og veldokumentert programvare under prosjektet. 

### Organisering av team
Vi møter ofte i uken, men møter også i felles for gruppetimen på tirsdag kl.12:00. Fremover så tenker vi å ha et fast tidspunkt for å møte over Discord, ved brukt av chat og voice-chat for å kommunisere oftere med hverandre. Bruker issue-board på GitLab fordi da har alt samlet på et sted, og kan derfor lettere integrere issues mot pull requests. 

#### Bruk av Kanban 
Hvordan det er satt opp nå har er vi har kolonner for open, help-needed, WIP (work in progress) og closed. help-needed mener vi trengs for å få en lettere oversikt om hvem som trenger hjelp, ettersom vi ikke assignee flere personer til ett issue i GitLab, som kan fører til litt forvirringer. Løsningen vi kom frem til var å lage en ny kolonne for "help-needed" så kan vi kontakte den person som har tagget sitt issue der og høre om hvilken hjelp de trenger. Så langt så har det fungert godt. 

#### Bruk av git og [Gitflow](https://www.atlassian.com/git/tutorials/comparing-workflows/gitflow-workflow)  
Vi har en hoved branch for relase (master), og en developer branch. Når vi implementere noe fra en issue, lager vi en ny branch fra developer-branchen, og lager en "pull-request" tilbake til developer-branchen når problemet er løst. Dette kalles for [Gitflow](https://www.atlassian.com/git/tutorials/comparing-workflows/gitflow-workflow). I denne pull requesten (PR) så kan vi kommentere, komme med innspill og "godkjenne" endringer. I tillegg til dette så skriver vi "Fixed #issue_tallet" i commit meldingen, samt en kommentar i issue i hvilken commit det ble gjort. Dette gjøres for øyeblikket av personen som lager PR, men dette jobber vi mer på til neste innlevering ettersom issues for øyeblikket er veldig små. For hver innlevering så merger vi development til master, samt lager vi en release inne på GitLab. 

## Oppgave 3 
### Overordene mål:
Målet med prosjektet er å lage en versjon av Mario spillene, og det er der teamnavnet vår kommer fra. For denne innleveringen jobber vi først ved å få "kjernen" til spillet å fungere. Dvs. få opp et brett, og få Mario til å flytte på seg. Disse blir selvsagt bygd opp for hver innlevering. 

### Brukerhistorie 
1. Som en spiller må jeg kunne se spillbrettet for å vite hvor man skal gå.
- Akseptansekriterier: Spilleren må kunne se brettet
    - Arbeidsoppgave: 
		- [ ] Lage kode med rammeverket LIBgdx slik at spilleren kan se brettet.

3. Som en spiller må jeg kunne bevege med piltaster/WASD og mellomrom
- Akseptansekriterier: Spilleren må kunne se bevege seg med input fra tastaturet
    - Arbeidsoppgave: 
		- [ ] Lage logikk som flytter Mario i riktig retning.

2. Som en spiller må jeg kunne se Mario for å vite hvor spillet "begynner"
- Akseptansekriterier: Mario må vises på spillbrettet
- Arbeidsoppgaver: 
	- [ ] Vis en et bilde(sprite) av Mario på brettet.

3. Som en spiller må jeg kunne ha muligheten til å tape/vinne for å avslutte spillet.
- Akseptansekriterier: 
	- Spilleren må skjønne raskt hva man skal gjøre i spillbrettet
	- Spilleren må kunne se fiender 
	- Spilleren må få en indikasjon for om de tar skade/dør
	- Gitt at spilleren kommer seg til mål, så må de få en indikasjon at de har kommet seg til mål.
	- Git at spilleren tar skade må de få tilbakemelding om dette.
- Arbeidsoppgaver: 
	- [ ] Få spilleren til å forstå at de skal jeg en spesefikk vei (høyre/venstre)
	- [ ] Få fiender synlig på brettet
	- [ ] Logikk som gir tilbakemelding om spilleren dør/tar skade
	- [ ] Logikk som gir tilbakemelding om de kommer seg til mål
	- [ ] Logikk som gir hvor mye skade spilleren har hatt

4. Som en må spiller må jeg vite hvordan jeg kommer til mål.
- Akseptansekriterier: Mario må kunne vite hvilken objekter gjør hva, for å vite hvordan de kommer seg til mål.
- Arbeidsoppgaver: 
	- [ ] For hvert objekt (fiende, plattform), må spilleren gjøre riktig handling for å komme seg videre. (F.eks. Hoppe på en platform)

5. Som en spiller må jeg kunne se menyen for å starte spillet.
- Akseptansekriterier: Spilleren må ha en "knapp" for å få opp menyen til å starte spillet.
- Arbeidsoppgaver: 
	- [ ] En visuell indikasjon for start knappen
	- [ ] Vise når spillet har startet

6. Som en spiller må jeg kunne stoppe spillet i menyen
- Akseptansekriterier: Spilleren må kunne få opp meny, og samt kunne avslutte det
- Arbeidsoppgaver: 
	- [ ] Som spiller må jeg kunne få opp menyen etter jeg har startet det
	- [ ] Lage logikk for å vise en pause knapp i menyen
	- [ ] Lage logikk for å vise en avslutt knapp i menyen

### En prioritert liste over hvilke brukerhistorier dere vil ha med i første iterasjon
1. Som en spiller må jeg kunne se spillbrettet
2. Som en spiller må jeg kunne se Mario
3. Som en spiller må jeg kunne bevege seg med WASD

## Oppgave 4 
Fokuserte tidlig på å få gjort 1-3, men vi jobber allerede på å implemntere nr. 4. 

## Oppgave 5: Oppsummering 
Planlagt:
1. Gjøre ferdig 1-3 MVP punkter (Sander, Stian og Belmin)
2. Implementere movement til Mario (Belmin)
3. Skrive møtereferat av møter vi har hatt (Belmin)
4. Planlagt møter frem i tid (gruppen)
5. Skrive innlevering 1 (Belmin)
6. Vi skal bruke issue-board, Kanban og Gitflow
7. Gjennomgang av git 
8. Begynte å "bygge" opp Mario (løpeanimasjon (Magne))

Gjort/fullført:
1. Ble ferdig med og har PR til developer-branchen
2. Ble ferdig med og har PR til developer-branchen
3. Belmin skrev møtereferat, og det ble fullført (se wiki på GitLab)
4. Møtene ble flyttet til senere på dagen ettersom det krasjet med andre fag for noen
5. Belmin skrev innlevering, og det ble fullført
6. Hadde litt problemer med issue-board ettersom vi ikke kunne gi flere personen samme issue, men vi kom på en god løsning. Issue-boardet inne på GitLab ble brukt hele tiden. 
7. Ikke alle var like kjent som git, og ble derfor gjort et par gjennomganger på møtene for å lære opp teamet (Belmin)
8. Ikke fullført (Magne)

Det å programmere på samme prosjekt med flere personen var relativt enkelt ettersom vi ikke rotet med hverandres filer de jobbet med ved å bruke git branches. Dette førte også at det var forståelig for å hverandre å vite hva som hadde blitt gjort, men ikke minst hvilken issue tilhørte hvilken branch. Vi skal bli flinkere på å lage tester før vi begynner å kode mer komplekse problemer, me mvp 1-3 var veldig små isseus. Dette blir selvsagt fikset for innlevering 2. Vi mener at vi traff ganske bra på oppgaven for den korte tiden vi hadde på oss. Vi tenker nok å ta 4+ punkter til neste gang, men dette ser vi neste uke 21. feb.
