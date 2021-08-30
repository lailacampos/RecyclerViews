package com.laila.udemy.recyclerviews.model;

public class Movie {

    private String movieTitle, movieGenre, movieYear;

    //region Getters and Setters
    //region Getters
    public String getMovieTitle() {
        return this.movieTitle;
    }

    public String getMovieGenre() {
        return this.movieGenre;
    }

    public String getMovieYear() {
        return this.movieYear;
    }
    //endregion

    //region Setters
    public void setMovieTitle(String newTitle) {
        this.movieTitle = newTitle;
    }

    public void setMovieGenre(String newGenre) {
        this.movieGenre = newGenre;
    }

    public void setMovieYear(String newYear) {
        this.movieYear = newYear;
    }
    //endregion
    //endregion

    //region Constructors

    public Movie() {}

    public Movie(String title, String genre, String year) {
        this.movieTitle = title;
        this.movieGenre = genre;
        this.movieYear = year;
    }
    //endregion

}
