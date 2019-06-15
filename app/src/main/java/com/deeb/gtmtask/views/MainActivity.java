package com.deeb.gtmtask.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.deeb.gtmtask.R;

public class MainActivity extends AppCompatActivity {
Button  login,event,contact,country_search,save_data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        save_data=findViewById(R.id.save_data);
        login=findViewById(R.id.login);
        event=findViewById(R.id.event);
        contact=findViewById(R.id.contact);
        country_search=findViewById(R.id.country_search);
        country_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,CountrySearch.class));
            }
        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,LoginUsingFacebookk.class));
            }
        });

        save_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SaveAndRetreveData.class));
            }
        });

        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,LoadContacts.class));
            }
        });

        event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,AddCalenderEvent.class));
            }
        });
    }
}
