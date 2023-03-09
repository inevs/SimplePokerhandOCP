package de.itagile.poker;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PokerhandEvaluatorTest {
    SimplePokerhandEvaluator evaluator = new SimplePokerhandEvaluator();

    @Test
    public void findsHighcardInHand() {
        assertThat(evaluator.evaluate("C2 C3 S4 D5 S6"), equalTo("HighCard: Six"));
        assertThat(evaluator.evaluate("S6 C2 C4 D5 C3"), equalTo("HighCard: Six"));
    }

    @Test
    public void findsHighcardWithFaceCards() {
        assertThat(evaluator.evaluate("C10 CJ C2 C3 S4"), equalTo("HighCard: Jack"));
        assertThat(evaluator.evaluate("CJ CQ C2 C3 S4"), equalTo("HighCard: Queen"));
        assertThat(evaluator.evaluate("CQ CK C2 C3 S4"), equalTo("HighCard: King"));
        assertThat(evaluator.evaluate("CK CA C2 C3 S4"), equalTo("HighCard: Ace"));
    }

    @Test
    public void findsPairInHand() {
        assertThat(evaluator.evaluate("C4 H4 C2 C3 S5"), equalTo("Pair: Four's"));
        assertThat(evaluator.evaluate("DQ SQ C2 C3 S4"), equalTo("Pair: Queen's"));
    }

    @Disabled("Shouldn't you refactor first?")
    @Test
    void findsThreeOfAKind() {
        assertThat(evaluator.evaluate("C4 H4 D4 C2 S3"), equalTo("Three of a Kind: Four's"));
    }
}
