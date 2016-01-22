package poker;

import java.util.Collections;
import java.util.List;

public class PokerhandEvaluator {

	public String evaluate(String hand) {
		List<Card> cards = Card.fromHand(hand);
		Collections.sort(cards);
		Card result = cards.get(cards.size() - 1);
		return result.toString();
	}
}
