package org.ratziiee.qlap.Registration.Registration.RIder;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.ratziiee.qlap.R;
import org.ratziiee.qlap.Registration.Utils.utils;

public class Registration extends AppCompatActivity {

    Button btn_save;
    TextView tv_toolbar_title,top,tv_hindi,tv_eng;
    EditText et_name,et_mobile,et_email,et_metro_card,et_address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);


        tv_toolbar_title=findViewById(R.id.toolbar_title);

        utils utils=new utils();
        utils.change_status_bar_color(this,this);
        tv_toolbar_title.setText("Welcome Rider");
        btn_save=findViewById(R.id.btn_save);
        et_address=findViewById(R.id.et_address);
        et_name=findViewById(R.id.et_username);
        et_mobile=findViewById(R.id.et_mobile_no);
        et_email=findViewById(R.id.et_email_address);
        et_metro_card=findViewById(R.id.et_metro_Card);
        top=findViewById(R.id.top);
        tv_eng=findViewById(R.id.tv_eng);
        tv_hindi=findViewById(R.id.tv_hindi);


        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if(et_name.getText().length()>0)
//                {
//                    if(et_mobile.getText().length()==10)
//                    {
//                        if(et_email.getText().length()>0)
//                        {
//                         if(et_metro_card.getText().length()==8)
//                         {
//                             if(et_address.getText().length()>0)
//                             {
                                 Intent i=new Intent(Registration.this, registartion_password.class);
                                 startActivity(i);
//                             }
//                             else
//                             {
//                                 et_address.setError("Cannot be empty");
//                             }
//                         }
//                         else
//                         {
//                             et_metro_card.setError("Invalid Metro Card");
//                         }
//                        }
//                        else
//                        {
//                            et_email.setError("Cannot be empty");
//                        }
//                    }
//                    else
//                    {
//                        et_mobile.setError("Invalid Mobile Number");
//                    }
//                }
//                else
//                {
//                    et_name.setError("Cannot be emptyx");
//                }
//
            }
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
        tv_toolbar_title.setText(R.string.hindi_welcome_driver);
        top.setText(R.string.hindi_registration);
        et_metro_card.setHint(R.string.hindi_metro_card);
        et_address.setHint(R.string.hindi_address_rider);



    }

    private void eng()
    {
        et_name.setHint(R.string.eng_name);
        et_mobile.setHint(R.string.eng_mobile);
        et_email.setHint(R.string.eng_email);
        tv_toolbar_title.setText(R.string.eng_welcome_driver);
        top.setText(R.string.eng_registration);
        et_metro_card.setHint(R.string.eng_metro_card);
        et_address.setHint(R.string.eng_address_rider);



    }

}
