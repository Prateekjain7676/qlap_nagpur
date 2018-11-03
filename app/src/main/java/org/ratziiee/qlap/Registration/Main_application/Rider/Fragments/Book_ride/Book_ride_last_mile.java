package org.ratziiee.qlap.Registration.Main_application.Rider.Fragments.Book_ride;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;

import org.json.JSONArray;
import org.json.JSONObject;
import org.ratziiee.qlap.R;
import org.ratziiee.qlap.Registration.Main_application.Rider.Fragments.Subscription.Subscription_activity;
import org.ratziiee.qlap.Registration.Utils.Location.StalkerCallback;
import org.ratziiee.qlap.Registration.Utils.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Book_ride_last_mile extends AppCompatActivity implements StalkerCallback{
    Button btn_save;
    String TAG="Book_ride_1";
    Spinner spn_destination_metro;
    private AlertDialog b;
    ArrayList<String> stop_spinner_data;
    JSONArray main_json;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_ride_last_mile);

        main_json=new JSONArray();
        stop_spinner_data=new ArrayList<>();
        spn_destination_metro=findViewById(R.id.spn_desti);
        TextView toolbar_title=findViewById(R.id.toolbar_title);
        toolbar_title.setText("Book Ride");
        utils utils=new utils();
        new parse_json().execute();
        utils.change_status_bar_color(this,this);
        btn_save=findViewById(R.id.btn_save);



        TextView tv_subs=findViewById(R.id.tv_subs);
        tv_subs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Book_ride_last_mile.this, Subscription_activity.class);
                startActivity(i);
            }
        });
        /*ArrayAdapter adapter=new ArrayAdapter<>(Book_ride_last_mile.this,R.layout.support_simple_spinner_dropdown_item,stop_spinner_data);
        spn_destination_metro.setAdapter(adapter);*/


        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(spn_destination_metro.getSelectedItemPosition()>0) {
                    Intent i = new Intent(Book_ride_last_mile.this, Book_ride_2_lastmile.class);
                    i.putExtra("selected_station", spn_destination_metro.getSelectedItem().toString());
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(Book_ride_last_mile.this, "Please select origin metro station.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onExecuted(Location location, int callingActivity) {
        Log.d(TAG, "onExecuted: "+location);
    }

    @Override
    public void onFailedStalklerCallback(int failCode, int callingActivity) {

        Log.d(TAG, "onFailedStalklerCallback: "+failCode);
    }

    public void showChangeLangDialog(final Context context, Activity activity) {

        final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
        LayoutInflater inflater = activity.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.dialog_map_image, null);
        dialogBuilder.setView(dialogView);
        dialogBuilder.setCancelable(false);
        ImageView iv_cross=dialogView.findViewById(R.id.iv_cross);
        ImageView iv_qr=dialogView.findViewById(R.id.iv_qr);

        iv_cross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b.dismiss();
            }
        });

        iv_qr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });






        b = dialogBuilder.create();
        b.show();

    }

    @SuppressLint("StaticFieldLeak")
    public class parse_json extends AsyncTask<Void,Void,Void>
    {

        @Override
        protected Void doInBackground(Void... voids) {

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


                    Location destination=new Location(LocationManager.GPS_PROVIDER);
                    destination.setLatitude(lat);
                    destination.setLongitude(lon);

                    int distance_between_points=Math.round(origin_location.distanceTo(destination));

                    JSONObject obj=new JSONObject();
                    obj.put("name",stop_name);
                    obj.put("location",destination);
                    main_json.put(obj);

                }

               // Log.d(TAG, "doInBackground: pre_sizee :"+main_json.length());
                parse_json(main_json);


            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
           // Log.d(TAG, "doInBackground: route size :"+final_list.size());


            return null;
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
                        Log.d(TAG, "parse_json:station_name "+obj.getString("name"));
                    }
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
