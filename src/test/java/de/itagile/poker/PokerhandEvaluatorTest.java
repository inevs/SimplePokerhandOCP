package de.itagile.poker;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PokerhandEvaluatorTest {
    SimplePokerhandEvaluator evaluator = new SimplePokerhandEvaluator();

    @Test
    public void findsHighcardOutOfTwo() throws Exception {
        assertThat(evaluator.evaluate("C2 C3"), equalTo("HighCard: Three"));
        assertThat(evaluator.evaluate("C2 C4"), equalTo("HighCard: Four"));
        assertThat(evaluator.evaluate("C4 C2"), equalTo("HighCard: Four"));
    }

    @Test
    public void findsHighcardWith10() throws Exception {
        assertThat(evaluator.evaluate("C4 C10"), equalTo("HighCard: Ten"));
    }

    @Test
    void findHighcardIgnoringColor() {
        assertThat(evaluator.evaluate("C4 H3"), equalTo("HighCard: Four"));
    }

    @Test
    public void findsHighcardWithFaceCards() throws Exception {
        assertThat(evaluator.evaluate("C10 CJ"), equalTo("HighCard: Jack"));
        assertThat(evaluator.evaluate("CJ CQ"), equalTo("HighCard: Queen"));
        assertThat(evaluator.evaluate("CQ CK"), equalTo("HighCard: King"));
        assertThat(evaluator.evaluate("CK CA"), equalTo("HighCard: Ace"));
    }

    @Test
    public void findsPairOutOfTwo() throws Exception {
        assertThat(evaluator.evaluate("C4 H4"), equalTo("Pair: Four's"));
    }
}
