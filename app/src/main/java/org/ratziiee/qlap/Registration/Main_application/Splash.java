package org.ratziiee.qlap.Registration.Main_application;

import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;


import org.ratziiee.qlap.R;
import org.ratziiee.qlap.Registration.Registration.First_Screen;

import java.util.ArrayList;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        if (Build.VERSION.SDK_INT >= 23)
        {
            //permission
            checkPermission();
        }
        else
        {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent i = new Intent(Splash.this, First_Screen.class);
                    startActivity(i);
                    finish();
                }
            }, 2000);

        }

    }

    private void checkPermission(){


        TedPermission.with(this)
                .setPermissionListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted() {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent i = new Intent(Splash.this, First_Screen.class);
                                startActivity(i);
                                finish();
                            }
                        }, 2000);
                    }
                    @Override
                    public void onPermissionDenied(ArrayList<String> deniedPermissions) {
                        Toast.makeText(Splash.this,"Unable to Run Application without required permission",Toast.LENGTH_LONG).show();
                        finishAffinity();
                    }
                })
                .setDeniedMessage("Unable to run app without these permission\n\nPlease turn on permissions at [Setting] > [Permission]")
                .setPermissions(Manifest.permission.ACCESS_COARSE_LOCATION,Manifest.permission.ACCESS_FINE_LOCATION)
                .check();

    }

}
