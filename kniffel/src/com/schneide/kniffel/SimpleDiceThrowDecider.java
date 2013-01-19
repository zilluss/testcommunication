package com.schneide.kniffel;

import java.util.List;

public class SimpleDiceThrowDecider {

	private static final int MAXIMUM_PIPS_ON_A_DICE = 6;
	private static final int MINIMUM_PIPS_ON_A_DICE = 1;
	private List<Integer> thrownDice;

	public SimpleDiceThrowDecider(List<Integer> thrownDice) {
		this.thrownDice = thrownDice;
	}

	public int getCategory() {
		for(int pip = MINIMUM_PIPS_ON_A_DICE; pip <= MAXIMUM_PIPS_ON_A_DICE; pip++){
			if(allDiceHaveTheSame(pip)){
				return pip;
			}
		}
		return 0;
	}

	private boolean allDiceHaveTheSame(int pip) {
		return new DiceCounter(thrownDice).getCountOf(pip) == DiceThrower.ALL_DICE;
	}

	public List<Integer> fixedDice() {
		return null;
	}

}
