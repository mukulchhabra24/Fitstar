package com.example.fitstar;

import android.util.Log;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_WORLD_WRITEABLE;

public abstract class globalVariables {
    public static List<Float> r= new ArrayList<>();
    public static List<Integer> previous_workouts=new ArrayList<>();



}
