package com.schneide.kniffel;

import java.util.ArrayList;
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
		if(countOfDiceWith(pips) >= countOfDiceWith(candidateForCategory)) {
			return pips;
		}
		return candidateForCategory;
	}

	private int countOfDiceWith(int pips) {
		return new DiceCounter(thrownDice).getCountOf(pips);
	}

	public List<Integer> fixedDice() {
		List<Integer> fixedDice = new ArrayList<Integer>();
		for(int diceToFix = 0; diceToFix < countOfDiceOfCategory(); diceToFix++){
			fixedDice.add(this.getCategory());
		}
		return fixedDice;
	}

	private int countOfDiceOfCategory() {
		return countOfDiceWith(getCategory());
	}

}
