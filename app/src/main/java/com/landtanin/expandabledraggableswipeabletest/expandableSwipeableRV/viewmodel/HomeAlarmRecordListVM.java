package com.landtanin.expandabledraggableswipeabletest.expandableSwipeableRV.viewmodel;

import android.databinding.BaseObservable;

import com.landtanin.expandabledraggableswipeabletest.BaseViewModel;
import com.landtanin.expandabledraggableswipeabletest.data.ExampleExpandableDataProvider;


public class HomeAlarmRecordListVM extends BaseObservable implements BaseViewModel {

    private ExampleExpandableDataProvider.ConcreteChildData model;

    public HomeAlarmRecordListVM() {

    }

    public void setModel(ExampleExpandableDataProvider.ConcreteChildData model) {
        this.model = model;
        updateContent();
        notifyChange();
    }

    public ExampleExpandableDataProvider.ConcreteChildData getModel() {
        return model;
    }

    private void updateContent() {

    }

    @Override
    public void onActCreate() {

    }

    @Override
    public void onActDestroy() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {

    }
}
