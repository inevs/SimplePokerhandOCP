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
        assertThat(new Card("C4").toString(), equalTo("Four"));
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
}
