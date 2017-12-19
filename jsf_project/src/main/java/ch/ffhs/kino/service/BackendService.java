package ch.ffhs.kino.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import ch.ffhs.kino.model.EventDateTime;
import ch.ffhs.kino.model.Genre;
import ch.ffhs.kino.model.GenreType;
import ch.ffhs.kino.model.Movie;
import ch.ffhs.kino.model.MovieEvent;
import ch.ffhs.kino.model.MovieEventDetail;
import ch.ffhs.kino.model.MovieLanguage;

public class BackendService {

	private static final String IMAGE_PATH = "/resources/images/kino/%s";
	
	private Movie movie1 = new Movie();
	private Movie movie2 = new Movie();
	private Movie movie3 = new Movie();
	private List<Genre> genreList;
	
	public BackendService(){
		LoadGenre();
	}
	
	public List<LocalDate> getEventsDates(){
		List<LocalDate> dates = new ArrayList<LocalDate>();
		dates.add(LocalDate.now());
		dates.add(LocalDate.now().plusDays(1));
		dates.add(LocalDate.now().plusDays(2));
		dates.add(LocalDate.now().plusDays(3));
		dates.add(LocalDate.now().plusDays(4));
		dates.add(LocalDate.now().plusDays(5));
		dates.add(LocalDate.now().plusDays(6));
		
		return dates;		
	}
	
	public List<MovieEvent> getAllMovieEvents(){
		createMovies();
		
		List<MovieEvent> events = new ArrayList<MovieEvent>();
		
		// 1. Film Dschungelhelden
		MovieEvent event1 = new MovieEvent();
		event1.setMovie(movie1);
		events.add(event1);
		
		MovieEventDetail detail1 = new MovieEventDetail();	
		detail1.setLanguage(MovieLanguage.DEUTSCH);
		detail1.setHall("1");	
		event1.getDetails().add(detail1);
		
		EventDateTime showTime1 = new EventDateTime();
		showTime1.setShowDate(LocalDate.now());
		showTime1.setShowTime(LocalTime.parse("18:30"));
		detail1.getEventDateTimes().add(showTime1);
		
		EventDateTime showTime2 = new EventDateTime();
		showTime2.setShowDate(LocalDate.now().plusDays(1));
		showTime2.setShowTime(LocalTime.parse("16:00"));
		detail1.getEventDateTimes().add(showTime2);
		
		EventDateTime showTime3 = new EventDateTime();
		showTime3.setShowDate(LocalDate.now().plusDays(2));
		showTime3.setShowTime(LocalTime.parse("19:30"));
		detail1.getEventDateTimes().add(showTime3);		
		
		MovieEventDetail detail2 = new MovieEventDetail();	
		detail2.setLanguage(MovieLanguage.ENGLISH);
		detail2.setHall("1");
		event1.getDetails().add(detail2);
		
		EventDateTime showTime1b = new EventDateTime();
		showTime1b.setShowDate(LocalDate.now());
		showTime1b.setShowTime(LocalTime.parse("22:45"));
		detail2.getEventDateTimes().add(showTime1b);

		// 2. Film
		MovieEvent event2 = new MovieEvent();
		event2.setMovie(movie2);
		events.add(event2);
		
		MovieEventDetail detail3 = new MovieEventDetail();
		detail3.setLanguage(MovieLanguage.DEUTSCH);
		detail3.setHall("1");	
		event2.getDetails().add(detail3);
		
		return events;
	}
	
	private List<Genre> LoadGenre(){
		genreList = new ArrayList<Genre>();
		genreList.add(new Genre(0, ""));
		genreList.add(new Genre(1, "Drama"));
		genreList.add(new Genre(2, "Action"));
		genreList.add(new Genre(3, "Komödie"));
		genreList.add(new Genre(4, "Mystery"));
		genreList.add(new Genre(5, "Thriller"));
		genreList.add(new Genre(6, "Krimi"));
		genreList.add(new Genre(7, "Horror"));
		genreList.add(new Genre(8, "Science Fiction"));
		genreList.add(new Genre(9, "Trickfilm"));
		return genreList;
	}
	
