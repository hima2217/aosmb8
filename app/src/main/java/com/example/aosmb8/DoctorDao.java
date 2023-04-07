package com.example.aosmb8;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Query;

@Dao
public interface DoctorDao {
    @Query("SELECT * FROM Doctor WHERE status LIKE :status LIMIT 1")
    Doctor findByStatus(String status);

    @Query("SELECT * FROM Doctor WHERE doctorID LIKE :id")
    Doctor findById(int id);

    @Query("INSERT INTO Doctor(doctorID,status) VALUES (:id,:status)")
    void insert(int id, String status);

    @Delete
    void delete(Doctor doctor);

    @Query("DELETE FROM Doctor WHERE doctorID LIKE :id")
    void delete(int id);

    @Query("UPDATE Doctor SET status =:status WHERE doctorID LIKE :id")
    void update(int id, String status);
}

