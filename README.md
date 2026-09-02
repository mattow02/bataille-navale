# Battleship (Java MVC)

![Java](https://img.shields.io/badge/Java_17-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Swing](https://img.shields.io/badge/Swing-GUI-blue?style=for-the-badge)
![MVC](https://img.shields.io/badge/Pattern-MVC-green?style=for-the-badge)

A full-featured Battleship game built in Java 17 with strict MVC architecture, a Swing GUI, two game modes, special weapons, traps, and configurable AI.

---

## Features

- **10×10 grid** with collision-aware ship placement.
- **Two modes:** Classic (scattered traps) and Island (central 4×4 zone with hidden bonuses and traps).
- **Arsenal:** standard missile (unlimited), bomb (5-cell cross pattern), sonar (3×3 scan, requires a living submarine).
- **Traps:** Tornado (offsets shots by +5 for 3 turns) and Black Hole (reflects a shot back at the attacker).
- **Configurable AI:** Easy (fully random) or Standard (switches to targeted hunting after a hit).
- Full Swing interface: configuration, interactive placement, real-time battle with event log.

---

## How to play

### Classic mode
1. Place your fleet and 2 traps (1 Black Hole, 1 Tornado).
2. You start with 1 Bomb and 1 Sonar.
3. The AI places its own traps randomly.

### Island mode
1. A 4×4 island zone blocks ship placement on both sides.
2. The enemy island hides bonuses (Bomb, Sonar) and traps, explore it to collect them.
3. No starting special ammo, everything must be found.

### Flow
1. **Configure**, pick ship count (0–3 per type, max 35 cells), mode, and AI level.
2. **Place**, position ships and traps on your grid. Use "Rotate" to toggle orientation.
3. **Battle**, select a weapon, click the enemy grid, repeat until one fleet is sunk.

---

## Running the project

**Requirements:** JDK 17+

```bash
git clone https://github.com/mattow02/bataille-navale-v2.git
cd bataille-navale-v2
find src -name '*.java' > sources.txt
javac -d bin @sources.txt
java -cp bin App
```

`javac` ne développe pas `**` lui-même : on lui passe la liste des fichiers.

Or open the project in IntelliJ/Eclipse and run `App.java`.

---

## Architecture

Strict **MVC** with the following design patterns:

- **Observer**, view/controller notifications on game events.
- **Strategy**, AI behavior (`RandomShotStrategy`, `TargetedShotStrategy`) and weapon selection.
- **Factory**, ships, traps, weapons, island items.
- **State**, cell and entity state management.

```
Model       Grid logic, ships, weapons, traps, turn management
Controller  Configuration, placement flow, battle orchestration
View        Swing screens (Config, Placement, Battle, EndGame) + grid components
```

UML diagrams are in the `uml/` folder.
