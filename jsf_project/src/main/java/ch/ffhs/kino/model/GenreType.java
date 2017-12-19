package ch.ffhs.kino.model;

public enum GenreType {
	DRAMA("Drama"), ACTION("Action"), COMEDY("Komödie"), MISTRERY("Mystery"), THRILLER("Thriller"), CRIMINAL(
			"Krimi"), HORROR("Horror"), SCIENCE_FICTION("Science Fiction"), ANIMATION("Trickfilm"), NONE("");
	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	private GenreType(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return getText();
	}
}
