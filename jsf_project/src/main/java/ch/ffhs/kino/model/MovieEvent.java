package ch.ffhs.kino.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class MovieEvent {
	private int id;
	private Movie movie;
	private MovieLanguage language;
	private LocalDate date;
	private LocalTime time;
	private String hall;
	private ShowType type = ShowType.NORMAL;
	
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
	public MovieLanguage getLanguage() {
		return language;
	}
	public void setLanguage(MovieLanguage language) {
		this.language = language;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}
	public String getHall() {
		return hall;
	}
	public void setHall(String hall) {
		this.hall = hall;
	}
	public ShowType getType() {
		return type;
	}
	public void setType(ShowType type) {
		this.type = type;
	}
}
