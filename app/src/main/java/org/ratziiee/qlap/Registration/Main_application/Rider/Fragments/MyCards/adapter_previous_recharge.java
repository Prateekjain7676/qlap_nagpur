package org.ratziiee.qlap.Registration.Main_application.Rider.Fragments.MyCards;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.ratziiee.qlap.R;
import org.ratziiee.qlap.Registration.Main_application.Rider.Fragments.Book_ride.Adapter_book_ride_2;

import java.util.ArrayList;

public class adapter_previous_recharge extends RecyclerView.Adapter<adapter_previous_recharge.MyViewHolder> {

    private ArrayList<model_previous_recharge> list;
    private Context context;
    public adapter_previous_recharge(Context context, ArrayList<model_previous_recharge> list)
    {
        this.context=context;
        this.list=list;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(context).inflate(R.layout.adapter_previous_rechrge,viewGroup,false);

        return new MyViewHolder(v) ;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder h, int i) {

        model_previous_recharge m=list.get(i);
        h.tv_amt.setText(m.getRecharge_amount());
        h.tv_date.setText(m.getDate());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_amt,tv_date;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_amt=itemView.findViewById(R.id.tv_amt);
            tv_date=itemView.findViewById(R.id.tv_date);
        }
    }
}
