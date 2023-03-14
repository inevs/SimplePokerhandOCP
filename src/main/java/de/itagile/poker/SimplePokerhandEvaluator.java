package de.itagile.poker;

import de.itagile.poker.rules.HighCardRule;
import de.itagile.poker.rules.PairRule;
import de.itagile.poker.rules.PokerRule;
import de.itagile.poker.rules.ThreeOfAKindRule;

import java.util.*;

public class SimplePokerhandEvaluator {

    private List<PokerRule> ruleSet = Arrays.asList(
            new ThreeOfAKindRule(),
            new PairRule(),
            new HighCardRule()
    );

    public String evaluate(String hand) {
        List<Card> cards = Card.fromHand(hand);
        String result = "";
        for (PokerRule rule : ruleSet) {
            result = rule.applyRule(cards);
            if (!result.isBlank()) {
                break;
            }
        }
        return result;
    }

}
