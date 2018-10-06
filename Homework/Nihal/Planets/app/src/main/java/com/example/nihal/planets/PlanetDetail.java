package com.example.nihal.planets;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class PlanetDetail extends AppCompatActivity{

    /*Intent i;*/
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        /*i=getIntent();*/

        getIncomingItent();
    }

    private void getIncomingItent(){
        if(getIntent().hasExtra("image_url") && getIntent().hasExtra("image_name")){
            String imageUrl = getIntent().getStringExtra("image_url");
            String imageName = getIntent().getStringExtra("image_name");

            setImage(imageUrl,imageName);
        }
    }
    private void setImage(String imageUrl,String imageName){

        TextView name = findViewById(R.id.tvPlanetNameDetail);
        name.setText(imageName);

        ImageView image = findViewById(R.id.ivPlanetDetail);
        Picasso.get()
                .load(imageUrl)
                .into(image);

    }

}
