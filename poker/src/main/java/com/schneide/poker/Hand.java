package com.schneide.poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.schneide.framework.text.buffer.DirectChunkBuffer;

public class Hand {

	private List<Card> cards;

	public Hand(List<Card> cards) {
		super();
		Collections.sort(cards);
		this.cards = cards;
	}

	public static Hand from(String representation) {
		List<Card> cards = new ArrayList<Card>();
		String[] symbols = representation.split(" ");
		for (String symbol : symbols) {
			cards.add(Card.forSymbol(symbol));
		}
		return new Hand(cards);
	}

	public String representation() {
		DirectChunkBuffer buffer = new DirectChunkBuffer(' ');
		for (Card card : this.cards) {
			buffer.add(card.symbol());
		}
		return buffer.toString();
	}

	public boolean hasSameSuit() {
		Suit commonSuit = cards.get(0).suit();
		for (Card card : cards) {
			if (!card.suit().equals(commonSuit)) {
				return false;
			}
		}
		return true;
	}

	public boolean hasConsecutiveValues() {
		for (int i = 1; i < cards.size(); i++) {
			Value currentCard = cards.get(i).value();
			Card previousCard = cards.get(i - 1);
			if (!currentCard.isDirectSuccessorOf(previousCard.value())) {
				return false;
			}
		}
		return true;
	}

	public Value highestValue() {
		return cards.get(cards.size()-1).value();
	}

}
