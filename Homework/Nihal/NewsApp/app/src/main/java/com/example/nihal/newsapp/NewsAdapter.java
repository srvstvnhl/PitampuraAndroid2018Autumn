package com.example.nihal.newsapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsHolder> {

    private Context ctx;
    private Result finalResult;

    public NewsAdapter(Context ctx, Result finalResult) {
        this.ctx = ctx;
        this.finalResult = finalResult;
    }

    @NonNull
    @Override
    public NewsHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater li = LayoutInflater.from(ctx);
        View inflatedView = li.inflate(R.layout.item_row, viewGroup, false);

        return new NewsHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsHolder newsHolder, int i) {

        ArrayList<Articles> articlesArrayList = finalResult.getArticlesArrayList();
        Articles currentArticles = articlesArrayList.get(i);
        if (currentArticles != null) {
            newsHolder.title.setText(currentArticles.getTitle());
        } else {
            newsHolder.title.setText("");
        }
        if (currentArticles.getAuthor() != null) {
            newsHolder.author.setText(currentArticles.getAuthor());
        } else {
            newsHolder.author.setText("");
        }
        if (currentArticles.getDescription() != null) {
            newsHolder.content.setText(currentArticles.getDescription());
        } else {
            newsHolder.content.setText("");
        }
        if (currentArticles.getUrl() != null) {
            final String currentLink = currentArticles.getUrl();
            newsHolder.url.setText(currentArticles.getUrl());
            newsHolder.url.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(currentLink));
                    ctx.startActivity(i);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return finalResult.getArticlesArrayList().size();
    }

    class NewsHolder extends RecyclerView.ViewHolder {

        TextView title, author, content, url;

        public NewsHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tvTitle);
            author = itemView.findViewById(R.id.tvAuthor);
            content = itemView.findViewById(R.id.tvContent);
            url = itemView.findViewById(R.id.tvLink);
        }
    }
}
