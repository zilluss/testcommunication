package com.schneide.kniffel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Player {

	private final DiceThrower thrower;

	public Player(DiceThrower thrower) {
		super();
		this.thrower = thrower;
	}

	public TurnResult performDiceRolls() {
		SimpleDiceThrowDecider decider = new SimpleDiceThrowDecider(
				thrower.throwAllDice());
		Collection<Integer> fixedDice = decider.fixedDice();
		int reThrowCount = 0;
		while (DiceThrower.KNIFFEL_DICE_COUNT != fixedDice.size()
				&& reThrowCount < 2) {
			reThrowCount++;
			Collection<Integer> newThrow = buildNewThrow(fixedDice,reThrow(numberOfDiceToReThrow(fixedDice)));
			decider = new SimpleDiceThrowDecider(newThrow);
			fixedDice = decider.fixedDice();
		}
		return new TurnResult(decider.getCategory(), computeScore(fixedDice));

	}

	private Collection<Integer> buildNewThrow(Collection<Integer> fixedDice,
			Collection<Integer> reThrownDice) {
		List<Integer> newThrow = new ArrayList<Integer>();
		newThrow.addAll(fixedDice);
		newThrow.addAll(reThrownDice);
		return newThrow;
	}

	private Collection<Integer> reThrow(int diceCount) {
		return thrower.throwDice(diceCount);
	}

	private int numberOfDiceToReThrow(Collection<Integer> fixedDice) {
		return DiceThrower.KNIFFEL_DICE_COUNT - fixedDice.size();
	}

	private int computeScore(Collection<Integer> fixedDice) {
		int score = 0;
		for (Integer die : fixedDice) {
			score += die;
		}
		return score;
	}

}
