package de.itagile.poker.rules;

import de.itagile.poker.Card;

import java.util.Collections;
import java.util.List;

public class HighCardRule implements PokerRule {
    public String applyRule(List<Card> cards) {
        Collections.sort(cards);
        Card highCard = cards.get(cards.size() - 1);
        return "HighCard: " + highCard.toString();
    }
}
