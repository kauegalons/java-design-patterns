# Java Design Patterns

Two design pattern implementations in Java, written as the practical part of the
exams for a software design course: Strategy applied to freight transport
selection, and a thread-safe Singleton holding global configuration.

Each folder is an independent package that compiles and runs on its own.

## Contents

| Folder | Pattern | Problem it solves here |
| --- | --- | --- |
| `strategy/` | Strategy | choosing between four transport methods at runtime |
| `singleton/` | Singleton | a single globally reachable configuration object |

## Requirements

A JDK. Verified with OpenJDK 17.

---

## strategy — Transport selection

The `TransporteStrategy` interface defines the contract every transport method
must honour: select a carrier, and report whether it is currently available.

```java
public interface TransporteStrategy {
    void selecionarTransportadora();
    boolean verificarDisponibilidade();
}
```

Four implementations encapsulate different rules, each with its own constructor
parameters and its own notion of availability.

| Implementation | Constructor parameters | Available when |
| --- | --- | --- |
| `TransporteTerrestre` | local carrier name | always |
| `TransporteAereo` | maximum weight, maximum dimensions | weight is at most 1000 and dimensions at most 2 |
| `TransporteMaritimo` | international flag | the shipment is international |
| `EntregaPorDrones` | metropolitan area flag, small package flag | both conditions hold |

`GestorTransporte` is the context. It holds a strategy, lets callers swap it
through `setEstrategia`, and runs the shipment without knowing which concrete
implementation it is talking to. If no strategy has been set it asks for one
instead of failing.

This is the point of the pattern: adding a fifth transport method means writing one
new class, with no change to `GestorTransporte`.

### Running it

```bash
javac -encoding UTF-8 -d out strategy/*.java
java -cp out strategy.Main
```

`Main` exercises all four strategies with values that satisfy their requirements,
so every one of them reports as available.

```text
Selecionando transportadora terrestre: Transportadora A
Transporte em andamento...

Selecionando transportadora aérea...
Verificando peso máximo e dimensões...
Transporte em andamento...

Selecionando transportadora marítima para entrega internacional...
Transporte em andamento...

Organizando entrega por drones...
Para áreas metropolitanas e pacotes pequenos.
Transporte em andamento...
```

Changing a constructor argument so a rule fails, for example an air shipment
heavier than 1000, makes the context print that transport is unavailable instead.

### Theory answers

`strategy/exercicios-teoricos.txt` holds the written part of the same exam: a
matching exercise pairing Singleton, Dependency Injection, Interfaces, Decorator,
Factory Method, Strategy and Prototype with their definitions, and a set of
true-or-false statements about Singleton, Strategy and Factory Method.

---

## singleton — Global configuration

`GlobalConfig` guarantees a single instance for the whole program run, using
double-checked locking with a `volatile` field.

```java
private static volatile GlobalConfig instance;

public static GlobalConfig getInstance() {
    if (instance == null) {
        synchronized (GlobalConfig.class) {
            if (instance == null) {
                instance = new GlobalConfig();
            }
        }
    }
    return instance;
}
```

Both parts matter. The `volatile` keyword stops a thread from observing a
partially constructed object, and the second null check inside the synchronized
block prevents two threads that both passed the first check from each creating an
instance. The outer check exists so that the synchronization cost is paid only
once, not on every call.

The constructor is private, which is what forces every caller through
`getInstance`. It seeds three defaults: application name `DefaultApp`, environment
`development`, and a maximum of 10 connections.

### Running it

```bash
javac -encoding UTF-8 -d out singleton/*.java
java -cp out singleton.Main
```

`Main` reads the defaults, mutates the configuration through one reference, then
requests the instance again through a separate reference. The second reference sees
the mutations, and the identity comparison confirms both names point at the same
object.

```text
Configurações iniciais:
Application Name: DefaultApp
Environment: development
Max Connections: 10

Configurações atualizadas:
Application Name: MyIoTApp
Environment: production
Max Connections: 50

As duas instâncias são iguais? true
```

---

## Note on packages

The sources originally lived in a single `Prova` package. They now declare
`package strategy;` and `package singleton;` so that the package names match the
directory layout, which is what lets each folder compile independently. Both
folders contain a `Main`, which is not a conflict: they resolve as `strategy.Main`
and `singleton.Main`.

Program output and source comments are in Portuguese.

## License

Academic work, shared for reference.
