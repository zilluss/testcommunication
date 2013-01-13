package com.schneide.poker.categories;

import static org.junit.Assert.*;

import org.junit.Test;

import com.schneide.poker.Hand;

public class FourOfAKindTest {

	@Test
	public void matches() {
		assertTrue(new FourOfAKind().matches(Hand.from("2C 2D 2H 2S 6D")));
		assertTrue(new FourOfAKind().matches(Hand.from("AD 3C 3D 3H 3S")));
	}

}
