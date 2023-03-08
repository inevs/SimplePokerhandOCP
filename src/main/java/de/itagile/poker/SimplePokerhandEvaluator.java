package de.itagile.poker;

import java.util.*;
import java.util.stream.Collectors;

public class SimplePokerhandEvaluator {
    public String evaluate(String hand) {
        List<Card> cards = Card.fromHand(hand);
        String result;

        List<Card> foundCards = findPair(cards);
        if (!foundCards.isEmpty()) {
            result = "Pair: " + foundCards.get(0).toString() + "'s";
        } else {
            Card highCard = findHighCard(cards);
            result = "HighCard: " + highCard.toString();
        }
        return result;
    }

    private List<Card> findPair(List<Card> cards) {
        Map<Integer, List<Card>> rankHistogram = makeRankHistogram(cards);
        return findPairInHistogram(rankHistogram);
    }

    private List<Card> findPairInHistogram(Map<Integer, List<Card>> rankHistogram) {
        for (Integer rank : rankHistogram.keySet()) {
            List<Card> cardsForRank = rankHistogram.get(rank);
            if (cardsForRank.size() == 2) {
                return cardsForRank;
            }
        }
        return new ArrayList<>();
    }

    private Map<Integer, List<Card>> makeRankHistogram(List<Card> cards) {
        Map<Integer, List<Card>> histogram = new HashMap<>();
        for (Card card : cards) {
            Integer rank = card.getRank();
            List<Card> cardsForRank = histogram.get(rank);
            if (cardsForRank == null) {
                cardsForRank = new ArrayList<>();
                histogram.put(rank, cardsForRank);
            }
            cardsForRank.add(card);
        }
        return histogram;
    }

    private Card findHighCard(List<Card> cards) {
        Collections.sort(cards);
        return cards.get(cards.size() - 1);
    }
}
