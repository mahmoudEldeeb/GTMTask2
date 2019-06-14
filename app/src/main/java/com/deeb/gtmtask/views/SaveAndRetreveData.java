package com.deeb.gtmtask.views;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.deeb.gtmtask.R;
import com.deeb.gtmtask.models.utils.Constants;
import com.deeb.gtmtask.views.fragments.RetreveData;
import com.deeb.gtmtask.views.fragments.SaveData;

public class SaveAndRetreveData extends AppCompatActivity {
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    Fragment selectedFragment;
    Button save_data,retreve_data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_and_retreve_data);
        Constants.application=this.getApplication();
        save_data=findViewById(R.id.save_data);
        retreve_data=findViewById(R.id.retreve_data);
        selectedFragment=new SaveData();
        replaceFragment();

        save_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedFragment=new SaveData();
                replaceFragment();
            }
        });

        retreve_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedFragment=new RetreveData();
                replaceFragment();
            }
        });
    }
    public void replaceFragment(){
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction =
                fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.data_fram, selectedFragment);
        fragmentTransaction.commit();
    }
    }

