package com.api.FavoriteMovies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.FavoriteMovies.model.MoviesModel;

import java.util.UUID;

@Repository
public interface MoviesRepository extends JpaRepository <MoviesModel, UUID> {


    
}
