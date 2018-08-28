package org.ratziiee.qlap.Registration.Main_application.Rider.Fragments.Book_ride;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.ratziiee.qlap.R;
import org.ratziiee.qlap.Registration.Utils.utils;

import java.util.ArrayList;

public class Book_ride_2 extends AppCompatActivity {

    RecyclerView rv_book_ride_2;
    ArrayList<model_bok_ride_2> list;
    Button btn_auto,btn_rikshaw,btn_smart,btn_bus,btn_taxi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_ride_2);

        TextView toolbar_title=findViewById(R.id.toolbar_title);
        toolbar_title.setText("Book Ride");
        utils utils=new utils();
        utils.change_status_bar_color(this,this);


        btn_auto=findViewById(R.id.btn_auto);
        btn_rikshaw=findViewById(R.id.btn_rikshaw);
        btn_smart=findViewById(R.id.btn_smart);
        btn_bus=findViewById(R.id.btn_bus);
        btn_taxi=findViewById(R.id.btn_taxi);
        selection_button();
        list=new ArrayList<>();


        rv_book_ride_2=findViewById(R.id.rv_book_ride_2);
        RecyclerView.LayoutManager manager=new LinearLayoutManager(this);
        rv_book_ride_2.setLayoutManager(manager);
        rv_book_ride_2.addItemDecoration(new DividerItemDecoration(rv_book_ride_2.getContext(), DividerItemDecoration.VERTICAL));


    }

    private void initlist_auto()
    {
        list.clear();
        model_bok_ride_2 m=new model_bok_ride_2();
        m.setTime_1("6:15 P.M");
        m.setTime_2("6.40 P.M");
        list.add(m);

        model_bok_ride_2 m2=new model_bok_ride_2();
        m2.setTime_1("6:20 P.M");
        m2.setTime_2("6.50 P.M");
        list.add(m2);

        model_bok_ride_2 m3=new model_bok_ride_2();
        m3.setTime_1("6:30 P.M");
        m3.setTime_2("6.50 P.M");
        list.add(m3);

        model_bok_ride_2 m4=new model_bok_ride_2();
        m4.setTime_1("6:40 P.M");
        m4.setTime_2("7.00 P.M");
        list.add(m4);

        Adapter_book_ride_2 adapter=new Adapter_book_ride_2(this,list);
        rv_book_ride_2.setAdapter(adapter);
    }
    private void initlist_rickshaw()
    {
        list.clear();
        model_bok_ride_2 m=new model_bok_ride_2();
        m.setTime_1("6:15 P.M");
        m.setTime_2("6.35 P.M");
        list.add(m);

        model_bok_ride_2 m2=new model_bok_ride_2();
        m2.setTime_1("6:30 P.M");
        m2.setTime_2("6.50 P.M");
        list.add(m2);

        model_bok_ride_2 m3=new model_bok_ride_2();
        m3.setTime_1("6:45 P.M");
        m3.setTime_2("7.05 P.M");
        list.add(m3);

        model_bok_ride_2 m4=new model_bok_ride_2();
        m4.setTime_1("7:00 P.M");
        m4.setTime_2("7.20 P.M");
        list.add(m4);

        Adapter_book_ride_2 adapter=new Adapter_book_ride_2(this,list);
        rv_book_ride_2.setAdapter(adapter);
    }



    private void initlist_bus()
    {
        list.clear();
        model_bok_ride_2 m=new model_bok_ride_2();
        m.setTime_1("6:30 P.M");
        m.setTime_2("7.00 P.M");
        list.add(m);

        model_bok_ride_2 m2=new model_bok_ride_2();
        m2.setTime_1("7:00 P.M");
        m2.setTime_2("7.30 P.M");
        list.add(m2);

        model_bok_ride_2 m3=new model_bok_ride_2();
        m3.setTime_1("7:30 P.M");
        m3.setTime_2("8.00 P.M");
        list.add(m3);

        model_bok_ride_2 m4=new model_bok_ride_2();
        m4.setTime_1("8:00 P.M");
        m4.setTime_2("8.30 P.M");
        list.add(m4);

        Adapter_book_ride_2 adapter=new Adapter_book_ride_2(this,list);
        rv_book_ride_2.setAdapter(adapter);
    }

    private void selection_button()
    {
        btn_auto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_auto.setBackgroundResource(R.drawable.auto);
                btn_rikshaw.setBackgroundResource(R.drawable.unselect_rikshaw);
                btn_smart.setBackgroundResource(R.drawable.unselect_smart);
                btn_bus.setBackgroundResource(R.drawable.unselect_bus);
                btn_taxi.setBackgroundResource(R.drawable.unselect_taxi);
                initlist_auto();
            }
        });

        btn_rikshaw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_auto.setBackgroundResource(R.drawable.unselect_auto);
                btn_rikshaw.setBackgroundResource(R.drawable.erickshaw);
                btn_smart.setBackgroundResource(R.drawable.unselect_smart);
                btn_bus.setBackgroundResource(R.drawable.unselect_bus);
                btn_taxi.setBackgroundResource(R.drawable.unselect_taxi);

                initlist_rickshaw();
            }
        });

        btn_smart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_auto.setBackgroundResource(R.drawable.unselect_auto);
                btn_rikshaw.setBackgroundResource(R.drawable.unselect_rikshaw);
                btn_smart.setBackgroundResource(R.drawable.smart_book);
                btn_bus.setBackgroundResource(R.drawable.unselect_bus);
                btn_taxi.setBackgroundResource(R.drawable.unselect_taxi);


                rv_book_ride_2.setAdapter(null);

                Intent i=new Intent(Book_ride_2.this,Book_ride_3.class);
                startActivity(i);


            }
        });

        btn_bus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_auto.setBackgroundResource(R.drawable.unselect_auto);
                btn_rikshaw.setBackgroundResource(R.drawable.unselect_rikshaw);
                btn_smart.setBackgroundResource(R.drawable.unselect_smart);
                btn_bus.setBackgroundResource(R.drawable.minibus);
                btn_taxi.setBackgroundResource(R.drawable.unselect_taxi);

                initlist_bus();
            }
        });

        btn_taxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_auto.setBackgroundResource(R.drawable.unselect_auto);
                btn_rikshaw.setBackgroundResource(R.drawable.unselect_rikshaw);
                btn_smart.setBackgroundResource(R.drawable.unselect_smart);
                btn_bus.setBackgroundResource(R.drawable.unselect_bus);
                btn_taxi.setBackgroundResource(R.drawable.taxi);

                initlist_auto();
            }
        });
    }
}
