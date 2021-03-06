package com.codingblocks.decouplingadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity implements Communicator {

    ArrayList<SuperHero> superHeroes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        superHeroes.add(new SuperHero("Batman", "DC", "Rich"));
        superHeroes.add(new SuperHero("Superman", "DC", "Superhuman abilities"));
        superHeroes.add(new SuperHero("Captain America", "Marvel", "American"));
        superHeroes.add(new SuperHero("Ironman", "Marvel", "Rich"));
        superHeroes.add(new SuperHero("Green Lantern", "DC", "Magic Ring"));
        superHeroes.add(new SuperHero("Black Widow", "Marvel", "Agent"));
        superHeroes.add(new SuperHero("Shazam", "DC", "God's man"));
        superHeroes.add(new SuperHero("Hulk", "Marvel", "Smash"));
        superHeroes.add(new SuperHero("Batman", "DC", "Rich"));
        superHeroes.add(new SuperHero("Superman", "DC", "Superhuman abilities"));
        superHeroes.add(new SuperHero("Captain America", "Marvel", "American"));
        superHeroes.add(new SuperHero("Ironman", "Marvel", "Rich"));
        superHeroes.add(new SuperHero("Green Lantern", "DC", "Magic Ring"));
        superHeroes.add(new SuperHero("Black Widow", "Marvel", "Agent"));
        superHeroes.add(new SuperHero("Shazam", "DC", "God's man"));
        superHeroes.add(new SuperHero("Hulk", "Marvel", "Smash"));

        RecyclerView recyclerView = findViewById(R.id.rvDetail);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        SuperheroAdapter superheroAdapter = new SuperheroAdapter(superHeroes,this);

        recyclerView.setAdapter(superheroAdapter);

    }

//    void log(SuperHero superHero){
//        Log.e("TAG", "log: " + superHero.getName());
//    }

    @Override
    public void peformAction(SuperHero superHero) {
        Log.e("TAG", "log: " + superHero.getName());
    }
}
