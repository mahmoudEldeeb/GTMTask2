package com.deeb.gtmtask.models.database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "data_table")
public class DataItem
{
    @PrimaryKey(autoGenerate = true)
    @NonNull
    public int id;
    public String title,description;


    public DataItem(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
