package org.ratziiee.qlap.Registration.Main_application.Rider.Fragments.MyCards;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.ratziiee.qlap.R;
import org.ratziiee.qlap.Registration.Utils.utils;

import java.util.ArrayList;

public class availeble_balance extends AppCompatActivity {

    RecyclerView rv_previous_recharges;
    ArrayList<model_previous_recharge> list;
    Button btn_recharge;
    TextView tv_amt;
    int  pay=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_availeble_balance);


        TextView toolbar_title=findViewById(R.id.toolbar_title);
        tv_amt=findViewById(R.id.tv_amt);
        toolbar_title.setText("Recharge Card");
        utils utils=new utils();
        utils.change_status_bar_color(this,this);


        pay=getIntent().getIntExtra("payment_amt",0);
        if(pay!=0)
        {
            int add=pay+505;
            tv_amt.setText("₹"+String.valueOf(add));
        }

        rv_previous_recharges=findViewById(R.id.rv_payment);
        list=new ArrayList<>();
        btn_recharge=findViewById(R.id.btn_recharge);
        initList();
        RecyclerView.LayoutManager manager=new LinearLayoutManager(this);
        rv_previous_recharges.setLayoutManager(manager);

        adapter_previous_recharge adapter=new adapter_previous_recharge(this,list);
        rv_previous_recharges.setAdapter(adapter);

        btn_recharge.setOnClickListener(view -> {
            Intent i=new Intent(availeble_balance.this,payment_options.class);
            startActivity(i);
        });


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
