package com.schneide.poker;

import java.util.HashMap;
import java.util.Map;

public enum Value {

	_2 {
		@Override
		public String representation() {
			return "2";
		}
	},
	_3 {
		@Override
		public String representation() {
			return "3";
		}
	},
	_4 {
		@Override
		public String representation() {
			return "4";
		}
	},
	_5 {
		@Override
		public String representation() {
			return "5";
		}
	},
	_6 {
		@Override
		public String representation() {
			return "6";
		}
	},
	_7 {
		@Override
		public String representation() {
			return "7";
		}
	},
	_8 {
		@Override
		public String representation() {
			return "8";
		}
	},
	_9 {
		@Override
		public String representation() {
			return "9";
		}
	},
	_10 {
		@Override
		public String representation() {
			return "T";
		}
	},
	JACK {
		@Override
		public String representation() {
			return "J";
		}
	},
	QUEEN {
		@Override
		public String representation() {
			return "Q";
		}
	},
	KING {
		@Override
		public String representation() {
			return "K";
		}
	},
	ACE {
		@Override
		public String representation() {
			return "A";
		}
	};

	public static Value forSymbol(String symbol) {
		if (!stringValueMapping.containsKey(symbol)) {
			throw new IllegalArgumentException("Could not parse " + symbol
					+ " to Value");
		}
		return stringValueMapping.get(symbol);
	}

	public abstract String representation();

	private static Map<String, Value> stringValueMapping = new HashMap<String, Value>();
	static {
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
