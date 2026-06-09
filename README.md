DEZSYS_GK771_WAREHOUSE_REST

Kurzbeschreibung

In diesem Projekt wird eine einfache REST-Schnittstelle fuer ein Warenlager umgesetzt.
Das Lager ist in Linz und liefert Standortdaten und Produktdaten.
Die Daten koennen als JSON und als XML abgerufen werden.

Umgesetzt

- Generator fuer Lager- und Produktdaten
- REST Controller mit einfachen URLs
- JSON-Ausgabe
- XML-Ausgabe
- Klassen fuer Lager und Produkte

Technologien

- Java
- Spring Boot
- Gradle
- REST
- JSON
- XML
- Git

Spring Boot 3 braucht Java 17 oder neuer.
In IntelliJ sollte deshalb als Gradle JVM ein JDK 17 eingestellt sein.

Projekt starten

JSON:

```text
http://localhost:8080/api/warehouse
http://localhost:8080/api/warehouse.json
```

XML:

```text
http://localhost:8080/api/warehouse.xml
```

JSON

JSON ist das Standardformat der REST-Schnittstelle.
Spring Boot wandelt das Java-Objekt automatisch in JSON um.

Kleines Beispiel:

```json
{
  "warehouseID": "001",
  "warehouseName": "Linz Bahnhof"
}
```

Das ist praktisch, weil andere Programme diese Daten leicht lesen koennen.

XML

XML wird ueber die URL `/api/warehouse.xml` ausgegeben.
Dafuer wurde in Gradle die Jackson-XML-Abhaengigkeit ergaenzt.

```gradle
implementation 'com.fasterxml.jackson.dataformat:jackson-dataformat-xml'
```

Mit XML-Annotationen wird der Aufbau ungefaehr wie in der Angabe gemacht.
Zum Beispiel heisst das Root-Element `warehouseData`.

## Generator

Der Generator steht in `WarehouseSimulation`.
Er erzeugt die Daten fuer das Lager in Linz und mehrere Produkte.

```java
data.setWarehouseName("Linz Bahnhof");
data.setWarehouseCity("Linz");
data.setProductData(getProducts());
```

Die Produktmengen werden zufaellig erzeugt.
Dadurch sieht man bei mehreren Requests, dass die Daten simuliert werden.

## Controller

Der Controller nimmt HTTP-Requests entgegen und gibt die Lagerdaten zurueck.
Es gibt eine JSON-URL und eine XML-URL.

```java
@GetMapping(value = {"/api/warehouse", "/api/warehouse.json"},
        produces = MediaType.APPLICATION_JSON_VALUE)
```

Hier wird festgelegt, dass diese URL JSON zurueckgibt.

## Model-Klassen

`WarehouseData` beschreibt das Lager.
Darin stehen zum Beispiel ID, Name, Adresse, Timestamp und die Produktliste.

`Product` beschreibt ein Produkt.
Darin stehen ID, Name, Kategorie, Menge und Einheit.

```java
private String productName;
private int productQuantity;
private String productUnit;
```

Diese Klassen sind wichtig, weil Spring daraus JSON und XML erzeugen kann.