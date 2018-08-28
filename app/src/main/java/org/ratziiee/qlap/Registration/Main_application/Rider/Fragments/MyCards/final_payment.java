package org.ratziiee.qlap.Registration.Main_application.Rider.Fragments.MyCards;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.ratziiee.qlap.R;
import org.ratziiee.qlap.Registration.Main_application.Rider.main_application;
import org.ratziiee.qlap.Registration.Utils.utils;
import org.w3c.dom.Text;

public class final_payment extends AppCompatActivity {

    TextView tv_100,tv_200,tv_500;
    Button btn_add_money;
    EditText et_money;
    ImageView iv_payment;
    String var_payment="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_payment);

        TextView toolbar_title=findViewById(R.id.toolbar_title);
        toolbar_title.setText("Recharge Amount");
        utils utils=new utils();
        utils.change_status_bar_color(this,this);
       tv_100=findViewById(R.id.tv_100);
        tv_200=findViewById(R.id.tv_200);
        tv_500=findViewById(R.id.tv_500);
        et_money=findViewById(R.id.et_money);
        btn_add_money=findViewById(R.id.btn_add_money);
        iv_payment=findViewById(R.id.iv_payment);
        int payment=getIntent().getIntExtra("payment_mode",0);
        if(payment==1)
        {
            iv_payment.setImageResource(R.drawable.buddy);
        }
        else if(payment==2)
        {
            iv_payment.setImageResource(R.drawable.paytm);
        }
        else if(payment==3)
        {
            iv_payment.setImageResource(R.drawable.bhim);
        }
        else if(payment==4)
        {
            iv_payment.setImageResource(R.drawable.phone_pe);
        }
        else if(payment==5)
        {
            iv_payment.setImageResource(R.drawable.tez);
        }

        tv_100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et_money.setText("100");

            }
        });

        tv_200.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et_money.setText("200");

            }
        });

        tv_500.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et_money.setText("500");

            }
        });

        btn_add_money.setOnClickListener(view -> {

            if(et_money.getText().length()>0) {
                Intent i = new Intent(final_payment.this, availeble_balance.class);
                i.putExtra("payment_amt", Integer.parseInt(et_money.getText().toString()));
                startActivity(i);
                Toast.makeText(final_payment.this, "Money Added Successfully...", Toast.LENGTH_SHORT).show();
            }
            else
            {
                et_money.setError("Enter Amount");
            }


        });
    }
}
