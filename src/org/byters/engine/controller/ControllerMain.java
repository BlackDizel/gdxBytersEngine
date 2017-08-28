package org.byters.engine.controller;

import com.badlogic.gdx.Gdx;
import org.byters.engine.controller.listener.OnUpdateResources;
import org.byters.engine.view.IScreen;

import java.util.Random;

public class ControllerMain {
    public static final boolean IS_DEBUG = true;//todo move to gradle script

    private static ControllerMain instance;
    private IScreen currentScreen;
    private Random random;
    private long timeStartMillis;
    private OnUpdateResources listener;

    private ControllerMain() {
        timeStartMillis = System.currentTimeMillis();
        random = new Random();
    }

    public static ControllerMain getInstance() {
        if (instance == null) instance = new ControllerMain();
        return instance;
    }

    public void setListener(OnUpdateResources listener) {
        this.listener = listener;
    }

    public long getGameTime() {
        return System.currentTimeMillis() - timeStartMillis;
    }

    public Random getRandom() {
        return random;
    }

    public IScreen getCurrentScreen() {
        return currentScreen;
    }

    public void navigateScreen(IScreen screen) {
        ControllerCamera.getInstance().resetCamera();
        listener.onDisposeResources();
        currentScreen = screen;
        listener.onLoadResources();
    }
}
