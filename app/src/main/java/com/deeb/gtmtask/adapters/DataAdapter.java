package com.deeb.gtmtask.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.deeb.gtmtask.R;
import com.deeb.gtmtask.models.database.DataItem;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
List<DataItem>list;

    public DataAdapter(List<DataItem> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ViewHolder viewHolder;
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.data_item, viewGroup, false);
    viewHolder=new ViewHolder(view);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull DataAdapter.ViewHolder viewHolder, int i) {
viewHolder.title.setText(list.get(i).title);
viewHolder.description.setText(list.get(i).description);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView title,description;


        public ViewHolder(View v) {
            super(v);
            title =  v.findViewById(R.id.title);
            description =  v.findViewById(R.id.description);
        }

    }

}
