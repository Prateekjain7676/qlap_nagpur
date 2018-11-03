package org.ratziiee.qlap.Registration.Main_application.Rider.Fragments.Book_ride;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;

import org.json.JSONArray;
import org.json.JSONObject;
import org.ratziiee.qlap.R;
import org.ratziiee.qlap.Registration.Main_application.Database.models.model_station_details;
import org.ratziiee.qlap.Registration.Main_application.Database.qlap_database;
import org.ratziiee.qlap.Registration.Main_application.Rider.Fragments.Subscription.Subscription_activity;
import org.ratziiee.qlap.Registration.Utils.Location.LocationStalker;
import org.ratziiee.qlap.Registration.Utils.Location.StalkerCallback;
import org.ratziiee.qlap.Registration.Utils.nearest_metro_Comparison;
import org.ratziiee.qlap.Registration.Utils.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Book_ride_1 extends AppCompatActivity implements StalkerCallback{
    Button btn_save;
    String TAG="Book_ride_1";
    TextView btn_maps,tv_nearest_station;
    Spinner spn_destination_metro;
    qlap_database db;
    Location current_location;
    int status=0;
    double current_lat, current_lon;
    List<Integer> array_distance;
    HashMap<Integer,String> hmap,finalhmap;
    JSONArray main_json;
    ArrayList<String> stop_spinner_data;

    Map.Entry me2;
    ArrayList<Object> final_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_ride_1);

        new parse_json().execute();
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

        array_distance=new ArrayList<>();
        hmap =new HashMap<>();
        finalhmap=new HashMap<>();
        final_list=new ArrayList<>();
        main_json=new JSONArray();
        stop_spinner_data=new ArrayList<>();

        current_lat =getIntent().getDoubleExtra("current_lat",0f);
        current_lon =getIntent().getDoubleExtra("current_lon",0f);
        Log.d(TAG, "onCreate: "+ current_lat +"\ncurrent_lon"+ current_lon);


        LocationStalker stalker=new LocationStalker(this,1);
        stalker.stalkLocation();

        TextView tv_subscription=findViewById(R.id.tv_subscription);



        tv_subscription.setOnClickListener(new View.OnClickListener()
        {
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
                    Log.d(TAG, "onClick: location :"+getting_loc(main_json,spn_destination_metro.getSelectedItem().toString()));
                    Intent i = new Intent(Book_ride_1.this, Book_ride_2.class);
                    i.putExtra("selected_station",spn_destination_metro.getSelectedItem().toString());
                    startActivity(i);
                  /* Intent i=new Intent(Book_ride_1.this,nagpur_book_ride_2.class);
                   startActivity(i);*/
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
                stop_spinner_data.add(0,"Giripeth Post Office");
                ArrayAdapter adapter=new ArrayAdapter<>(Book_ride_1.this,R.layout.support_simple_spinner_dropdown_item,stop_spinner_data);
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
        temp_loc.setLatitude(Double.valueOf("21.1481026"));
        temp_loc.setLongitude(Double.valueOf("79.0701773"));
        nearest_metro_Comparison nearest=new nearest_metro_Comparison(db.all_details(),this,temp_loc,10000);

        ArrayList<Location> reqd = nearest.return_values();
        ArrayList<model_station_details> stationDetails = db.getStationsDetails();
        Log.d(TAG, "comparison_nearest_station: "+reqd);
        int i=0,j=0;
        for(Location loc : reqd)
        {
            Log.d(TAG, "comparison_nearest_station: first loop counter : "+i++);
            for(model_station_details station_detail : stationDetails)
            {
                Log.d(TAG, "comparison_nearest_station: second loop :"+j++);
                if(String.valueOf(loc.getLatitude()).equals(station_detail.getLatitude()) &&
                        String.valueOf(loc.getLongitude()).equals(station_detail.getLongitude()))
                {
                    Log.e("stations_details",station_detail.getStation_name());
                    nearestStations.add(station_detail.getStation_name());
                }
            }
        }


        ArrayList<String> temp_jugaad=new ArrayList<>();
        temp_jugaad.add("Bole Petrol Pump Bus Stand(650m)");
        temp_jugaad.add("Dpeth Bus Stand(800m)");
        temp_jugaad.add("Khurana Bus Stand(850m)");
        temp_jugaad.add("Jhansi Rani Square Metro station(1.7km)");
        temp_jugaad.add("Prop. Sitabuldi Metro Station(1.9km)");
        return temp_jugaad;
    }


    @SuppressLint("StaticFieldLeak")
    public class parse_json extends AsyncTask<Void,Void,HashMap<Integer,String>>
    {

        @Override
        protected HashMap<Integer,String> doInBackground(Void... voids) {

            ArrayList<ArrayList<LatLng>> route=new ArrayList<>();
            ArrayList<LatLng> temp_route;

            try
            {
                InputStream inputStream = getResources().openRawResource(R.raw.bus_stop_detail);
                BufferedReader rd = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
                StringBuilder sb = new StringBuilder();
                int cp;
                while ((cp = rd.read()) != -1) {
                    sb.append((char) cp);
                }

                inputStream.close();
                int j=0;
                JSONArray json=new JSONArray(sb.toString());
                Log.d(TAG, "doInBackground: main_json :"+json.length());
                for(int i=0;i<json.length();i++)
                {
                    double lat=json.getJSONObject(i).getJSONObject("geometry").getJSONArray("coordinates").getDouble(1);
                    double lon=json.getJSONObject(i).getJSONObject("geometry").getJSONArray("coordinates").getDouble(0);
                    String stop_name=json.getJSONObject(i).getString("name");
                    Log.d(TAG, "doInBackground: current_lat :"+lat+"\ncurrent_lon:"+lon+"\nname :"+stop_name+json.length());
                    Location origin_location =new Location(LocationManager.GPS_PROVIDER);
                    Log.d(TAG, "doInBackground: checking :"+j++);
                    /*origin_location.setLatitude(21.147845);
                    origin_location.setLongitude(79.070250);*/
                    origin_location.setLatitude(current_lat);
                    origin_location.setLongitude(current_lon);

                    Location destination=new Location(LocationManager.GPS_PROVIDER);
                    destination.setLatitude(lat);
                    destination.setLongitude(lon);

                    int distance_between_points=Math.round(origin_location.distanceTo(destination));

                    JSONObject obj=new JSONObject();
                    obj.put("name",stop_name);
                    obj.put("location",destination);
                    main_json.put(obj);

                }

                Log.d(TAG, "doInBackground: pre_sizee :"+main_json.length());

                Map<Integer, String> map = new TreeMap<>(hmap);
                Set set2 = map.entrySet();
                Iterator iterator2 = set2.iterator();
                while(iterator2.hasNext())
                {
                     me2 = (Map.Entry) iterator2.next();
                    Log.d(TAG, "doInBackground sorted_values: key:"+me2.getKey()+"\nvalue :"+me2.getValue());

                }
                parse_json(main_json);

            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            Log.d(TAG, "doInBackground: route size :"+final_list.size());

            return finalhmap;
        }

        @Override
        protected void onPostExecute(HashMap<Integer, String> integerStringHashMap) {
            super.onPostExecute(integerStringHashMap);

            Log.d(TAG, "onPostExecute: sizeeee :"+main_json.toString());

        }

        private void parse_json(JSONArray array)
        {
            try
            {
                if(array.length()>0)
                {
                    for(int i=0;i<array.length();i++)
                    {
                        JSONObject obj=(JSONObject) array.get(i);
                        stop_spinner_data.add(obj.getString("name"));
                    }
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
    private double getting_loc(JSONArray array,String namee)
    {
        double location=0.0;
        try
        {
            if(array.length()>0)
            {
                for(int i=0;i<array.length();i++)
                {
                    JSONObject obj=(JSONObject) array.get(i);
                    if(obj.getString("name").equalsIgnoreCase(namee))
                    {
                        location=obj.getDouble("location");
                    }
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return location;
    }
}
