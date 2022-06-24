package com.moringaschool.hanshowtime.models;


import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class TvshowsResponse {

    @SerializedName("page")
    @Expose
    private Integer page;
    @SerializedName("resultsTv")
    @Expose
    private List<ResultsTv> resultsTv = null;
    @SerializedName("total_pages")
    @Expose
    private Integer totalPages;
    @SerializedName("total_results")
    @Expose
    private Integer totalResults;

    /**
     * No args constructor for use in serialization
     *
     */
    public TvshowsResponse() {
    }

    /**
     *
     * @param totalResults
     * @param resultsTv
     * @param totalPages
     * @param page
     */
    public TvshowsResponse(Integer page, List<ResultsTv> resultsTv, Integer totalPages, Integer totalResults) {
        super();
        this.page = page;
        this.resultsTv = resultsTv;
        this.totalPages = totalPages;
        this.totalResults = totalResults;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public List<ResultsTv> getResultsTv() {
        return resultsTv;
    }

    public void setResultsTv(List<ResultsTv> resultsTv) {
        this.resultsTv = resultsTv;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

}