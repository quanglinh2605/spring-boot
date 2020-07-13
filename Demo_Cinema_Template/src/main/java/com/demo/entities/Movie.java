package com.demo.entities;

import javax.validation.constraints.NotEmpty;

public class Movie{

	private int movieId;
   
	@NotEmpty
	private String movieName;
    
	
	private String movieDescription;
    
	
	private String movieTrailer;
    
	
	private String movieCens;
    
	
	private String movieLength;
    
	
	private String movieFormat;
    
	
	private String moviePoster;

    public Movie() {
    }

    public Movie(String movieName, String movieDescription, String movieTrailer, String movieCens, String movieGenres, String movieRelease, String movieLength, String movieFormat, String moviePoster) {
        this.movieName = movieName;
        this.movieDescription = movieDescription;
        this.movieTrailer = movieTrailer;
        this.movieCens = movieCens;
        this.movieLength = movieLength;
        this.movieFormat = movieFormat;
        this.moviePoster = moviePoster;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieDescription() {
        return movieDescription;
    }

    public void setMovieDescription(String movieDescription) {
        this.movieDescription = movieDescription;
    }

    public String getMovieTrailer() {
        return movieTrailer;
    }

    public void setMovieTrailer(String movieTrailer) {
        this.movieTrailer = movieTrailer;
    }

    public String getMovieCens() {
        return movieCens;
    }

    public void setMovieCens(String movieCens) {
        this.movieCens = movieCens;
    }

   
    public String getMovieLength() {
        return movieLength;
    }

    public void setMovieLength(String movieLength) {
        this.movieLength = movieLength;
    }

    public String getMovieFormat() {
        return movieFormat;
    }

    public void setMovieFormat(String movieFormat) {
        this.movieFormat = movieFormat;
    }

    public String getMoviePoster() {
        return moviePoster;
    }

    public void setMoviePoster(String moviePoster) {
        this.moviePoster = moviePoster;
    }
}
