package de.itagile.poker;

import java.util.*;

public class SimplePokerhandEvaluator {
    public String evaluate(String hand) {
        List<Card> cards = Card.fromHand(hand);
        String result = findPair(cards);
        if (result.isBlank()) {
            result = findHighCard(cards);
        }
        return result;
    }

    private String findPair(List<Card> cards) {
        Map<Integer, List<Card>> rankHistogram = makeRankHistogram(cards);
        List<Card> foundCards = findPairInHistogram(rankHistogram);
        if (!foundCards.isEmpty()) {
            return "Pair: " + foundCards.get(0).toString() + "'s";
        }
        return "";
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

    private String findHighCard(List<Card> cards) {
        Collections.sort(cards);
        Card highCard = cards.get(cards.size() - 1);
        return "HighCard: " + highCard.toString();
    }
}
