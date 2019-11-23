package com.example.tmdbapi;

import com.google.gson.annotations.SerializedName;

public class MoviesModel {

    @SerializedName("original_title")
    private String title;

    @SerializedName("overview")
    private String overview;

    @SerializedName("release_date")
    private String release_date;

    @SerializedName("vote_average")
    private String runtime;

    @SerializedName("poster_path")
    private String poster_path;

    @SerializedName("backdrop_path")
    private String backdrop;


    public MoviesModel(String title, String overview, String release_date, String runtime, String poster_path, String backdrop){

        this.setOverview(overview);
        this.setTitle(title);
        this.setRelease_date(release_date);
        this.setPoster_path(poster_path);
        this.setRuntime(runtime);
        this.setBackdrop(backdrop);

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getBackdrop() { return backdrop; }
    public void setBackdrop(String backdrop) { this.backdrop = backdrop; }
}
