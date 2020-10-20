package com.example.fitstar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Second_Activity extends AppCompatActivity {
    List<String> items;
    RecyclerView recyclerView1;
    itemsAdapter itemsAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_);
        recyclerView1= findViewById(R.id.recyclerView1);

        items= new ArrayList<>();
        items.add("Bicep curls");
        items.add("Bench Press");
        items.add("Rowing");
        items.add("leg press");

        itemsAdapter itemsAdapter = new itemsAdapter(items);
        recyclerView1.setAdapter(itemsAdapter);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this));

    }
}