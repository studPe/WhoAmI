# WhoAmI Webanwendung
![WhoAmI](https://github.com/studPe/WhoAmI/assets/158460492/7515a185-aac5-4fd4-8d3e-746895c84508)


**SQS SoSe 2024**

# Einführung und Ziele

Die WhoAmI Webanwendung ist eine interaktive Webapp, die Flask für das Backend und Vaadin für das Frontend nutzt. Mit dieser Webapp kann "Wer bin ich ?" / bzw. "20 Questions" im Browser gespielt werden.

Ziel der Anwendung ist die Entwicklung einer Anwendung, die abgesichert ist Anhand einiger der Qualitätsmerkmale nach ISO 25010. Die Anwendung muss, dazu auch einen externe Schnittstelle ansprechen, diese API wurde für den Zweck der Anwendung eingens mit Flask umgesetzt.

| Use Case | Beschreibung | Ziele | Beteiligte |
|----------|---------------|-------|------------|
| **1. Spiel starten** | Ein Spieler startet ein neues Spiel, indem er einen Spielernamen und eine GameId eingibt. | - Einfache Spielinitialisierung<br>- Netzwerkfähiges Spiel | Spieler |
| **2. Antwort überprüfen** | WhoAmI überprüft, ob die Antwort korrekt ist. | - Klare Kommunikation<br>- Echtzeit-Interaktion | Spieler |
| **3. Spielinformationen einsehen** | Spieler sollte sich über die Spielregeln informieren können. | - Einrichtung einer About-Page | Spieler |
| **4. Spiel neustarten** | Spieler eröffnet ein neues Spiel. | - Zurücksetzen des aktuellen Spielzustands | Spieler |



## Qualitätsziele

| Qualitätskriterium | Beschreibung | Ziele | Maßnahmen |
|---------------------|---------------|-------|-----------|
| **1. Reliability - Zuverlässigkeit** | Die Verlässlichkeit und Betriebsfähigkeit der Anwendung, um Ausfälle und Fehler zu minimieren. | - Hohe Resilienz gegenüber User-Eingaben <br>- Wiederstandsfähigkeit gegenüber Hoherlast | - Umfangreiche Testabdeckung<br>- Lasttestung mit Locust<br>- CodeQL Überprüfung<br>- SonarQube |
| **2. Portability - Übertragbarkeit** | Flexibilität einer Anwendung was die Laufzeitumgebung angeht. |- Gradle Pipeline auf verschiedenen Plattformen<br>- PlayWrightest auf verschiedenen Browsern | - Verwendung von Docker für isolierte Umgebungen <br> |
| **3. Usability - Benutzerfreundlichkeit** | Die Benutzerfreundlichkeit der Anwendung, einschließlich Benutzeroberfläche, Navigation und Interaktion. | - Einfach zu bedienende UI<br>- Intuitive Navigation<br>- Schnelle Ladezeiten | - Manuelle UI Prüfungen (Usability-Tests <br>- Lighthouse Tests<br> |

## Stakeholder


| Rolle        | Kontakt        | Erwartungshaltung |
|--------------|----------------|-------------------|
| *Player* | *User-Befragungen* | *Einfaches & positives Spielerlebnis*  |
| *Entwickler* | *pxxxx.sxxxx@stud.xxxx.de* | *Schnelle Entwicklung, klar definierte Ziele*  |
| *Prüfer* | *xxx@xxx.de* | *Gut dokumentiertes Projekt mit klaren Vor- & Nachteilen*  |

# Randbedingungen

Die hier beschriebene Anwendung wurde für die Veranstaltung SQS im Sommersemester 2024 entwickelt.

## Usability-Test:
### Usability-Test und abgeleitete Maßnahmen

| Test     | Ergebnis/Beobachtung                              | Abgeleitete Maßnahme                  | Frist     |
|-------------------|---------------------------------------------------|--------------------------------------|-----------|
| M 40 Jahre  | Nutzer finden den Button "Schließen" verwirrend              | Button wird verändert       | 22.06.2024|
| W 54      | Oberflächen Design wenig ansprechend | - zuküftige verbessertes Design | 30.06.2024|
| W 23         |         PWA muss in manchen Fällen manuell refreshed werden                       | Auto Refresh             | 22.06.2024|


# Kontextabgrenzung
![Kontextdiagramm drawio](https://github.com/studPe/WhoAmI/assets/158460492/60d0b703-79f0-47fb-ab76-21197eea6900)


## Fachlicher Kontext

| Kommunikationsbeziehung     | Eingabe                                           | Ausgabe                                 |
|-----------------------------|--------------------------------------------------|-----------------------------------------|
| User (Spieler) -> System    | Benutzeraktionen (z.B. Klicks, Formulareingaben) | Benutzeroberflächenaktualisierungen     |
| System -> Benutzer          | Benutzeroberflächenaktualisierungen              | Sichtbare Ergebnisse in der Anwendung   |
| Entwickler ->System (Docker)| Code, Konfigurationsdateien                      | Isolierte Anwendungsumgebungen          |
| System -> Entwickler        | Ausgabeport                                      | Ouput der Anwendungen  an Port          |


## Technischer Kontext
Ursprünglich geplanter Umfang:

![signal-2024-06-09-222603](https://github.com/studPe/WhoAmI/assets/158460492/2b3fa6d3-ca6f-4326-8e85-27a23129a42e)

Technische Umsetzung:

![Technical Context Diagram drawio](https://github.com/studPe/WhoAmI/assets/158460492/034500f0-8f61-412e-96b6-5d2efff51ebd)


# Lösungsstrategie


-   Nutzung für den Entwickler bekannter Ideen, um gewonnenes Wissen später in laufenden Projekten umzusetzen.

-   Zerlegung des Systems in 2 seperate Docker-Container, um Portabilität zu erhöhen und Prüfung gesamter Container zu ermöglichen

-   Nutzung einer JSON-Datei anstelle einer DB, um Entwicklungsaufwand Testing / Usability zu fokussieren.

-   Seperate Teststrategien für Front- & Backend

# Bausteinsicht

<div class="formalpara-title">

**Inhalt**

</div>

Die Bausteinsicht zeigt die statische Zerlegung des Systems in Bausteine
(Module, Komponenten, Subsysteme, Klassen, Schnittstellen, Pakete,
Bibliotheken, Frameworks, Schichten, Partitionen, Tiers, Funktionen,
Makros, Operationen, Datenstrukturen, …) sowie deren Abhängigkeiten
(Beziehungen, Assoziationen, …)

Diese Sicht sollte in jeder Architekturdokumentation vorhanden sein. In
der Analogie zum Hausbau bildet die Bausteinsicht den *Grundrissplan*.

<div class="formalpara-title">

**Motivation**

</div>

Behalten Sie den Überblick über den Quellcode, indem Sie die statische
Struktur des Systems durch Abstraktion verständlich machen.

Damit ermöglichen Sie Kommunikation auf abstrakterer Ebene, ohne zu
viele Implementierungsdetails offenlegen zu müssen.

<div class="formalpara-title">

**Form**

</div>

Die Bausteinsicht ist eine hierarchische Sammlung von Blackboxen und
Whiteboxen (siehe Abbildung unten) und deren Beschreibungen.

![Hierarchie in der Bausteinsicht](images/05_building_blocks-DE.png)

**Ebene 1** ist die Whitebox-Beschreibung des Gesamtsystems, zusammen
mit Blackbox-Beschreibungen der darin enthaltenen Bausteine.

**Ebene 2** zoomt in einige Bausteine der Ebene 1 hinein. Sie enthält
somit die Whitebox-Beschreibungen ausgewählter Bausteine der Ebene 1,
jeweils zusammen mit Blackbox-Beschreibungen darin enthaltener
Bausteine.

**Ebene 3** zoomt in einige Bausteine der Ebene 2 hinein, usw.

Siehe [Bausteinsicht](https://docs.arc42.org/section-5/) in der
online-Dokumentation (auf Englisch!).

## Whitebox Gesamtsystem

![WhiteBox drawio (1)](https://github.com/studPe/WhoAmI/assets/158460492/538d920f-f195-40bd-ab1a-fb309f43254d)

### Begründung

Diese Zerlegung des Gesamtsystems ermöglicht eine klare Trennung der Frontend- und Backend-Komponenten sowie eine klare Schnittstellendefinition zwischen den einzelnen Bausteinen. Dies erleichtert die Wartung und Weiterentwicklung des Systems und ermöglicht eine bessere Skalierbarkeit und Fehlertoleranz.

### Enthaltene Bausteine

#### Tabelle der enthaltenen Bausteine

| **Name**              | **Verantwortung**                                          |
|-----------------------|------------------------------------------------------------|
| WhoAmI-Frontend       | Bereitstellung der Benutzeroberfläche                      |
| WAI-API               | Bereitstellung der API-Funktionalitäten                    |
| Docker-Container      | Umgebung für die Ausführung der Frontend- und Backend-Komponenten |
| UI                    | Benutzeroberfläche des WhoAmI-Frontends                    |
| Vaadin-UI             | Webinterface-Komponente im Frontend                        |
| Webinterface          | Schnittstelle für die Benutzerinteraktion                  |
| Gunicorn              | WSGI-Server für die WAI-API                                |
| Flask-API             | API-Funktionalität der WAI-API                             |
| JSON-File             | Datenquelle für die WAI-API                                |

### Wichtige Schnittstellen

- **HTTP**: Verbindet den Browser des Nutzers mit dem WhoAmI-Frontend.
- **REST**: Verbindung zwischen dem WhoAmI-Frontend und der WAI-API.
- **WSGI**: Verbindung zwischen Gunicorn und der Flask-API.

### Blackbox-Beschreibungen der Ebene 1

#### WhoAmI-Frontend

- **Zweck/Verantwortung**: Bereitstellung der Benutzeroberfläche für den Zugriff auf die WhoAmI-Dienste.
- **Schnittstellen**: HTTP-Schnittstelle für die Kommunikation mit dem Browser.
- **Qualitäts-/Leistungsmerkmale**: Hohe Verfügbarkeit, schnelle Reaktionszeiten.
- **Ablageort/Datei(en)**: Docker-Container.

#### WAI-API

- **Zweck/Verantwortung**: Bereitstellung der API-Funktionalitäten.
- **Schnittstellen**: REST-Schnittstelle zur Kommunikation mit dem Frontend, WSGI für die interne Kommunikation.
- **Qualitäts-/Leistungsmerkmale**: Skalierbarkeit, Sicherheit.
- **Ablageort/Datei(en)**: Docker-Container.

### Ebene 2

#### Whitebox WhoAmI-Frontend

- **Innere Bausteine**: UI, Vaadin-UI, Webinterface.
- **Beschreibung**: Die UI-Komponente stellt die Hauptbenutzeroberfläche bereit, die Vaadin-UI ist für das Webinterface verantwortlich, und das Webinterface dient als Schnittstelle für die Benutzerinteraktion.

#### Whitebox WAI-API

- **Innere Bausteine**: Gunicorn, Flask-API, JSON-File.
- **Beschreibung**: Gunicorn fungiert als WSGI-Server, der die Flask-API bedient, welche die Hauptlogik der API enthält. Die JSON-File dient als Datenquelle für die API.

### Ebene 3

#### Whitebox Gunicorn

- **Innere Bausteine**: WSGI-Server, Worker-Prozesse.
- **Beschreibung**: Gunicorn nutzt Worker-Prozesse zur Bearbeitung eingehender Anfragen und zur Weiterleitung an die Flask-API.

#### Whitebox Flask-API

- **Innere Bausteine**: Routen, Controller, Services.
- **Beschreibung**: Die Flask-API enthält verschiedene Routen, die zu entsprechenden Controllern führen, welche wiederum die Logik über Services bereitstellen.

#### Whitebox JSON-File

- **Innere Bausteine**: Dateistruktur, Parser.
- **Beschreibung**: Die JSON-File enthält die Daten in einer strukturierten Form, die über einen Parser in der Flask-API verarbeitet werden.

# Laufzeitsicht

![Sequenz Diagramm drawio (1)](https://github.com/studPe/WhoAmI/assets/158460492/2c8bbfe3-8ae9-4213-a39a-f35d929678d6)


<div class="formalpara-title">

**Inhalt**

</div>

Diese Sicht erklärt konkrete Abläufe und Beziehungen zwischen Bausteinen
in Form von Szenarien aus den folgenden Bereichen:

-   Wichtige Abläufe oder *Features*: Wie führen die Bausteine der
    Architektur die wichtigsten Abläufe durch?

-   Interaktionen an kritischen externen Schnittstellen: Wie arbeiten
    Bausteine mit Nutzern und Nachbarsystemen zusammen?

-   Betrieb und Administration: Inbetriebnahme, Start, Stop.

-   Fehler- und Ausnahmeszenarien

Anmerkung: Das Kriterium für die Auswahl der möglichen Szenarien (d.h.
Abläufe) des Systems ist deren Architekturrelevanz. Es geht nicht darum,
möglichst viele Abläufe darzustellen, sondern eine angemessene Auswahl
zu dokumentieren.

<div class="formalpara-title">

**Motivation**

</div>

Sie sollten verstehen, wie (Instanzen von) Bausteine(n) Ihres Systems
ihre jeweiligen Aufgaben erfüllen und zur Laufzeit miteinander
kommunizieren.

Nutzen Sie diese Szenarien in der Dokumentation hauptsächlich für eine
verständlichere Kommunikation mit denjenigen Stakeholdern, die die
statischen Modelle (z.B. Bausteinsicht, Verteilungssicht) weniger
verständlich finden.

<div class="formalpara-title">

**Form**

</div>

Für die Beschreibung von Szenarien gibt es zahlreiche
Ausdrucksmöglichkeiten. Nutzen Sie beispielsweise:

-   Nummerierte Schrittfolgen oder Aufzählungen in Umgangssprache

-   Aktivitäts- oder Flussdiagramme

-   Sequenzdiagramme

-   BPMN (Geschäftsprozessmodell und -notation) oder EPKs
    (Ereignis-Prozessketten)

-   Zustandsautomaten

-   …

### Laufzeitsicht
#### Szenario 1: Start eines Spiels

**Ablaufbeschreibung**

1. **Benutzeranfrage im Browser**: Ein Benutzer startet ein Spiel in der Webanwendung.
2. **Anfrage an das Frontend**: Der Browser sendet eine Anforderung zum Starten eines neuen Spiels an das Frontend.
3. **Lokale Speicherung der Spiel-ID und des Spielernamens**:
   - Das Frontend generiert eine neue Spiel-ID und nimmt den Spielernamen auf.
   - Diese Informationen werden im lokalen Speicher des Browsers gespeichert.
4. **Anfrage an das Backend (API)**:
   - Das Frontend sendet eine Anfrage an das Backend, um das Spiel mit der erzeugten Spiel-ID zu initialisieren.
5. **Datenabruf aus dem JSON-Speicher**:
   - Das Backend verwendet die Spiel-ID, um aus einer JSON-Datenquelle Namen zu seeden und Spielinformationen abzurufen.
6. **Rückgabe der Namen an das Frontend**:
   - Das Backend sendet die abgerufenen Namen zurück an das Frontend.
7. **Spielaktionen**:
   - Der Benutzer macht in der Webanwendung einen Spielzug (z.B. eine Schätzung oder Auswahl).
8. **Feedback zum Benutzer**:
   - Basierend auf der Eingabe des Benutzers generiert das Frontend Feedback und zeigt dieses im Browser an.


## *\<Bezeichnung Laufzeitszenario 2>*

…

## *\<Bezeichnung Laufzeitszenario n>*

…

# Verteilungssicht

<div class="formalpara-title">

**Inhalt**

</div>

Die Verteilungssicht beschreibt:

1.  die technische Infrastruktur, auf der Ihr System ausgeführt wird,
    mit Infrastrukturelementen wie Standorten, Umgebungen, Rechnern,
    Prozessoren, Kanälen und Netztopologien sowie sonstigen
    Bestandteilen, und

2.  die Abbildung von (Software-)Bausteinen auf diese Infrastruktur.

Häufig laufen Systeme in unterschiedlichen Umgebungen, beispielsweise
Entwicklung-/Test- oder Produktionsumgebungen. In solchen Fällen sollten
Sie alle relevanten Umgebungen aufzeigen.

Nutzen Sie die Verteilungssicht insbesondere dann, wenn Ihre Software
auf mehr als einem Rechner, Prozessor, Server oder Container abläuft
oder Sie Ihre Hardware sogar selbst konstruieren.

Aus Softwaresicht genügt es, auf die Aspekte zu achten, die für die
Softwareverteilung relevant sind. Insbesondere bei der
Hardwareentwicklung kann es notwendig sein, die Infrastruktur mit
beliebigen Details zu beschreiben.

<div class="formalpara-title">

**Motivation**

</div>

Software läuft nicht ohne Infrastruktur. Diese zugrundeliegende
Infrastruktur beeinflusst Ihr System und/oder querschnittliche
Lösungskonzepte, daher müssen Sie diese Infrastruktur kennen.

<div class="formalpara-title">

**Form**

</div>

Das oberste Verteilungsdiagramm könnte bereits in Ihrem technischen
Kontext enthalten sein, mit Ihrer Infrastruktur als EINE Blackbox. Jetzt
zoomen Sie in diese Infrastruktur mit weiteren Verteilungsdiagrammen
hinein:

-   Die UML stellt mit Verteilungsdiagrammen (Deployment diagrams) eine
    Diagrammart zur Verfügung, um diese Sicht auszudrücken. Nutzen Sie
    diese, evtl. auch geschachtelt, wenn Ihre Verteilungsstruktur es
    verlangt.

-   Falls Ihre Infrastruktur-Stakeholder andere Diagrammarten
    bevorzugen, die beispielsweise Prozessoren und Kanäle zeigen, sind
    diese hier ebenfalls einsetzbar.

Siehe [Verteilungssicht](https://docs.arc42.org/section-7/) in der
online-Dokumentation (auf Englisch!).

## Infrastruktur Ebene 1

An dieser Stelle beschreiben Sie (als Kombination von Diagrammen mit
Tabellen oder Texten):

-   die Verteilung des Gesamtsystems auf mehrere Standorte, Umgebungen,
    Rechner, Prozessoren o. Ä., sowie die physischen Verbindungskanäle
    zwischen diesen,

-   wichtige Begründungen für diese Verteilungsstruktur,

-   Qualitäts- und/oder Leistungsmerkmale dieser Infrastruktur,

-   Zuordnung von Softwareartefakten zu Bestandteilen der Infrastruktur

Für mehrere Umgebungen oder alternative Deployments kopieren Sie diesen
Teil von arc42 für alle wichtigen Umgebungen/Varianten.

***\<Übersichtsdiagramm>***

Begründung  
*\<Erläuternder Text>*

Qualitäts- und/oder Leistungsmerkmale  
*\<Erläuternder Text>*

Zuordnung von Bausteinen zu Infrastruktur  
*\<Beschreibung der Zuordnung>*

## Infrastruktur Ebene 2

An dieser Stelle können Sie den inneren Aufbau (einiger)
Infrastrukturelemente aus Ebene 1 beschreiben.

Für jedes Infrastrukturelement kopieren Sie die Struktur aus Ebene 1.

### *\<Infrastrukturelement 1>*

*\<Diagramm + Erläuterungen>*

### *\<Infrastrukturelement 2>*

*\<Diagramm + Erläuterungen>*

…

### *\<Infrastrukturelement n>*

*\<Diagramm + Erläuterungen>*

# Querschnittliche Konzepte

<div class="formalpara-title">

**Inhalt**

</div>

Dieser Abschnitt beschreibt übergreifende, prinzipielle Regelungen und
Lösungsansätze, die an mehreren Stellen (=*querschnittlich*) relevant
sind.

Solche Konzepte betreffen oft mehrere Bausteine. Dazu können vielerlei
Themen gehören, beispielsweise:

-   Modelle, insbesondere fachliche Modelle

-   Architektur- oder Entwurfsmuster

-   Regeln für den konkreten Einsatz von Technologien

-   prinzipielle — meist technische — Festlegungen übergreifender Art

-   Implementierungsregeln

<div class="formalpara-title">

**Motivation**

</div>

Konzepte bilden die Grundlage für *konzeptionelle Integrität*
(Konsistenz, Homogenität) der Architektur und damit eine wesentliche
Grundlage für die innere Qualität Ihrer Systeme.

Manche dieser Themen lassen sich nur schwer als Baustein in der
Architektur unterbringen (z.B. das Thema „Sicherheit“).

<div class="formalpara-title">

**Form**

</div>

Kann vielfältig sein:

-   Konzeptpapiere mit beliebiger Gliederung,

-   übergreifende Modelle/Szenarien mit Notationen, die Sie auch in den
    Architektursichten nutzen,

-   beispielhafte Implementierung speziell für technische Konzepte,

-   Verweise auf „übliche“ Nutzung von Standard-Frameworks
    (beispielsweise die Nutzung von Hibernate als Object/Relational
    Mapper).

<div class="formalpara-title">

**Struktur**

</div>

Eine mögliche (nicht aber notwendige!) Untergliederung dieses
Abschnittes könnte wie folgt aussehen (wobei die Zuordnung von Themen zu
den Gruppen nicht immer eindeutig ist):

-   Fachliche Konzepte

-   User Experience (UX)

-   Sicherheitskonzepte (Safety und Security)

-   Architektur- und Entwurfsmuster

-   Unter-der-Haube

-   Entwicklungskonzepte

-   Betriebskonzepte

![Possible topics for crosscutting
concepts](images/08-Crosscutting-Concepts-Structure-DE.png)

Siehe [Querschnittliche Konzepte](https://docs.arc42.org/section-8/) in
der online-Dokumentation (auf Englisch).

## *\<Konzept 1>*

*\<Erklärung>*

## *\<Konzept 2>*

*\<Erklärung>*

…

## *\<Konzept n>*

*\<Erklärung>*

# Architekturentscheidungen

## (Ausführliche Beschreibungen sind im entsprechenden Ordner)
| Nummer | ADR                                      | Begründung                                                                                           |
|--------|------------------------------------------|------------------------------------------------------------------------------------------------------|
| 1      | Flask als Backend-Framework              | Flask wurde gewählt, um von seiner Einfachheit und Erweiterbarkeit zu profitieren.                   |
| 2      | Vaadin für das Frontend                  | Vaadin wird verwendet, um eine robuste und interaktive Benutzeroberfläche bereitzustellen.           |
| 3      | REST APIs für Backend-Frontend-Kommunikation | REST APIs werden eingesetzt, um eine entkoppelte Kommunikation zwischen Flask und Vaadin zu ermöglichen. |
| 4      | Verwendung von gemockten JSON-Dateien    | Statt einer traditionellen Datenbank werden JSON-Dateien zur Datenspeicherung verwendet, um Flexibilität und Einfachheit in der Entwicklungsphase zu gewährleisten. |
| 5      | Docker zur Containerisierung             | Docker wird genutzt, um Konsistenz, Portabilität und Isolation der Anwendungsumgebungen zu gewährleisten. |



# Qualitätsanforderungen


## Qualitätsbaum

![Qualitätsbaum drawio (2)](https://github.com/studPe/WhoAmI/assets/158460492/aa06b281-9c93-4bcf-bad7-767bb3b5f3f1)


## Qualitätsszenarien

| Attribut                     | Szenario                                                                                     | Maßnahme                                              |
|------------------------------|----------------------------------------------------------------------------------------------|-------------------------------------------------------|
| Reliability - Zuverlässigkeit| Nutzungsszenario: Das System führt umfassende Tests durch, um die Zuverlässigkeit zu gewährleisten. | Unittest, End-to-End Tests, Manuelle Verifikation     |
|                              | Änderungsszenario: Bei einer Änderung im Code wird das Testkonzept aktualisiert und erneut ausgeführt. | Umfassendes Testkonzept                               |
|                              | Nutzungsszenario: Das System kann unter Last stabil bleiben und Anfragen effizient verarbeiten. | Laststabilität, Locust-Tests für API                  |
|                              | Änderungsszenario: Neue Lastbedingungen erfordern Anpassungen und erneute Tests der Laststabilität. | Manuelle Verifikation                                 |
| Portability - Übertragbarkeit| Nutzungsszenario: Das System läuft in unterschiedlichen Umgebungen ohne Anpassungen.             | Dockerisierung, Gradle build auf Windows / Mac / Linux|
|                              | Änderungsszenario: Eine neue Laufzeitumgebung wird unterstützt und getestet.                    | Unabhängige Laufzeitumgebung                          |
|                              | Nutzungsszenario: Das System ist in den meisten bekannten Browsern nutzbar.                     | Playwright End-to-End Testing                         |
|                              | Änderungsszenario: Neue Browser-Versionen werden unterstützt und getestet.                      | Nutzbarkeit auf den meisten bekannten Browsern        |
| Usability - Benutzerfreundlichkeit| Nutzungsszenario: Die Benutzer verstehen den Spielablauf durch klare Erklärungen.             | About-Seite erklärt Spielablauf                       |
|                              | Änderungsszenario: Verbesserungen der Verständlichkeit werden kontinuierlich umgesetzt.         | Verständlichkeit                                      |
|                              | Nutzungsszenario: Das System ist barrierefrei und für alle Benutzer zugänglich.                 | Prüfung der Anwendung mit Lighthouse und Umsetzung der Vorschläge |
|                              | Änderungsszenario: Neue Barrierefreiheitsstandards werden berücksichtigt und umgesetzt.          | Barrierefreiheit                                      |



<div class="formalpara-title">

**Inhalt**

</div>

Konkretisierung der (in der Praxis oftmals vagen oder impliziten)
Qualitätsanforderungen durch (Qualitäts-)Szenarien.

Diese Szenarien beschreiben, was beim Eintreffen eines Stimulus auf ein
System in bestimmten Situationen geschieht.

Wesentlich sind zwei Arten von Szenarien:

-   Nutzungsszenarien (auch bekannt als Anwendungs- oder
    Anwendungsfallszenarien) beschreiben, wie das System zur Laufzeit
    auf einen bestimmten Auslöser reagieren soll. Hierunter fallen auch
    Szenarien zur Beschreibung von Effizienz oder Performance. Beispiel:
    Das System beantwortet eine Benutzeranfrage innerhalb einer Sekunde.

-   Änderungsszenarien beschreiben eine Modifikation des Systems oder
    seiner unmittelbaren Umgebung. Beispiel: Eine zusätzliche
    Funktionalität wird implementiert oder die Anforderung an ein
    Qualitätsmerkmal ändert sich.

<div class="formalpara-title">

**Motivation**

</div>

Szenarien operationalisieren Qualitätsanforderungen und machen deren
Erfüllung mess- oder entscheidbar.

Insbesondere wenn Sie die Qualität Ihrer Architektur mit Methoden wie
ATAM überprüfen wollen, bedürfen die in Abschnitt 1.2 genannten
Qualitätsziele einer weiteren Präzisierung bis auf die Ebene von
diskutierbaren und nachprüfbaren Szenarien.

<div class="formalpara-title">

**Form**

</div>

Entweder tabellarisch oder als Freitext.

# Risiken und technische Schulden

| Risiko/Technische Schuld                    | Beschreibung                                                                                       | Maßnahme zur Risikovermeidung/Risikominimierung/Abbau der technischen Schuld                          | Priorität     |
|---------------------------------------------|---------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------|---------------|
| Mangelnde Skalierbarkeit                    | Flask ist leichtgewichtig, könnte aber bei hohen Lasten an seine Grenzen stoßen.                  | Frühzeitiges Testen der Anwendung unter Lastbedingungen. Wechsel auf andere Back-End-Technologie für Produktionseinsatz | Hoch          |
| Sicherheitslücken                            | Vaadin-Frontends könnten anfällig für Sicherheitsprobleme sein.                                  | Implementierung von Sicherheitsmechanismen wie Validierung und Sanitierung von Eingaben, regelmäßige Sicherheitsüberprüfungen. | Hoch          |
| Fehlende Testabdeckung                      | Unzureichende Tests besonders beim Play-Testing                                     | Aufbau einer umfassenden Teststrategie mit Unit-, Integrations- und End-to-End-Tests. Feedback von Nutzern einholen                  | Hoch          |
| Komplexität der API-Kommunikation           | REST API-Kommunikation zwischen Frontend und Backend kann komplex und fehleranfällig sein.        | Einsatz von API-Gateways und umfassende API-Dokumentation sowie Testen der API-Endpunkte.               | Mittel        |
| Datenkonsistenz                             | Verwendung von JSON-Dateien statt einer Datenbank kann zu Inkonsistenzen führen.                  | Zukünftig Einführung robuste Datenbanklösung.                                                           | Mittel        |
| Performance-Probleme                        | JSON-Dateien und Vaadin können bei wachsendem Datenvolumen Performance-Probleme verursachen.      | Performance-Optimierungen durch Caching, Indexierung und effiziente Datenverarbeitungsmethoden.         | Mittel        |
| Docker-Komplexität                          | Beide Docker-Container (Backend / Frontend) müssen zur selben Zeit laufen.                        | Automatisierung des Docker-Setups und umfassende Dokumentation der Container-Konfiguration.             | Mittel       |
| Wartungsaufwand                             | Hoher Wartungsaufwand durch Nutzung einer JSON Datei anstelle einer Datenbank                     | Zukünftig Verwendung einer bewährten Datenbanklösung.                                                   | Niedrig        |

# Setup

Folgen Sie diesen Schritten, um die WhoAmI Webanwendung lokal auf Ihrem System einzurichten:

### Voraussetzungen

- Docker
- Python 3.8 oder höher
- Java 11 oder höher

### Anwendung klonen

Klonen Sie dieses Repository auf Ihren lokalen Rechner:

```bash
git clone https://github.com/yourusername/whoami.git
cd whoami
```

### Docker-Container starten

Bauen und starten Sie die Docker-Container für das Backend und das Frontend:

```bash
docker-compose up --build
```

Nachdem die Container erfolgreich gestartet wurden, ist das Backend erreichbar unter `http://localhost:5000` und das Frontend unter `http://localhost:8080`.

## Entwicklung und Beitrag

Um zur Entwicklung beizutragen, folgen Sie bitte dem Standard-Git-Workflow:

1. Erstellen Sie einen Fork des Repositories.
2. Erstellen Sie einen neuen Branch für Ihre Feature- oder Bugfix-Arbeiten.
3. Commiten und pushen Sie Ihre Änderungen.
4. Senden Sie einen Pull-Request.



# Vaadin Gradle Skeleton Starter Spring Boot

This project demos the possibility of having Vaadin project in npm+webpack mode using Gradle.
Please see the [Starting a Vaadin project using Gradle](https://vaadin.com/docs/latest/guide/start/gradle) for the documentation.


Prerequisites:
* Java 17 or higher
* Git
* (Optionally): Intellij Community
* (Optionally): Node.js and npm, if you have JavaScript/TypeScript customisations in your project.
  * You can either let the Vaadin Gradle plugin to install `Node.js` and `npm/pnpm` for you automatically, or you can install it to your OS:
  * Windows: [node.js Download site](https://nodejs.org/en/download/) - use the .msi 64-bit installer
  * Linux: `sudo apt install npm`

## Vaadin Versions

* The [v24](https://github.com/vaadin/base-starter-spring-gradle) branch (the default one) contains the example app for Vaadin latest version
* See other branches for other Vaadin versions.

## Running With Spring Boot via Gradle In Development Mode

Run the following command in this repo:

```bash
./gradlew clean bootRun
```

Now you can open the [http://localhost:8080](http://localhost:8080) with your browser.

## Running With Spring Boot from your IDE In Development Mode

Run the following command in this repo, to create necessary Vaadin config files:

```bash
./gradlew clean vaadinPrepareFrontend
```

The `build/vaadin-generated/` folder will now contain proper configuration files.

Open the `DemoApplication` class, and Run/Debug its main method from your IDE.

Now you can open the [http://localhost:8080](http://localhost:8080) with your browser.

## Building In Production Mode

Run the following command in this repo:

```bash
./gradlew clean build -Pvaadin.productionMode
```

That will build this app in production mode as a runnable jar archive; please find the jar file in `build/libs/base-starter-spring-gradle*.jar`.
You can run the JAR file with:

```bash
cd build/libs/
java -jar base-starter-spring-gradle*.jar
```

Now you can open the [http://localhost:8080](http://localhost:8080) with your browser.

### Building In Production On CI

Usually the CI images will not have node.js+npm available. Vaadin uses pre-compiled bundle when possible, i.e. Node.js is not always needed.
Or Vaadin Gradle Plugin will download Node.js for you automatically if it finds any front-end customisations, there is no need for you to do anything.
To build your app for production in CI, just run:

```bash
./gradlew clean build -Pvaadin.productionMode
```

# Glossar

<div class="formalpara-title">

**Inhalt**

</div>

Die wesentlichen fachlichen und technischen Begriffe, die Stakeholder im
Zusammenhang mit dem System verwenden.

Nutzen Sie das Glossar ebenfalls als Übersetzungsreferenz, falls Sie in
mehrsprachigen Teams arbeiten.

<div class="formalpara-title">

**Motivation**

</div>

Sie sollten relevante Begriffe klar definieren, so dass alle Beteiligten

-   diese Begriffe identisch verstehen, und

-   vermeiden, mehrere Begriffe für die gleiche Sache zu haben.

Zweispaltige Tabelle mit \<Begriff> und \<Definition>.

Eventuell weitere Spalten mit Übersetzungen, falls notwendig.

Siehe [Glossar](https://docs.arc42.org/section-12/) in der
online-Dokumentation (auf Englisch!).

| Begriff        | Definition        |
|----------------|-------------------|
| *\<Begriff-1>* | *\<Definition-1>* |
| *\<Begriff-2*  | *\<Definition-2>* |
