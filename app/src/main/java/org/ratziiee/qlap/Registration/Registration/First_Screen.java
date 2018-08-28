package org.ratziiee.qlap.Registration.Registration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.ratziiee.qlap.R;
import org.ratziiee.qlap.Registration.Registration.Driver.Registration_driver;
import org.ratziiee.qlap.Registration.Registration.RIder.Registration;
import org.ratziiee.qlap.Registration.Utils.utils;

public class First_Screen extends AppCompatActivity {

    Button btn_driver,btn_rider;
    TextView tv_toolbar_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        utils utils=new utils();
        utils.change_status_bar_color(this,this);
        listner();
    }

    private void initViews()
    {
        btn_driver=findViewById(R.id.btn_driver);
        btn_rider=findViewById(R.id.btn_rider);
        tv_toolbar_title=findViewById(R.id.toolbar_title);

        tv_toolbar_title.setText("QLAP");
    }

    private void listner()
    {
        btn_rider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(First_Screen.this, "Rider", Toast.LENGTH_SHORT).show();
                Intent i=new Intent(First_Screen.this,Registration.class);
                startActivity(i);
            }
        });

        btn_driver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(First_Screen.this, "Driver", Toast.LENGTH_SHORT).show();
                Intent i=new Intent(First_Screen.this,Registration_driver.class);
                startActivity(i);
            }
        });
    }
}
