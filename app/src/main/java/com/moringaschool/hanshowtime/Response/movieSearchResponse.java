package com.moringaschool.hanshowtime.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.moringaschool.hanshowtime.Models.movieModels;

import java.util.List;

public class movieSearchResponse {
    @SerializedName("total_results")
    @Expose()

    private int total_count;


    @SerializedName("results")
    @Expose()

    private List<movieModels> movies;

    public int getTotal_count(){
        return total_count;
    }

    public List<movieModels> getMovies(){
        return movies;
    }

    @Override
    public String toString() {
        return "movieSearchResponse{" +
                "total_count=" + total_count +
                ", movies=" + movies +
                '}';
    }
}
