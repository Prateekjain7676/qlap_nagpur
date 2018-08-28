package org.ratziiee.qlap.Registration.Main_application.Rider.Fragments.MyCards;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.ratziiee.qlap.R;
import org.ratziiee.qlap.Registration.Utils.utils;

public class payment_options extends AppCompatActivity {

    ImageView iv_paytm,iv_tez,iv_bhim,iv_phone_pe,iv_buddy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_options);

        iv_paytm=findViewById(R.id.iv_paytm);
        iv_tez=findViewById(R.id.iv_tez);
        iv_bhim=findViewById(R.id.iv_bhim);
        iv_phone_pe=findViewById(R.id.iv_phone_pe);
        iv_buddy=findViewById(R.id.iv_buddy);

        TextView toolbar_title=findViewById(R.id.toolbar_title);
        toolbar_title.setText("Mode of Payment");
        utils utils=new utils();
        utils.change_status_bar_color(this,this);

        iv_buddy.setOnClickListener(view -> {
            Intent i=new Intent(payment_options.this,final_payment.class);
            i.putExtra("payment_mode",1);
            startActivity(i);
        });

        iv_paytm.setOnClickListener(view -> {
            Intent i=new Intent(payment_options.this,final_payment.class);
            i.putExtra("payment_mode",2);
            startActivity(i);
        });

        iv_bhim.setOnClickListener(view -> {
            Intent i=new Intent(payment_options.this,final_payment.class);
            i.putExtra("payment_mode",3);
            startActivity(i);
        });

        iv_phone_pe.setOnClickListener(view -> {
            Intent i=new Intent(payment_options.this,final_payment.class);
            i.putExtra("payment_mode",4);
            startActivity(i);
        });

        iv_tez.setOnClickListener(view -> {
            Intent i=new Intent(payment_options.this,final_payment.class);
            i.putExtra("payment_mode",5);
            startActivity(i);
        });
    }
}
