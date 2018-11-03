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
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(21.1414848, 79.0793786),14f));
    }
    /**
     * Read the data (locations of police stations) from raw resources.
     */
    private ArrayList<LatLng> rohini_east()  {

        ArrayList<LatLng> list = new ArrayList<LatLng>();
        LatLng l1=new LatLng(21.1414848, 79.0793786);
        LatLng l2=new LatLng(21.141635, 79.079196);
        LatLng l3=new LatLng(21.141715, 79.079169);
        LatLng l4=new LatLng(21.141715, 79.079593);

        list.add(l1);
        list.add(l2);
        list.add(l3);
        list.add(l4);



        return list;
    }

    private ArrayList<LatLng> rohini_west()  {

        ArrayList<LatLng> list = new ArrayList<LatLng>();
        LatLng l1=new LatLng(21.1416140, 79.0827186);
        LatLng l2=new LatLng(21.141614, 79.082719);
        LatLng l3=new LatLng(21.141924, 79.083073);
        LatLng l4=new LatLng(21.141674, 79.082848);

        list.add(l1);
        list.add(l2);
        list.add(l3);
        list.add(l4);



        return list;
    }

    private ArrayList<LatLng> pitampura()  {

        ArrayList<LatLng> list = new ArrayList<LatLng>();
        LatLng l1=new LatLng(21.1462179, 79.0697572 );
        LatLng l2=new LatLng(21.146278, 79.069510);
        LatLng l3=new LatLng(21.146318, 79.069392);
        LatLng l4=new LatLng(21.146368, 79.069113);

        list.add(l1);
        list.add(l2);
        list.add(l3);
        list.add(l4);



        return list;
    }

    private ArrayList<LatLng> near_rohini_east()  {

        ArrayList<LatLng> list = new ArrayList<LatLng>();
        LatLng l1=new LatLng(21.1481, 79.0702);
        LatLng l2=new LatLng(21.148025, 79.070071);
        LatLng l3=new LatLng(21.147960, 79.070393);
        LatLng l4=new LatLng(21.147944, 79.070214);

        list.add(l1);
        list.add(l2);
        list.add(l3);
        list.add(l4);


        return list;
    }


    private ArrayList<LatLng> near_rohini_west()  {

        ArrayList<LatLng> list = new ArrayList<LatLng>();
        LatLng l1=new LatLng(21.1416140, 79.0827186);
        LatLng l2=new LatLng(21.139088, 79.073522);
        LatLng l3=new LatLng(21.138928, 79.073415);
        LatLng l4=new LatLng(21.138738, 79.073544);

        list.add(l1);
        list.add(l2);
        list.add(l3);
        list.add(l4);



        return list;
    }


    int[] colors_rohini_east = {




            Color.rgb(237,125,49) ,//auto orange
            Color.rgb(112,173,71), // minibus green
            Color.rgb(255,192,0) //e rikshaw yellowish
    };

    float[] startpoints_rohini_east = {
            0.1F, 0.2F, 1F
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
