package com.example.fitstar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static com.example.fitstar.globalVariables.r;

public class progressActivity extends AppCompatActivity {
    TextView tv2;
    float progress=0.0f;
    ProgressBar Pb;
    TextView tvProg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
        tv2=findViewById(R.id.textView2);
        Pb= findViewById(R.id.progressBar);
        tvProg=findViewById(R.id.tvProgress);

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
}