package com.schneide.poker;

public class Card implements Comparable<Card> {
	private final Suit suit;
	private final Value value;

	public Card(Value value, Suit suit) {
		this.value = value;
		this.suit = suit;
	}

	public static Card forSymbol(String symbol){
		if(symbol.length() != 2){
			throw new IllegalArgumentException("symbol for card must have 2 characters");
		}

		return new Card(Value.forSymbol(symbol.substring(0,1)), Suit.forSymbol(symbol.substring(1,2)));
	}

	public String symbol(){
		return value.symbol() + suit.symbol();
	}

	@Override
	public int compareTo(Card that) {
		return this.value.compareTo(that.value);
	}

	public Suit suit() {
		return suit;
	}

	public Value value() {
		return value;
	}
}
