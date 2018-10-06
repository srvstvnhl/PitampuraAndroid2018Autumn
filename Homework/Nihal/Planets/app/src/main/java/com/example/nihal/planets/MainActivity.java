package com.example.nihal.planets;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ArrayList<Object> arrayList = new ArrayList<>();
    Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayList.add(new Planet("Mercury","click here","http://media.istockphoto.com/vectors/the-planet-mercury-vector-illustration-vector-id522334466?k=6&m=522334466&s=612x612&w=0&h=YHhh_to335Nssyc5MD0pgOUg2Ae0y2X4ShcMtpaKNng="));
        arrayList.add(new Planet("Venus","click here","https://pixfeeds.com/images/astronomy/venus/1280-1200-522334442-the-planet-venus.jpg"));
        arrayList.add(new Planet("Earth","click here","http://2.bp.blogspot.com/-2BhpjwNZZGk/T83VB4Om80I/AAAAAAAADtU/rvf6v0oqiPA/s1600/Planet+Earth+1.jpg"));
        arrayList.add(new Planet("Mars","click here","http://www.media-tchat.org/tchat-media/wp-content/uploads/2012/11/mars.jpg"));
        arrayList.add(new Planet("Jupiter","click here","https://pixfeeds.com/images/astronomy/jupiter/1280-1200-522334568-the-planet-jupiter.jpg"));
        arrayList.add(new Planet("Saturn","click here","http://descopera.truezone.ro/wp-content/uploads/2014/05/Saturn.png"));
        arrayList.add(new Planet("Uranus","click here","https://pixfeeds.com/images/topic/5474/1200-5474-planet-uranus-photo2.jpg"));
        arrayList.add(new Planet("Neptune","click here","https://static.independent.co.uk/s3fs-public/styles/article_small/public/thumbnails/image/2017/05/11/17/neptune.jpg"));
        arrayList.add(new Planet("Pluto","click here","http://media.istockphoto.com/vectors/the-planet-pluto-vector-illustration-vector-id522334258?k=6&m=522334258&s=612x612&w=0&h=d4ly2QErI-tmugXtU53B8B2weOiyc01R__mj_MmQDDU="));

        /*ctx=getApplication();*/
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        PlanetAdapter planetAdapter = new PlanetAdapter(arrayList, ctx); /*new PlanetAdapter.onItemClickListener() */
      /*      @Override
            public void onItemClick(int position) {
                Toast.makeText(MainActivity.this,"hduhjcdbckjxbcn",Toast.LENGTH_LONG).show();

                Intent intent = new Intent(MainActivity.this,PlanetDetail.class);

                startActivity(intent);
            }
        });
*/
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(planetAdapter);

    }
}
