package org.ratziiee.qlap.Registration.Main_application.Rider.Fragments.Subscription.Create_subscription;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.ratziiee.qlap.R;
import org.ratziiee.qlap.Registration.Utils.utils;

public class create_subs_2 extends AppCompatActivity {

    Button btn_confirm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_subs_2);

        TextView toolbar_title=findViewById(R.id.toolbar_title);
        toolbar_title.setText("Route Subscription");
        utils utils=new utils();
        utils.change_status_bar_color(this,this);
        btn_confirm=findViewById(R.id.btn_confirm);
        btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(create_subs_2.this,subscription_confirmation.class);
                startActivity(i);
            }
        });
    }
}
