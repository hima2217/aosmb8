package com.example.aosmb8;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity
public class Doctor {
    @PrimaryKey
    public int doctorID;
    @ColumnInfo(name="status")
    public String status;
}
