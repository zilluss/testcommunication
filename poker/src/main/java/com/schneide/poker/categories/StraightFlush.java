package com.schneide.poker.categories;

import com.schneide.poker.Hand;

public class StraightFlush implements Category {

	@Override
	public boolean matches(Hand hand) {
		return hand.hasSameSuit() && hand.hasConsecutiveValues();
	}

	@Override
	public int compare(Hand a, Hand b) {
		return a.highestValue().compareTo(b.highestValue());
	}
}
