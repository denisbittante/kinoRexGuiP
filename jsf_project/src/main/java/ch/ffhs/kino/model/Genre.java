package ch.ffhs.kino.model;

import java.io.Serializable;

public class Genre implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id;		
	private String description;
	
	public Genre(int id, String description){
		this.id = id;
		this.description = description;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
