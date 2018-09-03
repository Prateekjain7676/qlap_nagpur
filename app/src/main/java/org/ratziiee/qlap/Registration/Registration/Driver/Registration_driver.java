package org.ratziiee.qlap.Registration.Registration.Driver;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.ratziiee.qlap.R;
import org.ratziiee.qlap.Registration.Main_application.Driver.driver_navigation;
import org.ratziiee.qlap.Registration.Registration.RIder.registartion_password;
import org.ratziiee.qlap.Registration.Registration.RIder.registration_successfull;
import org.ratziiee.qlap.Registration.Utils.utils;

public class Registration_driver extends AppCompatActivity {

    Button btn_next;
    TextView tv_toolbar_title;
    EditText et_name,et_mobile,et_email,et_vehicle_no;
    Spinner spn_vehicle_Category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_driver);


        tv_toolbar_title=findViewById(R.id.toolbar_title);

        utils utils=new utils();
        utils.change_status_bar_color(this,this);
        tv_toolbar_title.setText("Welcome Driver");
        btn_next =findViewById(R.id.btn_next);
        et_vehicle_no=findViewById(R.id.et_vehicle_no);
        et_name=findViewById(R.id.et_username);
        et_mobile=findViewById(R.id.et_mobile_no);
        et_email=findViewById(R.id.et_email_address);
        spn_vehicle_Category=findViewById(R.id.spn_vehicle_category);


        btn_next.setOnClickListener(view -> {
//            if(et_name.getText().length()>0)
//            {
//                if(et_mobile.getText().length()==10)
//                {
//                    if(et_email.getText().length()>0)
//                    {
//                     if(spn_vehicle_Category.getSelectedItemPosition()>0)
//                     {
//                         if(et_vehicle_no.getText().length()>0)
//                         {
                             Intent i=new Intent(Registration_driver.this,registartion_password_driver.class);
                             startActivity(i);
//                         }
//                         else
//                         {
//                             et_vehicle_no.setError("Cannot be empty");
//                         }
//                     }
//                     else
//                     {
//                         Toast.makeText(Registration_driver.this, "Vehicle Category is mandatory...!!!", Toast.LENGTH_SHORT).show();
//                     }
//                    }
//                    else
//                    {
//                        et_email.setError("Cannot be empty");
//                    }
//                }
//                else
//                {
//                    et_mobile.setError("Invalid Mobile Number");
//                }
//            }
//            else
//            {
//                et_name.setError("Cannot be empty");
//            }

        });

    }
}
