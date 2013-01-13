package com.schneide.poker;

import java.util.Arrays;
import java.util.List;

public enum Value {
	_2("2"),
	_3("3"),
	_4("4"),
	_5("5"),
	_6("6"),
	_7("7"),
	_8("8"),
	_9("9"),
	_10("T"),
	JACK("J"),
	QUEEN("Q"),
	KING("K"),
	ACE("A");

	private String symbol;

	private Value(String symbol) {
		this.symbol = symbol;
	}

	public String symbol(){
		return symbol;
	}

	public boolean isDirectSuccessorOf(Value value) {
		List<Value> valuesAsList = Arrays.asList(values());
		return valuesAsList.indexOf(value) + 1 == valuesAsList.indexOf(this);
	}

	public static Value forSymbol(String symbol){
		for (Value value : Value.values()) {
			if(value.symbol().equals(symbol)){
				return value;
			}
		}
		throw new IllegalArgumentException("No value found for symbol: " + symbol);
	}
}
