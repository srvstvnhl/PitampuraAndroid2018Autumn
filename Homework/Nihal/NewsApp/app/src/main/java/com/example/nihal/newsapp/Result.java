package com.example.nihal.newsapp;

import java.util.ArrayList;

public class Result {

    private String status;
    private Integer totalResults;
    private ArrayList<Articles> articlesArrayList;

    public Result(String status, Integer totalResults, ArrayList<Articles> articlesArrayList) {
        this.status = status;
        this.totalResults = totalResults;
        this.articlesArrayList = articlesArrayList;
    }

    public String getStatus() {
        return status;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public ArrayList<Articles> getArticlesArrayList() {
        return articlesArrayList;
    }
}
