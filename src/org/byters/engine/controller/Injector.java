package org.byters.engine.controller;

import org.byters.engine.view.DebugDraw;
import org.byters.engine.view.Navigator;
import org.byters.engine.view.util.InputHelper;

import java.util.Random;

public class Injector {

    private Navigator navigator;
    private ControllerResources controllerResources;
    private ControllerCamera controllerCamera;
    private Random random;
    private InputHelper inputHelper;
    private DebugDraw debugDraw;

    public void dispose() {
        getDebugDraw().dispose();
        getControllerResources().dispose();
    }

    public void load() {
        getDebugDraw().load();
        getControllerResources().init();
        getControllerCamera().load();
    }

    public Navigator getNavigator() {
        if (navigator == null) navigator = new Navigator(getControllerCamera(), getControllerResources());
        return navigator;
    }

    public ControllerCamera getControllerCamera() {
        if (controllerCamera == null) controllerCamera = new ControllerCamera();
        return controllerCamera;
    }

    public ControllerResources getControllerResources() {
        if (controllerResources == null) controllerResources = new ControllerResources();
        return controllerResources;
    }

    public Random getRandom() {
        if (random == null) random = new Random();
        return random;
    }

    public InputHelper getInputHelper() {
        if (inputHelper == null) inputHelper = new InputHelper(getControllerCamera());
        return inputHelper;
    }

    public DebugDraw getDebugDraw() {
        if (debugDraw == null) debugDraw = new DebugDraw();
        return debugDraw;
    }
}
