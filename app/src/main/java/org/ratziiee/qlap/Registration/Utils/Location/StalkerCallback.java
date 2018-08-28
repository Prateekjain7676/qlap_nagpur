package org.ratziiee.qlap.Registration.Utils.Location;

/*Created by cs07 on 21/12/17.*/

import android.location.Location;

public interface StalkerCallback {

    int LOCATION_SERVICE_NOT_AVAILABLE_ERROR =1;
    int LOCATION_SERVICE_TURNED_OFF_ERROR=2;
    int LOCATION_PERMISSION_NOT_GRANTED_ERROR=3;
    int FATAL_ERROR=4;
    int TIME_OUT_ERROR=12;

    void onExecuted(Location location, int callingActivity);
    void onFailedStalklerCallback(int failCode, int callingActivity);

}
