package com.example.smartpanqrroom.ui;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartpanqrroom.R;
import com.example.smartpanqrroom.room.QrData;
import com.example.smartpanqrroom.room.QrDataViewModel;

import java.util.ArrayList;
import java.util.List;

public class QrDataAdapter extends RecyclerView.Adapter<QrDataAdapter.QrDataViewHolder> {

    private List<QrData> qrDataList = new ArrayList<>();
    private QrDataViewModel qrDataViewModel;

    @NonNull
    @Override
    public QrDataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_qr, parent, false);
        qrDataViewModel = ViewModelProviders.of((FragmentActivity) parent.getContext()).get(QrDataViewModel.class);
        return new QrDataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QrDataViewHolder holder, final int position) {
        holder.tv_qr_data.setText(qrDataList.get(position).getData());
        holder.tv_qr_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qrDataViewModel.delete(qrDataList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return qrDataList.size();
    }

    public void setQrDataList(List<QrData> qrDataList){
        this.qrDataList = qrDataList;
        notifyDataSetChanged();
    }

    class QrDataViewHolder extends RecyclerView.ViewHolder{

        public TextView tv_qr_data;
        public ImageView tv_qr_delete;

        public QrDataViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_qr_data = itemView.findViewById(R.id.tv_qr_data);
            tv_qr_delete = itemView.findViewById(R.id.iv_qr_delete);
        }
    }
}
