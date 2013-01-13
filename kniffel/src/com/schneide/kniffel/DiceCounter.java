package com.schneide.kniffel;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

public class DiceCounter {

	private final Collection<Integer> dice;
	private Map<Integer, Integer> diceCounts;

	public DiceCounter(Collection<Integer> dice) {
		this.dice = dice;
		this.diceCounts = countDice();
	}

	private Map<Integer, Integer> countDice() {
		Map<Integer, Integer> diceCounts = initialCounts();
		for (Integer die : this.dice) {
			diceCounts.put(die, diceCounts.get(die) + 1);
		}
		return diceCounts;
	}

	public Map<Integer, Integer> getDiceCounts() {
		return diceCounts;
	}

	public int getCountOf(int die) {
		return getDiceCounts().get(die);
	}

	private Map<Integer, Integer> initialCounts() {
		Map<Integer, Integer> diceCounts = new TreeMap<Integer, Integer>();
		for (int i = 1; i <= 6; i++) {
			diceCounts.put(i, 0);
		}
		return diceCounts;
	}
}
