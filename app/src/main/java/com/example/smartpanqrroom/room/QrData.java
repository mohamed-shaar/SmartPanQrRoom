package com.example.smartpanqrroom.room;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "qr_data_table")
public class QrData {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String data;

    public QrData() {
    }

    public QrData(String data) {
        this.data = data;
    }

    public QrData(int id, String data) {
        this.id = id;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
