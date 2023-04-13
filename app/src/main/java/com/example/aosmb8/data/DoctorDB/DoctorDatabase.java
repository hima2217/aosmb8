package com.example.aosmb8.data.DoctorDB;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Doctor.class}, version = 1)
public abstract class DoctorDatabase extends RoomDatabase {
    public abstract DoctorDao doctorDao();

    private static volatile DoctorDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    private static final RoomDatabase.Callback sRoomDatabaseCallback
            = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            Log.d("DoctorDatabase", "onCreate");
            databaseWriteExecutor.execute(() -> {
                DoctorDao dao = INSTANCE.doctorDao();
                dao.deleteAll();
            });
        }
    };

    public  static DoctorDatabase getDatabase(final Context context) {
        Log.d("DoctorDatabase", "getDatabase");
        if (INSTANCE == null) {
            synchronized (DoctorDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    DoctorDatabase.class, "doctors_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}