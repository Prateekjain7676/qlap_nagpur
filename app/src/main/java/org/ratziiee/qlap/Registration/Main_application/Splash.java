package org.ratziiee.qlap.Registration.Main_application;

import android.Manifest;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;


import org.ratziiee.qlap.R;
import org.ratziiee.qlap.Registration.Main_application.Database.models.model_station_details;
import org.ratziiee.qlap.Registration.Main_application.Database.qlap_database;
import org.ratziiee.qlap.Registration.Registration.First_Screen;
import org.ratziiee.qlap.Registration.Utils.nearest_metro_Comparison;

import java.util.ArrayList;

import timber.log.Timber;

public class Splash extends AppCompatActivity {
    
    ArrayList<model_station_details> list;
    qlap_database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        list=new ArrayList<>();
        db=qlap_database.getInstance(this);
        db.openDB();
        station_details();

        comparison_nearest_station();


        if (Build.VERSION.SDK_INT >= 23)
        {
            //permission
            checkPermission();
        }
        else
        {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent i = new Intent(Splash.this, First_Screen.class);
                    startActivity(i);
                    finish();
                }
            }, 2000);

        }

    }

    private void checkPermission(){


        TedPermission.with(this)
                .setPermissionListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted() {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent i = new Intent(Splash.this, First_Screen.class);
                                startActivity(i);
                                finish();
                            }
                        }, 2000);
                    }
                    @Override
                    public void onPermissionDenied(ArrayList<String> deniedPermissions) {
                        Toast.makeText(Splash.this,"Unable to Run Application without required permission",Toast.LENGTH_LONG).show();
                        finishAffinity();
                    }
                })
                .setDeniedMessage("Unable to run app without these permission\n\nPlease turn on permissions at [Setting] > [Permission]")
                .setPermissions(Manifest.permission.ACCESS_COARSE_LOCATION,Manifest.permission.ACCESS_FINE_LOCATION)
                .check();

    }
    
    private void station_details()
    {
        model_station_details m=new model_station_details();
        m.setStation_name("Rithala");
        m.setLatitude("28.7208533");
        m.setLongitude("77.1071309");
        m.setFlag("0");
        
        list.add(m);

        model_station_details m1=new model_station_details();
        m1.setStation_name("Netaji Subhash Place");
        m1.setLatitude("28.6970532");
        m1.setLongitude("77.1552652");
        m1.setFlag("0");

        list.add(m1);

        model_station_details m2=new model_station_details();
        m2.setStation_name("Inderlok");
        m2.setLatitude("28.6736172");
        m2.setLongitude("77.1702754");
        m2.setFlag("0");

        list.add(m2);

        model_station_details m3=new model_station_details();
        m3.setStation_name("Kashmere Gate");
        m3.setLatitude("28.6675032");
        m3.setLongitude("77.2285464");
        m3.setFlag("0");

        list.add(m3);

        model_station_details m4=new model_station_details();
        m4.setStation_name("Jamia Millia Islamia");
        m4.setLatitude("28.5630087");
        m4.setLongitude("77.2862756");
        m4.setFlag("0");

        list.add(m4);

        model_station_details m5=new model_station_details();
        m5.setStation_name("Okhla NSIC");
        m5.setLatitude("28.554669");
        m5.setLongitude("77.2649722");
        m5.setFlag("0");

        list.add(m5);

        model_station_details m6=new model_station_details();
        m6.setStation_name("Greater Kailash");
        m6.setLatitude("28.541841");
        m6.setLongitude("77.238236");
        m6.setFlag("0");

        list.add(m6);

        model_station_details m7=new model_station_details();
        m7.setStation_name("Munirka");
        m7.setLatitude("28.557825");
        m7.setLongitude("77.174027");
        m7.setFlag("0");

        list.add(m7);

        db.deleteTable("metro_station_data");
        db.AddMetroStationData(list);
    }

    private void comparison_nearest_station()
    {
        Location temp_loc=new Location(LocationManager.GPS_PROVIDER);
        temp_loc.setLatitude(Double.valueOf("28.709603100000002"));
        temp_loc.setLongitude(Double.valueOf("77.1227114"));
        nearest_metro_Comparison nearest=new nearest_metro_Comparison(list,this,temp_loc,2000);


        for(int i=0;i<nearest.return_values().size();i++)
        {
            Log.d("check", "comparison_nearest_station: "+nearest.return_values().get(i));
        }
    }



    
    

}
