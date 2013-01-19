package com.schneide.kniffel;

import java.util.ArrayList;
import java.util.Collection;

public class DiceThrower {

	private static final int ALL_DICE = 5;

	public Collection<Integer> throwAllDice() {
		return throwDice(ALL_DICE);
		
	}

	public Collection<Integer> throwDice(int numberOfDiceToThrow) {
		Collection<Integer> thrownDice = new ArrayList<Integer>();
		for(int diceToThrow = 0; diceToThrow < numberOfDiceToThrow; diceToThrow++) {
			throwADiceAndAddItTo(thrownDice);
		}
		return thrownDice;
	}

	private void throwADiceAndAddItTo(Collection<Integer> thrownDice) {
		int randomDiceThrow = (int)Math.floor((Math.random() * 6d) + 1d);
		thrownDice.add(randomDiceThrow);
	}

}
