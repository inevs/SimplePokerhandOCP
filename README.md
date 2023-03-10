# SimplePokerhandKataOCP

## About this Kata

Diese Kata ist abgeleitet aus der [Pokerhands Kata](https://codingdojo.org/kata/PokerHands/). Das Ziel hier ist lediglich eine Pokerhand aus 5 Karten nach den Pokerregeln zu bewerten.
In diesem Fall handelt es sich um eine Refactoring-Übung, um verschiedene Designprinzipien zu erlernen. 

## Problembeschreibung
Deine Aufgabe ist es, verschiedene Pokerhände zu bewerten und zu ermitteln, welche Regel hier zutrifft.

Die aktuelle Implementierung findet die höchste Karte und Paare. Wie würdest du die nächste Regel "Drilling" implementieren (der entsprechende Test ist deaktiviert)?
Es wäre gut, den Code vorher umzubauen, sodass er dem [OCP](https://de.wikipedia.org/wiki/Open-Closed-Prinzip) entspricht.

## Pokerregeln

Ein Pokerspiel besteht aus 52 Karten - jede Karte hat eine Farbe nämlich Kreuz, Karo, Herz oder Pik (in den Eingabedaten mit C, D, H und S bezeichnet - Clubs, Diamonds, Hearts und Spades). Jede Karte hat außerdem einen Wert, nämlich 2, 3, 4, 5, 6, 7, 8, 9, 10, Bube, Dame, König, Ass (bezeichnet als 2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K, A). Für die Punktevergabe sind die Farben ungeordnet, während die Werte wie oben angegeben geordnet sind, wobei die 2 der niedrigste und das Ass der höchste Wert ist.
Eine Pokerhand besteht aus 5 Karten, die aus dem Deck ausgeteilt werden. Pokerhände werden in der folgenden Reihenfolge von der niedrigsten bis zur höchsten Karte gewertet.

* **HighCard**: Hände, die in keine höhere Kategorie passen, werden nach dem Wert ihrer höchsten Karte gereiht.
* **Paar**: 2 der 5 Karten der Hand haben den gleichen Wert.
  **Zwei Paare**: Das Blatt enthält 2 verschiedene Paare.
* **Drilling**: Drei der Karten haben den gleichen Wert.
* **Strasse**: Das Blatt enthält 5 Karten mit aufeinanderfolgenden Werten.
* **Flush**: Das Blatt enthält 5 Karten der gleichen Farbe.
  **Full House**: 3 Karten desselben Werts, wobei die verbleibenden 2 Karten ein Paar bilden.
* **Vierling**: 4 Karten mit demselben Wert.
* **Straight Flush**: 5 Karten der gleichen Farbe mit aufeinanderfolgenden Werten.

## Vorschlag für Testfälle

Sample input:

```
C2 H3 S4 C8 HA
H2 S4 C4 D2 H4
S2 S8 SA SQ S10
```

Sample output:

```
High card: Ace 
Full house: 4 over 2 
Flush: Spades with Ace
```

## Designtip

In der Klasse `SimplePokerhandEvaluator` gibt es verschiedene Methoden, die die einzelnen Pokerregeln abbilden, z.B. `findPair()`.
Die Erweiterung auf zusätzliche Pokerregeln bedeutet hier, dass der bestehende Code geändert wird. Besser wäre aber, wenn es nun für jede
Regel eine eigene Klasse geben würde. Dann könnten zusätzliche Regeln einfach durch weitere Klassen umgesetzt werden.
Diese müssten ein gemeinsames Interface implementieren und werden in einer bestimmten Reihenfolge (entsprechend der Pokerregeln) aufgerufen.

```
interface PokerRule {
  String applyRule(List<Card> cards);
}
```

In einem weiteren Schritt sollte die Logik der Ausgabe ("Pair: ...") von der Evaluation der Hand getrennt werden. Hier könnte man
die Ausgabe String durch ein `PokerRuleResult` ersetzen, welches weiß, wie man es auf der Konsole ausgibt.

```
interface PokerRuleResult {
  String textOutput();
}

interface PokerRule {
  PokerRuleResult applyRule(List<Card> cards);
}
```