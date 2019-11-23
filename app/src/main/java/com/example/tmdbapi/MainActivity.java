package com.example.tmdbapi;

import android.app.ProgressDialog;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements MoviesAdapter.OnItemClickListener {

    RecyclerView movies_recycler_view;
    List<MoviesModel> moviesData = new ArrayList<>();
    MoviesAdapter myAdapter;
    private static final String LANGUAGE = "en-US";
    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movies_recycler_view = findViewById(R.id.movies_recycler_view);
        movies_recycler_view.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = new MoviesAdapter(moviesData, R.layout.list_item_movies, getApplicationContext());

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        movies_recycler_view.setAdapter(myAdapter);
        myAdapter.setOnItemClickListener(MainActivity.this);
        loadMovies();
    }

    public void loadMovies() {
        progressDialog.show();
        THdbApiEndPoint apiService = ApiClient.getClient().create(THdbApiEndPoint.class);
        Call<Movies> call = apiService.getPopularMovies("7b8620769d7b7e2395718ee8abbd200d", LANGUAGE, 1);

        call.enqueue(new Callback<Movies>() {
            @Override
            public void onResponse(Call<Movies> call, Response<Movies> response) {

                progressDialog.dismiss();
                moviesData.clear();
                moviesData.addAll(response.body().getMoviesModel());
                myAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<Movies> call, Throwable t) {

                Toast.makeText(MainActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();

            }
        });
    }

    @Override
    public void onItemClick(int position) {
        Intent detailIntent = new Intent(MainActivity.this,MovieDetails.class);
        MoviesModel moviesModel = moviesData.get(position);

        detailIntent.putExtra("NAME",moviesModel.getTitle());
        detailIntent.putExtra("RELEASEDATE",moviesModel.getRelease_date());
        detailIntent.putExtra("OVERVIEW",moviesModel.getOverview());
        detailIntent.putExtra("POSTER",moviesModel.getPoster_path());
        detailIntent.putExtra("BACKDROP",moviesModel.getBackdrop());


        startActivity(detailIntent);
    }
}
