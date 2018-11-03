package org.ratziiee.qlap.Registration.Main_application.Admin.Fragments.Rider;

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
import org.ratziiee.qlap.Registration.Main_application.Admin.Fragments.Driver.adapter_driver;
import org.ratziiee.qlap.Registration.Main_application.Admin.Fragments.Driver.model_driver;

import java.util.ArrayList;

public class frag_rider extends Fragment {

    RecyclerView rv_driver;
    ArrayList<model_rider> list;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.frag_rider,container,false);
        rv_driver=v.findViewById(R.id.rv_driver);
        initList();

        adapter_rider adapter=new adapter_rider(list,getContext(),1);
        RecyclerView.LayoutManager manager=new LinearLayoutManager(getActivity());
        rv_driver.addItemDecoration(new DividerItemDecoration(rv_driver.getContext(), DividerItemDecoration.VERTICAL));
        rv_driver.setLayoutManager(manager);
        rv_driver.setAdapter(adapter);

        return v;
    }

    private void initList()
    {
        list=new ArrayList<>();
        model_rider m=new model_rider();
        m.setDriver_name("babloo hatkar");
        m.setSno("1");
        m.setRider_rating("2.5/5");
        list.add(m);

        model_rider m1=new model_rider();
        m1.setDriver_name("sonu bala");
        m1.setSno("2");
        m1.setRider_rating("3.5/5");
        list.add(m1);

        model_rider m2=new model_rider();
        m2.setDriver_name("rakesh kumar");
        m2.setSno("3");
        m2.setRider_rating("4/5");
        list.add(m2);

        model_rider m3=new model_rider();
        m3.setDriver_name("vikas yogi");
        m3.setSno("4");
        m3.setRider_rating("4.1/5");
        list.add(m3);

        model_rider m4=new model_rider();
        m4.setDriver_name("sudhir desai");
        m4.setSno("5");
        m4.setRider_rating("3.5/5");
        list.add(m4);

        model_rider m5=new model_rider();
        m5.setDriver_name("rahul dhawan");
        m5.setSno("6");
        m5.setRider_rating("4.2/5");
        list.add(m5);

        model_rider m6=new model_rider();
        m6.setDriver_name("ganesh dhingra");
        m6.setSno("7");
        m6.setRider_rating("3.8/5");
        list.add(m6);


        model_rider m7=new model_rider();
        m7.setDriver_name("bablu hatkar");
        m7.setSno("1");
        m7.setRider_rating("2.5/5");
        list.add(m7);

        model_rider m8=new model_rider();
        m8.setDriver_name("sonu bala");
        m8.setSno("2");
        m8.setRider_rating("3.5/5");
        list.add(m8);

        model_rider m9=new model_rider();
        m9.setDriver_name("rakesh kumar");
        m9.setSno("3");
        m9.setRider_rating("4/5");
        list.add(m9);

        model_rider m11=new model_rider();
        m11.setDriver_name("vikas yogi");
        m11.setSno("4");
        m11.setRider_rating("4.1/5");
        list.add(m11);

        model_rider m14=new model_rider();
        m14.setDriver_name("sudhir desai");
        m14.setSno("5");
        m14.setRider_rating("3.5/5");
        list.add(m14);

        model_rider m15=new model_rider();
        m15.setDriver_name("rahul dhawan");
        m15.setSno("6");
        m15.setRider_rating("4.2/5");
        list.add(m15);

        model_rider m16=new model_rider();
        m16.setDriver_name("ganesh dhingra");
        m16.setSno("7");
        m16.setRider_rating("3.8/5");
        list.add(m16);




    }
}
