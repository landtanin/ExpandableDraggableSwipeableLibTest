package com.landtanin.expandabledraggableswipeabletest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.h6ah4i.android.widget.advrecyclerview.utils.AbstractExpandableItemAdapter;
import com.h6ah4i.android.widget.advrecyclerview.utils.AbstractExpandableItemViewHolder;
import com.landtanin.expandabledraggableswipeabletest.expandableSwipeableRV.model.HomeAlarmChildItem;
import com.landtanin.expandabledraggableswipeabletest.expandableSwipeableRV.model.HomeAlarmGroupItem;

import java.util.List;

public class ExpandableAdapter extends AbstractExpandableItemAdapter<ExpandableAdapter.GroupVH, ExpandableAdapter.ChildVH> {

    Context context;
    private List<HomeAlarmGroupItem> groupModels;

    public ExpandableAdapter(Context context, List<HomeAlarmGroupItem> groupModels) {
        setHasStableIds(true);
        this.context = context;
        this.groupModels = groupModels;
    }

    @Override
    public int getGroupCount() {
        return groupModels.size();
    }

    @Override
    public int getChildCount(int groupPosition) {
        return groupModels.get(groupPosition).children.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupModels.get(groupPosition).getId();
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return groupModels.get(groupPosition).children.get(childPosition).getId();
    }

    @Override
    public GroupVH onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);

        return new GroupVH(itemView);
    }

    @Override
    public ChildVH onCreateChildViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);

        return new ChildVH(itemView);
    }

    @Override
    public void onBindGroupViewHolder(GroupVH holder, int groupPosition, int viewType) {

        HomeAlarmGroupItem item = groupModels.get(groupPosition);
        holder.textView.setText(item.getTitleStr());
    }

    @Override
    public void onBindChildViewHolder(ChildVH holder, int groupPosition, int childPosition, int viewType) {

        HomeAlarmChildItem item = groupModels.get(childPosition).children.get(childPosition);
        holder.textView.setText(item.getTimeStr());
    }

    @Override
    public boolean onCheckCanExpandOrCollapseGroup(GroupVH holder, int groupPosition, int x, int y, boolean expand) {
        return true;
    }

    static class ChildVH extends AbstractExpandableItemViewHolder {

        TextView textView;

        public ChildVH(View itemView) {
            super(itemView);
            textView = itemView.findViewById(android.R.id.text1);
        }
    }

    static class GroupVH extends AbstractExpandableItemViewHolder {

        TextView textView;

        public GroupVH(View itemView) {
            super(itemView);
            textView = itemView.findViewById(android.R.id.text1);
        }
    }
}
