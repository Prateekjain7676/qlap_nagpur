package org.ratziiee.qlap.Registration.Main_application.Admin.Fragments.fleet_managment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.ratziiee.qlap.R;
import org.ratziiee.qlap.Registration.Utils.utils;

public class Fleet_managment_2 extends AppCompatActivity {

    Button btn_save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fleet_managment_2);

        TextView toolbar_title=findViewById(R.id.toolbar_title);
        toolbar_title.setText("Fleet Managment");
        utils utils=new utils();
        utils.change_status_bar_color(this,this);
        btn_save=findViewById(R.id.btn_save);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Fleet_managment_2.this,Fleet_managment_3.class);
                startActivity(i);
            }
        });
    }
}
