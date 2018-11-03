package org.ratziiee.qlap.Registration.Main_application.Admin.Fragments.analysis;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.ratziiee.qlap.R;
import org.ratziiee.qlap.Registration.Utils.utils;

public class tisba_analysis extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    Spinner spn_tisba;
    LatLng Dpeth =null, bole_petrol_pump =null, khurana_bus_stand =null, jhansi_rani_square =null, prop =null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tisba_analysis);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        utils utils=new utils();
        utils.change_status_bar_color(this,this);

        spn_tisba=findViewById(R.id.spn_tisba);
        Dpeth =new LatLng(21.1460919, 79.0693469);
        bole_petrol_pump =new LatLng(21.1461800, 79.0680090);
        khurana_bus_stand =new LatLng(21.1462179, 79.0697572);
        jhansi_rani_square =new LatLng(21.1414848, 79.0793786);
        prop =new LatLng(21.1416140, 79.0827186);


        spn_tisba.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i>0) {
                    if (i == 1) {
                        morning_Session();
                    } else if (i == 2) {
                        afternoon_Session();
                    } else if (i == 3) {
                        evening_Session();
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }

    private void morning_Session()
    {
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Dpeth,12f));
        mMap.addMarker(new MarkerOptions()
                .position(khurana_bus_stand)
                .title("2.5")
                .snippet("Khurana Bus Stand")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        mMap.addMarker(new MarkerOptions()
                .position(bole_petrol_pump)
                .title("0.95")
                .snippet("Bole Petrol Pump Bus Stop")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));

        mMap.addMarker(new MarkerOptions()
                .position(Dpeth)
                .title("2.5")
                .snippet("Dpeth Bus Stop")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        mMap.addMarker(new MarkerOptions()
                .position(jhansi_rani_square)
                .title("2.5")
                .snippet("Jhansi Rani Square Metro Station")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        mMap.addMarker(new MarkerOptions()
                .position(prop)
                .title("0.4")
                .snippet("Prop. Sitabuldi Metro Station")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));


    }

    private void afternoon_Session()
    {
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Dpeth,12f));
        mMap.addMarker(new MarkerOptions()
                .position(khurana_bus_stand)
                .title("0.94")
                .snippet("Khurana Bus Stand")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));

        mMap.addMarker(new MarkerOptions()
                .position(bole_petrol_pump)
                .title("0.95")
                .snippet("Bole Petrol Pump Bus Stop")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));

        mMap.addMarker(new MarkerOptions()
                .position(Dpeth)
                .title("0.94")
                .snippet("Dpeth Bus Stop")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));

        mMap.addMarker(new MarkerOptions()
                .position(jhansi_rani_square)
                .title("1.06")
                .snippet("Jhansi Rani Square Metro Station")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        mMap.addMarker(new MarkerOptions()
                .position(prop)
                .title("1.06")
                .snippet("Prop. Sitabuldi Metro Station")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));


    }

    private void evening_Session()
    {
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Dpeth,12f));
        mMap.addMarker(new MarkerOptions()
                .position(khurana_bus_stand)
                .title("0.4")
                .snippet("Khurana Bus Stand")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions()
                .position(bole_petrol_pump)
                .title("1.5")
                .snippet("Bole Petrol Pump Bus Stop")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        mMap.addMarker(new MarkerOptions()
                .position(Dpeth)
                .title("0.4")
                .snippet("Dpeth Bus Stop")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions()
                .position(jhansi_rani_square)
                .title("0.04")
                .snippet("Jhansi Rani Square Metro Station")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions()
                .position(prop)
                .title("2.5")
                .snippet("Prop. Sitabuldi Metro Station")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));


    }





    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Dpeth,12f));

        // Add a marker in Sydney and move the camera


    }
}
