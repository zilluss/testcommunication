package com.schneide.kniffel;

import java.util.List;

public class CalculateTurnResult {

	private List<Integer> diceForResult;

	public CalculateTurnResult(List<Integer> fixedDice) {
		this.diceForResult = fixedDice;
	}

	public TurnResult forTurn() {
		return new TurnResult(new SimpleDiceThrowDecider(diceForResult).getCategory(), sumOf(diceForResult));
	}

	private int sumOf(List<Integer> thrownDice) {
		int sum = 0;
		for(int dice : thrownDice) {
			sum += dice;
		}
		return sum;
	}

}
