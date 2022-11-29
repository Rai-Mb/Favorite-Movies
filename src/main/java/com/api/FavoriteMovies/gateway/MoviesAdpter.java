package com.api.FavoriteMovies.gateway;

import com.api.FavoriteMovies.dto.MoviesDto;
import com.api.FavoriteMovies.model.MoviesModel;

public class MoviesAdpter {

    public static MoviesModel convert(MoviesDto moviesDto){
        
        return MoviesModel
        .builder()
        .title(moviesDto.getTitle())
        .runTimeMins(moviesDto.getRunTimeMins())
        .genres(moviesDto.getGenres())
        .imdbRating(moviesDto.getImdbRating())
        .build();
    }
    
}
