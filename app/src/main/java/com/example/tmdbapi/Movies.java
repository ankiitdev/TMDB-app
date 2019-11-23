package com.example.tmdbapi;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Movies {

    @SerializedName("results")
    List<MoviesModel> moviesModel;

    public Movies(List<MoviesModel> moviesModel) {
        this.moviesModel = moviesModel;
    }

    public List<MoviesModel> getMoviesModel() {
        return moviesModel;
    }

    public void setMoviesModel(List<MoviesModel> moviesModel) {
        this.moviesModel = moviesModel;
    }
}
