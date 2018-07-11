package com.landtanin.expandabledraggableswipeabletest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.landtanin.expandabledraggableswipeabletest.expandableSwipeableRV.model.HomeAlarmChildItem;

import java.util.List;

public class SimpleAdapter extends RecyclerView.Adapter<SimpleAdapter.SimpleViewHolder> {

    Context context;
    private List<HomeAlarmChildItem> modelList;

    public SimpleAdapter(Context context, List<HomeAlarmChildItem> modelList) {
        this.context = context;
        this.modelList = modelList;
    }

    @Override
    public SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);

        return new SimpleViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SimpleViewHolder holder, int position) {

        SimpleViewHolder holder1 = holder;
        holder1.textView.setText(modelList.get(position).getTimeStr());

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class SimpleViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public SimpleViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(android.R.id.text1);
        }

    }
}
