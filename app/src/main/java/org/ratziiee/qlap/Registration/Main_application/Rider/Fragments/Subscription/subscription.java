package org.ratziiee.qlap.Registration.Main_application.Rider.Fragments.Subscription;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.ratziiee.qlap.R;
import org.ratziiee.qlap.Registration.Main_application.Rider.Fragments.Subscription.Create_subscription.Create_subscription;
import org.ratziiee.qlap.Registration.Main_application.Rider.Fragments.Subscription.Create_subscription.create_subs_pre;

public class subscription extends Fragment {

    TextView tv_view_subscription,tv_create_subscription;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=LayoutInflater.from(getContext()).inflate(R.layout.subscription_fragment,container,false);

        tv_view_subscription=v.findViewById(R.id.tv_view_subscription);
        tv_create_subscription=v.findViewById(R.id.tv_create_subscription);
        tv_view_subscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getActivity(),View_subscription.class);
                startActivity(i);
            }
        });

        tv_create_subscription.setOnClickListener(view -> {
            Intent i=new Intent(getActivity(),create_subs_pre.class);
            startActivity(i);
        });
        return v;
    }
}
