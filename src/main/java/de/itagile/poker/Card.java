package de.itagile.poker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Card implements Comparable<Card> {
    private static List<String> rankNames = Arrays.asList("Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace");
    private String value;

    public Card(String value) {
        this.value = value;
    }

    public static List<Card> fromHand(String hand) {
        String[] cards = hand.split(" ");
        return Arrays.stream(cards).map(Card::new).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return rankNames.get(getRank()-2);
    }

    @Override
    public int compareTo(Card other) {
        Integer rank1 = this.getRank();
        Integer rank2 = other.getRank();
        return rank1.compareTo(rank2);
    }

    public Integer getRank() {
        String rankString = value.substring(1);
        int rank = 0;
        switch (rankString) {
            case "J": rank = 11; break;
            case "Q": rank = 12; break;
            case "K": rank = 13; break;
            case "A": rank = 14; break;
            default: rank = Integer.parseInt(rankString);
        }
        return rank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        return value != null ? value.equals(card.value) : card.value == null;

    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }

    public static String formatToString(List<Card> cards) {
        List<String> cardStrings = new ArrayList<>();
        for (Card card : cards) {
            cardStrings.add(card.toString());
        }
        return String.join(" ", cardStrings);
    }
}
