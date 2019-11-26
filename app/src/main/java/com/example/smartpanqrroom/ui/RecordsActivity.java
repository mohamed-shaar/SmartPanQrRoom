package com.example.smartpanqrroom.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.smartpanqrroom.R;
import com.example.smartpanqrroom.room.QrData;
import com.example.smartpanqrroom.room.QrDataViewModel;

import java.util.ArrayList;
import java.util.List;

public class RecordsActivity extends AppCompatActivity {

    private QrDataViewModel qrDataViewModel;
    private QrDataAdapter qrDataAdapter;
    private RecyclerView rv_data;
    private List<QrData> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_records);

        qrDataViewModel = ViewModelProviders.of(this).get(QrDataViewModel.class);
        rv_data = findViewById(R.id.rv_data);
        rv_data.setHasFixedSize(false);
        rv_data.setLayoutManager(new LinearLayoutManager(this));
        qrDataAdapter = new QrDataAdapter();
        rv_data.setAdapter(qrDataAdapter);

        qrDataViewModel.getAllData().observe(this, new Observer<List<QrData>>() {
            @Override
            public void onChanged(List<QrData> qrData) {
                data.clear();
                for (QrData qrData1: qrData){
                    data.add(qrData1);
                }
                qrDataAdapter.setQrDataList(qrData);
            }
        });
    }
}
