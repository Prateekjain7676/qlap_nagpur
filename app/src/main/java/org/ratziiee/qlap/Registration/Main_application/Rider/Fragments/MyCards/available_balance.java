package org.ratziiee.qlap.Registration.Main_application.Rider.Fragments.MyCards;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import org.ratziiee.qlap.R;

import java.util.ArrayList;

public class available_balance extends Fragment
{
    RecyclerView rv_previous_recharges;
    ArrayList<model_previous_recharge> list;
    Button btn_recharge;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=LayoutInflater.from(getActivity()).inflate(R.layout.fragment_availeble_balance,container,false);

        rv_previous_recharges=v.findViewById(R.id.rv_payment);
        list=new ArrayList<>();
        btn_recharge=v.findViewById(R.id.btn_recharge);
        initList();
        RecyclerView.LayoutManager manager=new LinearLayoutManager(getActivity());
        rv_previous_recharges.setLayoutManager(manager);

        adapter_previous_recharge adapter=new adapter_previous_recharge(getActivity(),list);
        rv_previous_recharges.setAdapter(adapter);

        btn_recharge.setOnClickListener(view -> {
            Intent i=new Intent(getActivity(),payment_options.class);
            startActivity(i);
        });
        return v;
    }

    private void initList()
    {
        model_previous_recharge m=new model_previous_recharge();
        m.setDate("13 august 2018");
        m.setRecharge_amount("₹ 300");
        list.add(m);

        model_previous_recharge m1=new model_previous_recharge();
        m1.setDate("20 august 2018");
        m1.setRecharge_amount("₹ 500");
        list.add(m1);

        model_previous_recharge m2=new model_previous_recharge();
        m2.setDate("25 august 2018");
        m2.setRecharge_amount("₹ 200");
        list.add(m2);

        model_previous_recharge m3=new model_previous_recharge();
        m3.setDate("4 oct 2018");
        m3.setRecharge_amount("₹ 100");
        list.add(m3);

        model_previous_recharge m4=new model_previous_recharge();
        m4.setDate("8 oct 2018");
        m4.setRecharge_amount("₹ 600");
        list.add(m4);
    }
}
