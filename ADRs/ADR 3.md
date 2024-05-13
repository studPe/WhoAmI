**ADR 3: Kommunikation zwischen Flask und Vaadin über REST APIs**

Entscheidung

Für die Kommunikation zwischen dem Flask-Backend und dem Vaadin-Frontend werden REST APIs verwendet.
Status

Angenommen
Kontext

Um eine saubere Trennung zwischen dem Frontend und dem Backend zu gewährleisten, ist eine zuverlässige Kommunikationsmethode erforderlich.
Begründung

    - Standardisierung und Einfachheit: REST ist ein weit verbreiteter Standard für die API-Entwicklung, der die Integration verschiedener Technologien erleichtert.
    - Entkopplung: Durch die Verwendung von REST APIs können das Backend und das Frontend unabhängig voneinander entwickelt und skaliert werden.

Konsequenzen

Die Notwendigkeit, RESTful Endpoints im Flask-Backend zu entwickeln und sicherzustellen, dass das Vaadin-Frontend diese korrekt konsumieren kann. Dies könnte zusätzlichen Entwicklungsaufwand bedeuten, um die Schnittstelle korrekt zu implementieren.