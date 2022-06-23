package com.moringaschool.hanshowtime.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.moringaschool.hanshowtime.Models.movieModels;
import com.moringaschool.hanshowtime.MovieApi;
import com.moringaschool.hanshowtime.R;
import com.moringaschool.hanshowtime.Response.movieSearchResponse;
import com.moringaschool.hanshowtime.Servicey;
import com.moringaschool.hanshowtime.constants;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieListActivity extends AppCompatActivity {

    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        btn = findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GetRetrofitResponse();
            }
        });

    }

    private void GetRetrofitResponse() {
        MovieApi movieApi = Servicey.getMovieAPi();
    Call<movieSearchResponse> responseCall =movieApi
            .searchMovie(
                    constants.API_KEY,
                    "Jack Reacher",
                    "1"
                    );

responseCall.enqueue(new Callback<movieSearchResponse>() {
    @Override
    public void onResponse(Call<movieSearchResponse> call, Response<movieSearchResponse> response) {
        if(response.code() == 200){
            Log.v("Tag", "the response" + response.body().toString());

            List<movieModels> movies = new ArrayList<>(response.body().getMovies());
            for(movieModels movie: movies){
                Log.v("Tag", "The release date" + movie.getReleased_date());
            }
        }
        else{
            try {
                Log.v("Tag","Error" + response.errorBody().string());
            } catch (IOException e){
                e.printStackTrace();
            }
        }



    }

    @Override
    public void onFailure(Call<movieSearchResponse> call, Throwable t) {

    }
});






    }
}