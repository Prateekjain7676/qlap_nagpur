package org.ratziiee.qlap.Registration.Main_application.Admin.Fragments.fleet_managment.last_mile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.ratziiee.qlap.R;
import org.ratziiee.qlap.Registration.Main_application.Admin.Admin;
import org.ratziiee.qlap.Registration.Utils.utils;

public class last_mile_increase_fleet extends AppCompatActivity {

    Button btn_done;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_mile_increase_fleet);

        TextView toolbar_title=findViewById(R.id.toolbar_title);
        toolbar_title.setText("Fleet Management");
        utils utils=new utils();
        utils.change_status_bar_color(this,this);

        btn_done=findViewById(R.id.btn_done);

        btn_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(last_mile_increase_fleet.this,fleet_last_mile_3.class);
                startActivity(i);
            }
        });


    }

    @Override
    public void onBackPressed() {
        Intent i=new Intent(last_mile_increase_fleet.this,Admin.class);
        startActivity(i);
    }
}
