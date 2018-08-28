package org.ratziiee.qlap.Registration.Main_application.Rider;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import org.ratziiee.qlap.R;
import org.ratziiee.qlap.Registration.Main_application.Rider.Fragments.Book_ride.book_ride;
import org.ratziiee.qlap.Registration.Main_application.Rider.Fragments.Help.help_fragment;
import org.ratziiee.qlap.Registration.Main_application.Rider.Fragments.MyCards.available_balance;
import org.ratziiee.qlap.Registration.Main_application.Rider.Fragments.MyTrips.my_trips;
import org.ratziiee.qlap.Registration.Main_application.Rider.Fragments.Profile.profile_rider;
import org.ratziiee.qlap.Registration.Main_application.Rider.Fragments.Subscription.subscription;

public class main_application extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_application);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("QLAP");


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        transition(new book_ride());
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_book_ride)
        {
            Intent i=new Intent(main_application.this, main_application.class);
            startActivity(i);
            // Handle the camera action
        } else if (id == R.id.nav_my_trip)
        {
            transition(new my_trips());
        } else if (id == R.id.nav_my_cards)
        {
            transition(new available_balance());

        } else if (id == R.id.nav_account)
        {

            transition(new profile_rider());
        } else if (id == R.id.nav_help)
        {
            transition(new help_fragment());
        }
        else if (id == R.id.nav_subscription)
        {
            transition(new subscription());
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private void transition(Fragment fragment)
    {
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.lay_frame,fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
