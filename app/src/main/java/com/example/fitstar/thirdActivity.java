package com.example.fitstar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class thirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        Bundle bd = getIntent().getExtras();
        String workout = (String) bd.get("item");
        TextView soreView= findViewById(R.id.soreView);
        soreView.setText(workout);
       // DatabaseReference reference= FirebaseDatabase.getInstance().getReference().child()
    }
}