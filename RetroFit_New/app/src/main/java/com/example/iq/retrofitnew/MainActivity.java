package com.example.iq.retrofitnew;

import android.app.ProgressDialog;
//import android.graphics.Movie;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity implements ListView.OnItemClickListener{

    public static final String ROOT_URL="http://www.delaroystudios.com/";

    public static final String KEY_MOVIE_ID = "key_movie_id";
    public static final String KEY_MOVIE_NAME = "key_movie_name";
    public static final String KEY_MOVIE_PRICE = "key_movie_price";
    public static final String KEY_MOVIE_STOCK = "key_movie_stock";

    private static String LOG_TAG = "MainActivity";
    private ListView listView;
    private List<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.listViewMovies);

        getMovies();

        listView.setOnItemClickListener(this);

    }

    public void getMovies(){
        final ProgressDialog loading = ProgressDialog.show(this,"Fetching Data","Please Wait....",false,false);

            RestAdapter adapter = new RestAdapter.Builder()
                    .setEndpoint(ROOT_URL)
                    .build();
            MovieAPI  api = adapter.create(MovieAPI.class);

            api.getMovies(new Callback<List<Movie>>(){
                @Override
                public void success(List<Movie> list, Response response){
                    loading.dismiss();

                    movies = list;

                    showList();
                }

                public void failure(RetrofitError error)
                {

                }
            });

    }

    private void showList(){
        String[] items = new String[movies.size()];
        Log.e("MainActivity","items  = "+items.toString());
        for(int i=0; i<movies.size();i++){
            items[i] = movies.get(i).getName();
        }

        ArrayAdapter arrayAdapter = new ArrayAdapter(this,R.layout.simple_list,items);

        listView.setAdapter(arrayAdapter);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position,long id){

        Intent i = new Intent(this, show_movie_details.class);


        Movie movie = movies.get(position);
        Log.e(LOG_TAG,"heres the Movies.get("+position+") = "+movies.get(position));
        i.putExtra(KEY_MOVIE_ID,movie.getMovieId());
        i.putExtra(KEY_MOVIE_NAME,movie.getName());
        i.putExtra(KEY_MOVIE_PRICE,movie.getPrice());
        i.putExtra(KEY_MOVIE_STOCK,movie.getInStock());

        startActivity(i);
    }
}
