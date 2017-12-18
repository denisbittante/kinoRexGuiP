package ch.ffhs.kino.model;

import java.util.ArrayList;
import java.util.List;

public class MovieEvent {
	private int id;
	private Movie movie;
	private List<MovieEventDetail> details = new ArrayList<MovieEventDetail>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public List<MovieEventDetail> getDetails() {
		return details;
	}
	public void setDetails(List<MovieEventDetail> details) {
		this.details = details;
	}
}
