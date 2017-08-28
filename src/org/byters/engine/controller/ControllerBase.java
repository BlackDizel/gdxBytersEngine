package org.byters.engine.controller;

import org.byters.engine.controller.listener.OnBaseEvent;

import java.util.ArrayList;

public class ControllerBase {
    private ArrayList<OnBaseEvent> listeners;

    public void addListener(OnBaseEvent item) {
        if (listeners == null) listeners = new ArrayList<OnBaseEvent>();
        listeners.add(item);
    }

    public void removeListener(OnBaseEvent event) {
        if (listeners == null) return;
        listeners.remove(event);
    }

    protected void notifyListeners() {
        if (listeners == null) return;
        for (OnBaseEvent item : listeners)
            item.onEvent();
    }
}
