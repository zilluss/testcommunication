package com.schneide.kniffel;

public class TurnResult {

	private int i;
	private int j;

	public TurnResult(int i, int j) {
		this.i = i;
		this.j = j;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + i;
		result = prime * result + j;
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
		if (i != other.i)
			return false;
		if (j != other.j)
			return false;
		return true;
	}

}
