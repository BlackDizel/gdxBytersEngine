package org.byters.engine.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;

public class ControllerCamera {

    private OrthographicCamera camera;
    private Vector3 originPosition;

    public void load() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        this.originPosition = camera.position.cpy();
    }

    public void setZoom(float zoom) {
        if (zoom <= 0) return;
        camera.zoom = zoom;
        originPosition.scl(zoom);
        camera.update();
    }

    public Matrix4 getCameraProjection() {
        return camera.combined;
    }

    public void translateCamera(float x, float y) {
        camera.translate(x, y);
        camera.update();
    }

    public void setPosition(float x, float y, float z) {
        camera.position.set(x, y, z);
        camera.update();
    }

    public float getCameraPositionX() {
        return camera.position.x;
    }

    public float getCameraPositionY() {
        return camera.position.y;
    }

    public void resetCamera() {
        camera.position.set(originPosition);
        camera.update();
    }

    public void resize(int width, int height) {
        camera.setToOrtho(false, width, height);
    }

    public void setMapCamera(TiledMapRenderer map) {
        map.setView(camera);
    }

    public float getCameraWidth() {
        return Gdx.graphics.getWidth() * camera.zoom;
    }

    public float getCameraHeight() {
        return Gdx.graphics.getHeight() * camera.zoom;
    }
}

