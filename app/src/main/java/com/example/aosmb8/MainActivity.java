package com.example.aosmb8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            String filename = "specstor";
            File file = new File(this.getFilesDir(), filename);
            Log.d(filename, String.valueOf(file.createNewFile()));
            file.delete();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        try {
            String filename = "exstor";
            File file = new File(Environment.getExternalStorageDirectory(), filename);
            Log.d(filename, String.valueOf(file.createNewFile()));
            file.delete();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}