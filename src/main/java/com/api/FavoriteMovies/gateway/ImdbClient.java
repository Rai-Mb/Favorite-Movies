package com.api.FavoriteMovies.gateway;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import com.api.FavoriteMovies.dto.ImdbFindByIdResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;

import org.springframework.http.HttpMethod;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class ImdbClient {

    private final WebClient webClient;
    private final String IMDB_SECRET_KEY = "K_4W5MK4YT";
    
    public ImdbClient(WebClient.Builder builder) {
        webClient = builder
        .baseUrl("https://imdb-api.com/en/API/")
        .build();
    }

    public Mono<ImdbResponse> findImdbByTitle(String title){
        log.info("Buscando o filme com o title[{}]", title);
        return this.webClient
                .method(HttpMethod.GET)
                .uri("SearchMovie/" + IMDB_SECRET_KEY + "/" + title)
                .accept(APPLICATION_JSON)
                .exchangeToMono(response -> response.bodyToMono(ImdbResponse.class));
    }

    public Mono<ImdbFindByIdResponse> findImdbById(String id){
        log.info("Buscando o filme com o id[{}]", id);
        return this.webClient
                .get()
                .uri("Title/" + IMDB_SECRET_KEY + "/" + id)
                .accept(APPLICATION_JSON)
                .retrieve().bodyToMono(ImdbFindByIdResponse.class);
    }

    
}
