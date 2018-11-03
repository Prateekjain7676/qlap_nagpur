package org.ratziiee.qlap.Registration.Registration.Driver;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
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
    TextView tv_toolbar_title,top,tv_hindi,tv_eng;
    EditText et_name,et_mobile,et_email,et_vehicle_no;
    Spinner spn_vehicle_Category;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_driver);


        tv_toolbar_title=findViewById(R.id.toolbar_title);
        tv_hindi=findViewById(R.id.tv_hindi);

        utils utils=new utils();
        utils.change_status_bar_color(this,this);
        tv_toolbar_title.setText("Welcome Driver");
        btn_next =findViewById(R.id.btn_next);
        et_vehicle_no=findViewById(R.id.et_vehicle_no);
        et_name=findViewById(R.id.et_username);
        et_mobile=findViewById(R.id.et_mobile_no);
        et_email=findViewById(R.id.et_email_address);
        spn_vehicle_Category=findViewById(R.id.spn_vehicle_category);
        top=findViewById(R.id.top);
        tv_eng=findViewById(R.id.tv_eng);


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

        tv_hindi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hindi();
                tv_eng.setVisibility(View.VISIBLE);
                tv_hindi.setVisibility(View.GONE);
            }
        });

        tv_eng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eng();
                tv_eng.setVisibility(View.GONE);
                tv_hindi.setVisibility(View.VISIBLE);
            }
        });



    }



    private void hindi()
    {
        et_name.setHint(R.string.hindi_name);
        et_mobile.setHint(R.string.hindi_mobile);
        et_email.setHint(R.string.hindi_email);
        et_vehicle_no.setHint(R.string.hindi_vehice_no);
        tv_toolbar_title.setText(R.string.hindi_welcome_driver);
        top.setText(R.string.hindi_registration);

        String[] array=getResources().getStringArray(R.array.hindi_vehicle_category);
        ArrayAdapter adapter=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,array);

        spn_vehicle_Category.setAdapter(adapter);

    }

    private void eng()
    {
        et_name.setHint(R.string.eng_name);
        et_mobile.setHint(R.string.eng_mobile);
        et_email.setHint(R.string.eng_email);
        et_vehicle_no.setHint(R.string.eng_vehice_no);
        tv_toolbar_title.setText(R.string.eng_welcome_driver);
        top.setText(R.string.eng_registration);

        String[] array=getResources().getStringArray(R.array.vehicle_category);
        ArrayAdapter adapter=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,array);

        spn_vehicle_Category.setAdapter(adapter);

    }



}
