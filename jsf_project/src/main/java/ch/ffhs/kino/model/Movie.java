package ch.ffhs.kino.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class Movie {

	private UUID id = UUID.randomUUID();
	private MovieLanguage originalLanguage = MovieLanguage.NONE;
	private MovieLanguage subtitle = MovieLanguage.NONE;
	private String regie;
	private List<String> actors = new ArrayList<String>();
	private String title;
	private List<GenreType> genre;
	private String desc;
	private String imageRessource;
//	private String altersfreigabe;
	private int altersfreigabe;
	private int laengeMin;
	private String webseite;
	private double criticStars;
	private String trailer;

//	public String getActorsAsString() {
//		return StringUtils.join(getActors(), ", ");
//
//	}

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

	public void setGenre(List<GenreType> genre) {
		this.genre = genre;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

//	public String getGenreText() {
//		return StringUtils.join(this.genre, ", ");
//
//	}

	public void setGenre(GenreType... genreTypes) {
		this.genre = Arrays.asList(genreTypes);
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getImageRessource() {
		return imageRessource;
	}

	public void setImageRessource(String imageRessource) {
		this.imageRessource = imageRessource;
	}

	public int getAltersfreigabe() {
		return altersfreigabe;
	}

	public void setAltersfreigabe(int altersfreigabe) {
		this.altersfreigabe = altersfreigabe;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", originalLanguage=" + originalLanguage + ", regie=" + regie + ", actors=" + actors
				+ ", title=" + title + ", genre=" + genre + ", desc=" + desc + ", imageRessource=" + imageRessource
				+ ", altersfreigabe=" + altersfreigabe + ", laengeMin=" + laengeMin + ", webseite=" + webseite
				+ ", criticsStar=" + criticStars + ", trailer=" + trailer + "]";
	}

	public Movie addActors(String actor) {

		getActors().add(actor);
		return this;
	}
}
