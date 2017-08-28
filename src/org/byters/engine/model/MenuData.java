package org.byters.engine.model;

import java.util.ArrayList;

public class MenuData {

    private int id;
    private int titleID;
    private ArrayList<MenuData> childs;

    public int getId() {
        return id;
    }

    public int getTitleId() {
        return titleID;
    }

    public ArrayList<MenuData> getChilds() {
        return childs;
    }
}