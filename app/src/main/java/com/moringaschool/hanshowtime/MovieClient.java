package com.moringaschool.hanshowtime;


import static com.moringaschool.hanshowtime.constants.TMDB_API_KEY;
import static com.moringaschool.hanshowtime.constants.BASE_URL;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieClient {


    private static Retrofit retrofit = null;


    public static movieApi getClient() {

        if (retrofit == null) {
            OkHttpClient okHttpClient = new OkHttpClient.Builder() //OkHttpClient intercepts each request and adds an HTTP Authorization header with token
                    .addInterceptor(new Interceptor() {
                        @Override
                        public Response intercept(Chain chain) throws IOException {
                            Request newRequest  = chain.request().newBuilder()
                                    .addHeader("Authorization", TMDB_API_KEY)
                                    .build();
                            return chain.proceed(newRequest);
                        }
                    })
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL) //appended to the endpoints we defined in the interface class
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create()) //converter handles data serialization from JSON to Java objects
                    .build();
        }

        return retrofit.create(movieApi.class);
    }
}