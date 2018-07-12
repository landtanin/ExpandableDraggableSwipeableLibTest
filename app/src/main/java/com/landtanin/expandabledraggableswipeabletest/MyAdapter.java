package com.landtanin.expandabledraggableswipeabletest;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemAdapter;
import com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemConstants;
import com.h6ah4i.android.widget.advrecyclerview.swipeable.action.SwipeResultAction;
import com.h6ah4i.android.widget.advrecyclerview.swipeable.action.SwipeResultActionDoNothing;
import com.h6ah4i.android.widget.advrecyclerview.swipeable.action.SwipeResultActionMoveToSwipedDirection;
import com.h6ah4i.android.widget.advrecyclerview.utils.AbstractSwipeableItemViewHolder;
import com.landtanin.expandabledraggableswipeabletest.expandableSwipeableRV.model.HomeAlarmChildModel;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.RecyclerViewHolder> implements SwipeableItemAdapter<MyAdapter.RecyclerViewHolder> {

    Context context;
    private List<HomeAlarmChildModel> newList;

    public MyAdapter(Context context, List<HomeAlarmChildModel> newList) {
        setHasStableIds(true);
        this.context = context;
        this.newList = newList;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);

        return new RecyclerViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {

        RecyclerViewHolder holder1 = holder;
        holder1.textView.setText(newList.get(position).getTimeStr());

    }

    @Override
    public int getItemCount() {
        return newList.size();
    }

    @Override
    public long getItemId(int position) {
        return newList.get(position).getId();
    }

    // Swipeable adapter
    private interface Swipeable extends SwipeableItemConstants {
    }

    @Override
    public int onGetSwipeReactionType(RecyclerViewHolder holder, int position, int x, int y) {
        return Swipeable.REACTION_CAN_SWIPE_BOTH_H;
    }

    @Override
    public void onSwipeItemStarted(RecyclerViewHolder holder, int position) {
        notifyDataSetChanged();
    }

    @Override
    public void onSetSwipeBackground(RecyclerViewHolder holder, int position, int type) {
        if (type == Swipeable.DRAWABLE_SWIPE_LEFT_BACKGROUND) {
            holder.itemView.setBackgroundColor(Color.CYAN);

        } else if (type == Swipeable.DRAWABLE_SWIPE_RIGHT_BACKGROUND) {
            holder.itemView.setBackgroundColor(Color.GREEN);

        } else {
            holder.itemView.setBackgroundColor(Color.TRANSPARENT);
        }
    }

    @Override
    public SwipeResultAction onSwipeItem(RecyclerViewHolder holder, int position, int result) {
        // Return sub class of the SwipeResultAction.
        //
        // Available base (abstract) classes are;
        // - SwipeResultActionDefault
        // - SwipeResultActionMoveToSwipedDirection
        // - SwipeResultActionRemoveItem
        // - SwipeResultActionDoNothing

        // The argument "result" can be one of the followings;
        //
        // - Swipeable.RESULT_CANCELED
        // - Swipeable.RESULT_SWIPED_LEFT
        // (- Swipeable.RESULT_SWIPED_UP)
        // (- Swipeable.RESULT_SWIPED_RIGHT)
        // (- Swipeable.RESULT_SWIPED_DOWN)

        if (result == Swipeable.RESULT_SWIPED_RIGHT) {
            return new SwipeResultActionMoveToSwipedDirection() {
                // Optionally, you can override these three methods
                // - void onPerformAction()
                // - void onSlideAnimationEnd()
                // - void onCleanUp()

            };
        } else if (result == Swipeable.RESULT_SWIPED_LEFT) {
            return new SwipeResultActionMoveToSwipedDirection() {
                // Optionally, you can override these three methods
                // - void onPerformAction()
                // - void onSlideAnimationEnd()
                // - void onCleanUp()

            };
        } else {
            return new SwipeResultActionDoNothing();
        }
    }

    // ViewHolder
    static class RecyclerViewHolder extends AbstractSwipeableItemViewHolder {

        TextView textView;
        FrameLayout containerView;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(android.R.id.text1);
            containerView = itemView.findViewById(R.id.container);
        }

        @Override
        public View getSwipeableContainerView() {
            return containerView;
        }
    }
}