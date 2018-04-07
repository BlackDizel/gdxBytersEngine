package org.byters.engine.controller;

public class ControllerMain {
    public static final boolean IS_DEBUG = true;//todo move to gradle script

    private long timeStartMillis;

    private ControllerMain() {
        timeStartMillis = System.currentTimeMillis();
    }

    public long getGameTime() {
        return System.currentTimeMillis() - timeStartMillis;
    }
}
