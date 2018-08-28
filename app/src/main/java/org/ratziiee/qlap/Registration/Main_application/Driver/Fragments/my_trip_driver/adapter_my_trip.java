package org.ratziiee.qlap.Registration.Main_application.Driver.Fragments.my_trip_driver;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.ratziiee.qlap.R;

import java.util.ArrayList;

public class adapter_my_trip extends RecyclerView.Adapter<adapter_my_trip.MyViewHolder>
{
    Context context;
    ArrayList<model_my_trip> list;

    public adapter_my_trip(Context context,ArrayList<model_my_trip> list)
    {
        this.context=context;
        this.list=list;

    }

    @NonNull
    @Override
    public adapter_my_trip.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v= LayoutInflater.from(context).inflate(R.layout.adapter_my_trip,viewGroup,false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder h, int i) {

        model_my_trip m=list.get(i);
        h.tv_station_name.setText(m.getStation_name());
        h.tv_date.setText(m.getDate());
        h.tv_time.setText(m.getTime());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_station_name,tv_time,tv_date;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_station_name=itemView.findViewById(R.id.tv_station_name);
            tv_time=itemView.findViewById(R.id.tv_time);
            tv_date=itemView.findViewById(R.id.tv_date);

        }
    }
}
