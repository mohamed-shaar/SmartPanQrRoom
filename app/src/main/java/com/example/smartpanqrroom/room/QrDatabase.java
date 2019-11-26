package com.example.smartpanqrroom.room;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = QrData.class, version = 1, exportSchema = false)
public abstract class QrDatabase extends RoomDatabase {
    private static QrDatabase instance;

    public abstract QrDataDao qrDataDao();

    public static synchronized QrDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    QrDatabase.class
                    , "qr_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private QrDataDao qrDataDao;

        private PopulateDbAsyncTask(QrDatabase db){
            qrDataDao = db.qrDataDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            qrDataDao.insert(new QrData("hello world"));
            return null;
        }
    }
}
