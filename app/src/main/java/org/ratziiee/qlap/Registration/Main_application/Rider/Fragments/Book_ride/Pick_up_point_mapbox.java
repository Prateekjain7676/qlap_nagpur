package org.ratziiee.qlap.Registration.Main_application.Rider.Fragments.Book_ride;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.annotations.Marker;
import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;

import org.ratziiee.qlap.R;
import org.ratziiee.qlap.Registration.Utils.AppConstants;
import org.ratziiee.qlap.Registration.Utils.utils;

public class Pick_up_point_mapbox extends AppCompatActivity {
    private MapView mapView;
    Button btn_done;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_up_point_mapbox);

        Mapbox.getInstance(this, AppConstants.MAP_BOX_API);
        mapView=findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);



        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(MapboxMap mapboxMap) {

            mapboxMap.addMarker(new MarkerOptions().position(new LatLng(28.7149,77.1154)));
            }
        });

        btn_done=findViewById(R.id.btn_done);
        btn_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Pick_up_point_mapbox.this,book_ride_5.class);
                startActivity(i);
            }
        });

        int i=getIntent().getIntExtra("pick_up_subscription",0);
        if(i==1)
        {
            btn_done.setVisibility(View.GONE);
        }

        TextView toolbar_title=findViewById(R.id.toolbar_title);
        toolbar_title.setText("Subscription Confirmation");
        utils utils=new utils();
        utils.change_status_bar_color(this,this);
    }

    @Override
    public void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }
}
