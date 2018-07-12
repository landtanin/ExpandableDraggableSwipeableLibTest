package com.landtanin.expandabledraggableswipeabletest.expandableSwipeableRV.viewmodel;

import android.databinding.BaseObservable;

import com.landtanin.expandabledraggableswipeabletest.BaseViewModel;
import com.landtanin.expandabledraggableswipeabletest.expandableSwipeableRV.model.HomeAlarmChildModel;


public class HomeAlarmRecordListVM extends BaseObservable implements BaseViewModel {

    private HomeAlarmChildModel model;

    public HomeAlarmRecordListVM() {

    }

    public void setModel(HomeAlarmChildModel model) {
        this.model = model;
        updateContent();
        notifyChange();
    }

    public HomeAlarmChildModel getModel() {
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
