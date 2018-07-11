package com.landtanin.expandabledraggableswipeabletest.expandableSwipeableRV.model;

import android.support.annotation.ColorRes;

import java.util.List;

public class HomeAlarmGroupItem {

    private int id;
    private String titleStr;
    public List<HomeAlarmChildItem> children;

    private String detailStr;
    private String noOfOpenAlarmStr;
    private int noOfOpenAlarmInt;
    private String noOfTotalAlarmStr;
    private int noOfTotalAlarmInt;
    private String lastAlarmLabelStr;
    private String lastAlarmTimeStr;
    private int cardStatusColor;

    public HomeAlarmGroupItem(Builder builder) {
        this.id = builder.id;
        this.titleStr = builder.titleStr;
        this.detailStr = builder.detailStr;
        this.noOfOpenAlarmStr = builder.noOfOpenAlarmStr;
        this.noOfOpenAlarmInt = builder.noOfOpenAlarmInt;
        this.noOfTotalAlarmStr = builder.noOfTotalAlarmStr;
        this.noOfTotalAlarmInt = builder.noOfTotalAlarmInt;
        this.lastAlarmLabelStr = builder.lastAlarmLabelStr;
        this.lastAlarmTimeStr = builder.lastAlarmTimeStr;
        this.cardStatusColor = builder.cardStatusColor;
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

    public String getDetailStr() {
        return detailStr;
    }

    public void setDetailStr(String detailStr) {
        this.detailStr = detailStr;
    }

    public String getNoOfOpenAlarmStr() {
        return noOfOpenAlarmStr;
    }

    public void setNoOfOpenAlarmStr(String noOfOpenAlarmStr) {
        this.noOfOpenAlarmStr = noOfOpenAlarmStr;
    }

    public int getNoOfOpenAlarmInt() {
        return noOfOpenAlarmInt;
    }

    public void setNoOfOpenAlarmInt(int noOfOpenAlarmInt) {
        this.noOfOpenAlarmInt = noOfOpenAlarmInt;
    }

    public String getNoOfTotalAlarmStr() {
        return noOfTotalAlarmStr;
    }

    public void setNoOfTotalAlarmStr(String noOfTotalAlarmStr) {
        this.noOfTotalAlarmStr = noOfTotalAlarmStr;
    }

    public int getNoOfTotalAlarmInt() {
        return noOfTotalAlarmInt;
    }

    public void setNoOfTotalAlarmInt(int noOfTotalAlarmInt) {
        this.noOfTotalAlarmInt = noOfTotalAlarmInt;
    }

    public String getLastAlarmLabelStr() {
        return lastAlarmLabelStr;
    }

    public void setLastAlarmLabelStr(String lastAlarmLabelStr) {
        this.lastAlarmLabelStr = lastAlarmLabelStr;
    }

    public String getLastAlarmTimeStr() {
        return lastAlarmTimeStr;
    }

    public void setLastAlarmTimeStr(String lastAlarmTimeStr) {
        this.lastAlarmTimeStr = lastAlarmTimeStr;
    }

    public int getCardStatusColor() {
        return cardStatusColor;
    }

    public void setCardStatusColor(int cardStatusColor) {
        this.cardStatusColor = cardStatusColor;
    }

    public static class Builder {

        // Required parameters
        private final String titleStr;
        private int id;

        // Optional parameters
        private String detailStr;
        private String noOfOpenAlarmStr;
        private int noOfOpenAlarmInt;
        private String noOfTotalAlarmStr;
        private int noOfTotalAlarmInt;
        private String lastAlarmLabelStr;
        private String lastAlarmTimeStr;
        private int cardStatusColor;

        public Builder(int id, String titleStr) {
            this.id = id;
            this.titleStr = titleStr;

            // Default Values
            this.detailStr = "-";
            this.noOfOpenAlarmStr = "-";
            this.noOfOpenAlarmInt = 0;
            this.noOfTotalAlarmStr = "-";
            this.noOfTotalAlarmInt = 0;
            this.lastAlarmLabelStr = "-";
            this.lastAlarmTimeStr = "--:--";
            this.cardStatusColor = 0x999999;

        }

        public Builder detailStr(String detailStr) {
            this.detailStr = detailStr;
            return this;
        }

        public Builder noOfOpenAlarmStr(String noOfOpenAlarmStr) {
            this.noOfOpenAlarmStr = noOfOpenAlarmStr;
            return this;
        }

        public Builder noOfOpenAlarmInt(int noOfOpenAlarmInt) {
            this.noOfOpenAlarmInt = noOfOpenAlarmInt;
            return this;
        }

        public Builder noOfTotalAlarmStr(String noOfTotalAlarmStr) {
            this.noOfTotalAlarmStr = noOfTotalAlarmStr;
            return this;
        }

        public Builder noOfTotalAlarmInt(int noOfTotalAlarmInt) {
            this.noOfTotalAlarmInt = noOfTotalAlarmInt;
            return this;
        }

        public Builder lastAlarmLabelStr(String lastAlarmLabelStr) {
            this.lastAlarmLabelStr = lastAlarmLabelStr;
            return this;
        }

        public Builder lastAlarmTimeStr(String lastAlarmTimeStr) {
            this.lastAlarmTimeStr = lastAlarmTimeStr;
            return this;
        }

        public Builder cardStatusColor(@ColorRes int cardStatusColor) {
            this.cardStatusColor = cardStatusColor;
            return this;
        }

        public HomeAlarmGroupItem build() {
            return new HomeAlarmGroupItem(this);
        }
    }
}
