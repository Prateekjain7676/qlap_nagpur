package org.ratziiee.qlap.Registration.Utils.Location;

/*Created by cs07 on 21/12/17.*/

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;

import static android.content.Context.LOCATION_SERVICE;

public class LocationStalker {

    private Context stalkerContext;
    private StalkerCallback stalkerCallback;

    private boolean isRetryEnable = false;
    private boolean locCallBack = false;
    public int priority = LocationRequest.PRIORITY_HIGH_ACCURACY;

    private int retryInterval = 0;
    private int maxRetry= 3;

    private  int currentRetryCount = 0;
    public  int currentRetryTimeOut = 20 * 1000;//20 second time frame
    private FusedLocationProviderClient fusedClient;
   // private PreferenceClass mPreferenceClass;
    SharedPreferences sharedPrefs ;
    private int callingActivity;

    public int apiRetryTimeOut=20*1000;
    public int managerRetryTimeOut=45*1000;

    public LocationStalker(Context context, int i){
        stalkerContext=context;
        stalkerCallback=(StalkerCallback)context;
        callingActivity=i;
       /* mPreferenceClass= new PreferenceClass(stalkerContext);
        sharedPrefs = PreferenceManager
                .getDefaultSharedPreferences(stalkerContext);
        setLocationPriority();
        setCurrentRetryTimeOut();*/
    }


