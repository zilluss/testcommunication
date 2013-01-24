package com.schneide.poker;

public class Card {

	public static Card from(String cardRepresentation) {
		Value value = parseValueFrom(cardRepresentation);
		String decoration = parseDecorationFrom(cardRepresentation);
		return new Card(value, decoration);
	}
	
	private static String parseDecorationFrom(String cardRepresentation) {
		return cardRepresentation.substring(1, 2);
	}

	private static Value parseValueFrom(String cardRepresentation) {
		String valueRepresentation = cardRepresentation.substring(0, 1);
		return Value.forSymbol(valueRepresentation);
	}

	private Value value;
	private String decoration;

	private Card(Value value, String decoration) {
		this.value = value;
		this.decoration = decoration;
	}
	
	public String representation() {
		return value.representation() + decoration;
	}

}
