package com.example.aosmb8.UI;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.aosmb8.data.DoctorDB.Doctor;
import com.example.aosmb8.data.DoctorDB.DoctorRepository;

import java.util.List;

public class DoctorVM extends AndroidViewModel {
    private final LiveData<List<Doctor>> mAllDoctor;
    private final DoctorRepository mRepository;

    public DoctorVM(Application application) {
        super(application);
        Log.d("DoctorVM", "Constructor");
        mRepository = new DoctorRepository(application);
        mAllDoctor = mRepository.getAllApartment();
    }

    public LiveData<List<Doctor>> getAllDoctor() {
        return mAllDoctor;
    }

    public void insert(Doctor doctor) {
        mRepository.insert(doctor);
    }
}