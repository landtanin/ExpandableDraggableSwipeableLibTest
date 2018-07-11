package com.landtanin.expandabledraggableswipeabletest;

import java.util.ArrayList;
import java.util.List;

public class StupidGroupModel {

    private int id;
    private String stupidName;
    List<StupidModel> children;

    public StupidGroupModel(int id, String stupidName) {
        this.id = id;
        this.stupidName = stupidName;
        this.children = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStupidName() {
        return stupidName;
    }

    public void setStupidName(String stupidName) {
        this.stupidName = stupidName;
    }

    public List<StupidModel> getChildren() {
        return children;
    }

    public void setChildren(List<StupidModel> children) {
        this.children = children;
    }
}
