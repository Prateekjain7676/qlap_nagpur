package org.ratziiee.qlap.Registration.Main_application.Rider.Fragments.Book_ride;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.ratziiee.qlap.R;
import org.ratziiee.qlap.Registration.Main_application.Rider.main_application;

public class book_ride_6 extends AppCompatActivity {

    Button btn_done;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_ride_6);

        btn_done=findViewById(R.id.btn_done);
        btn_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(book_ride_6.this, main_application.class);
                startActivity(i);
            }
        });
    }
}
