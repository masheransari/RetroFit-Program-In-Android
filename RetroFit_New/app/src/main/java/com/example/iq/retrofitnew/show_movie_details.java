package com.example.iq.retrofitnew;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class show_movie_details extends AppCompatActivity {

    private TextView textViewMovieId, textViewMovieName,textViewMoviePrice,textViewInStock;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_movie_details);

        textViewMovieId = (TextView)findViewById(R.id.textViewMovieID);
        textViewMovieName = (TextView)findViewById(R.id.textViewMovieName);
        textViewMoviePrice =(TextView)findViewById(R.id.textViewMoviePrice);
        textViewInStock = (TextView)findViewById(R.id.textViewMovieInStock);

        Intent i = getIntent();

        textViewMovieId.setText(String.valueOf(i.getIntExtra(MainActivity.KEY_MOVIE_ID, 0)));
        textViewMovieName.setText(String.valueOf(i.getStringExtra(MainActivity.KEY_MOVIE_NAME)));
        textViewMoviePrice.setText(String.valueOf(i.getStringExtra(MainActivity.KEY_MOVIE_PRICE)));
        textViewMoviePrice.setText(String.valueOf(i.getStringExtra(MainActivity.KEY_MOVIE_STOCK)));
    }
}
