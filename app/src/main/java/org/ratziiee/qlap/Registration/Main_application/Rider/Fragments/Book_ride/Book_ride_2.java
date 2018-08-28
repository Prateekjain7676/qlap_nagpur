package org.ratziiee.qlap.Registration.Main_application.Rider.Fragments.Book_ride;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import org.ratziiee.qlap.R;
import org.ratziiee.qlap.Registration.Utils.utils;

import java.util.ArrayList;

public class Book_ride_2 extends AppCompatActivity {

    RecyclerView rv_book_ride_2;
    ArrayList<model_bok_ride_2> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_ride_2);

        TextView toolbar_title=findViewById(R.id.toolbar_title);
        toolbar_title.setText("Book Ride");
        utils utils=new utils();
        utils.change_status_bar_color(this,this);
        list=new ArrayList<>();
        initlist();

        rv_book_ride_2=findViewById(R.id.rv_book_ride_2);
        RecyclerView.LayoutManager manager=new LinearLayoutManager(this);
        rv_book_ride_2.setLayoutManager(manager);
        rv_book_ride_2.addItemDecoration(new DividerItemDecoration(rv_book_ride_2.getContext(), DividerItemDecoration.VERTICAL));

        Adapter_book_ride_2 adapter=new Adapter_book_ride_2(this,list);
        rv_book_ride_2.setAdapter(adapter);
    }

    private void initlist()
    {
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
    }
}
