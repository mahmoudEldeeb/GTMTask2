package com.deeb.gtmtask.viewModels;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.deeb.gtmtask.R;
import com.deeb.gtmtask.models.CountryModel;
import com.deeb.gtmtask.models.utils.Constants;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CountryViewModels extends ViewModel {
    public MutableLiveData<List<CountryModel>>getCountries(String searchText){
        MutableLiveData<List<CountryModel>>countrieesList=new MutableLiveData<>();
        countrieesList.setValue(new ArrayList<CountryModel>());
        CountryModel countryModel;
        try {
            JSONObject object=new JSONObject(Constants.COUNTRIES_JSON);
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
