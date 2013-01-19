package com.schneide.kniffel;

import java.util.List;

public class SimpleDiceThrowDecider {

	private static final int MAXIMUM_PIPS_ON_A_DICE = 6;
	private static final int TWO_PIPS = 2;
	private List<Integer> thrownDice;

	public SimpleDiceThrowDecider(List<Integer> thrownDice) {
		this.thrownDice = thrownDice;
	}

	public int getCategory() {
		int candidateForCategory = 1;
		for(int pips = TWO_PIPS; pips <= MAXIMUM_PIPS_ON_A_DICE; pips++){
			candidateForCategory = getMostSuitable(candidateForCategory, pips);
		}
		return candidateForCategory;
	}

	private int getMostSuitable(int candidateForCategory, int pips) {
		if(occurrenceOf(pips) >= occurrenceOf(candidateForCategory)) {
			return pips;
		}
		return candidateForCategory;
	}

	private int occurrenceOf(int pips) {
		return new DiceCounter(thrownDice).getCountOf(pips);
	}

	public List<Integer> fixedDice() {
		return null;
	}

}
