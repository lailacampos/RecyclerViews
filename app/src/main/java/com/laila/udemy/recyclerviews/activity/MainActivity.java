package com.laila.udemy.recyclerviews.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.laila.udemy.recyclerviews.R;
import com.laila.udemy.recyclerviews.RecyclerItemClickListener;
import com.laila.udemy.recyclerviews.adapter.MyAdapter;
import com.laila.udemy.recyclerviews.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Movie> movieList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.recyclerView = findViewById(R.id.recyclerView);

        //Fill list of movies
        this.createMovies();

        // Configure adapter
        MyAdapter myAdapter = new MyAdapter(movieList);
        // An adapter is a bridge between UI component and data source that helps to fill data in UI component.

        // Configure RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        this.recyclerView.setLayoutManager(layoutManager);
        this.recyclerView.setHasFixedSize(true);
        this.recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        this.recyclerView.setAdapter(myAdapter);

        // Add click event
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                Movie movie = movieList.get(position);
                                Toast.makeText(
                                        getApplicationContext(),
                                        movie.getMovieTitle() + " pressed",
                                        Toast.LENGTH_SHORT
                                ).show();
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {
                                Movie movie = movieList.get(position);
                                Toast.makeText(
                                        getApplicationContext(),
                                        "Long touched: " + movie.getMovieTitle(),
                                        Toast.LENGTH_SHORT
                                ).show();
                            }

                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                            }
                        }
                )
        );

    }

    public void createMovies() {

        Movie movie = new Movie("Mystic River", "Crime", "2003");
        movieList.add(movie);

        movie = new Movie("Traffic ", "Crime", "2000");
        movieList.add(movie);

        movie = new Movie("L.A. Confidential", "Crime", "1997");
        movieList.add(movie);

        movie = new Movie("Nomadland", "Drama", "2020");
        movieList.add(movie);

        movie = new Movie("Parasite", "Drama", "2019");
        movieList.add(movie);

        movie = new Movie("Green Book", "Comedy/Drama", "2018");
        movieList.add(movie);

        movie = new Movie("The Shape of Water", "Fantasy", "2017");
        movieList.add(movie);

        movie = new Movie("Moonlight", "Drama", "2016");
        movieList.add(movie);

        movie = new Movie("Spotlight", "Crime", "2015");
        movieList.add(movie);

        movie = new Movie("Birdman or (The Unexpected Virtue of Ignorance)", "Comedy/Drama", "2014");
        movieList.add(movie);

        movie = new Movie("12 Years a Slave", "History", "2013");
        movieList.add(movie);

        movie = new Movie("Argo", "Thriller", "2012");
        movieList.add(movie);

        movie = new Movie("The Artist", "Comedy/Drama/Romance", "2011");
        movieList.add(movie);

        movie = new Movie("The King's Speech", "Biography/Drama/History", "2010");
        movieList.add(movie);

        movie = new Movie("Slumdog Millionaire", "Drama/Romance", "2009");
        movieList.add(movie);


    }
}