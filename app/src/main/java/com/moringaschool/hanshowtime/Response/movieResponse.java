package com.moringaschool.hanshowtime.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.moringaschool.hanshowtime.Models.movieModels;

public class movieResponse {
    @SerializedName("results")
    @Expose

    private movieModels movie;

    public movieModels getMovie(){
        return movie;
    }

    @Override
    public String toString() {
        return "movieResponse{" +
                "movie=" + movie +
                '}';
    }
}
