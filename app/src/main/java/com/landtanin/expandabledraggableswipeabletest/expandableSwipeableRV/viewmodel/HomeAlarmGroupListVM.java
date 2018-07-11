package com.landtanin.expandabledraggableswipeabletest.expandableSwipeableRV.viewmodel;

import android.databinding.BaseObservable;

import com.landtanin.expandabledraggableswipeabletest.BaseViewModel;
import com.landtanin.expandabledraggableswipeabletest.expandableSwipeableRV.model.HomeAlarmGroupItem;


public class HomeAlarmGroupListVM extends BaseObservable implements BaseViewModel {

    private final String TAG = getClass().getSimpleName();
    private HomeAlarmGroupItem model;
//    private HomeAlarmGroupContract mHomeContract;

    public HomeAlarmGroupListVM() {
    }

    public HomeAlarmGroupItem getModel() {
        return model;
    }

    public void setModel(HomeAlarmGroupItem model) {
        this.model = model;
        updateContent();
        notifyChange();
    }

    private void updateContent() {

    }

    // action methods
    public void groupHiddenBtnClicked() {

//        mHomeContract.goToAlarmGroup();

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
