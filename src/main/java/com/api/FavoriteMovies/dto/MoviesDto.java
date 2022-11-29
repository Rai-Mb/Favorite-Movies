package com.api.FavoriteMovies.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class MoviesDto {
    
    @NotBlank
    @Size(max = 30)
    private String title;
    private int runTimeMins;
    private String genres;
    private double imdbRating;
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getRunTimeMins() {
        return runTimeMins;
    }
    public void setRunTimeMins(int runTimeMins) {
        this.runTimeMins = runTimeMins;
    }
    public String getGenres() {
        return genres;
    }
    public void setGenres(String genres) {
        this.genres = genres;
    }
    public double getImdbRating() {
        return imdbRating;
    }
    public void setImdbRating(double imdbRating) {
        this.imdbRating = imdbRating;
    }
    

}
