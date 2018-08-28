package org.ratziiee.qlap.Registration.Main_application.Rider.Fragments.Book_ride;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.ratziiee.qlap.R;
import org.ratziiee.qlap.Registration.Main_application.Rider.Fragments.MyCards.availeble_balance;
import org.ratziiee.qlap.Registration.Main_application.Rider.Fragments.MyCards.payment_options;
import org.ratziiee.qlap.Registration.Utils.utils;

public class Book_ride_4 extends AppCompatActivity {

    TextView tv_reach_pickup_point,tv_recharge_metro_card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_ride_4);

        tv_reach_pickup_point=findViewById(R.id.tv_reach_pickup_point);
        tv_recharge_metro_card=findViewById(R.id.tv_metro_card_recharge);

        TextView toolbar_title=findViewById(R.id.toolbar_title);
        toolbar_title.setText("Book Ride");
        utils utils=new utils();
        utils.change_status_bar_color(this,this);

        tv_reach_pickup_point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Book_ride_4.this,Pick_up_point_mapbox.class);
                startActivity(i);
            }
        });

        tv_recharge_metro_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Book_ride_4.this,availeble_balance.class);
                startActivity(i);
            }
        });
    }
}
