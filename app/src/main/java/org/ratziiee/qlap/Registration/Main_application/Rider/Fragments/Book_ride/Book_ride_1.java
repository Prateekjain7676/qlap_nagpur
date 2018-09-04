package org.ratziiee.qlap.Registration.Main_application.Rider.Fragments.Book_ride;

import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.ratziiee.qlap.R;
import org.ratziiee.qlap.Registration.Main_application.Database.models.model_station_details;
import org.ratziiee.qlap.Registration.Main_application.Database.qlap_database;
import org.ratziiee.qlap.Registration.Main_application.Rider.Fragments.Subscription.Subscription_activity;
import org.ratziiee.qlap.Registration.Main_application.Rider.Fragments.Subscription.subscription;
import org.ratziiee.qlap.Registration.Utils.Location.LocationStalker;
import org.ratziiee.qlap.Registration.Utils.Location.StalkerCallback;
import org.ratziiee.qlap.Registration.Utils.nearest_metro_Comparison;
import org.ratziiee.qlap.Registration.Utils.utils;

import java.util.ArrayList;

public class Book_ride_1 extends AppCompatActivity implements StalkerCallback{
    Button btn_save;
    String TAG="Book_ride_1";
    TextView btn_maps,tv_nearest_station;
    Spinner spn_destination_metro;
    qlap_database db;
    Location current_location;
    int status=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_ride_1);


        TextView toolbar_title=findViewById(R.id.toolbar_title);
        toolbar_title.setText("Book Ride");
        utils utils=new utils();
        utils.change_status_bar_color(this,this);
        btn_save=findViewById(R.id.btn_save);
        btn_maps=findViewById(R.id.btn_maps);
        tv_nearest_station=findViewById(R.id.tv_nearest_station);
        spn_destination_metro=findViewById(R.id.spn_destination_metro);
        db=qlap_database.getInstance(this);
        db.openDB();

        LocationStalker stalker=new LocationStalker(this,1);
        stalker.stalkLocation();

        TextView tv_subscription=findViewById(R.id.tv_subscription);



        tv_subscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Book_ride_1.this, Subscription_activity.class);
                startActivity(i);
            }
        });

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(status==1)
                {
                    Intent i = new Intent(Book_ride_1.this, Book_ride_2.class);
                    i.putExtra("selected_station", spn_destination_metro.getSelectedItem().toString());
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(Book_ride_1.this, "Please select destination metro station ...!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Book_ride_1.this,choose_on_map_bookride1.class);
                startActivity(i);
            }
        });

        tv_nearest_station.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayAdapter adapter=new ArrayAdapter<>(Book_ride_1.this,R.layout.support_simple_spinner_dropdown_item,comparison_nearest_station());
                spn_destination_metro.setAdapter(adapter);
                status=1;
            }
        });
    }

    @Override
    public void onExecuted(Location location, int callingActivity) {
        Log.d(TAG, "onExecuted: "+location);
        current_location=location;
    }

    @Override
    public void onFailedStalklerCallback(int failCode, int callingActivity) {

        Log.d(TAG, "onFailedStalklerCallback: "+failCode);
    }

    public ArrayList<String> comparison_nearest_station()
    {
        ArrayList<String> nearestStations = new ArrayList<>();

        Location temp_loc=new Location(LocationManager.GPS_PROVIDER);
        temp_loc.setLatitude(Double.valueOf("28.709603100000002"));
        temp_loc.setLongitude(Double.valueOf("77.1227114"));
        nearest_metro_Comparison nearest=new nearest_metro_Comparison(db.all_details(),this,temp_loc,2000);

        ArrayList<Location> reqd = nearest.return_values();
        ArrayList<model_station_details> stationDetails = db.getStationsDetails();
        for(Location loc : reqd){
            for(model_station_details station_detail : stationDetails){
                if(String.valueOf(loc.getLatitude()).equals(station_detail.getLatitude()) &&
                        String.valueOf(loc.getLongitude()).equals(station_detail.getLongitude())){
                    Log.e("sta",station_detail.getStation_name());
                    nearestStations.add(station_detail.getStation_name());
                }
            }
        }
        return nearestStations;
    }
}
