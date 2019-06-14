package com.deeb.gtmtask.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.deeb.gtmtask.R;
import com.deeb.gtmtask.models.ContactsModel;


import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {
    List<ContactsModel> list;

    public ContactAdapter(List<ContactsModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ContactAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ContactAdapter.ViewHolder viewHolder;
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.data_item, viewGroup, false);
        viewHolder = new ContactAdapter.ViewHolder(view);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull ContactAdapter.ViewHolder viewHolder, int i) {
        viewHolder.title.setText(list.get(i).getName());
        viewHolder.description.setText(list.get(i).getNumber());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView title, description;


        public ViewHolder(View v) {
            super(v);
            title = v.findViewById(R.id.title);
            description = v.findViewById(R.id.description);
        }

    }
}