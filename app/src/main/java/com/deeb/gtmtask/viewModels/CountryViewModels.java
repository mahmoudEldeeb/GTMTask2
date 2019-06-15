package com.deeb.gtmtask.viewModels;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.deeb.gtmtask.models.CountryModel;
import com.deeb.gtmtask.models.utils.Constants;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CountryViewModels extends ViewModel {
    /*
    this method take search character and get all country contain this characters
     */
    public MutableLiveData<List<CountryModel>>getCountries(String searchText){
        MutableLiveData<List<CountryModel>>countrieesList=new MutableLiveData<>();
        countrieesList.setValue(new ArrayList<CountryModel>());
        CountryModel countryModel;
        try {
            JSONObject object=new JSONObject(Constants.COUNTRIES_JSON);
            // this Json contain all countries name
            JSONArray contries=object.getJSONArray(Constants.countries);
            for (int i=0;i<contries.length();i++){
                JSONObject countryObject=contries.getJSONObject(i);
                if(countryObject.getString("en").toLowerCase().contains(searchText)) {
                    countryModel = new CountryModel(countryObject.getString("en"),
                            countryObject.getString("local"), countryObject.getString("code"));
                    countrieesList.getValue().add(countryModel);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
return countrieesList;
    }

}