    private void setLocationPriority() {
        /*int priority=mPreferenceClass.getLocationPriority();*/
        String priority=sharedPrefs.getString("prefPriorty", "NULL");
        logCat("CurrentRetryTimeout priority=>"+priority);
        switch (priority){

            case "1":
                setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
                break;
            case "2":  setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
                break;
            case "3":setPriority(LocationRequest.PRIORITY_LOW_POWER);
                break;
            case "4":setPriority(LocationRequest.PRIORITY_NO_POWER);
                break;
            default:
                setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);


        }
        logCat("location mode=>"+priority);
    }


    private void setCurrentRetryTimeOut() {
       // int timeout=mPreferenceClass.getTimeOut();
        String timeout=sharedPrefs.getString("prefTimeOut", "");
        logCat("timeout:"+timeout);

        switch (timeout){
            case "1":currentRetryTimeOut=20*1000;
                break;
            case "2":currentRetryTimeOut=40*1000;
                break;
            case "3":currentRetryTimeOut=60*1000;
                break;
            case "4":currentRetryTimeOut=120*1000;
                break;
            case "5":currentRetryTimeOut=180*1000;
                break;
            case "6":currentRetryTimeOut=240*1000;
                break;
            default:
               currentRetryTimeOut=20*1000;
        }
        logCat("timeout:"+currentRetryTimeOut);
    }

    public void stalkLocation(){

        HandlerThread handlerThread = new HandlerThread("MyHandlerThread");
        handlerThread.start();
        Looper looper = handlerThread.getLooper();
        Handler handler = new Handler(looper);
        handler.post(new Runnable() {
            @Override
            public void run() {
                try {
                    Log.d("TAG","stalkLocation 1 ");
                    checkRequirementForLocation();
              } catch (Exception e) {
                    e.printStackTrace();
                    stalkerCallback.onFailedStalklerCallback(StalkerCallback.FATAL_ERROR,callingActivity);
                }
            }
        });


    }

    private void checkRequirementForLocation() {

        if (stalkerContext.getPackageManager().hasSystemFeature(PackageManager.FEATURE_LOCATION)) {

            if (ActivityCompat.checkSelfPermission(stalkerContext,
                    Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

                if (isProviderActive(LocationManager.GPS_PROVIDER) || isProviderActive(LocationManager.NETWORK_PROVIDER)) {
                    if (checkPlayServices()) {
                        //use loc service api
                        Log.d("TAG","stalkLocation 2");
                          stalkLocationUsingLocationAPI();
                    } else {
                        //use loc manager
                        logCat("Using LocationMAnager");
                        stalkLocationUsingLocationManager();
                    }
                } else {
                    stalkerCallback.onFailedStalklerCallback(StalkerCallback.LOCATION_SERVICE_TURNED_OFF_ERROR,callingActivity);
                    //turn on service
                }
            } else {
                stalkerCallback.onFailedStalklerCallback(StalkerCallback.LOCATION_PERMISSION_NOT_GRANTED_ERROR,callingActivity);
            }
        } else {
            stalkerCallback.onFailedStalklerCallback(StalkerCallback.LOCATION_SERVICE_NOT_AVAILABLE_ERROR,callingActivity);
        }
    }


    @SuppressLint("MissingPermission")
    private void stalkLocationUsingLocationAPI() {

        Log.d("TAG","stalkLocation 3");
        fusedClient = LocationServices.getFusedLocationProviderClient(stalkerContext);
        locCallBack = true;
        final Handler locHandler =new Handler();

        final LocationCallback lc=new LocationCallback(){
            @Override
            public void onLocationResult(LocationResult locationResult) {
                super.onLocationResult(locationResult);
                if (locationResult!=null) {
                    locCallBack = false;
                    locHandler.removeCallbacksAndMessages(null);
                    Location location=locationResult.getLastLocation();
                   // SystemClock.sleep(600000);
                    Log.d("TAG","stalkLocation 4");
                    logCat("stalkLocation CurrentRetryTimeout loc_api"+location.getLongitude());
                    stalkerCallback.onExecuted(location,callingActivity);

                }else{
                    //set fallback using location manager
                    stalkLocationUsingLocationManager();
                }
            }
        };


        LocationRequest lr=LocationRequest.create();
        lr.setNumUpdates(1);
        lr.setPriority(priority);
        fusedClient.requestLocationUpdates(lr,lc,null);

        locHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(locCallBack){
                    fusedClient.removeLocationUpdates(lc);
                    logCat("stalkLocation locCallBack=>"+locCallBack);

                    stalkLocationUsingLocationManager();
                }
            }
        }, Long.valueOf(apiRetryTimeOut));


    }










    @SuppressLint("MissingPermission")
    private  void stalkLocationUsingLocationManager() {
        locCallBack = true;
        logCat("stalkLocation Manager");
        final Handler locHandler = new Handler();

        final LocationListener locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                Log.d("TAG","stalkLocation 5");
                if (location != null) {
                    if (locCallBack) {
                        locCallBack = false;
                        locHandler.removeCallbacksAndMessages(null);
                        stalkerCallback.onExecuted(location, callingActivity);
                    }
                } else {
                    stalkerCallback.onFailedStalklerCallback(StalkerCallback.FATAL_ERROR,callingActivity);
                   // useRetryPolicyIfEnable();
                }
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {
                logCat("stalkLocation Changed "+provider);
            }

            @Override
            public void onProviderEnabled(String provider) {
                logCat("stalkLocation Enabled "+provider);
            }

            @Override
            public void onProviderDisabled(String provider) {
                logCat("stalkLocation Disabled "+provider);
            }
        };

         final LocationManager l=(LocationManager)stalkerContext.
                getSystemService(LOCATION_SERVICE);
        if (isProviderActive(LocationManager.GPS_PROVIDER)) {
            l.requestSingleUpdate(LocationManager.GPS_PROVIDER, locationListener, null);
            logCat("GPS LAUNCH");
        }

        if (isProviderActive(LocationManager.NETWORK_PROVIDER)) {
            l.requestSingleUpdate(LocationManager.NETWORK_PROVIDER, locationListener, null);
            logCat("NET LAUNCH");
        }

        l.requestSingleUpdate(LocationManager.PASSIVE_PROVIDER, locationListener, null);


        Runnable mRunnable= new Runnable() {
            @Override
            public void run() {
                if (locCallBack) {
                    l.removeUpdates(locationListener);
                    stalkerCallback.onFailedStalklerCallback(StalkerCallback.TIME_OUT_ERROR,callingActivity);
                   // useRetryPolicyIfEnable();
                }
            }
        };

        locHandler.postDelayed(mRunnable, Long.valueOf(managerRetryTimeOut));
    }
    private boolean isProviderActive(String providerType){
        LocationManager manager = (LocationManager)stalkerContext.
                getSystemService(LOCATION_SERVICE);
        assert manager != null;
        return (manager.isProviderEnabled(providerType));
    }

    private boolean checkPlayServices() {
        GoogleApiAvailability googleAPI = GoogleApiAvailability.getInstance();
        int result = googleAPI.isGooglePlayServicesAvailable(stalkerContext);
        logCat(result);
        return result == ConnectionResult.SUCCESS;
    }

    public void useRetryPolicyIfEnable() {
        if ( currentRetryCount < maxRetry) {
            logCat("Current retry time out=>"+currentRetryTimeOut+"CurrentRetryCount=>"+currentRetryCount);
            currentRetryCount++;
           // currentRetryTimeOut = currentRetryTimeOut + retryInterval;
            Runnable mRunnable= new Runnable() {
                @Override
                public void run() {
                    stalkLocationUsingLocationManager();
                }
            };
            Handler mHandler = new Handler();
            mHandler.postDelayed(mRunnable, Long.valueOf(currentRetryTimeOut));
        }
    }

    public void setPriority(int priority) {
        this.priority = priority;

    }

    //set whether retry is enable or not def-not enable
    void setRetryPolicy(int maxRetry,int retryInterval) {
        this.isRetryEnable = true;
        this.retryInterval = retryInterval;
        this.maxRetry = maxRetry;
    }

    private void logCat(Object obj){
        Log.d("DEMO", String.valueOf(obj));
    }






}