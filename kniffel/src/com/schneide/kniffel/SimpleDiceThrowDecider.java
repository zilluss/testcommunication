package com.schneide.kniffel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SimpleDiceThrowDecider {

	private final Collection<Integer> dice;

	public SimpleDiceThrowDecider(Collection<Integer> dice) {
		this.dice = dice;
	}

	public int getCategory() {
		return maximumSameDice(new DiceCounter(dice).getDiceCounts());
	}

	public Collection<Integer> fixedDice() {
		List<Integer> fixedDice = new ArrayList<Integer>();
		for (int i = 0; i < new DiceCounter(dice).getCountOf(getCategory()); i++) {
			fixedDice.add(getCategory());
		}
		return fixedDice;
	}

	private int maximumSameDice(Map<Integer, Integer> diceCounts) {
		int count = 0;
		int die = 0;
		for (Entry<Integer, Integer> diceCount : diceCounts.entrySet()) {
			if (diceCount.getValue() >= count) {
				die = diceCount.getKey();
				count = diceCount.getValue();
			}
		}
		return die;
	}
}
