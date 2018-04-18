package org.byters.engine.controller;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix4;
import org.byters.engine.view.IScreen;

public class ControllerResources {

    private long gameTimeStart;
    private SpriteBatch batch;
    private Color colorClear;

    public void load() {
        batch = new SpriteBatch();
        gameTimeStart = System.currentTimeMillis();

        colorClear = new Color();
        colorClear.r = 0;
        colorClear.g = 0;
        colorClear.b = 1;
        colorClear.a = 1;
    }

    public void dispose() {
        batch.dispose();
    }

    public void onDisposeResources(IScreen screen) {
        if (screen == null) return;
        screen.dispose();
    }

    public void onLoadResources(IScreen currentScreen) {
        currentScreen.load();
    }

    public void setColorClear(Color colorClear) {
        this.colorClear = colorClear;
    }

    public void clearColor(GL20 gl) {
        gl.glClearColor(colorClear.r, colorClear.g, colorClear.b, colorClear.a);
    }

    public void drawBegin(Matrix4 cameraProjection) {
        batch.setProjectionMatrix(cameraProjection);
        batch.begin();
    }

    public void drawEnd() {
        batch.end();
    }

    public SpriteBatch getSpriteBatch() {
        return batch;
    }
}
