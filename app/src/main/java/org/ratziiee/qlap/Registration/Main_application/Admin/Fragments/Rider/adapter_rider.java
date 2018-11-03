package org.ratziiee.qlap.Registration.Main_application.Admin.Fragments.Rider;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.ratziiee.qlap.R;

import java.util.ArrayList;

public class adapter_rider extends RecyclerView.Adapter<adapter_rider.MyViewHolder> {

    ArrayList<model_rider> list;
    Context context;
    int uid;



    public adapter_rider(ArrayList<model_rider> list, Context context, int i) {
        this.list=list;
        this.context=context;
        this.uid=i;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v= LayoutInflater.from(context).inflate(R.layout.adapter_rider_names,viewGroup,false);


        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder h, int i) {

        model_rider m=list.get(i);
        h.tv_sno.setText(m.getSno());
        h.tv_name.setText(m.getDriver_name());
        h.tv_rating.setText(m.getRider_rating());


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
