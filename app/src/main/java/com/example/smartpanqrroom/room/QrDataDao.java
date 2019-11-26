package com.example.smartpanqrroom.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface QrDataDao {

    @Insert
    void insert(QrData qrData);

    @Delete
    void delete(QrData qrData);

    @Query("SELECT * FROM qr_data_table")
    LiveData<List<QrData>> getAllData();

}
