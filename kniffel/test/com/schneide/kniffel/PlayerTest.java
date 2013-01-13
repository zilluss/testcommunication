package com.schneide.kniffel;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class PlayerTest {

	@Test
	public void executePerfectThrowTurn() {
		DiceThrower dt = new DiceThrower() {
			@Override
			public Collection<Integer> throwAllDice() {
				return Arrays.asList(2, 2, 2, 2, 2);
			}

			@Override
			public Collection<Integer> throwDice(int count) {
				throw new IllegalStateException(
						"Player should not reroll with five same dice");
			}
		};
		Player player = new Player(dt);
		assertEquals(new TurnResult(2, 10), player.performDiceRolls());
	}

	@Test
	public void executeTypicalTurn() throws Exception {
		DiceThrower dt = new DiceThrower() {
			int throwNumber;

			@Override
			public Collection<Integer> throwAllDice() {
				throwNumber++;
				return Arrays.asList(2, 5, 6, 1, 2);
			}

			@Override
			public Collection<Integer> throwDice(int count) {
				if (throwNumber == 1) {
					throwNumber++;
					return Arrays.asList(3,3,1);
				}
				if (throwNumber == 2) {
					throwNumber++;
					return Arrays.asList(3,6,6);
				}
				throw new IllegalStateException("Player should not rethrow more than two times");

			}
		};
		Player player = new Player(dt);
		assertEquals(new TurnResult(3, 9), player.performDiceRolls());
	}
}
