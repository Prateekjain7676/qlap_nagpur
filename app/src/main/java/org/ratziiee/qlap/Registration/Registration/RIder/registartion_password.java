package org.ratziiee.qlap.Registration.Registration.RIder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.ratziiee.qlap.R;
import org.ratziiee.qlap.Registration.Utils.utils;

public class registartion_password extends AppCompatActivity {
    Button btn_submit;
    TextView tv_toolbar_title;
    EditText et_password,et_repassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registartion_password);

        utils utils=new utils();
        utils.change_status_bar_color(this,this);

        tv_toolbar_title=findViewById(R.id.toolbar_title);
        et_password=findViewById(R.id.et_password);
        et_repassword=findViewById(R.id.et_repassword);

        tv_toolbar_title.setText("Welcome Rider");

        btn_submit=findViewById(R.id.btn_submit);
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(et_password.getText().length()>0)
                {
                    if(et_repassword.getText().length()>0)
                    {
                        String pass=et_password.getText().toString().trim();
                        String repass=et_repassword.getText().toString().trim();

                        if(pass.equalsIgnoreCase(repass))
                        {
                            Intent i=new Intent(registartion_password.this,registration_successfull.class);
                            startActivity(i);
                        }
                        else
                        {
                            et_password.setError("Password not matched");
                            et_repassword.setError("Password not matched");
                        }
                    }
                    else
                    {
                        et_repassword.setError("Cannot be empty");
                    }

                }
                else
                {
                    et_password.setError("Cannot be empty");
                }

                Intent i=new Intent(registartion_password.this,registration_successfull.class);
                startActivity(i);

            }
        });

    }
}
