package com.landtanin.expandabledraggableswipeabletest.expandableSwipeableRV.viewmodel;

import android.databinding.BaseObservable;

import com.landtanin.expandabledraggableswipeabletest.BaseViewModel;
import com.landtanin.expandabledraggableswipeabletest.expandableSwipeableRV.model.HomeAlarmChildItem;


public class HomeAlarmRecordListVM extends BaseObservable implements BaseViewModel {

    private HomeAlarmChildItem model;

    public HomeAlarmRecordListVM() {

    }

    public void setModel(HomeAlarmChildItem model) {
        this.model = model;
        updateContent();
        notifyChange();
    }

    public HomeAlarmChildItem getModel() {
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
