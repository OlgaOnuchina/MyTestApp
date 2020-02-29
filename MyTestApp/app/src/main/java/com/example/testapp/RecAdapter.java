package com.example.testapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecAdapter extends RecyclerView.Adapter<RecAdapter.DowntimeViewHolder> {

    private ArrayList<RecyclerData> recyclerListData;

    public RecAdapter(ArrayList<RecyclerData> recyclerListData) {
        this.recyclerListData = recyclerListData;
    }


    public class DowntimeViewHolder extends RecyclerView.ViewHolder {

        TextView desc;
        TextView period;
        public DowntimeViewHolder (View view){
            super(view);
            desc = (TextView) view.findViewById(R.id.recInfoDowntime);
            period = (TextView) view.findViewById(R.id.recPeriodDowntime);
        }
    }

    @NonNull
    @Override
    public DowntimeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewTipe){

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_design, parent, false);
        return new DowntimeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DowntimeViewHolder holder, int position) {
        holder.desc.setText(recyclerListData.get(position).getDesc());
        holder.period.setText(recyclerListData.get(position).getPeriod());

    }

    @Override
    public int getItemCount(){
        return recyclerListData.size();
    }

}
