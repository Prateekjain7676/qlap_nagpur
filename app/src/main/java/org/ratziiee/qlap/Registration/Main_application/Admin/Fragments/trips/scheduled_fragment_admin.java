package org.ratziiee.qlap.Registration.Main_application.Admin.Fragments.trips;

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
import org.ratziiee.qlap.Registration.Main_application.Driver.Fragments.my_trip_driver.model_my_trip;

import java.util.ArrayList;


public class scheduled_fragment_admin extends Fragment {

    RecyclerView rv_my_trip;
    ArrayList<model_my_trip> list;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.my_trip_fragment,container,false);

        rv_my_trip=v.findViewById(R.id.rv_my_trip);
        list=new ArrayList<>();
        init_list();
        RecyclerView.LayoutManager manager=new LinearLayoutManager(getActivity());
        rv_my_trip.setLayoutManager(manager);
        adapter_my_trip_admin adapter=new adapter_my_trip_admin(getActivity(),list,0);
        rv_my_trip.addItemDecoration(new DividerItemDecoration(rv_my_trip.getContext(), DividerItemDecoration.VERTICAL));
        rv_my_trip.setAdapter(adapter);
        return v;
    }

    private void init_list()
    {
        model_my_trip m=new model_my_trip();
        m.setStation_name("To Dpeth Bus Stand");
        m.setDate("");
        m.setTime("Arrival Time at Station : 9: 00 AM");
        list.add(m);

        model_my_trip m1=new model_my_trip();
        m1.setStation_name("From Bole Petrol Pump Bus Stand");
        m1.setDate("");
        m1.setTime("Departure Time from Station : 11: 00 AM");
        list.add(m1);

        model_my_trip m2=new model_my_trip();
        m2.setStation_name("To Khurana Bus Stand");
        m2.setDate("");
        m2.setTime("Arrival Time at Station : 2: 00 PM");
        list.add(m2);

        model_my_trip m3=new model_my_trip();
        m3.setStation_name("From Prop. Sitabuldi Metro Station");
        m3.setDate("");
        m3.setTime("Departure Time from Station : 4: 00 PM");
        list.add(m3);

        model_my_trip m4=new model_my_trip();
        m4.setStation_name("To Jhansi Rani Square Metro station");
        m4.setDate("");
        m4.setTime("Arrival Time at Station : 6: 00 PM");
        list.add(m4);


    }


}
