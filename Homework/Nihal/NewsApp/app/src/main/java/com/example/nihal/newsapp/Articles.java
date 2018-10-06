package com.example.nihal.newsapp;

public class Articles {


    String title,author,description,url;

    public Articles(String title, String author, String description, String url) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }
}
