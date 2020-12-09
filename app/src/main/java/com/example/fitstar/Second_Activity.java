package com.example.fitstar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.app.ActionBar;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class Second_Activity extends AppCompatActivity {
    List<String> items;
    RecyclerView recyclerView1;
    itemsAdapter itemsAdapter;
    Button btnProgress;
    List<Float> ratings;
    TextView tv1;
    Button btnPrev;
    Button btnSignOut;
    GoogleSignInClient mGoogleSignInClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_);
        recyclerView1= findViewById(R.id.recyclerView1);
        btnProgress=findViewById(R.id.btnProgress);
        tv1=findViewById(R.id.textView1);
        btnPrev=findViewById(R.id.btnPrev);
        btnSignOut= findViewById(R.id.btnSignOut);




        items= new ArrayList<>();
        items.add("Bicep curls");
        items.add("Bench Press");
        items.add("Rowing");
        items.add("Leg Press");
        items.add("Deadlift");
        items.add("Cable Reverse Fly");
        items.add("Leg curls");
        items.add("Squats");



        final itemsAdapter itemsAdapter = new itemsAdapter(this, items);
        recyclerView1.setAdapter(itemsAdapter);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this));

        ratings= new ArrayList<>();


        btnProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(Second_Activity.this, progressActivity.class);
                startActivity(i);
            }
        });
        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(Second_Activity.this, PreviousActivity.class);
                startActivity(i);

            }
        });
        btnSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                signOut();
                Intent i= new Intent(Second_Activity.this, MainActivity.class);
                startActivity(i);


            }
        });

    }
    private void signOut(){
        FirebaseAuth.getInstance().signOut();

        mGoogleSignInClient.signOut()

                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(Second_Activity.this,"Signed out Succesfully", Toast.LENGTH_LONG).show();

                    }
                });
    }
}
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