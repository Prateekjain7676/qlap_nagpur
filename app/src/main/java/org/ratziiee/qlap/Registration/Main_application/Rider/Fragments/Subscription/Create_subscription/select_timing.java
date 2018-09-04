package org.ratziiee.qlap.Registration.Main_application.Rider.Fragments.Subscription.Create_subscription;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.ratziiee.qlap.R;
import org.ratziiee.qlap.Registration.Utils.utils;

public class select_timing extends AppCompatActivity {

    ImageView iv_1,iv_2,iv_3,iv_4;
    Button btn_done;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_timing);

        iv_1=findViewById(R.id.iv_1);
        iv_2=findViewById(R.id.iv_2);
        iv_3=findViewById(R.id.iv_3);
        iv_4=findViewById(R.id.iv_4);
        btn_done=findViewById(R.id.btn_done);
        TextView toolbar_title=findViewById(R.id.toolbar_title);
        toolbar_title.setText("Select Timing");
        utils utils=new utils();
        utils.change_status_bar_color(this,this);

        String heading=getIntent().getStringExtra("heading");

        iv_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_1.setBackgroundResource(R.drawable.checked);
                iv_2.setBackgroundResource(R.drawable.unchecked);
                iv_3.setBackgroundResource(R.drawable.unchecked);
                iv_4.setBackgroundResource(R.drawable.unchecked);

            }
        });

        iv_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_1.setBackgroundResource(R.drawable.unchecked);
                iv_2.setBackgroundResource(R.drawable.checked);
                iv_3.setBackgroundResource(R.drawable.unchecked);
                iv_4.setBackgroundResource(R.drawable.unchecked);

            }
        });

        iv_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_1.setBackgroundResource(R.drawable.unchecked);
                iv_2.setBackgroundResource(R.drawable.unchecked);
                iv_3.setBackgroundResource(R.drawable.checked);
                iv_4.setBackgroundResource(R.drawable.unchecked);

            }
        });

        iv_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_1.setBackgroundResource(R.drawable.unchecked);
                iv_2.setBackgroundResource(R.drawable.unchecked);
                iv_3.setBackgroundResource(R.drawable.unchecked);
                iv_4.setBackgroundResource(R.drawable.checked);

            }
        });

        btn_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(select_timing.this,create_subs_2.class);
                i.putExtra("heading",heading);
                startActivity(i);
            }
        });
    }
}
