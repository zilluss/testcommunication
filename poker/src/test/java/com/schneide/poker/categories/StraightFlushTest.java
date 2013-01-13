package com.schneide.poker.categories;

import static org.junit.Assert.*;

import org.junit.Test;

import com.schneide.poker.Hand;

public class StraightFlushTest {

	@Test
	public void matches() {
		assertTrue(new StraightFlush().matches(Hand.from("2C 3C 4C 5C 6C")));
		assertTrue(new StraightFlush().matches(Hand.from("8D 9D TD JD QD")));
	}

	@Test
	public void doesNotMatchDueToDifferentSuits() {
		assertFalse(new StraightFlush().matches(Hand.from("2C 3C 4D 5D 6D")));
	}

	@Test
	public void doesNotMatchDueToNonConsecutiveValues() {
		assertFalse(new StraightFlush().matches(Hand.from("2C 3C 4C 6C 7C")));
	}

	@Test
	public void lowerRankDifferentSuits() {
		Hand a = Hand.from("2C 3C 4C 5C 6C");
		Hand b = Hand.from("3D 4D 5D 6D 7D");
		assertTrue(new StraightFlush().compare(a, b) < 0);
	}

	@Test
	public void higherRankDifferentSuits() {
		Hand a = Hand.from("3D 4D 5D 6D 7D");
		Hand b = Hand.from("2C 3C 4C 5C 6C");
		assertTrue(new StraightFlush().compare(a, b) > 0);
	}

	@Test
	public void sameRankDifferentSuits() {
		Hand a = Hand.from("2C 3C 4C 5C 6C");
		Hand b = Hand.from("2D 3D 4D 5D 6D");
		assertTrue(new StraightFlush().compare(a, b) == 0);
	}
}
