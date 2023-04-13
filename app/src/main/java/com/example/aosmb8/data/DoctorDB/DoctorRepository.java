package com.example.aosmb8.data.DoctorDB;


        import android.app.Application;
        import android.util.Log;

        import androidx.lifecycle.LiveData;

        import com.example.aosmb8.data.DoctorDB.Doctor;
        import com.example.aosmb8.data.DoctorDB.DoctorDao;
        import com.example.aosmb8.data.DoctorDB.DoctorDatabase;

        import java.util.List;

public class DoctorRepository {
    private final DoctorDao mDoctorDao;
    private final LiveData<List<Doctor>> doctors;

    public DoctorRepository(Application application) {
        Log.d("DoctorRepository", "Constructor");
        DoctorDatabase db = DoctorDatabase.getDatabase(application);
        mDoctorDao = db.doctorDao();
        doctors = mDoctorDao.getAll();
    }

    public LiveData<List<Doctor>> getAllApartment() {
        return doctors;
    }

    public void insert(Doctor doctor) {
        DoctorDatabase.databaseWriteExecutor.execute(() -> {
            mDoctorDao.insert(doctor);
            Log.d("ggg", doctor.name);
        });
    }
}
