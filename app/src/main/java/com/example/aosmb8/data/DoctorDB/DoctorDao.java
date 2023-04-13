package com.example.aosmb8.data.DoctorDB;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.aosmb8.data.DoctorDB.Doctor;

import java.util.List;

@Dao
public interface DoctorDao {
    @Query("SELECT * FROM Doctor")

    LiveData<List<Doctor>> getAll();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Doctor doctor);

    @Query("DELETE FROM Doctor")
    void deleteAll();

    @Query("SELECT * FROM Doctor WHERE doctorId IN (:doctorIds)")
    List<Doctor> loadAllByIds(int[] doctorIds);
}