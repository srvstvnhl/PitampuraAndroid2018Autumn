package com.example.nihal.customlistviewnoteapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<TotalItem> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText etItem = findViewById(R.id.etItem);

        ListView lvItem = findViewById(R.id.lvItem);
        final ItemAdapter itemAdapter = new ItemAdapter(arrayList);

        lvItem.setAdapter(itemAdapter);

        Button btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = etItem.getText().toString();

                String time = String.valueOf(System.currentTimeMillis()*0.001);

                TotalItem note = new TotalItem(title,time);

                arrayList.add(note);
                itemAdapter.notifyDataSetChanged();

            }
        });

    }
}
