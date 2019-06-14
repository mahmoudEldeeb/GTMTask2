package com.deeb.gtmtask.models.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface DataDao {
    @Insert
    void insert(DataItem cartItem);

    @Query("SELECT * FROM data_table")
    LiveData<List<DataItem>> getData();


}
