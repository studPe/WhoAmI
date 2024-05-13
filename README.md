# WhoAmI Webanwendung

Die WhoAmI Webanwendung ist eine interaktive Webapp, die Flask für das Backend und Vaadin für das Frontend nutzt. Mit dieser Webapp kann "Wer bin ich ?" / bzw. "20 Questions" im Browser gespielt werden.

## Technologie-Stack

- **Backend:** Flask (Python)
- **Frontend:** Vaadin (Java)
- **Datenmanagement:** Gemockte JSON-Dateien
- **Containerisierung:** Docker

## Architektur-Entscheidungen (ADRs)

1. **Flask als Backend-Framework:** Flask wurde gewählt, um von seiner Einfachheit und Erweiterbarkeit zu profitieren.
2. **Vaadin für das Frontend:** Vaadin wird verwendet, um eine robuste und interaktive Benutzeroberfläche bereitzustellen.
3. **REST APIs für Backend-Frontend-Kommunikation:** REST APIs werden eingesetzt, um eine entkoppelte Kommunikation zwischen Flask und Vaadin zu ermöglichen.
4. **Verwendung von gemockten JSON-Dateien:** Statt einer traditionellen Datenbank werden JSON-Dateien zur Datenspeicherung verwendet, um Flexibilität und Einfachheit in der Entwicklungsphase zu gewährleisten.
5. **Docker zur Containerisierung:** Docker wird genutzt, um Konsistenz, Portabilität und Isolation der Anwendungsumgebungen zu gewährleisten.

## Setup

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
