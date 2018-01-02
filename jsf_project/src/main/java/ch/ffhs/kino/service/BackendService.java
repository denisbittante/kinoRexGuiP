package ch.ffhs.kino.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import ch.ffhs.kino.model.EventDateTime;
import ch.ffhs.kino.model.GenreType;
import ch.ffhs.kino.model.Movie;
import ch.ffhs.kino.model.MovieEvent;
import ch.ffhs.kino.model.MovieEventDetail;
import ch.ffhs.kino.model.MovieLanguage;

public class BackendService {

	private static final String IMAGE_PATH = "/resources/images/kino/%s";
	private static final String FSK_PATH = "/resources/images/kino/FSK_ab_%s.png";
	
	private Movie movie1 = new Movie();
	private Movie movie2 = new Movie();
	private Movie movie3 = new Movie();
	private Movie movie4 = new Movie();
	private Movie movie5 = new Movie();
	private Movie movie6 = new Movie();
	
	public BackendService(){
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
		MovieEvent event = new MovieEvent();
		event.setMovie(movie1);
		events.add(event);
		
		MovieEventDetail detail = new MovieEventDetail();	
		detail.setLanguage(MovieLanguage.DEUTSCH);
		detail.setHall("Saal 1");	
		event.getDetails().add(detail);
		
		EventDateTime showTime = new EventDateTime();
		showTime.setShowDate(LocalDate.now());
		showTime.setShowTime(LocalTime.parse("18:30"));
		detail.getEventDateTimes().add(showTime);
		
		showTime = new EventDateTime();
		showTime.setShowDate(LocalDate.now().plusDays(1));
		showTime.setShowTime(LocalTime.parse("16:00"));
		detail.getEventDateTimes().add(showTime);
		
		showTime = new EventDateTime();
		showTime.setShowDate(LocalDate.now().plusDays(2));
		showTime.setShowTime(LocalTime.parse("19:30"));
		detail.getEventDateTimes().add(showTime);		
		//---------------
		MovieEventDetail detail2 = new MovieEventDetail();	
		detail2.setLanguage(MovieLanguage.ENGLISH);
		detail2.setHall("Saal 1");
		event.getDetails().add(detail2);
		
		EventDateTime showTime2 = new EventDateTime();
		showTime2.setShowDate(LocalDate.now());
		showTime2.setShowTime(LocalTime.parse("22:45"));
		detail2.getEventDateTimes().add(showTime2);

		// 2. Film
		event = new MovieEvent();
		event.setMovie(movie2);
		events.add(event);
		
		detail = new MovieEventDetail();	
		detail.setLanguage(MovieLanguage.ENGLISH);
		detail.setHall("Saal 2");	
		event.getDetails().add(detail);
		
		showTime = new EventDateTime();
		showTime.setShowDate(LocalDate.now());
		showTime.setShowTime(LocalTime.parse("19:30"));
		detail.getEventDateTimes().add(showTime);
		
		showTime = new EventDateTime();
		showTime.setShowDate(LocalDate.now().plusDays(1));
		showTime.setShowTime(LocalTime.parse("18:00"));
		detail.getEventDateTimes().add(showTime);
		
		showTime = new EventDateTime();
		showTime.setShowDate(LocalDate.now().plusDays(2));
		showTime.setShowTime(LocalTime.parse("19:30"));
		detail.getEventDateTimes().add(showTime);
		
		showTime = new EventDateTime();
		showTime.setShowDate(LocalDate.now().plusDays(3));
		showTime.setShowTime(LocalTime.parse("17:30"));
		detail.getEventDateTimes().add(showTime);
		
		showTime = new EventDateTime();
		showTime.setShowDate(LocalDate.now().plusDays(4));
		showTime.setShowTime(LocalTime.parse("18:00"));
		detail.getEventDateTimes().add(showTime);
		
		showTime = new EventDateTime();
		showTime.setShowDate(LocalDate.now().plusDays(5));
		showTime.setShowTime(LocalTime.parse("18:30"));
		detail.getEventDateTimes().add(showTime);
		
		showTime = new EventDateTime();
		showTime.setShowDate(LocalDate.now().plusDays(6));
		showTime.setShowTime(LocalTime.parse("18:30"));
		detail.getEventDateTimes().add(showTime);
		//---------------------------------------------
		detail2 = new MovieEventDetail();	
		detail2.setLanguage(MovieLanguage.ENGLISH);
		detail2.setHall("Saal 2");
		event.getDetails().add(detail2);
		
		showTime2 = new EventDateTime();
		showTime2.setShowDate(LocalDate.now());
		showTime2.setShowTime(LocalTime.parse("23:45"));
		detail2.getEventDateTimes().add(showTime2);
		
		showTime2 = new EventDateTime();
		showTime2.setShowDate(LocalDate.now().plusDays(1));
		showTime2.setShowTime(LocalTime.parse("22:30"));
		detail2.getEventDateTimes().add(showTime2);
		
		showTime2 = new EventDateTime();
		showTime2.setShowDate(LocalDate.now().plusDays(2));
		showTime2.setShowTime(LocalTime.parse("23:30"));
		detail2.getEventDateTimes().add(showTime2);
		
		showTime2 = new EventDateTime();
		showTime2.setShowDate(LocalDate.now().plusDays(3));
		showTime2.setShowTime(LocalTime.parse("22:15"));
		detail2.getEventDateTimes().add(showTime2);
		
		showTime2 = new EventDateTime();
		showTime2.setShowDate(LocalDate.now().plusDays(4));
		showTime2.setShowTime(LocalTime.parse("22:15"));
		detail2.getEventDateTimes().add(showTime2);
		
		showTime2 = new EventDateTime();
		showTime2.setShowDate(LocalDate.now().plusDays(5));
		showTime2.setShowTime(LocalTime.parse("22:15"));
		detail2.getEventDateTimes().add(showTime2);
		
		showTime2 = new EventDateTime();
		showTime2.setShowDate(LocalDate.now().plusDays(6));
		showTime2.setShowTime(LocalTime.parse("22:15"));
		detail2.getEventDateTimes().add(showTime2);
		
		// 3. Film
		event = new MovieEvent();
		event.setMovie(movie3);
		events.add(event);
		
		detail = new MovieEventDetail();	
		detail.setLanguage(MovieLanguage.DEUTSCH);
		detail.setHall("Saal 3");	
		event.getDetails().add(detail);
		
		showTime = new EventDateTime();
		showTime.setShowDate(LocalDate.now());
		showTime.setShowTime(LocalTime.parse("18:30"));
		detail.getEventDateTimes().add(showTime);
		
		showTime = new EventDateTime();
		showTime.setShowDate(LocalDate.now().plusDays(1));
		showTime.setShowTime(LocalTime.parse("16:00"));
		detail.getEventDateTimes().add(showTime);
		
		showTime = new EventDateTime();
		showTime.setShowDate(LocalDate.now().plusDays(2));
		showTime.setShowTime(LocalTime.parse("19:30"));
		detail.getEventDateTimes().add(showTime);		
		
		// 4. Film
		event = new MovieEvent();
		event.setMovie(movie4);
		events.add(event);
		
		detail = new MovieEventDetail();	
		detail.setLanguage(MovieLanguage.DEUTSCH);
		detail.setHall("Saal 4");	
		event.getDetails().add(detail);
		
		showTime = new EventDateTime();
		showTime.setShowDate(LocalDate.now());
		showTime.setShowTime(LocalTime.parse("18:30"));
		detail.getEventDateTimes().add(showTime);
		
		showTime = new EventDateTime();
		showTime.setShowDate(LocalDate.now().plusDays(1));
		showTime.setShowTime(LocalTime.parse("16:00"));
		detail.getEventDateTimes().add(showTime);
		
		showTime = new EventDateTime();
		showTime.setShowDate(LocalDate.now().plusDays(2));
		showTime.setShowTime(LocalTime.parse("19:30"));
		detail.getEventDateTimes().add(showTime);	
		
		// 5. Film
		event = new MovieEvent();
		event.setMovie(movie5);
		events.add(event);
		
		detail = new MovieEventDetail();	
		detail.setLanguage(MovieLanguage.DEUTSCH);
		detail.setHall("Saal 5");	
		event.getDetails().add(detail);
		
		showTime = new EventDateTime();
		showTime.setShowDate(LocalDate.now());
		showTime.setShowTime(LocalTime.parse("18:30"));
		detail.getEventDateTimes().add(showTime);
		
		showTime = new EventDateTime();
		showTime.setShowDate(LocalDate.now().plusDays(1));
		showTime.setShowTime(LocalTime.parse("16:00"));
		detail.getEventDateTimes().add(showTime);
		
		showTime = new EventDateTime();
		showTime.setShowDate(LocalDate.now().plusDays(2));
		showTime.setShowTime(LocalTime.parse("19:30"));
		detail.getEventDateTimes().add(showTime);	
		
		// 6. Film
		event = new MovieEvent();
		event.setMovie(movie6);
		events.add(event);
		
		detail = new MovieEventDetail();	
		detail.setLanguage(MovieLanguage.DEUTSCH);
		detail.setHall("Saal 6");	
		event.getDetails().add(detail);
		
		showTime = new EventDateTime();
		showTime.setShowDate(LocalDate.now());
		showTime.setShowTime(LocalTime.parse("18:30"));
		detail.getEventDateTimes().add(showTime);
		
		showTime = new EventDateTime();
		showTime.setShowDate(LocalDate.now().plusDays(1));
		showTime.setShowTime(LocalTime.parse("16:00"));
		detail.getEventDateTimes().add(showTime);
		
		showTime = new EventDateTime();
		showTime.setShowDate(LocalDate.now().plusDays(2));
		showTime.setShowTime(LocalTime.parse("19:30"));
		detail.getEventDateTimes().add(showTime);	
		
		return events;
	}
		
