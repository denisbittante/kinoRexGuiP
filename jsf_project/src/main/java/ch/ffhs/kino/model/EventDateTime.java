package ch.ffhs.kino.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class EventDateTime {
	private LocalDate showDate;
	private LocalTime showTime;
	
	public LocalDate getShowDate() {
		return showDate;
	}
	public void setShowDate(LocalDate showDate) {
		this.showDate = showDate;
	}
	public LocalTime getShowTime() {
		return showTime;
	}
	public void setShowTime(LocalTime showTime) {
		this.showTime = showTime;
	}
}
