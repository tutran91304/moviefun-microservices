package org.superbiz.moviefun.moviesapi;

import java.io.Serializable;

public class MovieInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String director;
    private String title;
    private Integer year;
    private String genre;
    private Integer rating;

    public MovieInfo() {
    }


    public MovieInfo( String title, String director, String genre, int rating, int year) {
        this(null, title, director, genre, rating, year);
    }

    public MovieInfo(Long id, String title, String director, String genre, int rating, int year) {
        this.id = id;
        this.director = director;
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
