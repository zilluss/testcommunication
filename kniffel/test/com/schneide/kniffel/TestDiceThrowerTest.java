package com.schneide.kniffel;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Test;

public class TestDiceThrowerTest {

	public TestDiceThrowerTest() {
		super();
	}

	@Test
	public void throwDice() throws Exception {
		Collection<Integer> dice = new DiceThrower().throwAllDice();
		assertEquals(5, dice.size());
		assertValuesInDiceRange(dice);
	}

	@Test
	public void throwOnlySomeDice() throws Exception {
		Collection<Integer> dice = new DiceThrower().throwDice(3);
		assertEquals(3, dice.size());
		assertValuesInDiceRange(dice);

	}

	private void assertValuesInDiceRange(Collection<Integer> dice) {
		for (Integer die : dice) {
			assertTrue("Die value must be between 1 and 6, but was: " + die, die >= 1 && die <= 6);
		}
	}
}
