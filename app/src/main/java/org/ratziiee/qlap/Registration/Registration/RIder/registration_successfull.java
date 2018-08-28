package org.ratziiee.qlap.Registration.Registration.RIder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.ratziiee.qlap.R;
import org.ratziiee.qlap.Registration.Main_application.Rider.main_application;
import org.ratziiee.qlap.Registration.Utils.utils;

public class registration_successfull extends AppCompatActivity {

    Button btn_continue;
    TextView tv_toolbar_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_successfull);


        tv_toolbar_title=findViewById(R.id.toolbar_title);

        utils utils=new utils();
        utils.change_status_bar_color(this,this);
        tv_toolbar_title.setText("Welcome Rider");
        btn_continue=findViewById(R.id.btn_continue);

        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(registration_successfull.this,main_application.class);
                startActivity(i);
            }
        });
    }
}
