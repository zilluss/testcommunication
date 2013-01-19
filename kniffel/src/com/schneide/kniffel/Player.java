package com.schneide.kniffel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Player {

	private static final int MAXIMUM_NUMBER_OF_THROWS = 3;
	private static final int MAXIMUM_NUMBER_OF_FIXED_DICE = 5;
	private DiceThrower diceThrower;
    private List<Integer> fixedDice = new ArrayList<Integer> ();
    private int numberOfThrows = 0;
    
	public Player(DiceThrower diceThrower) {
		this.diceThrower = diceThrower;
	}

	public TurnResult performDiceRolls() {
		while(playerIsAllowedToRollDice()) {
			fixDiceOfCurrent(diceThrow());
		}
		return new CalculateTurnResult(fixedDice).forTurn();
	}

	private boolean playerIsAllowedToRollDice() {
		return numberOfThrows < MAXIMUM_NUMBER_OF_THROWS && fixedDice.size() < MAXIMUM_NUMBER_OF_FIXED_DICE;
	}

	private void fixDiceOfCurrent(Collection<Integer> diceThrow) {
		this.fixedDice = new DecideWhichDiceToFix(fixedDice).forCurrent(diceThrow);
	}

	
	private Collection<Integer> diceThrow() {
		if(numberOfThrows == 0) {
			numberOfThrows++;
			return diceThrower.throwAllDice();
		}
		numberOfThrows++;
		return diceThrower.throwDice(numberOfDiceYetToFix());
			
	}
	
	private int numberOfDiceYetToFix() {
		return MAXIMUM_NUMBER_OF_FIXED_DICE - this.fixedDice.size();
	}
}
