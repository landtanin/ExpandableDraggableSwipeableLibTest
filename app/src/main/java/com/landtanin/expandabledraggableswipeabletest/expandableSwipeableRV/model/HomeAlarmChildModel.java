package com.landtanin.expandabledraggableswipeabletest.expandableSwipeableRV.model;

import android.support.annotation.ColorRes;

import com.landtanin.expandabledraggableswipeabletest.data.AbstractExpandableDataProvider;

public class HomeAlarmChildModel extends AbstractExpandableDataProvider.ChildData {

    private int id;
    private String titleStr;
    private String sourceOfAlarmStr;
    private String timeStr;
    private String aboveTimeStr;
    private int circleStatusColor;

    private HomeAlarmChildModel(Builder builder) {
        this.id = builder.id;
        this.titleStr = builder.titleStr;
        this.sourceOfAlarmStr = builder.sourceOfAlarmStr;
        this.timeStr = builder.timeStr;
        this.aboveTimeStr = builder.aboveTimeStr;
        this.circleStatusColor = builder.circleStatusColor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitleStr() {
        return titleStr;
    }

    public void setTitleStr(String titleStr) {
        this.titleStr = titleStr;
    }

    public String getSourceOfAlarmStr() {
        return sourceOfAlarmStr;
    }

    public void setSourceOfAlarmStr(String sourceOfAlarmStr) {
        this.sourceOfAlarmStr = sourceOfAlarmStr;
    }

    public String getTimeStr() {
        return timeStr;
    }

    public void setTimeStr(String timeStr) {
        this.timeStr = timeStr;
    }

    public String getAboveTimeStr() {
        return aboveTimeStr;
    }

    public void setAboveTimeStr(String aboveTimeStr) {
        this.aboveTimeStr = aboveTimeStr;
    }

    public int getCircleStatusColor() {
        return circleStatusColor;
    }

    public void setCircleStatusColor(int circleStatusColor) {
        this.circleStatusColor = circleStatusColor;
    }

    @Override
    public String getText() {
        return null;
    }

    @Override
    public void setPinned(boolean pinned) {

    }

    @Override
    public boolean isPinned() {
        return false;
    }

    @Override
    public long getChildId() {
        return 0;
    }

    public static class Builder {

        // Required parameters
        private int id;
        private final String titleStr;

        // Optional parameters
        private String sourceOfAlarmStr;
        private String timeStr;
        private String aboveTimeStr;
        private int circleStatusColor;

        public Builder(int id, String titleStr) {
            this.id = id;
            this.titleStr = titleStr;

            // Default values
            this.sourceOfAlarmStr = "-";
            this.timeStr = "--:--";
            this.aboveTimeStr = "-";
            this.circleStatusColor = 0x999999;
        }

        public Builder source(String sourceOfAlarmStr) {
            this.sourceOfAlarmStr = sourceOfAlarmStr;
            return this;
        }

        public Builder timeStr(String timeStr) {
            this.timeStr = timeStr;
            return this;
        }

        public Builder aboveTimeStr(String aboveTimeStr) {
            this.aboveTimeStr = aboveTimeStr;
            return this;
        }

        public Builder circleStatusColor(@ColorRes int circleStatusColor) {
            this.circleStatusColor = circleStatusColor;
            return this;
        }

        public HomeAlarmChildModel build() {
            return new HomeAlarmChildModel(this);
        }

    }
}
