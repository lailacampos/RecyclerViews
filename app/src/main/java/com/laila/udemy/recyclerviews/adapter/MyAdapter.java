package com.laila.udemy.recyclerviews.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.laila.udemy.recyclerviews.R;
import com.laila.udemy.recyclerviews.model.Movie;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<Movie> movieList;

    public MyAdapter() {}

    public MyAdapter(List<Movie> movieList){
        this.movieList = movieList;
    }

    // This method is called right when the adapter is created and is used to initialize the ViewHolder(s).
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // Inflates a layout from XML and returns the holder
        // parent.getContext() is the context that each component of the list is in
        View itemList = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_list, parent, false);

        return new MyViewHolder(itemList);
    }

    // This method is called for each ViewHolder to bind it to the adapter.
    // This is where the data will be passed to the ViewHolder.

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Movie movie = movieList.get(position);
        holder.title.setText(movie.getMovieTitle());
        holder.year.setText(movie.getMovieYear());
        holder.genre.setText(movie.getMovieGenre());

    }

    // This method returns an Integer which represents the view type.
    // Returns the amount of exhibited items
    // Will call onBindViewHolder as many times as it's needed
    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title, year, genre;

        // A view holder is the object that represents each item in the collection and is used to display it.
        // Useful answer -> https://stackoverflow.com/a/45534343/11627241
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            // It's itemView that accesses the view object
            this.title = itemView.findViewById(R.id.title_textView);
            this.year = itemView.findViewById(R.id.year_textView);
            this.genre = itemView.findViewById(R.id.genre_textView);
        }
    }

}
