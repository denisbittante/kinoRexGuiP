package ch.ffhs.kino.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import ch.ffhs.kino.model.EventDateTime;
import ch.ffhs.kino.model.GenreType;
import ch.ffhs.kino.model.Movie;
import ch.ffhs.kino.model.MovieEvent;
import ch.ffhs.kino.model.MovieEventDetail;
import ch.ffhs.kino.model.MovieLanguage;
import ch.ffhs.kino.service.BackendService;

@ManagedBean(name = "movieEventController")
@SessionScoped
public class MovieEventController {

	private List<LocalDate> dates = new ArrayList<LocalDate>();
	private List<MovieEvent> events = new ArrayList<MovieEvent>();
	private List<MovieEvent> filteredEvents = new ArrayList<MovieEvent>();
	
	private Movie selectedMovie;
	private MovieEvent selectedMovieEvent;
	private MovieEventDetail selectedDetail;
	private EventDateTime selectedEventDateTime;
	
	private GenreType searchGenre;
	private MovieLanguage searchLanguage;
	private String movieEventSummary;

	@PostConstruct
	public void init() {
		BackendService service = new BackendService();
		dates = service.getEventsDates();	
		events = service.getAllMovieEvents();
		filteredEvents = new ArrayList<MovieEvent>(events);
	}

	public GenreType[] getGenres() {
        return GenreType.values();
    }

	public MovieLanguage[] getLanguage() {
        return MovieLanguage.values();
    }
	
	public void search() {
		filteredEvents = new ArrayList<MovieEvent>(events);
		for (int i = filteredEvents.size() - 1; i >= 0; i--) {
			MovieEvent movieEvent = filteredEvents.get(i);
			
			// Filter Genre
			if (searchGenre != null && searchGenre != GenreType.NONE) {
				Optional<GenreType> foundGenre = movieEvent.getMovie().getGenre().stream().filter(x -> x == searchGenre).findFirst();
				if(!foundGenre.isPresent()){
					filteredEvents.remove(i);
					continue;
				}
			}
			
			// Filter Sprache
			if (searchLanguage != null && searchLanguage != MovieLanguage.NONE) {
				Optional<MovieEventDetail> foundEvent = movieEvent.getDetails().stream().filter(x -> x.getLanguage() == searchLanguage).findFirst();
				if(!foundEvent.isPresent()){
					filteredEvents.remove(i);
					continue;
				}
			}
		}
	}

	public String selectEvent(MovieEvent movieEvent, MovieEventDetail detail, EventDateTime dateTime){
		Movie selectedMovie = movieEvent.getMovie();
		
		setSelectedMovie(selectedMovie);
		setSelectedDetail(detail);
		setSelectedEventDateTime(dateTime);	
		
		String movieTitle = selectedMovie.getTitle();
		String movieLanguage = detail.getLanguage().getText();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E dd MMM yyyy");
		String formattedDate = dateTime.getShowDate().format(formatter);
		String movieEventSummary = movieTitle + " (" + movieLanguage + "), " + formattedDate + " " + dateTime.getShowTime() + ", " + detail.getHall();
		setMovieEventSummary(movieEventSummary);
		
		FacesContext facesContext = FacesContext.getCurrentInstance();
		// Gruusig: ELResolver geht bei Jetty leider nicht, da Java EE 7 Specification API
		BookingController kinoSaalManager = (BookingController) facesContext.getApplication().getVariableResolver().resolveVariable(facesContext, "kinoSaalManager");
		kinoSaalManager.resetReservedSeats();
		kinoSaalManager.setHasPayed(false);
		
		NavigationController navigationBean = (NavigationController) facesContext.getApplication().getVariableResolver().resolveVariable(facesContext, "navigationController");
		return navigationBean.goToStep2();
	}
	
	public String showMovieDetail(MovieEvent movieEvent){
		setSelectedMovieEvent(movieEvent);
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

    public List<MovieEvent> getFilteredEvents() {
        return filteredEvents;
    }

    public void setFilteredEvents(List<MovieEvent> filteredEvents) {
        this.filteredEvents = filteredEvents;
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
	
	public MovieLanguage getSearchLanguage() {
		return searchLanguage;
	}

	public void setSearchLanguage(MovieLanguage searchLanguage) {
		this.searchLanguage = searchLanguage;
	}

	public GenreType getSearchGenre() {
		return searchGenre;
	}

	public void setSearchGenre(GenreType searchGenre) {
		this.searchGenre = searchGenre;
	}

	public MovieEvent getSelectedMovieEvent() {
		return selectedMovieEvent;
	}

	public void setSelectedMovieEvent(MovieEvent selectedMovieEvent) {
		this.selectedMovieEvent = selectedMovieEvent;
	}

	public String getMovieEventSummary() {
		return movieEventSummary;
	}

	public void setMovieEventSummary(String movieEventSummary) {
		this.movieEventSummary = movieEventSummary;
	}
}
