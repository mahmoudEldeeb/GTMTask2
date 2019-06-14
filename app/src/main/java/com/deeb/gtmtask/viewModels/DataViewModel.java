package com.deeb.gtmtask.viewModels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.deeb.gtmtask.models.DataRepositry;
import com.deeb.gtmtask.models.database.DataItem;

import java.util.List;

public class DataViewModel extends ViewModel {
    DataRepositry dataRepositry;
    public void insert(DataItem dataItem){
       dataRepositry= new DataRepositry();
        dataRepositry.insert(dataItem);
    }

    public LiveData<List<DataItem>> getData(){
       dataRepositry= new DataRepositry();
        return dataRepositry.getData();
    }

}
