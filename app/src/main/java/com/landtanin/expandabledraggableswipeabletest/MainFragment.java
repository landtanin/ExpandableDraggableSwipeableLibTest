package com.landtanin.expandabledraggableswipeabletest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.h6ah4i.android.widget.advrecyclerview.expandable.RecyclerViewExpandableItemManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by landtanin on 5/1/2017 AD.
 */
public class MainFragment extends Fragment {

    private RecyclerView recyclerView;
    private List<StupidGroupModel> groupModels = new ArrayList<>();

    // constructor of Fragment must be Default constructor (has no arguments)
    public MainFragment() {
        super();
    }


    /**
     * <p>
     * Provide a pre-call instance of this fragment
     * <p>
     * @return an instance of this fragment
     */
    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(savedInstanceState);

        if (savedInstanceState != null)
            onRestoreInstanceState(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        In case of using binding tool
//        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_habit_frequency, container, false);
//        View rootView = binding.getRoot();
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        initInstances(rootView, savedInstanceState);
//        binding.setViewModel(viewModel);
        return rootView;
    }

    @SuppressWarnings("UnusedParameters")
    private void init(Bundle savedInstanceState) {
        // Init Fragment level's variable(s) here
    }

    @SuppressWarnings("UnusedParameters")
    private void initInstances(View rootView, Bundle savedInstanceState) {
        // Init 'View' instance(s) with rootView.findViewById here
        // Note: State of variable initialized here could not be saved
        //       in onSavedInstanceState
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());

        for (int groupIndex = 0; groupIndex < 15; groupIndex++) {

            StupidGroupModel group = new StupidGroupModel(
                    groupIndex,
                    "group " + groupIndex);
            for (int i = 0; i < 5; i++) {
                group.children.add(new StupidModel(i, "name " + i));
            }

            groupModels.add(group);
        }

        // Expandable RV

        recyclerView = rootView.findViewById(R.id.rv);
        RecyclerViewExpandableItemManager expandableItemManager
                = new RecyclerViewExpandableItemManager(null);

        ExpandableAdapter expandableAdapter = new ExpandableAdapter(getContext(), groupModels);
        RecyclerView.Adapter wrappedAdapter = expandableItemManager
                                                .createWrappedAdapter(expandableAdapter);


        recyclerView.setAdapter(wrappedAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);

        ((SimpleItemAnimator) recyclerView.getItemAnimator()).setSupportsChangeAnimations(false);

        expandableItemManager.attachRecyclerView(recyclerView);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save Instance (Fragment level's variables) State here
    }

    @SuppressWarnings("UnusedParameters")
    private void onRestoreInstanceState(Bundle savedInstanceState) {
        // Restore Instance (Fragment level's variables) State here
    }

}
