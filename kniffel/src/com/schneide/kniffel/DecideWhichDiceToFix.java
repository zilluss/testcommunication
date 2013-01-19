package com.schneide.kniffel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DecideWhichDiceToFix {

	private List<Integer> alreadyFixedDice;

	public DecideWhichDiceToFix(List<Integer> fixedDice) {
		this.alreadyFixedDice= fixedDice;
	}

	public List<Integer> forCurrent(Collection<Integer> diceThrow) {
		if(numberOfFixedDiceWillIncreaseWith(diceThrow)){
			return fixDiceForAlreadyFixedDicePlus(diceThrow);
		}
		return fixedDiceOf(diceThrow);
	}

	private boolean numberOfFixedDiceWillIncreaseWith(Collection<Integer> diceThrow) {
		return fixDiceForAlreadyFixedDicePlus(diceThrow).size() > fixedDiceOf(alreadyFixedDice).size();
	}

	private List<Integer> fixDiceForAlreadyFixedDicePlus(
			Collection<Integer> diceThrow) {
		List<Integer> combinedDice = new ArrayList<Integer>(diceThrow);
		combinedDice.addAll(alreadyFixedDice);
		return fixedDiceOf(combinedDice);
	}

	private List<Integer> fixedDiceOf(Collection<Integer> diceThrow) {
		return new SimpleDiceThrowDecider(diceThrow).fixedDice();
	}
}
