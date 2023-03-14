package de.itagile.poker.rules;

import de.itagile.poker.Card;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RankHistogram {

    private Map<Integer, List<Card>> histogram = new HashMap<>();

    public RankHistogram(List<Card> cards) {
        for (Card card : cards) {
            Integer rank = card.getRank();
            List<Card> cardsForRank = histogram.get(rank);
            if (cardsForRank == null) {
                cardsForRank = new ArrayList<>();
                histogram.put(rank, cardsForRank);
            }
            cardsForRank.add(card);
        }
    }

    public List<Card> findCounts(int count) {
        for (Integer rank : histogram.keySet()) {
            List<Card> cardsForRank = histogram.get(rank);
            if (cardsForRank.size() == count) {
                return cardsForRank;
            }
        }
        return new ArrayList<>();
    }

}
