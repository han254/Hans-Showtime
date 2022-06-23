package com.moringaschool.hanshowtime.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class movieModels implements Parcelable {

    private String title;
    private String poster_path;
    private String released_date;
    private int movie_id;
    private String vote_average;
    private String movie_overView;

    public movieModels(String title, String poster_path, String released_date, int movie_id, String vote_average, String movie_overView) {
        this.title = title;
        this.poster_path = poster_path;
        this.released_date = released_date;
        this.movie_id = movie_id;
        this.vote_average = vote_average;
        this.movie_overView = movie_overView;
    }

    protected movieModels(Parcel in) {
        title = in.readString();
        poster_path = in.readString();
        released_date = in.readString();
        movie_id = in.readInt();
        vote_average = in.readString();
        movie_overView = in.readString();
    }

    public static final Creator<movieModels> CREATOR = new Creator<movieModels>() {
        @Override
        public movieModels createFromParcel(Parcel in) {
            return new movieModels(in);
        }

        @Override
        public movieModels[] newArray(int size) {
            return new movieModels[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public String getReleased_date() {
        return released_date;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public String getVote_average() {
        return vote_average;
    }

    public String getMovie_overView() {
        return movie_overView;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(poster_path);
        dest.writeString(released_date);
        dest.writeInt(movie_id);
        dest.writeString(vote_average);
        dest.writeString(movie_overView);
    }
}
