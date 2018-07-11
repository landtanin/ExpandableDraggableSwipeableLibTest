package com.landtanin.expandabledraggableswipeabletest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;

import com.h6ah4i.android.widget.advrecyclerview.expandable.RecyclerViewExpandableItemManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
//    private List<StupidModel> models = new ArrayList<>();
    private List<StupidGroupModel> groupModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        for (int groupIndex = 0; groupIndex < 15; groupIndex++) {

            StupidGroupModel group = new StupidGroupModel(
                    groupIndex,
                    "group " + groupIndex);
            for (int i = 0; i < 5; i++) {
                group.children.add(new StupidModel(i, "name " + i));
            }

            groupModels.add(group);
        }

        // Swipeable RV
//        recyclerView = findViewById(R.id.rv);
//        RecyclerViewSwipeManager swipeManager = new RecyclerViewSwipeManager();
//
//        MyAdapter recyclerAdapter = new MyAdapter(this, models);
//        RecyclerView.Adapter wrappedAdapter = swipeManager.createWrappedAdapter(recyclerAdapter);
//
//        recyclerView.setAdapter(wrappedAdapter);
//        recyclerView.setLayoutManager(linearLayoutManager);
//        recyclerView.setHasFixedSize(true);
//
//        swipeManager.attachRecyclerView(recyclerView);

        // Expandable RV
        recyclerView = findViewById(R.id.rv);
        RecyclerViewExpandableItemManager expandableItemManager
                = new RecyclerViewExpandableItemManager(null);

        ExpandableAdapter expandableAdapter = new ExpandableAdapter(this, groupModels);
        RecyclerView.Adapter wrappedAdapter = expandableItemManager
                                                .createWrappedAdapter(expandableAdapter);


        recyclerView.setAdapter(wrappedAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);

        ((SimpleItemAnimator) recyclerView.getItemAnimator()).setSupportsChangeAnimations(false);

        expandableItemManager.attachRecyclerView(recyclerView);

    }
}
