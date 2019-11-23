package com.example.tmdbapi;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.squareup.picasso.Picasso;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder> {

    private List<MoviesModel> movies;
    private int rowLayout;
    private Context context;
    private String IMAGE_BASE_URL = "http://image.tmdb.org/t/p/w500";
    //private OnItemClickListener
    private OnItemClickListener mListener;


    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    public List<MoviesModel> getMovies() {
        return movies;
    }

    public void setMovies(List<MoviesModel> movies) {
        this.movies = movies;
    }

    public int getRowLayout() {
        return rowLayout;
    }

    public void setRowLayout(int rowLayout) {
        this.rowLayout = rowLayout;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public MoviesAdapter(List<MoviesModel> movies, int rowLayout, Context context) {
        this.setContext(context);
        this.setRowLayout(rowLayout);
        this.setMovies(movies);
    }

    @NonNull
    @Override
    public MoviesAdapter.MoviesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(rowLayout, viewGroup, false);
        return new MoviesViewHolder(view,mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesAdapter.MoviesViewHolder moviesViewHolder, int i) {

        moviesViewHolder.movie_title.setText(movies.get(i).getTitle());
        moviesViewHolder.movie_releasedate.setText(movies.get(i).getRelease_date());
        moviesViewHolder.movie_runtime.setText(movies.get(i).getRuntime());

        Picasso.get().load(IMAGE_BASE_URL + movies.get(i).getPoster_path())
                .into(moviesViewHolder.movie_poster);


    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public static class MoviesViewHolder extends RecyclerView.ViewHolder {

        LinearLayout moviesLayout;
        TextView movie_title;
        TextView movie_releasedate;
        TextView movie_runtime;
        ImageView movie_poster;

        //private OnItemClickListener itemClickListener;


        public MoviesViewHolder(@NonNull View itemView, final OnItemClickListener listener ) {
            super(itemView);

            moviesLayout = itemView.findViewById(R.id.movie_card);
            movie_title = itemView.findViewById(R.id.movie_title);
            movie_releasedate = itemView.findViewById(R.id.movie_releasedate);
            movie_runtime = itemView.findViewById(R.id.movie_runtime);
            movie_poster = itemView.findViewById(R.id.poster);
            //movie_overview = itemView.findViewById(R.id.movie_overview);
            // poster = itemView.findViewById(R.id.poster);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                  if (listener!= null){
                      int position = getAdapterPosition();
                      if(position != RecyclerView.NO_POSITION){
                          listener.onItemClick(position);
                      }
                  }
                }
            });

        }
    }
}
