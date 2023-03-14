package de.itagile.poker.rules;

import de.itagile.poker.Card;

import java.util.List;

public class ThreeOfAKindRule implements PokerRule {
    @Override
    public String applyRule(List<Card> cards) {
        RankHistogram rankHistogram = new RankHistogram(cards);
        List<Card> foundCards = rankHistogram.findCounts(3);
        if (!foundCards.isEmpty()) {
            return "Three of a Kind: " + foundCards.get(0).toString() + "'s";
        }
        return "";
    }

}
