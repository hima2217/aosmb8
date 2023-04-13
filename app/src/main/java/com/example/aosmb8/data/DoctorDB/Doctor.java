package com.example.aosmb8.data.DoctorDB;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Doctor {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "doctorId")
    public int doctorId;
    @ColumnInfo(name = "name")
    public String name;
    public Doctor() {}
    public Doctor(String name) {
        this.name = name;
    }
}