package org.ratziiee.qlap.Registration.Main_application.Rider.Fragments.Book_ride.ride_taxi;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.ratziiee.qlap.R;
import org.ratziiee.qlap.Registration.Main_application.Driver.Fragments.my_trip_driver.model_my_trip;
import org.ratziiee.qlap.Registration.Main_application.Driver.Fragments.my_trip_driver.trip_driver_1;

import java.util.ArrayList;

public class adapter_my_taxi extends RecyclerView.Adapter<adapter_my_taxi.MyViewHolder>
{
    private Context context;
    private ArrayList<model_taxi> list;
    private int unique_id=0;

    public adapter_my_taxi(Context context, ArrayList<model_taxi> list, int unique)
    {
        this.context=context;
        this.list=list;
        this.unique_id=unique;

    }

    @NonNull
    @Override
    public adapter_my_taxi.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v= LayoutInflater.from(context).inflate(R.layout.adapter_taxi,viewGroup,false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder h, int i) {

        model_taxi m=list.get(i);
        h.tv_type.setText(m.getCab_type());
        h.tv_arrival_time.setText(m.getArrival_time());
        h.tv_price.setText(m.getFare());
        h.tv_time_reach.setText(m.getReach_by_time());



        h.lay_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(unique_id==1)
                {
                    open_app_ola();
                }
                else
                {
                    open_uber();
                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_type,tv_arrival_time,tv_price,tv_time_reach;
        LinearLayout lay_main;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);


            lay_main=itemView.findViewById(R.id.lay_main);
            tv_type=itemView.findViewById(R.id.tv_type);
            tv_arrival_time=itemView.findViewById(R.id.tv_time);
            tv_price=itemView.findViewById(R.id.tv_price);
            tv_time_reach=itemView.findViewById(R.id.tv_time_reach);

        }
    }

    private void open_app_ola()
    {
        Intent launchIntent = context.getPackageManager().getLaunchIntentForPackage("com.olacabs.customer");
        if (launchIntent != null) {
            context.startActivity(launchIntent);//null pointer check in case package name was not found
        }else
        {
            Uri uri = Uri.parse("market://details?id=com.olacabs.customer");
            Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);

            goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                    Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                    Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
            try {
                context.startActivity(goToMarket);
            } catch (ActivityNotFoundException e) {
                context.startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://play.google.com/store/apps/details?id=com.olacabs.customer")));
            }
        }
    }

    private void open_uber()
    {
        PackageManager pm = context.getPackageManager();
        try {
            pm.getPackageInfo("com.ubercab", PackageManager.GET_ACTIVITIES);
            String uri = "uber://?action=setPickup&pickup=my_location";
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(uri));
            context.startActivity(intent);
        } catch (PackageManager.NameNotFoundException e) {
            try {
                context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.ubercab")));
            } catch (android.content.ActivityNotFoundException anfe) {
                context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=com.ubercab")));
            }
        }
    }
}
