package com.schneide.poker.categories;

import com.schneide.poker.Hand;

public class FourOfAKind {

	public boolean matches(Hand hand) {
		return hand.highestNumberOfCardsWithTheSameValue() == 4;
	}

}
