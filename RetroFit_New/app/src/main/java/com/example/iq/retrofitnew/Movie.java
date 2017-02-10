package com.example.iq.retrofitnew;

/**
 * Created by iQ on 2/10/2017.
 */

public class Movie {
    private int movieId;
    private String name;
    private String price;
    private int inStock;

    public int getMovieId() {
        return movieId;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public int getInStock() {
        return inStock;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setInStock(int inStock) {
        this.inStock = inStock;
    }
}
