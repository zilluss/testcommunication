package com.schneide.poker;

import static org.junit.Assert.*;

import org.junit.Test;

public class HandTest {

	@Test
	public void parseHand() {
		assertEquals("2C 3D 5S 9C KD", Hand.from("2C 3D 5S 9C KD").representation());
	}

	@Test
	public void parseAndSort() {
		assertEquals("2C 3D 5S 9C KD", Hand.from("9C KD 2C 5S 3D").representation());
	}

	@Test
	public void sameSuit() throws Exception {
		assertTrue(Hand.from("2D 3D 5D 9D KD").hasSameSuit());
	}

	@Test
	public void differentSuit() throws Exception {
		assertFalse(Hand.from("2C 3D 5D 9D KD").hasSameSuit());
	}

	@Test
	public void consecutive() throws Exception {
		assertTrue(Hand.from("2D 3D 5H 4D 6S").hasConsecutiveValues());
	}

	@Test
	public void notConsecutive() throws Exception {
		assertFalse(Hand.from("2D 3D 5D 9D KD").hasConsecutiveValues());
	}

	@Test
	public void highestValue() throws Exception {
		assertEquals(Value.KING, Hand.from("2C 3D KD KH 9D").highestValue());
	}
}
