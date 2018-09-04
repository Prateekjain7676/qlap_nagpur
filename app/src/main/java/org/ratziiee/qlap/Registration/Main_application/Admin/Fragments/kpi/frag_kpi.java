package org.ratziiee.qlap.Registration.Main_application.Admin.Fragments.kpi;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;

import org.ratziiee.qlap.R;


public class frag_kpi extends Fragment
{

    Spinner spn_parameter,spn_specific_lines,spn_metrostation;
    Button btn_station_all,btn_mode_all,btn_time_date,btn_trip_type_both;
    int val_btn_station_all =0,val_btn_mode_all=0,val_btn_time_date=0,val_btn_trip_type_both=0;
    LinearLayout lay_filter;
    FloatingActionButton btn_fab;
    ImageView iv_graph;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.frag_kpi,container,false);

        spn_parameter=v.findViewById(R.id.spn_parameter);
        spn_specific_lines=v.findViewById(R.id.spn_specific_lines);
        spn_metrostation=v.findViewById(R.id.spn_metrostation);
        lay_filter=v.findViewById(R.id.lay_filter);
        btn_fab=v.findViewById(R.id.btn_fab);
        iv_graph=v.findViewById(R.id.iv_graph);

        btn_station_all =v.findViewById(R.id.btn_station_all);
        btn_mode_all=v.findViewById(R.id.btn_mode_all);
        btn_time_date=v.findViewById(R.id.btn_time_date);
        btn_trip_type_both=v.findViewById(R.id.btn_type_both);


        btn_station_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                val_btn_station_all=1;
                SpannableString spanString = new SpannableString("All");
                spanString.setSpan(new StyleSpan(Typeface.BOLD), 0, spanString.length(), 0);
                btn_station_all.setText(spanString);
                btn_station_all.setTextColor(getResources().getColor(R.color.text_color));
                set_text_bold(btn_station_all,"ALL");
            }
        });

        btn_mode_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                val_btn_mode_all=1;
                SpannableString spanString = new SpannableString("All");
                spanString.setSpan(new StyleSpan(Typeface.BOLD), 0, spanString.length(), 0);
                btn_mode_all.setText(spanString);
                btn_mode_all.setTextColor(getResources().getColor(R.color.text_color));
                set_text_bold(btn_mode_all,"ALL");
            }
        });

        btn_time_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                val_btn_time_date=1;
                SpannableString spanString = new SpannableString("All");
                spanString.setSpan(new StyleSpan(Typeface.BOLD), 0, spanString.length(), 0);
                btn_time_date.setText(spanString);
                btn_time_date.setTextColor(getResources().getColor(R.color.text_color));
                set_text_bold(btn_time_date,"DATE");
            }
        });

        btn_trip_type_both.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                val_btn_trip_type_both=1;
                SpannableString spanString = new SpannableString("All");
                spanString.setSpan(new StyleSpan(Typeface.BOLD), 0, spanString.length(), 0);
                btn_trip_type_both.setText(spanString);
                btn_trip_type_both.setTextColor(getResources().getColor(R.color.text_color));
                set_text_bold(btn_trip_type_both,"BOTH");

                if(val_btn_station_all==1 && val_btn_mode_all==1 && val_btn_time_date==1 && val_btn_trip_type_both==1)
                {
                    String[] some_array = getResources().getStringArray(R.array.default_params);
                    ArrayAdapter adapter = new ArrayAdapter<>(getActivity(), R.layout.support_simple_spinner_dropdown_item, some_array);
                    spn_parameter.setAdapter(adapter);
                }

            }
        });

        spn_parameter.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i>0)
                {
                    if(val_btn_station_all==1 && val_btn_mode_all==1 && val_btn_time_date==1 && val_btn_trip_type_both==1)
                    {
                        lay_filter.setVisibility(View.GONE);
                        iv_graph.setVisibility(View.VISIBLE);

                        if(spn_parameter.getSelectedItemPosition()==1)
                        {
                            iv_graph.setImageResource(R.drawable.ride_taken);
                        }
                        else if(spn_parameter.getSelectedItemPosition()==2)
                        {
                            iv_graph.setImageResource(R.drawable.earing_km);
                        }
                        else if(spn_parameter.getSelectedItemPosition()==3)
                        {
                            iv_graph.setImageResource(R.drawable.cost_per_km);
                        }
                        else if(spn_parameter.getSelectedItemPosition()==4)
                        {
                            iv_graph.setImageResource(R.drawable.ride_rating);
                        }
                        else
                        {
                            lay_filter.setVisibility(View.VISIBLE);
                            iv_graph.setVisibility(View.GONE);
                        }


                    }
                }
                else
                {

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btn_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lay_filter.setVisibility(View.VISIBLE);
                iv_graph.setVisibility(View.GONE);
            }
        });


        return v;
    }

    private void set_text_bold(Button btn,String text)
    {
        SpannableString spanString = new SpannableString(text);
        spanString.setSpan(new StyleSpan(Typeface.BOLD), 0, spanString.length(), 0);
        btn.setText(spanString);
        btn.setTextColor(getResources().getColor(R.color.text_color));
    }
}
