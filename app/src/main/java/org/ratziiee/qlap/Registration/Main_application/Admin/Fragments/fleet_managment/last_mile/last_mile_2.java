package org.ratziiee.qlap.Registration.Main_application.Admin.Fragments.fleet_managment.last_mile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.ratziiee.qlap.R;
import org.ratziiee.qlap.Registration.Utils.utils;

public class last_mile_2 extends AppCompatActivity {

    Button btn_done;
    TextView tv_title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_mile_2);

        TextView toolbar_title=findViewById(R.id.toolbar_title);
        toolbar_title.setText("Fleet Management");
        utils utils=new utils();
        utils.change_status_bar_color(this,this);
        btn_done=findViewById(R.id.btn_done);

        tv_title=findViewById(R.id.tv_title);
        tv_title.setText(getIntent().getStringExtra("title"));

        btn_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(last_mile_2.this,fleet_last_mile_3.class);
                startActivity(i);
            }
        });
    }
}
