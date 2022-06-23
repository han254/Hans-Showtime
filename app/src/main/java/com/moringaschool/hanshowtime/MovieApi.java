package com.moringaschool.hanshowtime;

import com.moringaschool.hanshowtime.Response.movieSearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieApi {

    @GET
    Call<movieSearchResponse>searchMovie(
            @Query("api_key") String key,
            @Query("query") String query,
            @Query("page") String page
            );
}
