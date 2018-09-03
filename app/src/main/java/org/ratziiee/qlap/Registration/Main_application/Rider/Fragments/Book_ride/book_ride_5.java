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

        mMap.addMarker(new MarkerOptions().position(new LatLng(28.7149,77.1154)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(28.713538,77.120324)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(28.7149,77.1154),15.0f));
        PolylineOptions option=new PolylineOptions();
        LatLng lat1=new LatLng(28.713538,77.120324);
        LatLng lat2=new LatLng(28.712257,77.119088);
        LatLng lat3=new LatLng(28.714785,77.115368);
        option.add(lat1);
        option.add(lat2);
        option.add(lat3);

        mMap.addPolyline(option);
    }

}
