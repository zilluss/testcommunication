package com.schneide.kniffel;

public class TurnResult {

	private final int category;
	private final int score;

	public TurnResult(int category, int score) {
		super();
		this.category = category;
		this.score = score;
	}

	public int getCategory() {
		return category;
	}

	public int getScore() {
		return score;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + category;
		result = prime * result + score;
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
		if (score != other.score)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Category: " + getCategory() + ",Score: " + getScore();
	}

}
