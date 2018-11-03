package org.ratziiee.qlap.Registration.Main_application.Rider.Fragments.Book_ride;

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
import android.widget.Toast;

import org.ratziiee.qlap.R;

import java.util.ArrayList;

public class Adapter_book_ride_2 extends RecyclerView.Adapter<Adapter_book_ride_2.MyViewHolder> {

    private ArrayList<model_bok_ride_2> list;
    private Context context;
    String destination_name="";

    public Adapter_book_ride_2(Context context, ArrayList<model_bok_ride_2> list,String destination_name)
    {
        this.list=list;
        this.context=context;
        this.destination_name=destination_name;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        View v= LayoutInflater.from(context).inflate(R.layout.adapter_rv_book_ride_2,viewGroup,false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder h, int i) {

        model_bok_ride_2 m=list.get(i);
        h.tv_time_1.setText(m.getTime_1());
        h.tv_time_2.setText(m.getTime_2());
        h.tv_away.setText(m.away_text);

        Log.d("", "onBindViewHolder: "+m.getTime_1());

        h.lay_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "clicked :"+h.getAdapterPosition(), Toast.LENGTH_SHORT).show();
                Intent i=new Intent(context,Book_ride_3.class);
                i.putExtra("destination",destination_name);
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_time_1,tv_time_2,tv_away;
        LinearLayout lay_main;
        public MyViewHolder(@NonNull View v)
        {
            super(v);
            tv_time_1=v.findViewById(R.id.tv_time_1);
            tv_time_2=v.findViewById(R.id.tv_time_2);
            lay_main=v.findViewById(R.id.lay_main);
            tv_away=v.findViewById(R.id.tv_away);
        }
    }
}
