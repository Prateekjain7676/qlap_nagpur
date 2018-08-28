package org.ratziiee.qlap.Registration.Main_application.Rider.Fragments.Subscription;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.ratziiee.qlap.R;
import org.ratziiee.qlap.Registration.Main_application.Rider.Fragments.Subscription.Create_subscription.Create_subscription;
import org.ratziiee.qlap.Registration.Utils.utils;

public class Subscription_activity extends AppCompatActivity {
    TextView tv_view_subscription,tv_create_subscription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscription_activity);

        TextView toolbar_title=findViewById(R.id.toolbar_title);
        toolbar_title.setText("Route Subscription");
        utils utils=new utils();
        utils.change_status_bar_color(this,this);

        tv_view_subscription=findViewById(R.id.tv_view_subscription);
        tv_create_subscription=findViewById(R.id.tv_create_subscription);
        tv_view_subscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Subscription_activity.this,View_subscription.class);
                startActivity(i);
            }
        });

        tv_create_subscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Subscription_activity.this,Create_subscription.class);
                startActivity(i);
            }
        });
    }
}
