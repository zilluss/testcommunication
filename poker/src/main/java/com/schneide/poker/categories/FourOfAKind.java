package com.schneide.poker.categories;

import com.schneide.poker.Hand;

public class FourOfAKind implements Category {

	@Override
	public int compare(Hand o1, Hand o2) {
		return 0;
	}

	@Override
	public boolean matches(Hand hand) {
		return false;
	}

}
