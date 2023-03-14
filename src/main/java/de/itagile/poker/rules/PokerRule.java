package de.itagile.poker.rules;

import de.itagile.poker.Card;

import java.util.List;

public interface PokerRule {
    String applyRule(List<Card> cards);
}
