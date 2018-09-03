package org.ratziiee.qlap.Registration.Main_application.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import org.ratziiee.qlap.Registration.Main_application.Database.models.model_station_details;

import java.util.ArrayList;

public class qlap_database extends SQLiteOpenHelper {

    private static String DATABASE_NAME="QLAP_DATABASE.db";
    private static int DATABASE_VERSION=1;
    private static qlap_database database;
    private static SQLiteDatabase db;

    private static final String TABLE_NAME_METRO_STATION_DATA="metro_station_data";



    public static qlap_database getInstance(Context context)
    {
        if(database==null)
        {
            database=new qlap_database(context);
        }

        return database;
    }
    private qlap_database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void openDB()
    {

        db=null;
        db=getWritableDatabase();
    }


    public void deleteTable(String tableName)
    {
        db.execSQL("DELETE FROM "+tableName);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {

        String CREATE_TABLE_METRO_STATION_DATA = "CREATE TABLE "
                + TABLE_NAME_METRO_STATION_DATA
                + "( _id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + " station_name TEXT,"
                + " latitude TEXT,"
                + " longitude TEXT,"
                + " flag TEXT)";

        db.execSQL(CREATE_TABLE_METRO_STATION_DATA);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void AddMetroStationData(ArrayList<model_station_details> model)
    {

        for(model_station_details m:model)
        {
            ContentValues cv=new ContentValues();
            cv.put("station_name",m.getStation_name());
            cv.put("latitude",m.getLatitude());
            cv.put("longitude",m.getLongitude());
            cv.put("flag",m.getFlag());

            db.insert(TABLE_NAME_METRO_STATION_DATA,null,cv);

        }

    }

}
