package com.api.FavoriteMovies.gateway;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;


@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ImdbResponse {

public String searchType;
public String expression;
public List<Result> results;
public String errorMessage;    
    
}
