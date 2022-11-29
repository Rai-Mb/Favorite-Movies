package com.api.FavoriteMovies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class FavoriteMoviesApplication {

	public static void main(String[] args) {
		SpringApplication.run(FavoriteMoviesApplication.class, args);
	}

	@GetMapping("/")
	public String index(){
		return "Bora Bill";
	}
}
