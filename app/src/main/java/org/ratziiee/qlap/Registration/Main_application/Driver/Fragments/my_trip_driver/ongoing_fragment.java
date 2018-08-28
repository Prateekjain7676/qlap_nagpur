package org.ratziiee.qlap.Registration.Main_application.Driver.Fragments.my_trip_driver;

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

import java.util.ArrayList;

public class ongoing_fragment extends Fragment {

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
        adapter_my_trip adapter=new adapter_my_trip(getActivity(),list,1);
        rv_my_trip.addItemDecoration(new DividerItemDecoration(rv_my_trip.getContext(), DividerItemDecoration.VERTICAL));
        rv_my_trip.setAdapter(adapter);
        return v;
    }

    private void init_list()
    {
        model_my_trip m=new model_my_trip();
        m.setStation_name("From Kohat Enclave Metro Station");
        m.setDate("");
        m.setTime("Departure Time from station : 7:00 AM");
        list.add(m);


    }


}
