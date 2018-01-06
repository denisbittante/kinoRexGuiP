package ch.ffhs.kino.model;

import java.io.Serializable;

public enum GenreType  implements Serializable{
	NONE("-- Alle --"), DRAMA("Drama"), ACTION("Action"), FANTASY("Fantasy"), ABENTEUER("Abenteuer"), COMEDY("Komödie"), MISTRERY("Mystery"), THRILLER("Thriller"), CRIMINAL("Krimi"), HORROR("Horror"), SCIENCE_FICTION("Science Fiction"), ANIMATION("Trickfilm");
	
	private static final long serialVersionUID = 1L;
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
