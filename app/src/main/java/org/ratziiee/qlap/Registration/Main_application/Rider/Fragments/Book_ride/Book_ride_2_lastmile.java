package org.ratziiee.qlap.Registration.Main_application.Rider.Fragments.Book_ride;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import org.ratziiee.qlap.R;
import org.ratziiee.qlap.Registration.Main_application.Rider.Fragments.Book_ride.ride_taxi.ola;
import org.ratziiee.qlap.Registration.Main_application.Rider.Fragments.Book_ride.ride_taxi.uber;
import org.ratziiee.qlap.Registration.Utils.utils;

import java.util.ArrayList;
import java.util.List;

public class Book_ride_2_lastmile extends AppCompatActivity {

    RecyclerView rv_book_ride_2;
    ArrayList<model_bok_ride_2> list;
    Button btn_auto,btn_rikshaw,btn_smart,btn_bus,btn_taxi,btn_smart_book;
    CoordinatorLayout main_content;
    ScrollView lay_smart;
    String destination_address="";
    TextView tv_destination_address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_ride_2_last);

        TextView toolbar_title=findViewById(R.id.toolbar_title);
        toolbar_title.setText("Book Ride");
        utils utils=new utils();
        utils.change_status_bar_color(this,this);
        tv_destination_address=findViewById(R.id.tv_destination_address);

        destination_address=getIntent().getStringExtra("selected_station");
        tv_destination_address.setText(destination_address);

        main_content=findViewById(R.id.main_content);
        ViewPager viewPager = (ViewPager)findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        // Set Tabs inside Toolbar
        TabLayout tabs = (TabLayout)findViewById(R.id.result_tabs);
        tabs.setupWithViewPager(viewPager);

        btn_auto=findViewById(R.id.btn_auto);
        btn_rikshaw=findViewById(R.id.btn_rikshaw);
        btn_smart=findViewById(R.id.btn_smart);
        btn_bus=findViewById(R.id.btn_bus);
        btn_taxi=findViewById(R.id.btn_taxi);
        btn_smart_book=findViewById(R.id.btn_smart_book);
        lay_smart=findViewById(R.id.lay_smart);
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
        m.setAway_text("Pickup : 100m away");
        list.add(m);

        model_bok_ride_2 m2=new model_bok_ride_2();
        m2.setTime_1("6:20 P.M");
        m2.setTime_2("6.50 P.M");
        m2.setAway_text("Pickup : 80m away");
        list.add(m2);

        model_bok_ride_2 m3=new model_bok_ride_2();
        m3.setTime_1("6:30 P.M");
        m3.setTime_2("6.50 P.M");
        m3.setAway_text("Pickup : 75m away");
        list.add(m3);

        model_bok_ride_2 m4=new model_bok_ride_2();
        m4.setTime_1("6:40 P.M");
        m4.setTime_2("7.00 P.M");
        m4.setAway_text("Pickup : 70m away");
        list.add(m4);

        Adapter_book_ride_2 adapter=new Adapter_book_ride_2(this,list,destination_address);
        rv_book_ride_2.setAdapter(adapter);
    }
    private void initlist_rickshaw()
    {
        list.clear();
        model_bok_ride_2 m=new model_bok_ride_2();
        m.setTime_1("6:15 P.M");
        m.setTime_2("6.35 P.M");
        m.setAway_text("Pickup : 100m away");
        list.add(m);

        model_bok_ride_2 m2=new model_bok_ride_2();
        m2.setTime_1("6:30 P.M");
        m2.setTime_2("6.50 P.M");
        m2.setAway_text("Pickup : 80m away");
        list.add(m2);

        model_bok_ride_2 m3=new model_bok_ride_2();
        m3.setTime_1("6:45 P.M");
        m3.setTime_2("7.05 P.M");
        m3.setAway_text("Pickup : 75m away");
        list.add(m3);

        model_bok_ride_2 m4=new model_bok_ride_2();
        m4.setTime_1("7:00 P.M");
        m4.setTime_2("7.20 P.M");
        m4.setAway_text("Pickup : 70m away");
        list.add(m4);

        Adapter_book_ride_2 adapter=new Adapter_book_ride_2(this,list,destination_address);
        rv_book_ride_2.setAdapter(adapter);
    }



    private void initlist_bus()
    {
        list.clear();
        model_bok_ride_2 m=new model_bok_ride_2();
        m.setTime_1("6:30 P.M");
        m.setTime_2("6.33 P.M");
        m.setAway_text("Pickup : 100m away");
        list.add(m);

        model_bok_ride_2 m2=new model_bok_ride_2();
        m2.setTime_1("7:00 P.M");
        m2.setTime_2("7.03 P.M");
        m2.setAway_text("Pickup : 80m away");
        list.add(m2);

        model_bok_ride_2 m3=new model_bok_ride_2();
        m3.setTime_1("7:45 P.M");
        m3.setTime_2("8.48 P.M");
        m3.setAway_text("Pickup : 75m away");
        list.add(m3);

        model_bok_ride_2 m4=new model_bok_ride_2();
        m4.setTime_1("8:00 P.M");
        m4.setTime_2("8.03 P.M");
        m4.setAway_text("Pickup : 70m away");
        list.add(m4);

        Adapter_book_ride_2 adapter=new Adapter_book_ride_2(this,list,destination_address);
        rv_book_ride_2.setAdapter(adapter);
    }

    private void selection_button()
    {
        btn_auto.setOnClickListener(view -> {
            btn_auto.setBackgroundResource(R.drawable.auto);
            btn_rikshaw.setBackgroundResource(R.drawable.unselect_rikshaw);
            btn_smart.setBackgroundResource(R.drawable.unselect_smart);
            btn_bus.setBackgroundResource(R.drawable.unselect_bus);
            btn_taxi.setBackgroundResource(R.drawable.unselect_taxi);
            initlist_auto();

            main_content.setVisibility(View.GONE);
            rv_book_ride_2.setVisibility(View.VISIBLE);
            lay_smart.setVisibility(View.GONE);
        });

        btn_rikshaw.setOnClickListener(view -> {
            btn_auto.setBackgroundResource(R.drawable.unselect_auto);
            btn_rikshaw.setBackgroundResource(R.drawable.erickshaw);
            btn_smart.setBackgroundResource(R.drawable.unselect_smart);
            btn_bus.setBackgroundResource(R.drawable.unselect_bus);
            btn_taxi.setBackgroundResource(R.drawable.unselect_taxi);

            initlist_rickshaw();

            main_content.setVisibility(View.GONE);
            rv_book_ride_2.setVisibility(View.VISIBLE);
            lay_smart.setVisibility(View.GONE);
        });

        btn_smart.setOnClickListener(view -> {
            btn_auto.setBackgroundResource(R.drawable.unselect_auto);
            btn_rikshaw.setBackgroundResource(R.drawable.unselect_rikshaw);
            btn_smart.setBackgroundResource(R.drawable.smart_book);
            btn_bus.setBackgroundResource(R.drawable.unselect_bus);
            btn_taxi.setBackgroundResource(R.drawable.unselect_taxi);


            rv_book_ride_2.setAdapter(null);

            main_content.setVisibility(View.GONE);
            rv_book_ride_2.setVisibility(View.GONE);
            lay_smart.setVisibility(View.VISIBLE);
            });

        btn_bus.setOnClickListener(view -> {
            btn_auto.setBackgroundResource(R.drawable.unselect_auto);
            btn_rikshaw.setBackgroundResource(R.drawable.unselect_rikshaw);
            btn_smart.setBackgroundResource(R.drawable.unselect_smart);
            btn_bus.setBackgroundResource(R.drawable.minibus);
            btn_taxi.setBackgroundResource(R.drawable.unselect_taxi);

            initlist_bus();

            main_content.setVisibility(View.GONE);
            rv_book_ride_2.setVisibility(View.VISIBLE);
            lay_smart.setVisibility(View.GONE);
        });

        btn_taxi.setOnClickListener(view -> {
            btn_auto.setBackgroundResource(R.drawable.unselect_auto);
            btn_rikshaw.setBackgroundResource(R.drawable.unselect_rikshaw);
            btn_smart.setBackgroundResource(R.drawable.unselect_smart);
            btn_bus.setBackgroundResource(R.drawable.unselect_bus);
            btn_taxi.setBackgroundResource(R.drawable.taxi);

            main_content.setVisibility(View.VISIBLE);
            rv_book_ride_2.setVisibility(View.GONE);
            lay_smart.setVisibility(View.GONE);
        });

        btn_smart_book.setOnClickListener(view -> {


            Intent i=new Intent(Book_ride_2_lastmile.this,Book_ride_3_last.class);
            i.putExtra("destination",tv_destination_address.getText().toString());
            startActivity(i);


        });


    }

    private void setupViewPager(ViewPager viewPager) {


        Adapter adapter = new Adapter(getSupportFragmentManager());
        adapter.addFragment(new ola(), "OLA");
        adapter.addFragment(new uber(), "UBER");

        viewPager.setAdapter(adapter);



    }

    static class Adapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public Adapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
