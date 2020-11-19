package com.example.fitstar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;


import static com.example.fitstar.globalVariables.previous_workouts;

public class PreviousActivity extends AppCompatActivity {
    Button btnClear;
    TextView tvPrev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previous);

        btnClear = findViewById(R.id.btnDelete);
        tvPrev=findViewById(R.id.tvPrev);

        loadPrevWorkouts();
        StringBuilder builder = new StringBuilder();
        for(int i : previous_workouts)
        {
            builder.append("" + i + " ");
        }
       // Toast.makeText(PreviousActivity.this, builder, Toast.LENGTH_LONG).show();
        tvPrev.setText(builder);

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                previous_workouts.clear();
                saveWorkout();
                StringBuilder b = new StringBuilder();
                for(int i : previous_workouts)
                {
                    b.append("" + i + " ");
                }
                tvPrev.setText(b);

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