	private void createMovies(){
		
		movie1.setTitle("Dschungelhelden");
		movie1.addGenre(new Genre(1, "Komödie"));
		movie1.addGenre(new Genre(9, "Trickfilm"));
		movie1.setDesc("Der grosse weisse Tiger Maurice versucht mit aller Kraft, zusammen mit Freunden den bösen Koala-Bären Igor zu bezwingen, der den ganzen Dschungel ausrotten will. Nach und nach lernen sowohl Maurice als auch Igor, sich ihrer Vergangenheit zu stellen.");
		movie1.setAltersfreigabe(6);
		movie1.setLaengeMin(90);
		movie1.setCriticStars(4.3);
		movie1.setOriginalLanguage(MovieLanguage.FRANZOESISCH);
		movie1.setMovieImage(String.format(IMAGE_PATH,"movie1.jpg"));
		System.out.println(movie1.getMovieImage());
		String codemov1 = "VAB0tvLZtTw";
		String urlmovie1 = "http://www.youtube.com/embed/" + codemov1 + "?rel=0;3&amp;autohide=1&amp;showinfo=0";
		movie1.setTrailer(urlmovie1);
		movie1.setWebseite("http://www.imdb.com/title/tt6314690/");
		movie1.setRegie("David Alaux");
		movie1.addActors("Pascal Casanova").addActors("Michel Mella").addActors("Laurent Morteau").addActors("Emmanuel Curtil");
		

		movie2.setTitle("Barry Seal - Only in America");
		movie2.addGenre(new Genre(2, "Action"));
		movie2.addGenre(new Genre(5, "Thriller"));
//		movie2.setGenre(GenreType.ACTION, GenreType.COMEDY, GenreType.DRAMA, GenreType.THRILLER);
		movie2.setDesc("Einige Waisenkinder finden ein Zuhause bei einem Puppenmacher. Schon bald geraten sie ins Visier einer seiner Kreationen.");
		//movie2.setImageRessource(String.format(imgPath, "4"));
		movie2.setAltersfreigabe(14);
		movie2.setLaengeMin(90);
		movie2.setCriticStars(3.1);
		String codemov2 = "SiV3XA-sC8k";
		String urlmovie2 = "http://www.youtube.com/embed/" + codemov2 + "?rel=0;3&amp;autohide=1&amp;showinfo=0";
		movie2.setTrailer(urlmovie2);
		
		// Blade Runner 2049
		movie3.setTitle("Blade Runner 2049");
		movie3.addGenre(new Genre(8, "Science Fiction"));
		movie3.addGenre(new Genre(5, "Thriller"));
		movie3.setDesc("30 Jahre nach dem ersten Film f�rdert ein neuer Blade Runner ein lange unter Verschluss gehaltenes Geheimnis zu Tage.");
		//movie3.setImageRessource(String.format(imgPath, "23"));
		movie3.setAltersfreigabe(12);
		movie3.setLaengeMin(163);
		final String code = "gCcx85zbxz4";
		String url = "http://www.youtube.com/embed/" + code + "?rel=0;3&amp;autohide=1&amp;showinfo=0";
		movie3.setTrailer(url);
		movie3.setWebseite("http://www.imdb.com/title/tt1856101/");
		movie3.setCriticStars(4.3);
		movie3.setOriginalLanguage(MovieLanguage.ENGLISH);
		movie3.setSubtitle(MovieLanguage.FRANZOESISCH);
		movie3.setRegie("Denis Vileneuve");
		movie3.addActors("Ana de Armas").addActors("Dave Bautista").addActors("Edward James Olmos").addActors("Harrison Ford");
	}
	
	public void setGenreList(List<Genre> genreList){
		this.genreList = genreList;
	}
	
	public List<Genre> getGenreList(){
		return this.genreList;
	}
}
