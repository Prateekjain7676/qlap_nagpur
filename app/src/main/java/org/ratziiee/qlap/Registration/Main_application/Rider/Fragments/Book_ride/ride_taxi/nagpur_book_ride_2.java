package org.ratziiee.qlap.Registration.Main_application.Rider.Fragments.Book_ride.ride_taxi;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import org.json.JSONArray;
import org.json.JSONObject;
import org.ratziiee.qlap.R;
import org.ratziiee.qlap.Registration.Main_application.Rider.Fragments.Book_ride.Book_ride_2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class nagpur_book_ride_2 extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private static String TAG="nagpur_book_ride_2";
    private ArrayList<LatLng> list_zoom;
    private ArrayList<LatLng> stops;
    private ArrayList<LatLng> first_mile,last_mile;
    private Button btn_first_mile,btn_last_mile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nagpur_book_ride_2);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        btn_first_mile=findViewById(R.id.btn_first_mile);
        btn_last_mile=findViewById(R.id.btn_last_mile);

        btn_last_mile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d(TAG, "onClick: size_mile :"+last_mile.size());
                Intent i=new Intent(nagpur_book_ride_2.this,Book_ride_2.class);
                Bundle args=new Bundle();
                args.putSerializable("list", last_mile);
                i.putExtra("bundle",args);
                startActivity(i);
            }
        });

        btn_first_mile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d(TAG, "onClick: size_mile :"+first_mile.size());
                Intent i=new Intent(nagpur_book_ride_2.this,Book_ride_2.class);
                Bundle args=new Bundle();
                args.putSerializable("list", first_mile);
                i.putExtra("bundle",args);
                startActivity(i);
            }
        });
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
        list_zoom=new ArrayList<>();
        stops=new ArrayList<>();
        first_mile=new ArrayList<>();
        last_mile=new ArrayList<>();
        new parse_json().execute();


        // Add a marker in Sydney and move the camera

    }


    @SuppressLint("StaticFieldLeak")
    public class parse_json extends AsyncTask<Void,Void,ArrayList<ArrayList<LatLng>>>
    {

        @Override
        protected ArrayList<ArrayList<LatLng>> doInBackground(Void... voids) {

            ArrayList<ArrayList<LatLng>> route=new ArrayList<>();
            ArrayList<LatLng> temp_route;

           try
           {
               InputStream inputStream = getResources().openRawResource(R.raw.qlap_nagpur_1);
               BufferedReader rd = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
               StringBuilder sb = new StringBuilder();
               int cp;
               while ((cp = rd.read()) != -1) {
                   sb.append((char) cp);
               }

               inputStream.close();

               JSONObject json = new JSONObject(sb.toString());

               JSONObject itenaires=json.getJSONArray("itineraries").getJSONObject(0);
               JSONArray legs=itenaires.getJSONArray("legs");
               Log.d(TAG, "doInBackground:legs : "+legs.length());

               for(int i=0;i<legs.length();i++)
               {
                   temp_route=new ArrayList<>();
                   Log.d(TAG, "doInBackground: "+i);
                   JSONArray wayPoint=legs.getJSONObject(i).getJSONArray("waypoints");

                   for(int k=0;k<wayPoint.length();k++)
                   {
                       JSONObject obj=wayPoint.getJSONObject(k);
                       Log.d(TAG, "doInBackground:way_point lenghth "+wayPoint.length());
                       if(obj.has("stop"))
                       {
                           Log.d(TAG, "doInBackground: has_stops :yes");
                           double stop_lon=obj.getJSONObject("stop").getJSONObject("geometry").getJSONArray("coordinates").getDouble(0);
                           double stop_lat=obj.getJSONObject("stop").getJSONObject("geometry").getJSONArray("coordinates").getDouble(1);
                           stops.add(
                                   new LatLng(obj.getJSONObject("stop")
                                           .getJSONObject("geometry").getJSONArray("coordinates")
                                           .getDouble(1),obj.getJSONObject("stop").getJSONObject("geometry")
                                           .getJSONArray("coordinates").getDouble(0)));
                       }
                       else
                       {
                           Log.d(TAG, "doInBackground:  has_stops :no");
                       }
                   }
                   JSONArray dynamic_inside_legs=legs.getJSONObject(i).getJSONObject("geometry").getJSONArray("coordinates");

                   Log.d(TAG, "doInBackground: coordinate lenghth :"+dynamic_inside_legs.length());
                   for(int j=0;j<dynamic_inside_legs.length();j++) {

                       JSONArray final_latlng = dynamic_inside_legs.getJSONArray(j);
                       Log.d(TAG, "doInBackground: final latlng :" + final_latlng.length());
                       LatLng lat_lng = new LatLng(final_latlng.getDouble(1), final_latlng.getDouble(0));
                       temp_route.add(lat_lng);
                       list_zoom.add(lat_lng);


                       if (i == 0)
                       {
                            first_mile.add(lat_lng);

                       }

                       if (i == dynamic_inside_legs.length() - 1)
                       {
                           last_mile.add(lat_lng);
                       }
                   }

                   route.add(temp_route);

               }


           }
           catch (Exception e)
           {
               e.printStackTrace();
           }
            Log.d(TAG, "doInBackground: route size :"+route.size());
            return route;
        }

        @Override
        protected void onPostExecute(ArrayList<ArrayList<LatLng>> latLngs) {
            super.onPostExecute(latLngs);

            Log.d(TAG, "onPostExecute: sizee :"+latLngs.size());
            for(int i=0;i<latLngs.size();i++)
            {
                ArrayList<LatLng> temp_arraylist=latLngs.get(i);
                PolylineOptions option=new PolylineOptions().addAll(temp_arraylist);
                if(i==0 || i==latLngs.size()-1) {
                    option.color(getResources().getColor(R.color.black));
                }
                else
                {
                    option.color(getResources().getColor(R.color.colorAccent));
                }
                mMap.addMarker(new MarkerOptions().position(list_zoom.get(0)).title("First Mile"));
                mMap.addMarker(new MarkerOptions().position(list_zoom.get(list_zoom.size()-1)).title("Last Mile"));
                mMap.addPolyline(option);
                zoom(list_zoom);

                for(LatLng stop:stops) {
                   Marker m= mMap.addMarker(new MarkerOptions().position(stop));
                   m.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.ic_marker_24dp));
                   m.setAnchor(0.5f,0.5f);
                }

            }
        }
    }

    private void zoom(List<LatLng> list)
    {
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        for (LatLng latlng : list) {
            builder.include(latlng);
        }
        LatLngBounds bounds = builder.build();
        int padding = 200; // offset from edges of the map in pixels
        CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds,padding);
        mMap.animateCamera(cu);
    }

    private void stop_data()
    {

    }
}
