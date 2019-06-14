package com.deeb.gtmtask.views.fragments;


import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.deeb.gtmtask.R;
import com.deeb.gtmtask.models.database.DataItem;
import com.deeb.gtmtask.viewModels.DataViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class SaveData extends Fragment {


    public SaveData() {
        // Required empty public constructor
    }
    Button save_data;
    EditText description,title;
    DataViewModel dataViewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_save_data, container, false);
        save_data=view.findViewById(R.id.save_data);
        title=view.findViewById(R.id.title);
        description=view.findViewById(R.id.description);
        dataViewModel= ViewModelProviders.of(this).get(DataViewModel.class);
        save_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataItem dataItem=new DataItem(title.getText().toString(),description.getText().toString());
                dataViewModel.insert(dataItem);
            }
        });
        return view;
    }

}
