package com.landtanin.expandabledraggableswipeabletest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.landtanin.expandabledraggableswipeabletest.utils.ActivityUtils;

public class MainActivity extends AppCompatActivity {


//    private List<StupidModel> models = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
//        recyclerView = findViewById(R.id.rv);
//        RecyclerViewExpandableItemManager expandableItemManager
//                = new RecyclerViewExpandableItemManager(null);
//
//        ExpandableAdapter expandableAdapter = new ExpandableAdapter(this, groupModels);
//        RecyclerView.Adapter wrappedAdapter = expandableItemManager
//                                                .createWrappedAdapter(expandableAdapter);
//
//
//        recyclerView.setAdapter(wrappedAdapter);
//        recyclerView.setLayoutManager(linearLayoutManager);
//        recyclerView.setHasFixedSize(true);
//
//        ((SimpleItemAnimator) recyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
//
//        expandableItemManager.attachRecyclerView(recyclerView);


        // Swipable + Expandable
//        recyclerView = findViewById(R.id.rv);
//
//        RecyclerViewExpandableItemManager expandableItemManager
//                = new RecyclerViewExpandableItemManager(null);
//
//        ExpandableAdapter expandableAdapter = new ExpandableAdapter(this, groupModels);
//        RecyclerView.Adapter wrappedAdapter = expandableItemManager
//                .createWrappedAdapter(expandableAdapter);
//
//
//        recyclerView.setAdapter(wrappedAdapter);
//        recyclerView.setLayoutManager(linearLayoutManager);
//        recyclerView.setHasFixedSize(true);
//
//        ((SimpleItemAnimator) recyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
//
//        expandableItemManager.attachRecyclerView(recyclerView);

        MainFragment mainFragment = new MainFragment();
        ActivityUtils.addFragmentToActivity(
                getSupportFragmentManager(),
                mainFragment,
                R.id.main_content_container
        );

    }
}
