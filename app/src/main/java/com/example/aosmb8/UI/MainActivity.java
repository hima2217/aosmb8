package com.example.aosmb8.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.room.Room;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;

import com.example.aosmb8.data.DoctorDB.DoctorDatabase;
import com.example.aosmb8.data.DoctorDB.Doctor;
import com.example.aosmb8.R;

import java.io.File;
import java.io.IOException;

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
        } catch (IOException e) {
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

        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("secretkey", 22);
        editor.apply();
        Log.d("proverochka", String.valueOf(sharedPref.getInt("secretkey", 22)));


        DoctorVM doctorVM = new ViewModelProvider(this).get(DoctorVM.class);
        doctorVM.getAllDoctor().observe(this, doctors -> {
                        doctors.add(new Doctor("George"));
                        doctors.add(new Doctor("Harry"));
                        doctors.add(new Doctor("Jacob"));
                        doctors.add(new Doctor("Thomas"));

                        Doctor doctor1 = doctors.get(0);
                        Doctor doctor2 = doctors.get(3);
                        Doctor doctor3 = doctors.get(2);
                        Doctor doctor4 = doctors.get(3);

                        Log.i("Doctor_1", doctor1.name);
                        Log.i("Doctor_2", doctor2.name);
                        Log.i("Doctor_3", doctor3.name);
                        Log.i("Doctor_4", doctor4.name);



                }
        );


/*
        DoctorDatabase db = Room.databaseBuilder(getApplicationContext(),
                DoctorDatabase.class, "doctors").allowMainThreadQueries().build();
        int id = 22;
        String statusDoctor = "Kenny";
        db.doctorDao().insert(id, "Kenny");
        Doctor kenny = db.doctorDao().findByStatus("Kenny");
        Log.i(kenny.status, String.valueOf(kenny.doctorID));
        db.doctorDao().delete(id);


*/
    }
}