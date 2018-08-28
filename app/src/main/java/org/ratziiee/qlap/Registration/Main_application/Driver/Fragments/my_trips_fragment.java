package org.ratziiee.qlap.Registration.Main_application.Driver.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.ratziiee.qlap.R;
import org.ratziiee.qlap.Registration.Main_application.Driver.Fragments.my_trip_driver.completed_fragment;
import org.ratziiee.qlap.Registration.Main_application.Driver.Fragments.my_trip_driver.ongoing_fragment;
import org.ratziiee.qlap.Registration.Main_application.Driver.Fragments.my_trip_driver.scheduled_fragment;
import org.ratziiee.qlap.Registration.Main_application.Rider.Fragments.MyCards.available_balance;
import org.ratziiee.qlap.Registration.Main_application.Rider.Fragments.Profile.profile_rider;

import java.util.ArrayList;
import java.util.List;

public class my_trips_fragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment_driver,container, false);
        // Setting ViewPager for each Tabs
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        // Set Tabs inside Toolbar
        TabLayout tabs = (TabLayout) view.findViewById(R.id.result_tabs);
        tabs.setupWithViewPager(viewPager);


        return view;

    }

    private void setupViewPager(ViewPager viewPager) {


        Adapter adapter = new Adapter(getChildFragmentManager());
        adapter.addFragment(new ongoing_fragment(), "Ongoing");
        adapter.addFragment(new scheduled_fragment(), "Scheduled");
        adapter.addFragment(new completed_fragment(), "Completed");

        viewPager.setAdapter(adapter);



    }

    static class Adapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public Adapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

}
