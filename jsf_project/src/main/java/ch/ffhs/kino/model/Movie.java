package ch.ffhs.kino.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;

public class Movie {

	private UUID id = UUID.randomUUID();
	private MovieLanguage originalLanguage = MovieLanguage.NONE;
	private MovieLanguage subtitle = MovieLanguage.NONE;
	private String regie;
	private List<String> actors = new ArrayList<String>();
	private String title;
	private List<GenreType> genre;
	private String desc;
	private String movieImage;
	private int altersfreigabe;
	private String altersfreigabeImage;
	private int laengeMin;
	private String webseite;
	private double criticStars;
	private String trailer;

	public String getActorsAsString() {
		return StringUtils.join(getActors(), ", ");
	}

	public String getGenreText() {
		return StringUtils.join(this.genre, ", ");
	}
	
	public Movie addActors(String actor) {
		getActors().add(actor);
		return this;
	}
	
	@Override
	public String toString() {
		return "Movie [id=" + id + ", originalLanguage=" + originalLanguage + ", regie=" + regie + ", actors=" + actors
				+ ", title=" + title + ", genre=" + genre + ", desc=" + desc + ", imageRessource=" + movieImage
				+ ", altersfreigabe=" + altersfreigabe + ", laengeMin=" + laengeMin + ", webseite=" + webseite
				+ ", criticsStar=" + criticStars + ", trailer=" + trailer + "]";
	}
	
	// #### getters and setters ####
	public MovieLanguage getOriginalLanguage() {
		return originalLanguage;
	}

	public void setOriginalLanguage(MovieLanguage originalLanguage) {
		this.originalLanguage = originalLanguage;
	}

	public MovieLanguage getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(MovieLanguage subtitle) {
		this.subtitle = subtitle;
	}

	public String getRegie() {
		return regie;
	}

	public void setRegie(String regie) {
		this.regie = regie;
	}

	public List<String> getActors() {
		if (this.actors == null)
			this.actors = new ArrayList<String>();
		return actors;
	}

	public void setActors(List<String> actors) {
		this.actors = actors;
	}

	public String getTrailer() {
		return trailer;
	}

	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}

	public double getCriticStars() {
		return criticStars;
	}

	public void setCriticStars(double criticStars) {
		this.criticStars = criticStars;
	}

	public String getWebseite() {
		return webseite;
	}

	public void setWebseite(String webseite) {
		this.webseite = webseite;
	}

	public int getLaengeMin() {
		return laengeMin;
	}

	public void setLaengeMin(int laengeMin) {
		this.laengeMin = laengeMin;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
		
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getAltersfreigabe() {
		return altersfreigabe;
	}

	public void setAltersfreigabe(int altersfreigabe) {
		this.altersfreigabe = altersfreigabe;
	}

	public String getMovieImage() {
		return movieImage;
	}

	public void setMovieImage(String movieImage) {
		this.movieImage = movieImage;
	}
	
	public void setGenre(GenreType... genreTypes) {
		this.genre = Arrays.asList(genreTypes);
	}
	
	public List<GenreType> getGenre(){
		return this.genre;
	}

	public String getAltersfreigabeImage() {
		return altersfreigabeImage;
	}

	public void setAltersfreigabeImage(String altersfreigabeImage) {
		this.altersfreigabeImage = altersfreigabeImage;
	}
}
