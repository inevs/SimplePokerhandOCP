package de.itagile.poker.rules;

import de.itagile.poker.Card;

import java.util.List;

public class PairRule implements PokerRule {
    @Override
    public String applyRule(List<Card> cards) {
        RankHistogram rankHistogram = new RankHistogram(cards);
        List<Card> foundCards = rankHistogram.findCounts(2);
        if (!foundCards.isEmpty()) {
            return "Pair: " + foundCards.get(0).toString() + "'s";
        }
        return "";
    }

}
