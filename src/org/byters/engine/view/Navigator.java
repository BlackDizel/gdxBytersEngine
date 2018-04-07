package org.byters.engine.view;

import org.byters.engine.controller.ControllerCamera;
import org.byters.engine.controller.ControllerResources;

import java.lang.ref.WeakReference;

public class Navigator {

    private WeakReference<ControllerResources> refControllerResources;
    private WeakReference<ControllerCamera> refControllerCamera;
    private IScreen currentScreen;

    public IScreen getCurrentScreen() {
        return currentScreen;
    }

    public Navigator(ControllerCamera controllerCamera, ControllerResources controllerResources){
        this.refControllerCamera = new WeakReference<>(controllerCamera);
        this.refControllerResources = new WeakReference<>(controllerResources);
    }


    public void navigateScreen(IScreen screen) {
        refControllerCamera.get().resetCamera();
        refControllerResources.get().onDisposeResources(currentScreen);
        currentScreen = screen;
        refControllerResources.get().onLoadResources(currentScreen);
    }
}
