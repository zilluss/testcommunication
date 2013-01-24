package com.schneide.poker.categories;

import com.schneide.poker.Hand;

public class StraightFlush {

	public boolean matches(Hand hand) {
		return hand.hasConsecutiveValues() && hand.hasSameSuit();
	}

	public int compare(Hand a, Hand b) {
		// TODO Auto-generated method stub
		return 0;
	}

}
