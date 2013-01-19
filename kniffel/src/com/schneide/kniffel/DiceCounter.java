package com.schneide.kniffel;

import java.util.Collection;
import java.util.List;

public class DiceCounter {

	private Collection<Integer> listOfDice;

	public DiceCounter(Collection<Integer> thrownDice) {
		this.listOfDice = thrownDice;
	}

	public int getCountOf(int expectedDiceSide) {
		int diceWithExpectedDiceSide = 0;
		for(int thrownDiceSide : listOfDice){
			if(thrownDiceSide == expectedDiceSide){
				diceWithExpectedDiceSide += 1;
			}
		}
		return diceWithExpectedDiceSide;
	}

}
