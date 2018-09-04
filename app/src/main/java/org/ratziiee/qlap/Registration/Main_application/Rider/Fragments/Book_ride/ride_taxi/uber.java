package org.ratziiee.qlap.Registration.Main_application.Rider.Fragments.Book_ride.ride_taxi;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.ratziiee.qlap.R;
import org.ratziiee.qlap.Registration.Main_application.Driver.Fragments.my_trip_driver.adapter_my_trip;
import org.ratziiee.qlap.Registration.Main_application.Driver.Fragments.my_trip_driver.model_my_trip;

import java.util.ArrayList;

public class uber extends Fragment {

    RecyclerView rv_my_trip;
    ArrayList<model_taxi> list;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View v=inflater.inflate(R.layout.my_trip_fragment,container,false);
        rv_my_trip=v.findViewById(R.id.rv_my_trip);
        list=new ArrayList<>();
        init_list();
        RecyclerView.LayoutManager manager=new LinearLayoutManager(getActivity());
        rv_my_trip.setLayoutManager(manager);
        adapter_my_taxi adapter=new adapter_my_taxi(getActivity(),list,2);
        rv_my_trip.addItemDecoration(new DividerItemDecoration(rv_my_trip.getContext(), DividerItemDecoration.VERTICAL));
        rv_my_trip.setAdapter(adapter);

        return v;
    }

    private void init_list()
    {
        model_taxi m2=new model_taxi();
        m2.setCab_type("Mini");
        m2.setArrival_time("8 minutes away");
        m2.setFare("₹ 150 - 170");
        m2.setReach_by_time("6 : 48 PM");
        list.add(m2);

        model_taxi m3=new model_taxi();
        m3.setCab_type("Prime");
        m3.setArrival_time("13 minutes away");
        m3.setFare("₹ 200 - 230");
        m3.setReach_by_time("6 : 53 PM");
        list.add(m3);

        model_taxi m=new model_taxi();
        m.setCab_type("Share");
        m.setArrival_time("3 minutes away");
        m.setFare("₹ 80 - 90");
        m.setReach_by_time("6 : 40 PM");
        list.add(m);

        model_taxi m1=new model_taxi();
        m1.setCab_type("Micro");
        m1.setArrival_time("5 minutes away");
        m1.setFare("₹ 100 - 130");
        m1.setReach_by_time("6 : 45 PM");
        list.add(m1);


    }

}
