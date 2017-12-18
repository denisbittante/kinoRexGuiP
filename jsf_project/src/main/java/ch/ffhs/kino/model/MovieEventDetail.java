package ch.ffhs.kino.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class MovieEventDetail {
	private MovieLanguage language;
	private String hall;
	private List<EventDateTime> eventDateTimes = new ArrayList<EventDateTime>();
	private ShowType type = ShowType.NORMAL;
	
	public MovieLanguage getLanguage() {
		return language;
	}
	public void setLanguage(MovieLanguage language) {
		this.language = language;
	}
	
//	public LocalDate getDate() {
//		return date;
//	}
//	public void setDate(LocalDate date) {
//		this.date = date;
//	}
//	public LocalTime getTime() {
//		return time;
//	}
//	public void setTime(LocalTime time) {
//		this.time = time;
//	}
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
//	public List<EventDateTime> getShowTimes() {
//		return eventDateTime;
//	}
//	public void setShowTimes(List<EventDateTime> showTimes) {
//		this.eventDateTime = showTimes;
//	}
	public List<EventDateTime> getEventDateTimes() {
		return eventDateTimes;
	}
	public void setEventDateTimes(List<EventDateTime> eventDateTimes) {
		this.eventDateTimes = eventDateTimes;
	}
}
