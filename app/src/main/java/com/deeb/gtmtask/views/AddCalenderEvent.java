package com.deeb.gtmtask.views;

import android.Manifest;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.CalendarContract;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.deeb.gtmtask.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class AddCalenderEvent extends AppCompatActivity {
int MY_PERMISSIONS_REQUEST_READ_CONTACTS=122;
Button save_event;
    EditText description,title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_calender_event);
        save_event=findViewById(R.id.save_event);

        title=findViewById(R.id.title);
        description=findViewById(R.id.description);

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_CALENDAR)
                != PackageManager.PERMISSION_GRANTED
        ) {

                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.WRITE_CALENDAR},
                        MY_PERMISSIONS_REQUEST_READ_CONTACTS);

            }


save_event.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        addEvent();
    }
});
    }

    private void addEvent() {
/// here i use date of today you can change it as you want
        SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
        Calendar dt = Calendar.getInstance();

        dt.add(Calendar.DATE, 1);
        String dtStart = yyyyMMdd.format(dt.getTime());

        ContentResolver cr = getContentResolver();
        ContentValues values = new ContentValues();

        values.put(CalendarContract.Events.DTSTART, dtStart);
        values.put(CalendarContract.Events.TITLE, title.getText().toString());
        values.put(CalendarContract.Events.DESCRIPTION, description.getText().toString());

        TimeZone timeZone = TimeZone.getDefault();
        values.put(CalendarContract.Events.EVENT_TIMEZONE, timeZone.getID());

// Default calendar
        values.put(CalendarContract.Events.CALENDAR_ID, 1);

        values.put(CalendarContract.Events.DURATION, "+P1H");

        values.put(CalendarContract.Events.HAS_ALARM, 1);

// Insert event to calendar
        Uri uri = cr.insert(CalendarContract.Events.CONTENT_URI, values);
     if(uri!=null){
         Toast.makeText(getBaseContext(),"done",Toast.LENGTH_SHORT).show();
     }
    }
}
