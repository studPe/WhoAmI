**ADR 2: Verwendung von Vaadin für das Frontend**

Entscheidung

Es wurde entschieden, Vaadin als Frontend-Technologie für die Webanwendung "WhoAmI" zu verwenden.
Status

Angenommen
Kontext

Vaadin ist ein Java-basiertes Web-Framework, das sich besonders für die Erstellung von Geschäftsanwendungen eignet. Es ermöglicht die Entwicklung von Benutzeroberflächen auf der Serverseite.
Begründung

    - Produktivität: Vaadin unterstützt die schnelle Entwicklung durch eine Vielzahl von integrierten Komponenten und Tools.
    - Robustheit: Vaadin-Anwendungen sind in der Regel sicher und stabil, was sie für geschäftskritische Anwendungen geeignet macht.
    - Benutzererfahrung: Vaadin ermöglicht die Erstellung von reichhaltigen und interaktiven Benutzeroberflächen mit einer konsistenten Benutzererfahrung.

Konsequenzen

Die Entscheidung für Vaadin bedeutet, dass Java-Entwickler benötigt werden, was die Personalbeschaffung einschränken könnte. Außerdem muss sichergestellt werden, dass Vaadin effektiv mit Flask kommunizieren kann, möglicherweise über REST APIs.