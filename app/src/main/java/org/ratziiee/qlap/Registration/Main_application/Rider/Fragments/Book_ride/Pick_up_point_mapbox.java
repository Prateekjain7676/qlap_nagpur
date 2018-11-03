package org.ratziiee.qlap.Registration.Main_application.Rider.Fragments.Book_ride;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.ratziiee.qlap.R;
import org.ratziiee.qlap.Registration.Utils.utils;

public class Pick_up_point_mapbox extends AppCompatActivity implements OnMapReadyCallback {
    Button btn_done;
    private GoogleMap mMap;
    TextView tv_qr_code;
    private AlertDialog b,b1;
    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_up_point_mapbox);

        // Obtain the SupportMapFragment and get notified when the hmap is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        tv_qr_code=findViewById(R.id.tv_qr_code);

        btn_done=findViewById(R.id.btn_done);
        btn_done.setOnClickListener(view -> {
            Intent i=new Intent(Pick_up_point_mapbox.this,book_ride_5.class);
            startActivity(i);
        });

         i=getIntent().getIntExtra("pick_up_subscription",0);
        if(i==1)
        {
            btn_done.setVisibility(View.GONE);
        }

        TextView toolbar_title=findViewById(R.id.toolbar_title);
        toolbar_title.setText("Subscription Confirmation");
        utils utils=new utils();
        utils.change_status_bar_color(this,this);

        tv_qr_code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showChangeLangDialog(Pick_up_point_mapbox.this,Pick_up_point_mapbox.this);
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


            mMap.addMarker(new MarkerOptions().position(new LatLng(21.1481026, 79.0701773)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(21.1481026, 79.0701773), 15.0f));

    }

    public void showChangeLangDialog(final Context context, Activity activity) {

        final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
        LayoutInflater inflater = activity.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.dialog_qr_code, null);
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
                showChangeLangDialog_1(Pick_up_point_mapbox.this,Pick_up_point_mapbox.this);
            }
        });






        b = dialogBuilder.create();
        b.show();

    }

    public void showChangeLangDialog_1(final Context context, Activity activity) {

        final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
        LayoutInflater inflater = activity.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.dialog_qr_code_success, null);
        dialogBuilder.setView(dialogView);
        dialogBuilder.setCancelable(false);
        ImageView iv_cross=dialogView.findViewById(R.id.iv_cross);
        Button btn_done=dialogView.findViewById(R.id.btn_done);



        iv_cross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b1.dismiss();
            }
        });

        btn_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Pick_up_point_mapbox.this,book_ride_5.class);
                startActivity(i);
            }
        });






        b1 = dialogBuilder.create();
        b1.show();

    }
}
