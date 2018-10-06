package com.example.nihal.newsapp;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    NewsAdapter newsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);


        MyNetworkTask myNetworkTask = new MyNetworkTask();
        myNetworkTask.execute("https://newsapi.org/v2/top-headlines?sources=techcrunch&apiKey=50350542859a48b5ad736d0625e7ebb3");

    }

    public Result convertJsonToResult(String json){

        try {
            JSONObject jsonObject = new JSONObject(json);

            String status =jsonObject.getString("status");
            Integer totalResult = jsonObject.getInt("totalResults");
            JSONArray jsonArray = jsonObject.getJSONArray("articles");

            ArrayList<Articles> articleArrayList=new ArrayList<>();

            for(int i=0;i<jsonArray.length();i++){
                JSONObject articleObject= jsonArray.getJSONObject(i);
                String title=articleObject.getString("title");
                String author=articleObject.getString("author");
                String content=articleObject.getString("description");
                String link=articleObject.getString("url");

                Articles articles=new Articles(title,author,content,link);
                articleArrayList.add(articles);
            }
            Result result=new Result(status,totalResult,articleArrayList);
            return result;

        } catch (JSONException e) {
            e.printStackTrace();
        }


        return null;
    }

    class MyNetworkTask extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... strings) {

            String string = strings[0];

            try {

                URL url = new URL(string);

                HttpsURLConnection httpsURLConnection= (HttpsURLConnection) url.openConnection();

                InputStream inputStream =httpsURLConnection.getInputStream();

                Scanner scanner = new Scanner(inputStream);

                scanner.useDelimiter("\\A");

                String result = "";

                if(scanner.hasNext()){
                    //read the whole content of scanner in one go
                    result=scanner.next();
                }
                return result;


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return "firse kro";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            Result finalResult = convertJsonToResult(s);
            int n = finalResult.getTotalResults();

            if(n>0){
                Toast.makeText(getBaseContext(),"click on link to open news in browser"+finalResult.getStatus(),Toast.LENGTH_SHORT).show();
                newsAdapter=new NewsAdapter(MainActivity.this,finalResult);
                recyclerView.setAdapter(newsAdapter);
            }

        }
    }
}
