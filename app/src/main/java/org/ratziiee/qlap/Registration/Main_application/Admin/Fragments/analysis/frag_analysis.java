package org.ratziiee.qlap.Registration.Main_application.Admin.Fragments.analysis;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import org.ratziiee.qlap.R;

public class frag_analysis extends Fragment {

    Spinner spn_analysis;
    ImageView iv_analysis;
    TextView tv_theroy;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.frag_analysis,container,false);

        spn_analysis=v.findViewById(R.id.spn_analysis);
        iv_analysis=v.findViewById(R.id.iv_analysis);
        tv_theroy=v.findViewById(R.id.tv_theroy);
        spn_analysis.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i>0)
                {
                    if(i==1)
                    {
                        Intent intent=new Intent(getActivity(),heatMap.class);
                        startActivity(intent);
                    }
                    else if(i==2)
                    {
                        iv_analysis.setBackgroundResource(R.drawable.income_wise_mode_selection);
                        tv_theroy.setText("The income data has been collected by primary survey of the localities. The graphs get changed continuously based on the usage trends and statistics");
                    }
                    else if(i==3)
                    {
                        iv_analysis.setBackgroundResource(R.drawable.time_wise_mode_selection);
                        tv_theroy.setText("The data has been analysed anonymously for QLAP users. The data keeps on changing depending upon the usage dynamics.");
                    }
                    else if(i==4)
                    {
                        Intent intent=new Intent(getActivity(),tisba_analysis.class);
                        startActivity(intent);
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        return v;
    }
}
