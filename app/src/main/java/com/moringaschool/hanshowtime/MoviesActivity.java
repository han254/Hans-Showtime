package com.moringaschool.hanshowtime;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.TextView;

import com.moringaschool.hanshowtime.models.MoviesDetailsResponse;
import com.moringaschool.hanshowtime.models.Result;
import com.moringaschool.hanshowtime.models.TMDBSearchMoviesResponse;

import java.util.List;

import adapters.MoviesListAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;

public class MoviesActivity extends AppCompatActivity {

    private static final String TAG = MoviesActivity.class.getSimpleName(); // returns the simple name of the underlying class as given in the source code.
    @BindView(R.id.errorTextView) TextView mErrorTextView;
    @BindView(R.id.progressBar) ProgressBar mProgressBar;
    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;
    @BindView(R.id.searchMovies) SearchView mSearchView;
    @BindView(R.id.searchMoviesButton) Button mSearchMoviesButton;

    private MoviesListAdapter mAdapter;

    movieApi tmdbApi;

    public List<Result> results;
    private Result mMovies;
    private MoviesDetailsResponse details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        tmdbApi = MovieClient.getClient();


        mSearchMoviesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retrofit2.Call<TMDBSearchMoviesResponse> call = tmdbApi.getMovies(BuildConfig.TMDB_API_KEY, mSearchView.getQuery().toString(), 1);
                call.enqueue(new retrofit2.Callback<TMDBSearchMoviesResponse>() {
                    @Override
                    public void onResponse(retrofit2.Call<TMDBSearchMoviesResponse> call, retrofit2.Response<TMDBSearchMoviesResponse> response) {

                        hideProgressBar();

                        results = response.body().getResults();
                        mAdapter = new MoviesListAdapter(MoviesActivity.this, results);
                        mRecyclerView.setAdapter(mAdapter);
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MoviesActivity.this);
                        mRecyclerView.setLayoutManager(layoutManager);
                        mRecyclerView.setHasFixedSize(true);

                        showMovies();

                    }

                    @Override
                    public void onFailure(Call<TMDBSearchMoviesResponse> call, Throwable t) {
                        Log.i(TAG, "onFailure: show something ", t);
                        t.printStackTrace();
                        hideProgressBar();
                        showFailureMessage();
                        showUnsuccessfulMessage();

                    }
                });

                call = tmdbApi.getTvShows(BuildConfig.TMDB_API_KEY, mSearchView.getQuery().toString(), 1);
                call.enqueue(new retrofit2.Callback<TMDBSearchMoviesResponse>() {

                    @Override
                    public void onResponse(retrofit2.Call<TMDBSearchMoviesResponse> call, retrofit2.Response<TMDBSearchMoviesResponse> response) {

                        hideProgressBar();

                        results = response.body().getResults();
                        mAdapter = new MoviesListAdapter(MoviesActivity.this, results);
                        mRecyclerView.setAdapter(mAdapter);
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MoviesActivity.this);
                        mRecyclerView.setLayoutManager(layoutManager);
                        mRecyclerView.setHasFixedSize(true);

                        showMovies();

                    }

                    @Override
                    public void onFailure(Call<TMDBSearchMoviesResponse> call, Throwable t) {

                        Log.i(TAG, "onFailure: show something ", t);
                        t.printStackTrace();
                        hideProgressBar();
                        showFailureMessage();
                        showUnsuccessfulMessage();

                    }
                });
            }

            private void showFailureMessage() {
                mErrorTextView.setText("Something went wrong. Please check your Internet connection and try again later");
                mErrorTextView.setVisibility(View.VISIBLE);
            }

            private void showUnsuccessfulMessage() {
                mErrorTextView.setText("Something went wrong. Please try again later");
                mErrorTextView.setVisibility(View.VISIBLE);
            }

            private void showMovies() {
                mRecyclerView.setVisibility(View.VISIBLE);
            }

            private void hideProgressBar() {
                mProgressBar.setVisibility(View.GONE);
            }
        });
    }
}
