package com.schneide.poker;

import java.util.HashMap;
import java.util.Map;

public enum Value {
	
	KING, _2, _3, _4, _5, _6, _7, _8, _9, _10, JACK, QUEEN, ACE;

	public static Value forSymbol(String symbol) {
		if(!stringValueMapping.containsKey(symbol)) {
			throw new IllegalArgumentException("Could not parse " + symbol + " to Value");
		}
		return stringValueMapping.get(symbol);
	}
	private static Map<String, Value> stringValueMapping = new HashMap<String, Value>();
	static
	{
		stringValueMapping.put("2", _2);
		stringValueMapping.put("3", _3);
		stringValueMapping.put("4", _4);
		stringValueMapping.put("5", _5);
		stringValueMapping.put("6", _6);
		stringValueMapping.put("7", _7);
		stringValueMapping.put("8", _8);
		stringValueMapping.put("9", _9);
		stringValueMapping.put("T", _10);
		stringValueMapping.put("J", JACK);
		stringValueMapping.put("Q", QUEEN);
		stringValueMapping.put("A", ACE);
		stringValueMapping.put("K", KING);
	}
	
}
