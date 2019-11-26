package com.example.smartpanqrroom.room;

import android.app.Application;
import android.os.AsyncTask;
import android.provider.ContactsContract;

import androidx.lifecycle.LiveData;

import java.util.List;

public class QrDataRepository {
    private QrDataDao qrDataDao;
    private LiveData<List<QrData>> allData;

    public QrDataRepository(Application application){
        QrDatabase database = QrDatabase.getInstance(application);
        qrDataDao = database.qrDataDao();
        allData  = qrDataDao.getAllData();
    }

    public void insert(QrData qrData){new InsertQrDataAsyncTask(qrDataDao).execute(qrData);}

    public void delete(QrData qrData){new DeleteQrDataAsyncTask(qrDataDao).execute(qrData);}

    public LiveData<List<QrData>> getAllData(){ return allData;}

    private static class InsertQrDataAsyncTask extends AsyncTask<QrData, Void, Void> {

        private QrDataDao qrDataDao;

        private InsertQrDataAsyncTask(QrDataDao qrDataDao) {
            this.qrDataDao = qrDataDao;
        }

        @Override
        protected Void doInBackground(QrData... qrData) {
            qrDataDao.insert(qrData[0]);
            return null;
        }
    }

    private static class DeleteQrDataAsyncTask extends AsyncTask<QrData, Void, Void> {

        private QrDataDao qrDataDao;

        private DeleteQrDataAsyncTask(QrDataDao qrDataDao) {
            this.qrDataDao = qrDataDao;
        }

        @Override
        protected Void doInBackground(QrData... qrData) {
            qrDataDao.delete(qrData[0]);
            return null;
        }
    }
}
