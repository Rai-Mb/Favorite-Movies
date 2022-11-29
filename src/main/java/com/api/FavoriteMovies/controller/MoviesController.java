package com.api.FavoriteMovies.controller;

import java.util.UUID;
import java.util.List;
import java.util.Optional;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.FavoriteMovies.dto.ImdbFindByIdResponse;
import com.api.FavoriteMovies.dto.MoviesDto;
import com.api.FavoriteMovies.gateway.ImdbClient;
import com.api.FavoriteMovies.gateway.ImdbResponse;
import com.api.FavoriteMovies.gateway.MoviesAdpter;
import com.api.FavoriteMovies.model.MoviesModel;
import com.api.FavoriteMovies.service.MoviesService;

import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "*",  maxAge = 3600)
@RequestMapping("/favoriteMovies")
public class MoviesController {

    final MoviesService moviesService;
    final ImdbClient ImdbClient;

    public MoviesController(MoviesService moviesService, ImdbClient imdbClient) {
        this.moviesService = moviesService;
        this.ImdbClient = imdbClient;
    }

    @PostMapping
    public ResponseEntity<Object> saveMovies(@RequestBody @Valid MoviesDto moviesDto) {
        //pegar o titulo no body da requisição

        //integrar com o primeiro endpoint passando o titulo e pegar o movieId do imdb para chamar o segundo
        ImdbResponse imdbListFilmesResponse = ImdbClient.findImdbByTitle(moviesDto.getTitle()).block();
        System.out.println(imdbListFilmesResponse.results.get(0).id);
        String id = imdbListFilmesResponse.results.get(0).id;
        // integrar com o segundo endpoint para pegar as informações relevantes (imdbRating, runtimeMins, genres)

        ImdbFindByIdResponse imdbFilmesResponseById = ImdbClient.findImdbById(id).block();
        System.out.println(imdbFilmesResponseById);
        // montar um Objeto Movie com as informações (Title, imdRating, runtimeMins, genres)
        MoviesDto moviesInsert = new MoviesDto();
        moviesInsert.setTitle(imdbFilmesResponseById.getTitle());
        moviesInsert.setRunTimeMins(Integer.parseInt(imdbFilmesResponseById.getRuntimeMins()));
        moviesInsert.setGenres(imdbFilmesResponseById.getGenres());
        moviesInsert.setImdbRating(Double.parseDouble(imdbFilmesResponseById.getImDbRating()));
        System.out.println(moviesInsert);

        var saveMovies = moviesService.save(MoviesAdpter.convert(moviesInsert) );
        System.out.println(saveMovies);

        // salvar esse objeto no banco de dados postgres
        return ResponseEntity.status(HttpStatus.CREATED).body("Criado com sucesso!");

        // retornar 201 created com o filme criado no banco de dados
        // return ResponseEntity.status(HttpStatus.OK).body(imdbListFilmesResponse /*imdbFilmesResponseById.block)*/); //("Criado com sucesso!");
    }
    


@GetMapping("https://imdb-api.com/en/API/SearchMovie/k-4w5mk4yt/{title}")
public Mono<ImdbResponse> getImdbByTitle(@PathVariable(value = "title") String title){
    return ImdbClient.findImdbByTitle(title);

    /*@GetMapping("https://imdb-api.com/en/API/SearchMovie/k_4w5mk4yt/{id}")
    public Mono<ImdbResponse> getImdbById(@PathVariable String id){
        return imdbClient.findImdbById(id);
    }*/
}
    @GetMapping
    public ResponseEntity<List<MoviesModel>> getAllMovies(){
        return ResponseEntity.status(HttpStatus.OK).body(moviesService.findAll());
    }
    @GetMapping("/{id}")
    ResponseEntity <Object> getOneMovies(@PathVariable(value = "id")UUID id){
        Optional <MoviesModel> moviesModelOptional = moviesService.findById(id);
        if(!moviesModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Filme " + id + " não existe.");
        }
            return ResponseEntity.status(HttpStatus.OK).body(moviesModelOptional.get());
    }

}