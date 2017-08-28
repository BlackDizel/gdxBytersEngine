package org.byters.engine.controller;

import org.byters.engine.model.IDrawableObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ControllerSortedVerticalDrawableObjectList {
    private ArrayList<IDrawableObject> items;
    private ComparatorVertical comparatorVertical;

    public ControllerSortedVerticalDrawableObjectList() {
        comparatorVertical = new ComparatorVertical();
    }

    public void addItem(IDrawableObject item) {
        if (item == null) return;
        if (items == null) items = new ArrayList<IDrawableObject>();
        items.add(item);
        sort();
    }

    public void sort() {
        if (items == null) return;
        Collections.sort(items, comparatorVertical);
    }

    public ArrayList<IDrawableObject> getItems() {
        return items;
    }

    public void removeItem(int itemId) {
        if (items == null) return;
        IDrawableObject buffer = null;
        for (IDrawableObject item : items)
            if (item.getID() == itemId) {
                buffer = item;
                break;
            }
        if (buffer == null) return;
        items.remove(buffer);
    }

    private class ComparatorVertical implements Comparator<IDrawableObject> {
        public int compare(IDrawableObject o1, IDrawableObject o2) {
            return o1 == null || o2 == null ? 0 :
                    o2.getOriginY() - o1.getOriginY();
        }
    }
}
