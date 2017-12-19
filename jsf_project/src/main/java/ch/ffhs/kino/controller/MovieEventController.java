package ch.ffhs.kino.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;

import ch.ffhs.kino.model.EventDateTime;
import ch.ffhs.kino.model.Genre;
import ch.ffhs.kino.model.Movie;
import ch.ffhs.kino.model.MovieEvent;
import ch.ffhs.kino.model.MovieEventDetail;
import ch.ffhs.kino.service.BackendService;

@ManagedBean(name = "movieEventController")
@SessionScoped
public class MovieEventController {

	private List<LocalDate> dates = new ArrayList<LocalDate>();
	private List<MovieEvent> events = new ArrayList<MovieEvent>();
	private List<MovieEvent> filteredEvents = new ArrayList<MovieEvent>();
	
	private Movie selectedMovie;
	private MovieEventDetail selectedDetail;
	private EventDateTime selectedEventDateTime;
	
//	private GenreType selectedGenre;
//	
//	public GenreType[] getGenres() {
//        return GenreType.values();
//    }
	
	private List<Genre> genreList;
	private int selectedGenre;
	
	
//	 public SelectItem[] getGenderValues() {
//	    SelectItem[] items = new SelectItem[GenreType.values().length];
//	    int i = 0;
//	    for(GenreType g: GenreType.values()) {
//	      items[i++] = new SelectItem(g, g.getText());
//	    }
//	    return items;
//	}
	 
	@PostConstruct
	public void populateShowList() {
		BackendService service = new BackendService();
		dates = service.getEventsDates();	
		events = service.getAllMovieEvents();
		filteredEvents = new ArrayList<MovieEvent>(events);
		
		genreList = service.getGenreList();
	}

	public String selectEvent(MovieEvent movieEvent, MovieEventDetail detail, EventDateTime dateTime){
		setSelectedMovie(movieEvent.getMovie());
		setSelectedDetail(detail);
		setSelectedEventDateTime(dateTime);	
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

	public void valueChangeMethod(AjaxBehaviorEvent event){
		System.out.println("valueChangeMethod: " + getSelectedGenre());
		
		filteredEvents = new ArrayList<MovieEvent>(events);
		for (int i = filteredEvents.size() - 1; i >= 0; i--) {
			System.out.println("for Schlaufe... " + filteredEvents.size());
			MovieEvent movieEvent = filteredEvents.get(i);
			
			//GenreType selectedGenre = GenreType.ACTION;
			Optional<Genre> genre = genreList.stream().filter(x -> x.getId() == selectedGenre).findFirst();
			if(genre.isPresent()){
				System.out.println("Genre: " + genre.get().getDescription());

				boolean hasGenere = false;
				List<Genre> genreList = movieEvent.getMovie().getGenreList();
				for(Genre x : genreList){
					if(x.getId() == genre.get().getId()){
						hasGenere = true;
					}
					System.out.println("Has this Genre... " + x.getDescription());
				}
				
				System.out.println("ContainGenere: " + movieEvent.getMovie().getGenreList().contains(genre.get()));
				
				if (hasGenere == false) {
					System.out.println("Remove" + movieEvent.getMovie().getTitle());
					filteredEvents.remove(i);
					continue;
				}
			}
			
			List<MovieEventDetail> details = movieEvent.getDetails();
			for(MovieEventDetail detail : details){
				System.out.println("Language... " + detail.getLanguage());
			}
			
//			for (int d = details.size() - 1; d >= 0; d--) {
//				MovieEventDetail detail = details.get(i);
//				System.out.println("Language... " + detail.getLanguage());
//			}
			
//			if (!movieEvent.getDetails().getLanguage().getLongText()
//					.contains(sucheLanguage.getValue().toString())) {
//				filteredEvents.remove(i);
//				continue;
//			}
		}
	}
	
	public List<Genre> getGenreList() {
		return genreList;
	}

	public void setGenreList(List<Genre> genreList) {
		this.genreList = genreList;
	}
	
	public int getSelectedGenre() {
		return selectedGenre;
	}

	public void setSelectedGenre(int selectedGenre) {
		this.selectedGenre = selectedGenre;
		System.out.println("setSelectedGenre: " + selectedGenre);
	}
}
