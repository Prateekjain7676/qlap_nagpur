package org.ratziiee.qlap.Registration.Main_application.Driver.Fragments.my_trip_driver;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.ratziiee.qlap.R;

import java.util.ArrayList;

public class adapter_my_trip extends RecyclerView.Adapter<adapter_my_trip.MyViewHolder>
{
    Context context;
    ArrayList<model_my_trip> list;
    int unique_id=0;

    public adapter_my_trip(Context context,ArrayList<model_my_trip> list,int unique)
    {
        this.context=context;
        this.list=list;
        this.unique_id=unique;

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


        h.lay_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(context,trip_driver_1.class);
                i.putExtra("id",unique_id);
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_station_name,tv_time,tv_date;
        LinearLayout lay_main;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_station_name=itemView.findViewById(R.id.tv_station_name);
            tv_time=itemView.findViewById(R.id.tv_time);
            tv_date=itemView.findViewById(R.id.tv_date);
            lay_main=itemView.findViewById(R.id.lay_main);

        }
    }
}
