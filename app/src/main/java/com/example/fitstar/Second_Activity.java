package com.example.fitstar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
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

        final itemsAdapter itemsAdapter = new itemsAdapter(this, items);
        recyclerView1.setAdapter(itemsAdapter);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this));
     /*   recyclerView1.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
                Intent i = new Intent(Second_Activity.this, thirdActivity.class);
                i.putExtra("item",itemsAdapter.getItem());
                startActivity(i);
                return false;
            }

            @Override
            public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {


            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });*/

    }
}