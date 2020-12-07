package com.example.fitstar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;


import static com.example.fitstar.globalVariables.previous_workouts;

public class PreviousActivity extends AppCompatActivity {
    Button btnClear;
    GraphView graph;
    TextView tvInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previous);

        btnClear = findViewById(R.id.btnDelete);
        graph= (GraphView)findViewById(R.id.graph);
        tvInfo=findViewById(R.id.tvInfo);

        loadPrevWorkouts();
        StringBuilder builder = new StringBuilder();
        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>();
       /* for(int i : previous_workouts)
        {
            builder.append("" + i + " ");
        }*/
       // Toast.makeText(PreviousActivity.this, builder, Toast.LENGTH_LONG).show();
        //tvInfo.setText(builder);
        int x;
        for(int i=0;i<previous_workouts.size();i++)
        {
            x= previous_workouts.get(i);
            series.appendData(new DataPoint(i,x),true,previous_workouts.size());
        }

        graph.addSeries(series);

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                previous_workouts.clear();
                saveWorkout();
                Toast.makeText(PreviousActivity.this, "Data deleted", Toast.LENGTH_LONG).show();
                Intent i= new Intent(PreviousActivity.this, Second_Activity.class);
                startActivity(i);

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
