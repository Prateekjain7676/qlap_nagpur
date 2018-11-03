package org.ratziiee.qlap.Registration.Main_application.Admin.Fragments.Driver;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.ratziiee.qlap.R;

import java.util.ArrayList;

public class adapter_driver extends RecyclerView.Adapter<adapter_driver.MyViewHolder> {

    ArrayList<model_driver> list;
    Context context;
    int uid;


    public adapter_driver(ArrayList<model_driver> list, Context context,int i)
    {
        this.list=list;
        this.context=context;
        this.uid=i;

        Log.d("size", "adapter_rider: "+list.size());
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v= LayoutInflater.from(context).inflate(R.layout.adapter_driver_names,viewGroup,false);


        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder h, int i) {

        model_driver m=list.get(i);
        h.tv_sno.setText(m.getSno());
        h.tv_name.setText(m.getDriver_name());
        h.tv_rating.setText(m.getRider_rating());
        Log.d("", "onBindViewHolder: "+m.getMode());
        if(m.getMode().equalsIgnoreCase("auto"))
        {
            h.iv_mode.setBackgroundResource(R.drawable.auto_selected);
        }
        else  if(m.getMode().equalsIgnoreCase("bus"))
        {
            h.iv_mode.setBackgroundResource(R.drawable.unselect_bus);
        }
        else  if(m.getMode().equalsIgnoreCase("rikshaw"))
        {
            h.iv_mode.setBackgroundResource(R.drawable.unselect_rikshaw);
        }
        else  if(m.getMode().equalsIgnoreCase("cab"))
        {
            h.iv_mode.setBackgroundResource(R.drawable.unselect_taxi);
        }


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_sno,tv_name,tv_rating;
        ImageView iv_mode;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_name=itemView.findViewById(R.id.tv_driver);
            tv_sno=itemView.findViewById(R.id.tv_sno);
            tv_rating=itemView.findViewById(R.id.tv_rider_rating);
            iv_mode=itemView.findViewById(R.id.iv_mode);
        }
    }
}
