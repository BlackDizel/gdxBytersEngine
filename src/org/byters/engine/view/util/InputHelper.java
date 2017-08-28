package org.byters.engine.view.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import org.byters.engine.controller.ControllerCamera;

public class InputHelper {

    public static boolean isContainsPointer(Texture texture, float x, float y) {
        return isContainsPointer(x, y, texture.getWidth(), texture.getHeight());
    }

    public static boolean isContainsPointer(float x, float y, float width, float height) {
        float xPoint = Gdx.input.getX() / (Gdx.graphics.getWidth() / (float) ControllerCamera.getInstance().getCameraWidth());
        float yPoint = (Gdx.graphics.getHeight() - Gdx.input.getY()) / (Gdx.graphics.getHeight() / (float) ControllerCamera.getInstance().getCameraHeight());
        return x < xPoint
                && xPoint < x + width
                && y < yPoint
                && yPoint < y + height;
    }
}
