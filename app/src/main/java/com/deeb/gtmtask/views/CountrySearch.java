package com.deeb.gtmtask.views;

import android.app.Activity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.support.v7.widget.SearchView;
import android.widget.TextView;

import com.deeb.gtmtask.R;
import com.deeb.gtmtask.adapters.SuggestionsAdapter;
import com.deeb.gtmtask.models.CountryModel;
import com.deeb.gtmtask.models.utils.Constants;
import com.deeb.gtmtask.viewModels.CountryViewModels;

import java.util.Collections;
import java.util.List;

public class CountrySearch extends AppCompatActivity {
SearchView search_view;
SuggestionsAdapter mSuggestionsAdapter;
CountryViewModels countryViewModels;
MatrixCursor cursor;
TextView country_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_search);
        search_view=findViewById(R.id.search_view);
        Constants.context=this;
        country_name=findViewById(R.id.country_name);
        countryViewModels= ViewModelProviders.of(this).get(CountryViewModels.class);
        search_view.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                country_name.setText(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                search(newText);
                return false;
            }
        });

        search_view.setOnSuggestionListener(new SearchView.OnSuggestionListener() {
            @Override
            public boolean onSuggestionSelect(int i) {
                return false;
            }

            @Override
            public boolean onSuggestionClick(int i) {
                search_view.setQuery(cursor.getString(1),true);
//                country_name.setText(cursor.getString(1));
                return false;
            }
        });
    }

    public void search(String newText){
        countryViewModels.getCountries(newText).observe(this, new Observer<List<CountryModel>>() {
            @Override
            public void onChanged(@Nullable List<CountryModel> countryModels) {
                String[] columns = new String[]{"_id", "text"};
                cursor = new MatrixCursor(columns);
                mSuggestionsAdapter = new SuggestionsAdapter(CountrySearch.this, cursor);
                search_view.setSuggestionsAdapter(mSuggestionsAdapter);
                for(int i=0;i<countryModels.size();i++){
                    Object[] temp = new Object[]{0, countryModels.get(i).en};
                    cursor.addRow(temp);
                  }
                mSuggestionsAdapter.notifyDataSetChanged();
            }
        });
    }
}
