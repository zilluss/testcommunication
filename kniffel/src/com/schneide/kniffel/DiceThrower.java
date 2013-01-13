package com.schneide.kniffel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class DiceThrower {

	public static final int KNIFFEL_DICE_COUNT = 5;

	public DiceThrower() {
		super();
	}

	public Collection<Integer> throwAllDice() {
		return throwDice(KNIFFEL_DICE_COUNT);
	}

	public Collection<Integer> throwDice(int count) {
		List<Integer> dice = new ArrayList<Integer>();
		for (int i = 0; i < count; i++) {
			dice.add(computeDieValue());
		}
		return dice;
	}

	protected int computeDieValue() {
		return Math.abs(new Random().nextInt()) % 6 + 1;
	}

}
