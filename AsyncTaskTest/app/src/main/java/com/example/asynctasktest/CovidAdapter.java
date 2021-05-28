package com.example.asynctasktest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CovidAdapter extends RecyclerView.Adapter<CovidAdapter.Myviewholder>{
    Context ctx;
    List<DayWiseCovidCases> mylist;

    public CovidAdapter(Context ct, List<DayWiseCovidCases> covidCasesList) {
        ctx = ct;
        mylist = covidCasesList;
    }

    @NonNull
    @Override
    public CovidAdapter.Myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(ctx).inflate(R.layout.row,parent,false);
        return new Myviewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CovidAdapter.Myviewholder holder, int position) {
        holder.tv_date.setText(mylist.get(position).getDate());
        holder.tv_recovered.setText(mylist.get(position).getRecovered());
        holder.tv_active.setText(mylist.get(position).getActivecases());
        holder.tv_deaths.setText(mylist.get(position).getDeaths());
        holder.tv_confirmed.setText(mylist.get(position).getConfirmedcases());
    }

    @Override
    public int getItemCount() {

        return mylist.size();
    }

    public class Myviewholder extends RecyclerView.ViewHolder {
        TextView tv_date,tv_confirmed,tv_active,tv_recovered,tv_deaths;
        public Myviewholder(@NonNull View itemView) {
            super(itemView);
            tv_date = itemView.findViewById(R.id.date);
            tv_confirmed=itemView.findViewById(R.id.confirmed);
            tv_active =itemView.findViewById(R.id.active);
            tv_recovered =itemView.findViewById(R.id.recovered);
            tv_deaths =itemView.findViewById(R.id.deaths);
        }
    }
}
