package org.ratziiee.qlap.Registration.Main_application.Rider.Fragments.Book_ride;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import org.ratziiee.qlap.R;

public class book_ride extends Fragment {

    ImageView iv_reach_metro,iv_travel_from_metro;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.book_ride,container,false);

        iv_reach_metro=v.findViewById(R.id.iv_reach_metro);
        iv_travel_from_metro=v.findViewById(R.id.iv_from_metro);

        iv_reach_metro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent i=new Intent(getActivity(),Book_ride_1.class);
               startActivity(i);

            }
        });

        iv_travel_from_metro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(getActivity(),Book_ride_last_mile.class);
                startActivity(i);
            }
        });
        return v;
    }
}
