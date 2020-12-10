package com.example.fitstar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
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
        getSupportActionBar().hide();

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);




        items= new ArrayList<>();
        items.add("Bicep curls");
        items.add("Bench Press");
        items.add("Rowing");
        items.add("Leg Press");
        items.add("Deadlift");
        items.add("Cable Reverse Fly");
        items.add("Leg Curl");
        items.add("Squats");
        items.add("Dips");
        items.add("Shoulder Press");
        items.add("Cable Fly");
        items.add("Dumbbell Press");
        items.add("Lateral Raises");
        items.add("Hammer Curl");
        items.add("Lunges");
        items.add("Pushups");
        items.add("Calf Raises");
        items.add("Hip Thrusts");
        items.add("Glute Kickbacks");
        items.add("Sit ups");
        items.add("Crunches");
        items.add("Plank");
        items.add("Chin Ups");



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