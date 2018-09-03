package org.ratziiee.qlap.Registration.Utils;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;

import org.ratziiee.qlap.Registration.Main_application.Database.models.model_station_details;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class nearest_metro_Comparison {

    ArrayList<model_station_details> all_details;
    Context context;
    Location current_location;
    double distance_in_meters;
    private static String TAG="nearest_metro_Comparison";

    public nearest_metro_Comparison(ArrayList<model_station_details> model, Context context, Location current_location,double radius)
    {
        this.all_details=model;
        this.context=context;
        this.current_location=current_location;
        this.distance_in_meters=radius;

    }

    public ArrayList<Location> return_values()
    {
        ArrayList<Location> return_values=new ArrayList<>();
        ArrayList<Location> all_loc=new ArrayList<>();

        for(model_station_details m:all_details)
        {
            Location temp=new Location(LocationManager.GPS_PROVIDER);
            temp.setLatitude(Double.valueOf(m.getLatitude()));
            temp.setLongitude(Double.valueOf(m.getLongitude()));

            Log.d(TAG, "return_values: ");
            all_loc.add(temp);
        }

        for(Location loc:all_loc)
        {
            double distance_in_mtr=current_location.distanceTo(loc);
            if(distance_in_mtr<=4000)
            {
                return_values.add(loc);
            }
        }

        return return_values;

    }
}
