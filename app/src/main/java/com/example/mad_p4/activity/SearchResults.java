package com.example.mad_p4.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.mad_p4.R;
import com.example.mad_p4.recycler.RecyclerViewAdapter;

import java.util.ArrayList;

public class SearchResults extends AppCompatActivity {

    RecyclerView list;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(RecyclerView.VERTICAL);

        list = findViewById(R.id.jokeList);
        list.setLayoutManager(manager);


        Intent info = getIntent();
        ArrayList<String> data = info.getStringArrayListExtra("data");

        list.setAdapter(
                new RecyclerViewAdapter(data)
        );

    }
}
