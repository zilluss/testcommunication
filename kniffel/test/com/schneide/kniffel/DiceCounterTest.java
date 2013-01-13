package com.schneide.kniffel;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class DiceCounterTest {

	@Test
	public void countOnlyOnes() {
		DiceCounter counter = counterFor(1, 1, 1, 1, 1);
		assertEquals(5, counter.getCountOf(1));
		assertEquals(0, counter.getCountOf(2));
		assertEquals(0, counter.getCountOf(3));
		assertEquals(0, counter.getCountOf(4));
		assertEquals(0, counter.getCountOf(5));
		assertEquals(0, counter.getCountOf(6));
	}

	@Test
	public void countMixed() throws Exception {
		DiceCounter counter = counterFor(1, 5, 5, 4, 6);
		assertEquals(1, counter.getCountOf(1));
		assertEquals(0, counter.getCountOf(2));
		assertEquals(0, counter.getCountOf(3));
		assertEquals(1, counter.getCountOf(4));
		assertEquals(2, counter.getCountOf(5));
		assertEquals(1, counter.getCountOf(6));
	}

	private DiceCounter counterFor(int firstDie, int secondDie, int thirdDie, int fourthDie, int fifthDie) {
		return new DiceCounter(Arrays.asList(firstDie, secondDie, thirdDie, fourthDie, fifthDie));
	}

}
