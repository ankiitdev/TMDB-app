package com.example.tmdbapi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface THdbApiEndPoint {

    @GET("movie/popular")
    Call<Movies> getPopularMovies(
            @Query("api_key") String apiKey,
            @Query("language") String language,
            @Query("page") int page
    );

}
