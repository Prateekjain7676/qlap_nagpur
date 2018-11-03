package org.ratziiee.qlap.Registration.Main_application.Rider.Fragments.Book_ride;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.ratziiee.qlap.R;

import java.util.Objects;

public class choose_on_map_bookride1 extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    Button btn_select_location;
    LocationCallback callback;
    FusedLocationProviderClient getFusedLocationProviderClient;
    static Location current_location=null;
    private static float zoom_level=20f;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_on_map_bookride1);
        // Obtain the SupportMapFragment and get notified when the hmap is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        btn_select_location=findViewById(R.id.btn_select_location);


    }


    /**
     * Manipulates the hmap once available.
     * This callback is triggered when the hmap is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @SuppressLint("MissingPermission")
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        mMap.addMarker(new MarkerOptions().position(new LatLng(21.146208, 79.064590)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(21.146208, 79.064590), 20.0f));

        btn_select_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hit_current_location();
                Intent i=new Intent(choose_on_map_bookride1.this,Book_ride_1.class);
                i.putExtra("current_lat",21.146208);
                i.putExtra("current_lon",79.064590);
                startActivity(i);

            }
        });
        mMap.setMyLocationEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(false);

        getFusedLocationProviderClient=new FusedLocationProviderClient(this);
        LocationManager locationManager = (LocationManager)getSystemService(LOCATION_SERVICE);
        if(Objects.requireNonNull(locationManager).isProviderEnabled(LocationManager.GPS_PROVIDER))
        {
            startLocationUpdates(1);

        }
        else
        {
            Toast.makeText(this, "GPS is not active...", Toast.LENGTH_SHORT).show();
        }

    }

    @SuppressLint("MissingPermission")
    protected void startLocationUpdates(final int id) {

        // Create the location request to start receiving updates
        LocationRequest mLocationRequest = new LocationRequest();
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        long UPDATE_INTERVAL = 10 * 1000;
        mLocationRequest.setInterval(UPDATE_INTERVAL);
        long FASTEST_INTERVAL = 2000;
        mLocationRequest.setFastestInterval(FASTEST_INTERVAL);

        // Create LocationSettingsRequest object using location request
        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder();
        builder.addLocationRequest(mLocationRequest);
        LocationSettingsRequest locationSettingsRequest = builder.build();

        // Check whether location settings are satisfied
        // https://developers.google.com/android/reference/com/google/android/gms/location/SettingsClient
        SettingsClient settingsClient = LocationServices.getSettingsClient(this);
        settingsClient.checkLocationSettings(locationSettingsRequest);

        // new Google API SDK v11 uses getFusedLocationProviderClient(this)
        callback=new LocationCallback(){
            @Override
            public void onLocationResult(LocationResult locationResult) {
                onLocationChanged(locationResult.getLastLocation(),id);
            }
        };
        getFusedLocationProviderClient.requestLocationUpdates(mLocationRequest,callback,
                Looper.myLooper());



    }

    public void onLocationChanged(Location location, int id) {
        // New location has now been determined

        // You can now create a LatLng Object for use with maps
        current_location=location;
        if(id==1)
        {
            LatLng latLng = new LatLng(current_location.getLatitude(), current_location.getLongitude());
            mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, zoom_level));
            getFusedLocationProviderClient.removeLocationUpdates(callback);
            startLocationUpdates(2);
        }


    }

    private void showGPSDisabledAlertToUser(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("GPS is disabled in your device. Would you like to enable it?")
                .setCancelable(false)
                .setPositiveButton("Goto Settings",
                        new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dialog, int id){
                                Intent callGPSSettingIntent = new Intent(
                                        android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                                startActivity(callGPSSettingIntent);
                                dialog.dismiss();
                            }
                        });
        alertDialogBuilder.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                        dialog.dismiss();
                    }
                });
        AlertDialog alert = alertDialogBuilder.create();
        alert.show();
    }

    private void hit_current_location()
    {
        if(current_location!=null)
        {
            LatLng latLng = new LatLng(current_location.getLatitude(), current_location.getLongitude());
            mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, zoom_level));
        }
        else
        {
            startLocationUpdates(1);
        }

    }
}
