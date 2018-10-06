package com.example.nihal.notetakingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> arrayList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ListView lvItem = findViewById(R.id.lvItems);
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(

                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                arrayList
        );

        lvItem.setAdapter(arrayAdapter);

        final Button btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String newItem = ((EditText)findViewById(R.id.etItem)).getText().toString();
                arrayList.add(newItem);

                /*Long tsLong = System.currentTimeMillis()/1000;
                String ts = tsLong.toString();*/

                arrayAdapter.notifyDataSetChanged();



            }

        });


    }
}
