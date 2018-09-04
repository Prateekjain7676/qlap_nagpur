package org.ratziiee.qlap.Registration.Main_application.Rider.Fragments.Book_ride;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.ratziiee.qlap.R;
import org.ratziiee.qlap.Registration.Utils.utils;

public class Book_ride_3 extends AppCompatActivity {

    Button btn_book;
    TextView tv_view_on_map,tv_destination;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_ride_3);

        btn_book=findViewById(R.id.btn_book);
        tv_destination=findViewById(R.id.tv_destination);
        tv_view_on_map=findViewById(R.id.tv_view_on_map);
        TextView toolbar_title=findViewById(R.id.toolbar_title);
        toolbar_title.setText("Book Ride");
        utils utils=new utils();
        utils.change_status_bar_color(this,this);


        String destination=getIntent().getStringExtra("destination");
        tv_destination.setText(destination);
        btn_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Book_ride_3.this,Book_ride_4.class);
                startActivity(i);
            }
        });

        tv_view_on_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Book_ride_3.this,Pick_up_point_mapbox.class);
                i.putExtra("pick_up_subscription",1);
                startActivity(i);
            }
        });

    }
}
