package org.ratziiee.qlap.Registration.Main_application.Admin.Fragments.analysis;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.maps.android.heatmaps.Gradient;
import com.google.maps.android.heatmaps.HeatmapTileProvider;

import org.ratziiee.qlap.R;
import org.ratziiee.qlap.Registration.Utils.utils;

import java.util.ArrayList;
import java.util.List;

public class heatMap extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heat_map);

        utils utils=new utils();
        utils.change_status_bar_color(this,this);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);



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

        // Add a marker in Sydney and move the camera
        /*LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));*/

        addHeatMap();
    }

    private void addHeatMap() {
        List<LatLng> list_rohini_east = null;
        List<LatLng> list_rohini_west = null;
        List<LatLng> list_pitampura = null;
        List<LatLng> list_near_rohini_east = null;
        List<LatLng> list_near_rohini_west = null;

        // Get the data: latitude/longitude positions of police stations.
        try {
            list_rohini_east = rohini_east();
            list_rohini_west=rohini_west();
            list_pitampura=pitampura();
            list_near_rohini_east =near_rohini_east();
            list_near_rohini_west=near_rohini_west();
        } catch (Exception e) {
            Toast.makeText(this, "Problem reading list_rohini_east of locations.", Toast.LENGTH_LONG).show();
        }

        // Create a heat map tile provider, passing it the latlngs of the police stations.
        Gradient grad_rohini_east = new Gradient(colors_rohini_east, startpoints_rohini_east);
        HeatmapTileProvider provider_rohini_easr = new HeatmapTileProvider.Builder().data(list_rohini_east).gradient(grad_rohini_east).build();
        // Add a tile overlay to the map, using the heat map tile provider.
        mMap.addTileOverlay(new TileOverlayOptions().tileProvider(provider_rohini_easr));

        Gradient grad_rohini_west = new Gradient(colors_rohini_west, startpoints_rohini_west);
        HeatmapTileProvider provider_rohini_west = new HeatmapTileProvider.Builder().data(list_rohini_west).gradient(grad_rohini_west).build();
        // Add a tile overlay to the map, using the heat map tile provider.
        mMap.addTileOverlay(new TileOverlayOptions().tileProvider(provider_rohini_west));

        Gradient grad_pitampura = new Gradient(colors_pitampura, startpoints_pitampura);
        HeatmapTileProvider provider_pitampura = new HeatmapTileProvider.Builder().data(list_pitampura).gradient(grad_pitampura).build();
        // Add a tile overlay to the map, using the heat map tile provider.
        mMap.addTileOverlay(new TileOverlayOptions().tileProvider(provider_pitampura));

        Gradient grad_near_rohini_east = new Gradient(colors_rohini_west, startpoints_rohini_west);
        HeatmapTileProvider provider_near_rohini_east = new HeatmapTileProvider.Builder().data(list_near_rohini_east).gradient(grad_near_rohini_east).build();
        // Add a tile overlay to the map, using the heat map tile provider.
        mMap.addTileOverlay(new TileOverlayOptions().tileProvider(provider_near_rohini_east));


        Gradient grad_near_rohini_west = new Gradient(colors_rohini_east, startpoints_rohini_east);
        HeatmapTileProvider provider_near_rohini_west = new HeatmapTileProvider.Builder().data(list_near_rohini_west).gradient(grad_near_rohini_west).build();
        // Add a tile overlay to the map, using the heat map tile provider.
        mMap.addTileOverlay(new TileOverlayOptions().tileProvider(provider_near_rohini_west));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(28.713617, 77.118228),14f));
    }
    /**
     * Read the data (locations of police stations) from raw resources.
     */
    private ArrayList<LatLng> rohini_east()  {

        ArrayList<LatLng> list = new ArrayList<LatLng>();
        LatLng l1=new LatLng(28.707422, 77.125755);
        LatLng l2=new LatLng(28.707479, 77.126013);
        LatLng l3=new LatLng(28.707451, 77.125830);
        LatLng l4=new LatLng(28.707375, 77.125959);

        list.add(l1);
        list.add(l2);
        list.add(l3);
        list.add(l4);



        return list;
    }

    private ArrayList<LatLng> rohini_west()  {

        ArrayList<LatLng> list = new ArrayList<LatLng>();
        LatLng l1=new LatLng(28.714753, 77.115209);
        LatLng l2=new LatLng(28.714649, 77.115359);
        LatLng l3=new LatLng(28.714621, 77.115132);
        LatLng l4=new LatLng(28.714794, 77.115475);

        list.add(l1);
        list.add(l2);
        list.add(l3);
        list.add(l4);



        return list;
    }

    private ArrayList<LatLng> pitampura()  {

        ArrayList<LatLng> list = new ArrayList<LatLng>();
        LatLng l1=new LatLng(28.703095, 77.132141);
        LatLng l2=new LatLng(28.702939, 77.132329);
        LatLng l3=new LatLng(28.702836, 77.132530);
        LatLng l4=new LatLng(28.702704, 77.132496);

        list.add(l1);
        list.add(l2);
        list.add(l3);
        list.add(l4);



        return list;
    }

    private ArrayList<LatLng> near_rohini_east()  {

        ArrayList<LatLng> list = new ArrayList<LatLng>();
        LatLng l1=new LatLng(28.709316, 77.130280);
        LatLng l2=new LatLng(28.709095, 77.130364);
        LatLng l3=new LatLng(28.708933, 77.130700);
        LatLng l4=new LatLng(28.708977, 77.130297);

        list.add(l1);
        list.add(l2);
        list.add(l3);
        list.add(l4);



        return list;
    }


    private ArrayList<LatLng> near_rohini_west()  {

        ArrayList<LatLng> list = new ArrayList<LatLng>();
        LatLng l1=new LatLng(28.711937, 77.114062);
        LatLng l2=new LatLng(28.712172, 77.114347);
        LatLng l3=new LatLng(28.712172, 77.113860);
        LatLng l4=new LatLng(28.712290, 77.114364);

        list.add(l1);
        list.add(l2);
        list.add(l3);
        list.add(l4);



        return list;
    }


    int[] colors_rohini_east = {



            Color.rgb(255,192,0), //e rikshaw yellowish
            Color.rgb(237,125,49) ,//auto orange
            Color.rgb(112,173,71) // minibus green
    };

    float[] startpoints_rohini_east = {
            0.1F, 0.2F, 0.5F
    };

    int[] colors_rohini_west = {
            Color.rgb(237,125,49) ,//auto orange
            Color.rgb(112,173,71), // minibus green
            Color.rgb(255,192,0), //e rikshaw yellowish
    };

    float[] startpoints_rohini_west = {
            0.1F, 0.2F, 0.5F
    };

    int[] colors_pitampura = {

            Color.rgb(112,173,71), // minibus green
            Color.rgb(255,192,0), //e rikshaw yellowish
            Color.rgb(237,125,49)//auto orange
    };

    float[] startpoints_pitampura = {
            0.1F, 0.2F, 0.5F
    };
}
