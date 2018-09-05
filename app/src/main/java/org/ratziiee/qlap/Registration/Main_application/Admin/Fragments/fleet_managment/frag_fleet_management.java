package org.ratziiee.qlap.Registration.Main_application.Admin.Fragments.fleet_managment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import org.ratziiee.qlap.R;
import org.ratziiee.qlap.Registration.Main_application.Admin.Fragments.fleet_managment.last_mile.fleet_last_mile;

public class frag_fleet_management extends Fragment {

    Button btn_show;
    Spinner spn_trip_type;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.frag_fleet_managment,container,false);

        spn_trip_type=v.findViewById(R.id.spn_trip_type);

        btn_show=v.findViewById(R.id.btn_show);
        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(spn_trip_type.getSelectedItemPosition()==1)
                {
                    Intent i = new Intent(getActivity(), Fleet_activity_1.class);
                    startActivity(i);
                }
                else if(spn_trip_type.getSelectedItemPosition()==2)
                {
                    Intent i = new Intent(getActivity(), fleet_last_mile.class);
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(getActivity(), "Please select trip type...", Toast.LENGTH_SHORT).show();
                }

            }
        });
        return v;
    }
}
