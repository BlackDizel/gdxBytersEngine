package org.byters.engine.view.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import org.byters.engine.controller.ControllerCamera;

import java.lang.ref.WeakReference;

public class InputHelper {

    private WeakReference<ControllerCamera> refControllerCamera;

    public InputHelper(ControllerCamera controllerCamera) {
        this.refControllerCamera = new WeakReference<>(controllerCamera);
    }

    public boolean isContainsPointer(Texture texture, float x, float y) {
        return isContainsPointer(x, y, texture.getWidth(), texture.getHeight());
    }

    public boolean isContainsPointer(float x, float y, float width, float height) {

        if (refControllerCamera == null || refControllerCamera.get() == null) return false;

        float xPoint = Gdx.input.getX() / (Gdx.graphics.getWidth() / refControllerCamera.get().getCameraWidth());
        float yPoint = (Gdx.graphics.getHeight() - Gdx.input.getY())
                / (Gdx.graphics.getHeight() / refControllerCamera.get().getCameraHeight());

        return x < xPoint
                && xPoint < x + width
                && y < yPoint
                && yPoint < y + height;
    }
}
