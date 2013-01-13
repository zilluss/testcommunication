package com.schneide.poker.categories;

import java.util.Comparator;

import com.schneide.poker.Hand;

public interface Category extends Comparator<Hand> {

	public boolean matches(Hand hand);

}
