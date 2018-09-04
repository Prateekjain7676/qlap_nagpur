package org.ratziiee.qlap.Registration.Registration.Admin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.ratziiee.qlap.R;
import org.ratziiee.qlap.Registration.Registration.Driver.Registration_driver;
import org.ratziiee.qlap.Registration.Registration.Driver.registartion_password_driver;
import org.ratziiee.qlap.Registration.Utils.utils;

public class Registration_admin extends AppCompatActivity {

    Button btn_next;
    TextView tv_toolbar_title;
    EditText et_name,et_mobile,et_email,et_admin_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration2);

        tv_toolbar_title=findViewById(R.id.toolbar_title);

        utils utils=new utils();
        utils.change_status_bar_color(this,this);
        tv_toolbar_title.setText("Welcome Driver");
        btn_next =findViewById(R.id.btn_next);
        et_admin_id=findViewById(R.id.et_admin_id);
        et_name=findViewById(R.id.et_username);
        et_mobile=findViewById(R.id.et_mobile_no);
        et_email=findViewById(R.id.et_email_address);

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Registration_admin.this,Password_admin.class);
                startActivity(i);
            }
        });
    }
}
