
package com.moringaschool.hanshowtime.models;


import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.moringaschool.hanshowtime.models.Genre;

import org.parceler.Parcel;

@Parcel
public class GenreResponse {

    @SerializedName("genres")
    @Expose
    private List<Genre> genres = null;

    /**
     * No args constructor for use in serialization
     */
    public GenreResponse() {
    }

    /**
     * @param genres
     */
    public GenreResponse(List<Genre> genres) {
        super();
        this.genres = genres;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }
}
