package ch.ffhs.kino.model;

public enum MovieLanguage {
	NONE("", "-- Alle --"), DEUTSCH("D", "Deutsch"), ENGLISH("E", "Englisch"), FRANZOESISCH("F", "Französisch");

	private String text;
	private String longText;

	public String getText() {
		return text;
	}

	public String getLongText() {
		return longText;
	}

	public void setLongText(String longText) {
		this.longText = longText;
	}

	public void setText(String text) {
		this.text = text;
	}

	private MovieLanguage(String text, String longText) {
		this.text = text;
		this.longText = longText;

	}

	@Override
	public String toString() {
		return getLongText();
	}
}
