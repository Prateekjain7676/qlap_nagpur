package org.ratziiee.qlap.Registration.Main_application.Rider.Fragments.Book_ride;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import org.ratziiee.qlap.R;
import org.ratziiee.qlap.Registration.Utils.utils;

public class book_ride_5 extends AppCompatActivity implements OnMapReadyCallback {

    Button btn_continue;
    private GoogleMap mMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_ride_5);

        TextView toolbar_title=findViewById(R.id.toolbar_title);
        toolbar_title.setText("Ride in progress");
        utils utils=new utils();
        utils.change_status_bar_color(this,this);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        btn_continue=findViewById(R.id.btn_continue);
        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(book_ride_5.this,book_ride_6.class);
                startActivity(i);
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.addMarker(new MarkerOptions().position(new LatLng(21.14811,79.06984)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(21.14623,79.06438)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(21.146386,79.067506),15.0f));
        PolylineOptions option=new PolylineOptions();
        LatLng lat1=new LatLng(21.14811,79.06984);
        LatLng lat2=new LatLng(21.14868, 79.07011);
        LatLng lat3=new LatLng(21.14868,79.07011);
        LatLng lat4=new LatLng(21.14923, 79.06874);

        LatLng lat5=new LatLng(21.14944,79.06796);
        LatLng lat6=new LatLng(21.1496, 79.06693);
        LatLng lat7=new LatLng(21.1496,79.06693);
        LatLng lat8=new LatLng(21.1481, 79.06682);

        LatLng lat9=new LatLng(21.1481,79.06682);
        LatLng lat10=new LatLng(21.14805, 79.06673);
        LatLng lat11=new LatLng(21.14826,79.06543);
        LatLng lat12=new LatLng(21.14826, 79.06543);

        LatLng lat13=new LatLng(21.14639,79.06546);
        LatLng lat14=new LatLng(21.14639, 79.06546);
        LatLng lat15=new LatLng(21.1464,79.06467);
        LatLng lat16=new LatLng(21.14643, 79.0644);

        LatLng lat17=new LatLng(21.14643,79.0644);
        LatLng lat18=new LatLng(21.14623, 79.06438);

        option.add(lat1);
        option.add(lat2);
        option.add(lat3);
        option.add(lat4);
        option.add(lat5);
        option.add(lat6);
        option.add(lat7);
        option.add(lat8);
        option.add(lat9);
        option.add(lat10);
        option.add(lat11);
        option.add(lat12);
        option.add(lat13);
        option.add(lat14);
        option.add(lat15);
        option.add(lat16);
        option.add(lat17);
        option.add(lat18);


        mMap.addPolyline(option);
    }

}
