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

import org.ratziiee.qlap.R;

public class frag_fleet_management extends Fragment {

    Button btn_show;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.frag_fleet_managment,container,false);

        btn_show=v.findViewById(R.id.btn_show);
        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getActivity(),Fleet_activity_1.class);
                startActivity(i);
            }
        });
        return v;
    }
}
