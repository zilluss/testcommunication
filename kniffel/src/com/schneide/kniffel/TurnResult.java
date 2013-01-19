package com.schneide.kniffel;

public class TurnResult {

	private int category;
	private int points;

	public TurnResult(int category, int points) {
		this.category = category;
		this.points = points;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + category;
		result = prime * result + points;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TurnResult other = (TurnResult) obj;
		if (category != other.category)
			return false;
		if (points != other.points)
			return false;
		return true;
	}

}
