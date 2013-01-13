package com.schneide.poker;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class ValueTest {

	@Test
	public void parseValueForSymbol() {
		assertEquals(Value._2, Value.forSymbol("2"));
		assertEquals(Value._3, Value.forSymbol("3"));
		assertEquals(Value._4, Value.forSymbol("4"));
		assertEquals(Value._5, Value.forSymbol("5"));
		assertEquals(Value._6, Value.forSymbol("6"));
		assertEquals(Value._7, Value.forSymbol("7"));
		assertEquals(Value._8, Value.forSymbol("8"));
		assertEquals(Value._9, Value.forSymbol("9"));
		assertEquals(Value._10, Value.forSymbol("T"));
		assertEquals(Value.JACK, Value.forSymbol("J"));
		assertEquals(Value.QUEEN, Value.forSymbol("Q"));
		assertEquals(Value.KING, Value.forSymbol("K"));
		assertEquals(Value.ACE, Value.forSymbol("A"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void parseValueForIllegalSymbol() throws Exception {
		Value.forSymbol("X");
	}

	@Test
	public void ordering() throws Exception {
		List<Value> expected = Arrays.asList(
				Value._2,
				Value._3,
				Value._4,
				Value._5,
				Value._6,
				Value._7,
				Value._8,
				Value._9,
				Value._10,
				Value.JACK,
				Value.QUEEN,
				Value.KING,
				Value.ACE
				);

		List<Value> values = new ArrayList<Value>(expected);
		List<Value> shuffled = new ArrayList<Value>(values.subList(3, 6));
		values.removeAll(shuffled);
		values.addAll(shuffled);

		Collections.sort(values);

		assertArrayEquals(expected.toArray(), values.toArray());
	}
}
