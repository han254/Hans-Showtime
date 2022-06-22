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

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public void setReleased_date(String released_date) {
        this.released_date = released_date;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public void setVote_average(String vote_average) {
        this.vote_average = vote_average;
    }

    public void setMovie_overView(String movie_overView) {
        this.movie_overView = movie_overView;
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
