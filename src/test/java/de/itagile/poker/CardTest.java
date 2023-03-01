package de.itagile.poker;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;

public class CardTest {
    @Test
    public void hasValue() throws Exception {
        assertThat(new Card("C4").toString(), equalTo("C4"));
    }

    @Test
    public void isEqualToCardWithSameValue() throws Exception {
        assertThat(new Card("C4"), equalTo(new Card("C4")));
    }

    @Test
    public void cardWithHigherRankIsGreather() throws Exception {
        assertThat(new Card("C4"), greaterThan(new Card("C3")));
        assertThat(new Card("CA"), greaterThan(new Card("CJ")));
    }

    @Test
    public void formatsCardsToString() {
        List<Card> cards = Card.fromHand("C2 C3");
        assertThat(Card.formatToString(cards), equalTo("C2 C3"));
    }
}
