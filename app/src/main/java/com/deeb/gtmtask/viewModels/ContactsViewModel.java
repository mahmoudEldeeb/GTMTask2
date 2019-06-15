package com.deeb.gtmtask.viewModels;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.util.Log;

import com.deeb.gtmtask.models.ContactsModel;
import com.deeb.gtmtask.models.utils.Constants;

import java.util.ArrayList;
import java.util.List;

public class ContactsViewModel extends ViewModel {
    MutableLiveData<List<ContactsModel>>contacts;
    ContactsModel contactsModel;
    public MutableLiveData<List<ContactsModel>>getContacts(){
        contacts=new MutableLiveData<>();
        contacts.setValue(new ArrayList<ContactsModel>());
        // use getContentResolver to get contacts
        Cursor cursor= Constants.context.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                null,null,null,null);
        while (cursor.moveToNext()){
           String name= cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            String number= cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            contactsModel=new ContactsModel(name,number);
            contacts.getValue().add(contactsModel);
        }
return contacts;
    }
}
