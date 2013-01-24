package com.schneide.poker.categories;

import com.schneide.poker.Hand;

public class StraightFlush {

	public boolean matches(Hand hand) {
		return hand.hasConsecutiveValues() && hand.hasSameSuit();
	}

	public int compare(Hand a, Hand b) {
		return a.highestValue().compareTo(b.highestValue());
	}

}
