package org.ratziiee.qlap.Registration.Main_application.Rider.Fragments.Subscription.Create_subscription;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.ratziiee.qlap.R;
import org.ratziiee.qlap.Registration.Utils.utils;

public class Create_subs_1 extends AppCompatActivity {

    Button btn_next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_subs_1);

        TextView toolbar_title=findViewById(R.id.toolbar_title);
        toolbar_title.setText("Route Subscription");
        utils utils=new utils();
        utils.change_status_bar_color(this,this);

        btn_next=findViewById(R.id.btn_next);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Create_subs_1.this,create_subs_2.class);
                startActivity(i);
            }
        });
    }
}
