package com.moringaschool.hanshowtime;

import com.moringaschool.hanshowtime.models.TMDBSearchMoviesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface movieApi {
    @GET("search/movie")
    Call<TMDBSearchMoviesResponse> getMovies(
            @Query("api_key") String api_key,
            @Query("query") String query,
            @Query("page") Integer page
    );

    @GET("search/tv")
    Call<TMDBSearchMoviesResponse> getTvShows(
            @Query("api_key") String api_key,
            @Query("query") String query,
            @Query("page") Integer page
    );

    @GET("movie/{movie_id}")
    Call<TMDBSearchMoviesResponse> getMoviesDetail(
            @Path("movie_id") int movie_id,
            @Query("api_key") String api_key
    );
    @GET("movie/popular")
    Call<TMDBSearchMoviesResponse> getPopularMovies(
            @Query("api_key") String api_key
    );




}
