package org.ratziiee.qlap.Registration.Main_application.Admin.Fragments.Driver;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.ratziiee.qlap.R;

import java.util.ArrayList;

public class frag_driver extends Fragment
{
    RecyclerView rv_driver;
    ArrayList<model_driver> list;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.frag_driver,container,false);
        rv_driver=v.findViewById(R.id.rv_driver);
        initList();


        RecyclerView.LayoutManager manager=new LinearLayoutManager(getActivity());
        rv_driver.addItemDecoration(new DividerItemDecoration(rv_driver.getContext(), DividerItemDecoration.VERTICAL));
        rv_driver.setLayoutManager(manager);
        adapter_driver adapter=new adapter_driver(list,getActivity(),1);
        rv_driver.setAdapter(adapter);


        return v;
    }

    private void initList()
    {
        list=new ArrayList<>();
        model_driver m=new model_driver();
        m.setDriver_name("babloo hatkar");
        m.setMode("auto");
        m.setSno("1");
        m.setRider_rating("2.5/5");
        list.add(m);

        model_driver m1=new model_driver();
        m1.setDriver_name("sonu bala");
        m1.setMode("auto");
        m1.setSno("2");
        m1.setRider_rating("3.5/5");
        list.add(m1);

        model_driver m2=new model_driver();
        m2.setDriver_name("rakesh kumar");
        m2.setMode("bus");
        m2.setSno("3");
        m2.setRider_rating("4/5");
        list.add(m2);

        model_driver m3=new model_driver();
        m3.setDriver_name("vikas yogi");
        m3.setMode("rikshaw");
        m3.setSno("4");
        m3.setRider_rating("4.1/5");
        list.add(m3);

        model_driver m4=new model_driver();
        m4.setDriver_name("sudhir desai");
        m4.setMode("cab");
        m4.setSno("5");
        m4.setRider_rating("3.5/5");
        list.add(m4);

        model_driver m5=new model_driver();
        m5.setDriver_name("rahul dhawan");
        m5.setMode("auto");
        m5.setSno("6");
        m5.setRider_rating("4.2/5");
        list.add(m5);

        model_driver m6=new model_driver();
        m6.setDriver_name("ganesh dhingra");
        m6.setMode("rikshaw");
        m6.setSno("7");
        m6.setRider_rating("3.8/5");
        list.add(m6);


        model_driver m7=new model_driver();
        m7.setDriver_name("bablu hatkar");
        m7.setMode("auto");
        m7.setSno("8");
        m7.setRider_rating("2.5/5");
        list.add(m7);

        model_driver m8=new model_driver();
        m8.setDriver_name("sonu bala");
        m8.setMode("auto");
        m8.setSno("9");
        m8.setRider_rating("3.5/5");
        list.add(m8);

        model_driver m9=new model_driver();
        m9.setDriver_name("rakesh kumar");
        m9.setMode("bus");
        m9.setSno("10");
        m9.setRider_rating("4/5");
        list.add(m9);

        model_driver m11=new model_driver();
        m11.setDriver_name("vikas yogi");
        m11.setMode("rikshaw");
        m11.setSno("11");
        m11.setRider_rating("4.1/5");
        list.add(m11);

        model_driver m14=new model_driver();
        m14.setDriver_name("sudhir desai");
        m14.setMode("cab");
        m14.setSno("12");
        m14.setRider_rating("3.5/5");
        list.add(m14);

        model_driver m15=new model_driver();
        m15.setDriver_name("rahul dhawan");
        m15.setMode("auto");
        m15.setSno("13");
        m15.setRider_rating("4.2/5");
        list.add(m15);

        model_driver m16=new model_driver();
        m16.setDriver_name("ganesh dhingra");
        m16.setMode("rikshaw");
        m16.setSno("14");
        m16.setRider_rating("3.8/5");
        list.add(m16);




    }





}
