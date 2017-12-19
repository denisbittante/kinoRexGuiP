package ch.ffhs.kino.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ch.ffhs.kino.model.EventDateTime;
import ch.ffhs.kino.model.Movie;
import ch.ffhs.kino.model.MovieEvent;
import ch.ffhs.kino.model.MovieEventDetail;
import ch.ffhs.kino.service.BackendService;

@ManagedBean(name = "movieEventController")
@SessionScoped
public class MovieEventController {

	private List<LocalDate> dates = new ArrayList<LocalDate>();
	private List<MovieEvent> events = new ArrayList<MovieEvent>();
	
	private Movie selectedMovie;
	private MovieEventDetail selectedDetail;
	private EventDateTime selectedEventDateTime;
		
	@PostConstruct
	public void populateShowList() {
		BackendService service = new BackendService();
		dates = service.getEventsDates();	
		events = service.getAllMovieEvents();
	}

	public String selectEvent(MovieEvent movieEvent, MovieEventDetail detail, EventDateTime dateTime){
		setSelectedMovie(movieEvent.getMovie());
		setSelectedDetail(detail);
		setSelectedEventDateTime(dateTime);	
//		System.out.println("Detail: " + detail.getLanguage());
//		System.out.println("Date: " + dateTime.getShowDate());
//		System.out.println("Time: " + dateTime.getShowTime());
		return "movieShow.jsf";
	}
	
	public String showMovieDetail(MovieEvent movieEvent){
		setSelectedMovie(movieEvent.getMovie());
		return "movieDetail.jsf";
	}
	
    // #### getters and setters ####
    public List<LocalDate> getDates() {
        return dates;
    }

    public void setDates(List<LocalDate> dates) {
        this.dates = dates;
    }
    
    public List<MovieEvent> getEvents() {
        return events;
    }

    public void setEvents(List<MovieEvent> events) {
        this.events = events;
    }

	public Movie getSelectedMovie() {
		return selectedMovie;
	}

	public void setSelectedMovie(Movie selectedMovie) {
		this.selectedMovie = selectedMovie;
	}

	public MovieEventDetail getSelectedDetail() {
		return selectedDetail;
	}

	public void setSelectedDetail(MovieEventDetail selectedDetail) {
		this.selectedDetail = selectedDetail;
	}

	public EventDateTime getSelectedEventDateTime() {
		return selectedEventDateTime;
	}

	public void setSelectedEventDateTime(EventDateTime selectedEventDateTime) {
		this.selectedEventDateTime = selectedEventDateTime;
	}

}
