package ch.ffhs.kino.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ch.ffhs.kino.model.GenreType;
import ch.ffhs.kino.model.Movie;
import ch.ffhs.kino.model.MovieEvent;
import ch.ffhs.kino.model.MovieLanguage;

@ManagedBean(name = "movieEventController")
@SessionScoped
public class MovieEventController {

	private Movie movie1 = new Movie();
	private Movie movie2 = new Movie();
	private Movie movie3 = new Movie();
	private List<MovieEvent> events = new ArrayList<MovieEvent>();
	
	@PostConstruct
	public void populateShowList() {
		
		movie1.setTitle("Hereinspaziert");
		movie1.setGenre(GenreType.COMEDY);
		movie1.setDesc("Die neunk�pfige Romafamilie im Garten des Linksintellektuellen Jean-Etienne stellt seine �berzeugungen auf die Probe.");
		//movie1.setImageRessource(String.format(imgPath, "20"));
		movie1.setAltersfreigabe("12J");
		String codemov1 = "bw1TdXyXT8Y";
		String urlmovie1 = "http://www.youtube.com/embed/" + codemov1 + "?rel=0;3&amp;autohide=1&amp;showinfo=0";
		movie1.setTrailer(urlmovie1);
		
		movie2.setTitle("Barry Seal - Only in America");
		movie2.setGenre(GenreType.ACTION, GenreType.COMEDY, GenreType.DRAMA, GenreType.THRILLER);
		movie2.setDesc("Einige Waisenkinder finden ein Zuhause bei einem Puppenmacher. Schon bald geraten sie ins Visier einer seiner Kreationen.");
		//movie2.setImageRessource(String.format(imgPath, "4"));
		movie2.setAltersfreigabe("14/12J");
		String codemov2 = "SiV3XA-sC8k";
		String urlmovie2 = "http://www.youtube.com/embed/" + codemov2 + "?rel=0;3&amp;autohide=1&amp;showinfo=0";
		movie2.setTrailer(urlmovie2);
		
		// Blade Runner 2049
		movie3.setTitle("Blade Runner 2049");
		movie3.setGenre(GenreType.SCIENCE_FICTION, GenreType.THRILLER);
		movie3.setDesc("30 Jahre nach dem ersten Film f�rdert ein neuer Blade Runner ein lange unter Verschluss gehaltenes Geheimnis zu Tage.");
		//movie3.setImageRessource(String.format(imgPath, "23"));
		movie3.setAltersfreigabe("12");
		movie3.setLaengeMin(163);
		final String code = "gCcx85zbxz4";
		String url = "http://www.youtube.com/embed/" + code + "?rel=0;3&amp;autohide=1&amp;showinfo=0";
		movie3.setTrailer(url);
		movie3.setWebseite("http://www.imdb.com/title/tt1856101/");
		movie3.setCriticsStar(4.3);
		movie3.setOriginalLanguage(MovieLanguage.ENGLISH);
		movie3.setSubtitle(MovieLanguage.FRANZOESISCH);
		movie3.setRegie("Denis Vileneuve");
		movie3.addActors("Ana de Armas").addActors("Dave Bautista").addActors("Edward James Olmos").addActors("Harrison Ford");
		
		MovieEvent event1 = new MovieEvent();
		event1.setMovie(movie1);
		event1.setDate(LocalDate.now());
		event1.setTime(LocalTime.parse("18:30"));	
		event1.setLanguage(MovieLanguage.DEUTSCH);
		event1.setHall("1");	
		events.add(event1);
		
		MovieEvent event2 = new MovieEvent();
		event2.setMovie(movie1);
		event2.setDate(LocalDate.now());
		event2.setTime(LocalTime.parse("22:45"));	
		event2.setLanguage(MovieLanguage.ENGLISH);
		event2.setHall("1");	
		events.add(event2);
		
		MovieEvent event3 = new MovieEvent();
		event3.setMovie(movie2);
		event3.setDate(LocalDate.now());
		event3.setTime(LocalTime.parse("19:30"));	
		event3.setLanguage(MovieLanguage.DEUTSCH);
		event3.setHall("1");	
		events.add(event3);
	}

    // #### getters and setters ####
    public List<MovieEvent> getEvents() {
        return events;
    }

    public void setEvents(List<MovieEvent> events) {
        this.events = events;
    }

}
