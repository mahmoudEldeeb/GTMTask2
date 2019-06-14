package com.deeb.gtmtask.views.fragments;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.deeb.gtmtask.R;
import com.deeb.gtmtask.adapters.DataAdapter;
import com.deeb.gtmtask.models.database.DataItem;
import com.deeb.gtmtask.viewModels.DataViewModel;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class RetreveData extends Fragment {


    public RetreveData() {
        // Required empty public constructor
    }

RecyclerView data_res;
    DataAdapter dataAdapter;
    DataViewModel dataViewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_retreve_data, container, false);
        data_res=view.findViewById(R.id.data_res);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getActivity());
        data_res.setLayoutManager(layoutManager);
        dataViewModel= ViewModelProviders.of(this).get(DataViewModel.class);
        dataViewModel.getData().observe(this, new Observer<List<DataItem>>() {
            @Override
            public void onChanged(@Nullable List<DataItem> dataItems) {
                dataAdapter=new DataAdapter(dataItems);
                data_res.setAdapter(dataAdapter);
            }
        });

        return view;
    }

}
