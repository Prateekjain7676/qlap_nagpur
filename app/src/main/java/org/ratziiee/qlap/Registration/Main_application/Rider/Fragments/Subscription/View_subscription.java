package org.ratziiee.qlap.Registration.Main_application.Rider.Fragments.Subscription;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.ratziiee.qlap.R;
import org.ratziiee.qlap.Registration.Utils.utils;

public class View_subscription extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_subscription);

        TextView toolbar_title=findViewById(R.id.toolbar_title);
        toolbar_title.setText("My Subscription");
        utils utils=new utils();
        utils.change_status_bar_color(this,this);

    }
}
