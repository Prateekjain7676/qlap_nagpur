package org.ratziiee.qlap.Registration.Main_application.Rider.Fragments.Subscription.Create_subscription;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import org.ratziiee.qlap.R;
import org.ratziiee.qlap.Registration.Utils.utils;

public class Create_subscription extends AppCompatActivity {

    Button btn_next;
    Spinner spn_Selection,spn_route;
    ArrayAdapter adapter;
    LinearLayout lay_route;
    TextView tv_location;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_subscription);

        btn_next=findViewById(R.id.btn_next);
        spn_Selection=findViewById(R.id.spn_Selection);
        spn_route=findViewById(R.id.spn_route);
        lay_route=findViewById(R.id.lay_route);
        tv_location=findViewById(R.id.tv_location);
        TextView toolbar_title=findViewById(R.id.toolbar_title);
        toolbar_title.setText("Route Subscription");
        utils utils=new utils();
        utils.change_status_bar_color(this,this);


        spn_Selection.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i>0)
                {
                    lay_route.setVisibility(View.VISIBLE);
                    if(spn_Selection.getSelectedItemPosition()==1)
                    {
                        String[] array={"Select your destination metro station","Kohat","Rohini","Pitampura"};
                        adapter=new ArrayAdapter<>(Create_subscription.this,R.layout.support_simple_spinner_dropdown_item,array);
                        spn_route.setAdapter(adapter);
                        tv_location.setText("SELECT ORIGIN LOCATION");
                    }
                    else if(spn_Selection.getSelectedItemPosition()==2)
                    {
                        String[] array={"Select your origin metro station","Kohat","Rohini","Pitampura"};
                        adapter=new ArrayAdapter<>(Create_subscription.this,R.layout.support_simple_spinner_dropdown_item,array);
                        spn_route.setAdapter(adapter);
                        tv_location.setText("SELECT DESTINATION LOCATION");
                    }
                }
                else
                {
                    lay_route.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(Create_subscription.this,Create_subs_1.class);
                startActivity(i);
            }
        });
    }
}
