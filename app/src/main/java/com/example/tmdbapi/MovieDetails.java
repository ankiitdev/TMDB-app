package com.example.tmdbapi;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class MovieDetails extends AppCompatActivity {

    ImageView movie_poster;
    TextView movie_title, movie_release, movie_overview;

    private String IMG_BASEURL = "http://image.tmdb.org/t/p/w500";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        movie_title = findViewById(R.id.movie_title);
        movie_release = findViewById(R.id.movie_releasedate);
        movie_overview = findViewById(R.id.movie_overview);
        movie_poster = findViewById(R.id.movie_poster);

        Intent intent = getIntent();
        String mName = intent.getStringExtra("NAME");
        String mrelease = intent.getStringExtra("RELEASEDATE");
        String moverv = intent.getStringExtra("OVERVIEW");
        String posterpath = intent.getStringExtra("POSTER");
        String backdrop = intent.getStringExtra("BACKDROP");

        Picasso.get().load(IMG_BASEURL+backdrop).into(movie_poster);
        movie_title.setText(mName);
        //mrelease.setText(release);
        //movie_release.setText(mrelease);
        movie_overview.setText(moverv);
        Toast.makeText(this, ""+backdrop, Toast.LENGTH_SHORT).show();
    }
}
