package org.ratziiee.qlap.Registration.Main_application.Admin.Fragments.fleet_managment.last_mile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.ratziiee.qlap.R;
import org.ratziiee.qlap.Registration.Utils.utils;

public class fleet_last_mile extends AppCompatActivity {

    LinearLayout lay_jims,lay_crown,lay_salokaya,lay_church,lay_tulip,lay_dda,lay_iskon,lay_rithala;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fleet_last_mile);

        TextView toolbar_title=findViewById(R.id.toolbar_title);
        toolbar_title.setText("Fleet Management");
        utils utils=new utils();
        utils.change_status_bar_color(this,this);

        lay_jims=findViewById(R.id.lay_jims);
        lay_crown=findViewById(R.id.lay_crown);
        lay_salokaya=findViewById(R.id.lay_salokaya);
        lay_church=findViewById(R.id.lay_church);
        lay_tulip=findViewById(R.id.lay_tulip);
        lay_dda=findViewById(R.id.lay_dda);
        lay_iskon=findViewById(R.id.lay_iskon);
        lay_rithala=findViewById(R.id.lay_rithala);


        lay_jims.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(fleet_last_mile.this,last_mile_2.class);
                i.putExtra("title","Jims College");
                startActivity(i);
            }
        });

        lay_crown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(fleet_last_mile.this,last_mile_2.class);
                i.putExtra("title","Crown Plaza");
                startActivity(i);
            }
        });

        lay_salokaya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(fleet_last_mile.this,last_mile_2.class);
                i.putExtra("title","Salokaya Nursing College");
                startActivity(i);
            }
        });

        lay_church.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(fleet_last_mile.this,last_mile_2.class);
                i.putExtra("title","Church");
                startActivity(i);
            }
        });

        lay_tulip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(fleet_last_mile.this,last_mile_2.class);
                i.putExtra("title","Tulip School");
                startActivity(i);
            }
        });

        lay_dda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(fleet_last_mile.this,last_mile_2.class);
                i.putExtra("title","DDA  Park");
                startActivity(i);
            }
        });

        lay_iskon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(fleet_last_mile.this,last_mile_2.class);
                i.putExtra("title","ISKON Temple");
                startActivity(i);
            }
        });

        lay_rithala.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(fleet_last_mile.this,last_mile_2.class);
                i.putExtra("title","Rithala Power Plant");
                startActivity(i);
            }
        });
    }
}
