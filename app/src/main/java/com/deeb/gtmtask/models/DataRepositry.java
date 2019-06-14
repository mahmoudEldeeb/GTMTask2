package com.deeb.gtmtask.models;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.deeb.gtmtask.models.database.DataDao;
import com.deeb.gtmtask.models.database.DataItem;
import com.deeb.gtmtask.models.database.database;
import com.deeb.gtmtask.models.utils.Constants;

import java.util.List;

public class DataRepositry {
    private DataDao dataDao;
    public DataRepositry() {
        database db = database.getDatabase(Constants.application);
        dataDao= db.dao();
    }

    public void insert (DataItem dataItem) {
        new insertAsyncTask().execute(dataItem);
    }
    public LiveData<List<DataItem>>getData(){
        return dataDao.getData();

    }


    private  class insertAsyncTask extends AsyncTask<DataItem, Void, Void> {


        @Override
        protected Void doInBackground(final DataItem... params) {
            try {

                dataDao.insert(params[0]);

            }
            catch (Exception e){

            }
            return null;
        }
    }


}
