package com.api.FavoriteMovies.gateway;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Result implements Serializable {

public String id;
public String resultType;
public String image;
public String title;
public String description;    
    
}
