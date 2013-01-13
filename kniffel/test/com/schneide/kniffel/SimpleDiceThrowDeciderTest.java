package com.schneide.kniffel;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class SimpleDiceThrowDeciderTest {

	@Test
	public void chooseCategoryOne() {
		assertCategoryForallDice(1);
	}

	@Test
	public void chooseCategoryTwo() throws Exception {
		assertCategoryForallDice(2);
	}

	@Test
	public void chooseCategoryThree() throws Exception {
		assertCategoryForallDice(3);
	}

	@Test
	public void chooseCategoryFour() throws Exception {
		assertCategoryForallDice(4);
	}

	@Test
	public void chooseCategoryFive() throws Exception {
		assertCategoryForallDice(5);
	}

	@Test
	public void chooseCategorySix() throws Exception {
		assertCategoryForallDice(6);
	}

	@Test
	public void onlyOneOfEachDice() throws Exception {
		assertEquals(6, new SimpleDiceThrowDecider(Arrays.asList(4, 5, 6, 1, 3)).getCategory());
	}

	@Test
	public void twoOfDifferentDice() throws Exception {
		assertEquals(4, new SimpleDiceThrowDecider(Arrays.asList(2, 2, 4, 4, 3)).getCategory());
	}

	@Test
	public void fixedDiceForAllSame() throws Exception {
		assertEquals(Arrays.asList(3, 3, 3, 3, 3), new SimpleDiceThrowDecider(Arrays.asList(3, 3, 3, 3, 3)).fixedDice());
	}

	@Test
	public void fixedDiceForMostThrees() throws Exception {
		assertEquals(Arrays.asList(3, 3, 3), new SimpleDiceThrowDecider(Arrays.asList(3, 3, 3, 1, 6)).fixedDice());
	}

	@Test
	public void fixedDiceIsOfCategory() throws Exception {
		assertEquals(Arrays.asList(4, 4), new SimpleDiceThrowDecider(Arrays.asList(3, 3, 4, 4, 6)).fixedDice());
	}

	private void assertCategoryForallDice(int i) {
		assertEquals(i, new SimpleDiceThrowDecider(Arrays.asList(i, i, i, i, i)).getCategory());
	}
}
