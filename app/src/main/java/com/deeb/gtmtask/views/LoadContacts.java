package com.deeb.gtmtask.views;

import android.Manifest;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.deeb.gtmtask.R;
import com.deeb.gtmtask.adapters.ContactAdapter;
import com.deeb.gtmtask.models.ContactsModel;
import com.deeb.gtmtask.models.utils.Constants;
import com.deeb.gtmtask.viewModels.ContactsViewModel;


import java.util.List;

public class LoadContacts extends AppCompatActivity {
RecyclerView contacts_res;
ContactsViewModel contactsViewModel;
    ContactAdapter contactAdapter;
    int MY_PERMISSIONS_REQUEST_READ_CONTACTS=123;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_contacts);

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED
        ) {

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_CONTACTS},
                    MY_PERMISSIONS_REQUEST_READ_CONTACTS);

        }
        Constants.context=this;
        contacts_res=findViewById(R.id.contacts_res);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
        contacts_res.setLayoutManager(layoutManager);
        contactsViewModel= ViewModelProviders.of(this).get(ContactsViewModel.class);
        contactsViewModel.getContacts().observe(this, new Observer<List<ContactsModel>>() {
    @Override
    public void onChanged(@Nullable List<ContactsModel> contactsModels) {
        contactAdapter=new ContactAdapter(contactsModels);
        contacts_res.setAdapter(contactAdapter);
    }
});
    }
}
