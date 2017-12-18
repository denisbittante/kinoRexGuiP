package ch.ffhs.kino.model;

public enum ShowType {
	NORMAL, THREE_D;
	public  boolean isThreeD() {
		if (THREE_D.equals(this)) {
			return true;
		}
		return false;

	}
}
