package org.ratziiee.qlap.Registration.Main_application.Database.models;

public class model_station_details {

    String station_name;
    String latitude;
    String longitude;
    String flag;


    public model_station_details() {
    }

    public model_station_details(String station_name, String latitude, String longitude, String flag) {
        this.station_name = station_name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.flag = flag;
    }

    public String getStation_name() {
        return station_name;
    }

    public void setStation_name(String station_name) {
        this.station_name = station_name;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

}
