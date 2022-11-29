package com.api.FavoriteMovies.service;


import com.api.FavoriteMovies.model.MoviesModel;
import com.api.FavoriteMovies.repository.MoviesRepository;

import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
import java.util.List;

@Service
public class MoviesService {
    
    final MoviesRepository moviesRepository;

    public MoviesService(MoviesRepository moviesRepository){
        this.moviesRepository = moviesRepository;
    }

    @Transactional
    public MoviesModel save(MoviesModel moviesModel){
        return moviesRepository.save(moviesModel);
    }

    public List<MoviesModel> findAll(){
        return moviesRepository.findAll();
    }

    public Optional<MoviesModel> findById(UUID id){
        return moviesRepository.findById(id);
    }

}
