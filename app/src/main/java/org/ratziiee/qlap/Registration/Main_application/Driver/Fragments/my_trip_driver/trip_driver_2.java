package org.ratziiee.qlap.Registration.Main_application.Driver.Fragments.my_trip_driver;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.camera.CameraUpdate;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;

import org.ratziiee.qlap.R;
import org.ratziiee.qlap.Registration.Main_application.Driver.driver_navigation;
import org.ratziiee.qlap.Registration.Utils.AppConstants;
import org.ratziiee.qlap.Registration.Utils.CustomDIlaog.DialogInterface;
import org.ratziiee.qlap.Registration.Utils.utils;

public class trip_driver_2 extends AppCompatActivity {

    private MapView mapView;
    private AlertDialog b;
    Button btn_end_trip,btn_validate_rider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_driver_2);


        TextView toolbar_title=findViewById(R.id.toolbar_title);
        toolbar_title.setText("My Trip");
        utils utils=new utils();
        utils.change_status_bar_color(this,this);
        btn_end_trip=findViewById(R.id.btn_end_trip);
        btn_validate_rider=findViewById(R.id.btn_validate_rider);
        Mapbox.getInstance(this, AppConstants.MAP_BOX_API);
        mapView=findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);

        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(MapboxMap mapboxMap) {

                mapboxMap.addMarker(new MarkerOptions().position(new LatLng(28.7149,77.1154)));
                mapboxMap.moveCamera(com.mapbox.mapboxsdk.camera.CameraUpdateFactory.newLatLng(new LatLng(28.7149,77.1154)));


            }
        });

        btn_end_trip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showChangeLangDialog(trip_driver_2.this,trip_driver_2.this,"Are you want to end trip?",1);
            }
        });

        btn_validate_rider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate_dialog();
            }
        });

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

    public void showChangeLangDialog(final Context context, Activity activity, String DialogMessage, final int uniqueId) {

        final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
        LayoutInflater inflater = activity.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.customdialog, null);
        dialogBuilder.setView(dialogView);
        dialogBuilder.setCancelable(true);
        final Button yes=(Button)dialogView.findViewById(R.id.btn_yes);
        final Button no=(Button)dialogView.findViewById(R.id.btn_no);
        TextView tv_dialog=(TextView)dialogView.findViewById(R.id.tv_dialog);
        tv_dialog.setText(DialogMessage);

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(context, "Trip is successfully ended...", Toast.LENGTH_SHORT).show();
                Intent i=new Intent(trip_driver_2.this, driver_navigation.class);
                startActivity(i);

            }
        });

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b.dismiss();

            }
        });


        b = dialogBuilder.create();
        b.show();

    }

    public void validate_dialog() {

        final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.validate_dialog, null);
        dialogBuilder.setView(dialogView);
        dialogBuilder.setCancelable(true);
        final Button validate=(Button)dialogView.findViewById(R.id.btn_validate);
        final EditText et_ride_id=dialogView.findViewById(R.id.et_ride_id);
        validate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(et_ride_id.getText().length()==8) {
                    Toast.makeText(trip_driver_2.this, "Successfully verified...", Toast.LENGTH_SHORT).show();
                    b.dismiss();
                }
                else
                {
                    Toast.makeText(trip_driver_2.this, "Please enter correct Ride ID...", Toast.LENGTH_SHORT).show();
                }
                
            }
        });

        b = dialogBuilder.create();
        b.show();

    }
}
