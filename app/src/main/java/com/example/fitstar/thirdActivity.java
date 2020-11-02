package com.example.fitstar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class thirdActivity extends AppCompatActivity {
    String sore;
    TextView soreView;
    String workout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        Bundle bd = getIntent().getExtras();
        workout = (String) bd.get("item");
        soreView= findViewById(R.id.soreView);
        read();
       //DatabaseReference reference= FirebaseDatabase.getInstance().getReference().child(workout);
       /*reference.addValueEventListener(new ValueEventListener() {
           @Override
           public void onDataChange(@NonNull DataSnapshot snapshot) {
               soreView.setText(snapshot.getValue().toString());

           }

           @Override
           public void onCancelled(@NonNull DatabaseError error) {

           }
       });*/
    }
    public void read()
    {
        FirebaseDatabase database= FirebaseDatabase.getInstance();
        DatabaseReference reference= database.getReference().child(workout);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                sore= snapshot.getValue().toString();
                Toast.makeText(thirdActivity.this,sore, Toast.LENGTH_LONG).show();
                soreView.setText(sore);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.d("brbuh", "database error");

            }
        });

    }

}