package com.schneide.kniffel;

import java.util.List;

public class DiceCounter {

	private List<Integer> listOfDice;

	public DiceCounter(List<Integer> listOfDice) {
		this.listOfDice = listOfDice;
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
