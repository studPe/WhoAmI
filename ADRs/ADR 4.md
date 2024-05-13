**ADR 4: Verwendung von gemockten JSON-Dateien anstelle einer traditionellen Datenbank**

Entscheidung

Es wurde entschieden, gemockte JSON-Dateien zur Speicherung der Daten in der Webanwendung "WhoAmI" zu verwenden, anstatt eine traditionelle Datenbank einzusetzen.
Status

Angenommen
Kontext

In der Anfangsphase der Entwicklung können gemockte JSON-Dateien eine effiziente Alternative zu traditionellen Datenbanken darstellen, insbesondere wenn die Datenstruktur einfach ist und die Datenmenge überschaubar bleibt.
Begründung

    - Einfachheit und Schnelligkeit der Entwicklung: Durch Verwendung von JSON-Dateien können Entwicklungen beschleunigt und vereinfacht werden, da keine Datenbankkonfiguration und -wartung erforderlich ist.
    - Flexibilität: Änderungen am Datenmodell können schnell umgesetzt werden, ohne Schema-Migrationen durchführen zu müssen.
    - Effizienz: Kein Aufwand für Datenbankserver oder zusätzliche Infrastruktur in der Entwicklungsphase.

Konsequenzen

Diese Entscheidung begrenzt die Skalierbarkeit und die Effizienz der Anwendung bei wachsender Datenmenge oder komplexeren Datenstrukturen. Langfristig könnte es notwendig werden, auf eine robustere Datenbanklösung umzusteigen.