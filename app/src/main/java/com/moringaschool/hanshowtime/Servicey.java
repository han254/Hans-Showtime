package com.moringaschool.hanshowtime;

import com.moringaschool.hanshowtime.MovieApi;
import com.moringaschool.hanshowtime.constants;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Servicey {

    private static Retrofit.Builder retrofitBuilder =
            new Retrofit.Builder().baseUrl(constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = retrofitBuilder.build();

    private static MovieApi movieAPi = retrofit.create(MovieApi.class);

    public static MovieApi getMovieAPi() {
        return movieAPi;
    }
}
