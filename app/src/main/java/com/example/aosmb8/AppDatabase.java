package com.example.aosmb8;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Doctor.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract DoctorDao doctorDao();
}
