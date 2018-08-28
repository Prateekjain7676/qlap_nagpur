package org.ratziiee.qlap.Registration.Main_application.Rider.Fragments.Subscription.Create_subscription;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.ratziiee.qlap.R;
import org.ratziiee.qlap.Registration.Main_application.Rider.Fragments.Book_ride.Pick_up_point_mapbox;
import org.ratziiee.qlap.Registration.Main_application.Rider.main_application;
import org.ratziiee.qlap.Registration.Utils.utils;

public class subscription_confirmation extends AppCompatActivity {

    Button btn_done;
    TextView tv_view_pickup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscription_confirmation);

        btn_done=findViewById(R.id.btn_done);
        tv_view_pickup=findViewById(R.id.tv_view_pickup);

        TextView toolbar_title=findViewById(R.id.toolbar_title);
        toolbar_title.setText("Subscription Confirmation");
        utils utils=new utils();
        utils.change_status_bar_color(this,this);

        tv_view_pickup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(subscription_confirmation.this, Pick_up_point_mapbox.class);
                i.putExtra("pick_up_subscription",1);
                startActivity(i);
            }
        });
        btn_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(subscription_confirmation.this, main_application.class);
                startActivity(i);
            }
        });

    }
}
