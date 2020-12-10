package com.example.fitstar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static com.example.fitstar.globalVariables.r;

public class thirdActivity extends AppCompatActivity {
    String sore;
    TextView soreView;
    String workout;
    RatingBar ratingBar;
    float getRating;
    Button btnRating;
    TextView textView2;
     //List<Float> ratings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        Bundle bd = getIntent().getExtras();
        workout = (String) bd.get("item");
        soreView= findViewById(R.id.soreView);
        ratingBar=findViewById(R.id.ratingBar);
        btnRating=findViewById(R.id.btnRating);
        textView2=findViewById(R.id.TextView2);
        //ratings= new ArrayList<>();
        read();
        btnRating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getRating=ratingBar.getRating();
                r.add(getRating);
                Intent i= new Intent(thirdActivity.this, Second_Activity.class);
                startActivity(i);
                finish();
            }
        });


    }
    public void read()
    {
        FirebaseDatabase database= FirebaseDatabase.getInstance();
        DatabaseReference reference= database.getReference().child(workout);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                sore= snapshot.getValue().toString();
                //Toast.makeText(thirdActivity.this,sore, Toast.LENGTH_LONG).show();
                soreView.setText(sore);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.d("brbuh", "database error");

            }
        });

    }

}