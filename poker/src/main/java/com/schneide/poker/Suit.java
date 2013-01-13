package com.schneide.poker;

public enum Suit {
	CLUBS,
	DIAMONDS,
	HEARTS,
	SPADES;

	public String symbol(){
		return name().substring(0,1);
	}

	public static Suit forSymbol(String symbol){
		for (Suit suit : Suit.values()) {
			if(suit.symbol().equals(symbol)){
				return suit;
			}
		}
		throw new IllegalArgumentException("No found for symbol: " + symbol);
	}
}
