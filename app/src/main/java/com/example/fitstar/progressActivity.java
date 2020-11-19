package com.example.fitstar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
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
                loadPrevWorkouts();
                previous_workouts.add((int) progress);

                saveWorkout();
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
    public File getDataFile()
    {
        return new File(getFilesDir(), "data.txt");
    }
    public void loadPrevWorkouts() {
        try {
            previous_workouts.clear();
            List<String> s = new ArrayList<>(FileUtils.readLines(getDataFile(), Charset.defaultCharset()));
            for(String i: s)
            {
                previous_workouts.add((Integer.parseInt(i)));
            }
        } catch (Exception ex) {
            Log.e("MainActivity", "Error reading Items", ex);
            previous_workouts= new ArrayList<>();
        }
    }
    public void saveWorkout()
    {
        try {
            FileUtils.writeLines(getDataFile(),previous_workouts);
        } catch (IOException e) {
            Log.e("MainActivity", "Error writing Items", e);
        }
    }
}