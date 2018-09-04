package org.ratziiee.qlap.Registration.Main_application.Rider.Fragments.Subscription.Create_subscription;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.ratziiee.qlap.R;
import org.ratziiee.qlap.Registration.Main_application.Rider.Fragments.Subscription.View_subscription;
import org.ratziiee.qlap.Registration.Utils.utils;

public class create_subs_pre extends AppCompatActivity {

    ImageView iv_first_mile,iv_last_mile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_subs_pre);

        TextView toolbar_title=findViewById(R.id.toolbar_title);
        toolbar_title.setText("Route Subscription");
        utils utils=new utils();
        utils.change_status_bar_color(this,this);

        iv_first_mile=findViewById(R.id.iv_reach_metro);
        iv_last_mile=findViewById(R.id.iv_from_metro);

        iv_first_mile.setOnClickListener(view -> {
            Intent i=new Intent(create_subs_pre.this,Create_subscription.class);
            i.putExtra("top_heading","New Subscription for First Mile");
            startActivity(i);
        });

        iv_last_mile.setOnClickListener(view -> {
            Intent i=new Intent(create_subs_pre.this,Create_subscription.class);
            i.putExtra("top_heading","New Subscription for Last Mile");
            startActivity(i);
        });
    }
}
