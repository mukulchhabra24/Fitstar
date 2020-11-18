package com.example.fitstar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static com.example.fitstar.globalVariables.previous_workouts;
import static com.example.fitstar.globalVariables.r;

public class progressActivity extends AppCompatActivity {
    TextView tv2;
    float progress=0.0f;
    ProgressBar Pb;
    TextView tvProg;
    List<Integer> prev;
    Button btnClear;
    Button btnSave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
        tv2=findViewById(R.id.textView2);
        Pb= findViewById(R.id.progressBar);
        tvProg=findViewById(R.id.tvProgress);
        btnClear=findViewById(R.id.btnClear);
        btnSave=findViewById(R.id.btnSave);

        float sum=0.0f;
        for(int i=0;i<r.size();i++)
        {
            sum+= r.get(i);
        }
        float avg=sum/(r.size());
        progress=(avg/5)*100;

        Pb.setProgress((int) progress);
        tvProg.setText(Float.toString(progress));

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                previous_workouts.add((int) progress);
                Toast.makeText(progressActivity.this,"Workout Saved", Toast.LENGTH_LONG).show();
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r.clear();
                Toast.makeText(progressActivity.this,"Workout Cleared", Toast.LENGTH_LONG).show();
                float sum=0.0f;
                for(int i=0;i<r.size();i++)
                {
                    sum+= r.get(i);
                }
                float avg=sum/(r.size());
                progress=(avg/5)*100;

                Pb.setProgress((int) progress);
                tvProg.setText(Float.toString(progress));
                
            }
        });



    }
}