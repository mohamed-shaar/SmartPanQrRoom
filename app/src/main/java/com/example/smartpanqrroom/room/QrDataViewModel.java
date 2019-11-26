package com.example.smartpanqrroom.room;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class QrDataViewModel extends AndroidViewModel {

    private QrDataRepository qrDataRepository;
    private LiveData<List<QrData>> allData;

    public QrDataViewModel(@NonNull Application application) {
        super(application);
        qrDataRepository = new QrDataRepository(application);
        allData = qrDataRepository.getAllData();
    }

    public void insert(QrData qrData){qrDataRepository.insert(qrData);}

    public void delete(QrData qrData){qrDataRepository.delete(qrData);}

    public LiveData<List<QrData>> getAllData(){return allData;}
}