	private void createMovies(){
		
		movie1.setTitle("Dschungelhelden");
		movie1.setGenre(GenreType.COMEDY, GenreType.ANIMATION);		
		movie1.setDesc("Der grosse weisse Tiger Maurice versucht mit aller Kraft, zusammen mit Freunden den bösen Koala-Bären Igor zu bezwingen, der den ganzen Dschungel ausrotten will. Nach und nach lernen sowohl Maurice als auch Igor, sich ihrer Vergangenheit zu stellen.");
		movie1.setAltersfreigabe(6);
		movie1.setAltersfreigabeImage(String.format(FSK_PATH,6));
		movie1.setLaengeMin(90);
		movie1.setCriticStars(4.3);
		movie1.setOriginalLanguage(MovieLanguage.FRANZOESISCH);
		movie1.setSubtitle(MovieLanguage.DEUTSCH);
		movie1.setMovieImage(String.format(IMAGE_PATH,"movie1.jpg"));
		movie1.setTrailer("http://www.youtube.com/embed/VAB0tvLZtTw?autoplay=1;rel=0;3&amp;autohide=1&amp;showinfo=0");
		movie1.setWebseite("http://www.imdb.com/title/tt6314690/");
		movie1.setRegie("David Alaux");
		movie1.addActors("Pascal Casanova").addActors("Michel Mella").addActors("Laurent Morteau").addActors("Emmanuel Curtil");
		
		movie2.setTitle("Star Wars: Die letzten Jedi");
		movie2.setGenre(GenreType.ACTION, GenreType.FANTASY, GenreType.SCIENCE_FICTION);
		movie2.setDesc("Während sich die Mitglieder der Resistenz wie Finn (John Boyega) und Poe (Oscar Isaac) unter der Führung von General Leia (Carrie Fisher) mit der First Order Kämpfe bis zum bitteren Tod liefern, erhofft sich Rey (Daisy Ridley) von Luke Skywalker (Mark Hamill), den sie auf einer einsamen Insel aufgespürt hat, Jedi Training zu bekommen: Die achte Episode der Star Wars-Saga ist ein überraschendes Spektakel, das nicht nur die Fans voll auf die Kosten kommen lässt.");
		movie2.setAltersfreigabe(12);
		movie2.setAltersfreigabeImage(String.format(FSK_PATH,12));
		movie2.setLaengeMin(152);
		movie2.setTrailer("http://www.youtube.com/embed/cKjfEGvZrBQ?autoplay=1;rel=0;3&amp;autohide=1&amp;showinfo=0");
		movie2.setWebseite("http://www.imdb.com/title/tt2527336/");
		movie2.setCriticStars(4.9);
		movie2.setOriginalLanguage(MovieLanguage.ENGLISH);
		movie2.setSubtitle(MovieLanguage.DEUTSCH);
		movie2.setMovieImage(String.format(IMAGE_PATH,"movie2.jpg"));
		movie2.setRegie("Rian Johnson");
		movie2.addActors("Tom Hardy").addActors("Dave Bautista").addActors("Edward James Olmos").addActors("Harrison Ford");

		// Ferdinand – Geht STIERisch ab
		movie3.setTitle("Ferdinand – Geht STIERisch ab");
		movie3.setGenre(GenreType.ABENTEUER, GenreType.ANIMATION, GenreType.COMEDY);
		movie3.setDesc("Durch eine Verkettung unglücklicher Umstände wird der sanftmütige Stier Ferdinand plötzlich für eine wilde Bestie gehalten und findet sich unvermittelt auf der Farm wieder, von der er einst Reißaus genommen hat. Dort begegnet er nicht nur der redseligen Ziege Elvira, sondern auch seinem alten Widersacher Valiente. Basierend auf einem Kinderbuch aus dem Jahr 1936, legen die Macher der Ice Age-Saga eine inhaltlich einfach gestrickte, manchmal etwas beliebig wirkende Animationskomödie vor, die allerdings mit einem liebenswerten Protagonisten, einer schönen Botschaft und einem aufregenden Finale punkten kann.");
		movie3.setAltersfreigabe(0);
		movie3.setAltersfreigabeImage(String.format(FSK_PATH,0));
		movie3.setLaengeMin(107);
		movie3.setTrailer("http://www.youtube.com/embed/SDcH1f4XsSU?autoplay=1;rel=0;3&amp;autohide=1&amp;showinfo=0");
		movie3.setWebseite("http://www.imdb.com/title/tt3411444/");
		movie3.setCriticStars(3.0);
		movie3.setOriginalLanguage(MovieLanguage.ENGLISH);
		movie3.setSubtitle(MovieLanguage.DEUTSCH);
		movie3.setMovieImage(String.format(IMAGE_PATH,"movie3.jpg"));
		movie3.setRegie("Carlos Saldanha");
		movie3.addActors("John Cena").addActors("Kate McKinnon").addActors("Bobby Cannavale").addActors("Gina Rodriguez");
		
		movie4.setTitle("Mord im Orient Express");
		movie4.setGenre(GenreType.CRIMINAL, GenreType.DRAMA, GenreType.MISTRERY);
		movie4.setDesc("Nach einigen anstrengenden Fällen freut sich Hercule Poirot (Kenneth Brannagh) auf drei ruhige Tage im Orient Express. Doch an Erholung ist nicht zu denken: Der Zug wird von einer Lawine aufgehalten und der Passagier Ratchett (Johnny Depp) ermordet in seinem Abteil aufgefunden. Der exzentrische Detektiv nimmt sich dem Fall an, denn der Mörder muss sich noch unter den anwesenden Passagieren befinden. Hauptdarsteller und Regisseur Kenneth Brannagh liefert mit der Neuinterpretation des Agatha Christie-Klassikers einen subtil-spannenden Krimi ab, der zwar seine Längen hat, dafür aber mit einem hochgradig überzeugenden Darsteller-Ensemble auftritt. ");
		movie4.setAltersfreigabe(12);
		movie4.setAltersfreigabeImage(String.format(FSK_PATH,12));
		movie4.setLaengeMin(114);
		movie4.setTrailer("http://www.youtube.com/embed/lA_S-FX2v44?autoplay=1;rel=0;3&amp;autohide=1&amp;showinfo=0");
		movie4.setWebseite("http://www.imdb.com/title/tt3402236/");
		movie4.setCriticStars(4.0);
		movie4.setOriginalLanguage(MovieLanguage.ENGLISH);
		movie4.setSubtitle(MovieLanguage.DEUTSCH);
		movie4.setMovieImage(String.format(IMAGE_PATH,"movie4.jpg"));
		movie4.setRegie("Kenneth Branagh");
		movie4.addActors("Johnny Depp").addActors("Michelle Pfeiffer").addActors("Penélope Cruz").addActors("Willem Dafoe");
				
		// Fack ju Göhte 3
		movie5.setTitle("Fack ju Göhte 3");
		movie5.setGenre(GenreType.COMEDY);
		movie5.setDesc("Homo Faber, Kurvendiskussion, Asbest in den Toiletten. An der Goethe-Gesamtschule herrscht Stress: Zeki Müller (Elyas M'Barek) will Chantal (Jella Haase), Danger (Max von der Groeben), Zeynep (Gizem Emre) und die anderen Schüler zum Abitur peitschen, doch die Chaosklasse ist wenig kooperativ, denn die nette Dame vom Berufsinformationszentrum (BiZ) hat ihnen die Zukunftsaussichten ordentlich vermiest. Nun erreicht das Frustrationslevel ganz neue Höhen, was sich in maximaler Leistungsverweigerung und Schülereskalation äussert. Kann Herr Müller auch Motivation? Direktorin Gudrun Gerster (Katja Riemann) jedenfalls ist keine grosse Hilfe, seit sie mit dem Bildungsministerium im Clinch liegt und als letzte Gesamtschule des Bundeslandes mit Imageproblemen zu kämpfen hat, an denen die Problemschüler nicht ganz unschuldig sind. Wenigstens bekommt Zeki Müller Unterstützung von Neuzugang Biggi Enzberger (Sandra Hüller), die ihm bei einem Antimobbing-Seminar aushilft.");
		movie5.setAltersfreigabe(12);
		movie5.setAltersfreigabeImage(String.format(FSK_PATH,12));
		movie5.setLaengeMin(120);
		movie5.setTrailer("http://www.youtube.com/embed/WRXAhLyzbyE?autoplay=1;rel=0;3&amp;autohide=1&amp;showinfo=0");
		movie5.setWebseite("http://www.imdb.com/title/tt6471264/");
		movie5.setCriticStars(3.0);
		movie5.setOriginalLanguage(MovieLanguage.ENGLISH);
		movie5.setSubtitle(MovieLanguage.DEUTSCH);
		movie5.setMovieImage(String.format(IMAGE_PATH,"movie5.jpg"));
		movie5.setRegie("Bora Dagtekin");
		movie5.addActors("Corinna Harfouch").addActors("Elyas M'Barek").addActors("Jana Pallaske").addActors("Jella Haase");
		
		// Insidious: The Last Key
		movie6.setTitle("Insidious: The Last Key");
		movie6.setGenre(GenreType.HORROR, GenreType.MISTRERY, GenreType.THRILLER);
		movie6.setDesc("Wie bereits Insidious: Chapter 3 erzählt der vierte Teil die Vorgeschichte der ersten beiden Filme. Im Mittelpunkt steht erneut die Parapsychologin Dr. Elise Rainier (Lin Shaye), die sich diesmal einer besonders perfiden Herausforderung stellen muss: Den Horror dort zu bekämpfen, wo ihr einst selbst unglaublicher Schrecken widerfahren ist - in ihrem eigenen Familienhaus!");
		movie6.setAltersfreigabe(16);
		movie6.setAltersfreigabeImage(String.format(FSK_PATH,16));
		movie6.setLaengeMin(103);
		movie6.setTrailer("http://www.youtube.com/embed/lke1IvMKirI?autoplay=1;rel=0;3&amp;autohide=1&amp;showinfo=0");
		movie6.setWebseite("http://www.imdb.com/title/tt5726086/");
		movie6.setCriticStars(3.0);
		movie6.setOriginalLanguage(MovieLanguage.ENGLISH);
		movie6.setSubtitle(MovieLanguage.DEUTSCH);
		movie6.setMovieImage(String.format(IMAGE_PATH,"movie6.jpg"));
		movie6.setRegie("Adam Robitel");
		movie6.addActors("Lin Shaye").addActors("Leigh Whannell").addActors("Angus Sampson").addActors("Javier Botet");
	}
}
