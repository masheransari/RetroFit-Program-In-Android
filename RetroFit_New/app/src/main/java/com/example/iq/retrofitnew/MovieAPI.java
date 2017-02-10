package com.example.iq.retrofitnew;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by iQ on 2/10/2017.
 */

public interface MovieAPI {

    @GET("/retrofit/movies.json")
    public void getMovies(Callback<List<Movie>> response);
 }
