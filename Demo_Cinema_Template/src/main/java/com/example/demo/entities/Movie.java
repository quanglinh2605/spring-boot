
package com.example.demo.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Movie {

    @SerializedName("movieId")
    @Expose
    private String movieId;
    @SerializedName("movieName")
    @Expose
    private String movieName;
    @SerializedName("movieDescription")
    @Expose
    private String movieDescription;
    @SerializedName("movieTrailer")
    @Expose
    private String movieTrailer;
    @SerializedName("movieCens")
    @Expose
    private String movieCens;
    @SerializedName("movieLength")
    @Expose
    private String movieLength;
    @SerializedName("movieFormat")
    @Expose
    private String movieFormat;
    @SerializedName("moviePoster")
    @Expose
    private String moviePoster;

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
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
