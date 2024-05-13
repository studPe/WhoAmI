**ADR 4: Nutzung von Docker zur Containerisierung der Anwendung**

Entscheidung

Es wurde entschieden für die Verwendung von Docker, um die Webanwendung "WhoAmI" zu containerisieren.
Status

Angenommen
Kontext

Containerisierung ist ein effektiver Ansatz, um die Konsistenz zwischen Entwicklungs-, Test- und Produktionsumgebungen zu gewährleisten. Docker ist eines der führenden Tools in diesem Bereich.
Begründung

    - Konsistenz: Durch Docker wird sichergestellt, dass die Anwendung unter gleichen Bedingungen in verschiedenen Umgebungen läuft.
    - Portabilität: Container können leicht zwischen verschiedenen Umgebungen und Cloud-Plattformen verschoben werden.
    - Isolation: Docker bietet eine isolierte Umgebung für die Anwendung, was die Sicherheit verbessert.

Konsequenzen

Die Entscheidung erfordert Kenntnisse in Docker und möglicherweise zusätzliche Ressourcen für die Verwaltung der Containerinfrastruktur. Auch muss der Workflow für die Integration und Lieferung angepasst werden, um Container zu unterstützen.