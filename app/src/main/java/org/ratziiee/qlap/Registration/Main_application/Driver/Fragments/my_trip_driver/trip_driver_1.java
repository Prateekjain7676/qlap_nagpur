package org.ratziiee.qlap.Registration.Main_application.Driver.Fragments.my_trip_driver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.ratziiee.qlap.R;
import org.ratziiee.qlap.Registration.Utils.utils;

import static android.view.View.GONE;

public class trip_driver_1 extends AppCompatActivity {

    Button btn_start_trip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_driver_1);

        TextView toolbar_title=findViewById(R.id.toolbar_title);
        toolbar_title.setText("My RIDE");
        utils utils=new utils();
        utils.change_status_bar_color(this,this);

        btn_start_trip=findViewById(R.id.btn_satrt);
        btn_start_trip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(trip_driver_1.this,trip_driver_2.class);
                startActivity(i);
            }
        });


        int unique_id=getIntent().getIntExtra("id",0);
        if(unique_id==0)
        {
            btn_start_trip.setVisibility(GONE);

        }
    }
}
