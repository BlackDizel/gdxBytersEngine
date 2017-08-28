package org.byters.engine;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.byters.engine.controller.ControllerCamera;
import org.byters.engine.controller.ControllerMain;
import org.byters.engine.controller.listener.OnUpdateResources;
import org.byters.engine.view.DebugDraw;
import org.byters.engine.view.IScreen;

public class Engine implements OnUpdateResources {

    private static Engine instance;
    private SpriteBatch batch;
    private Color colorClear;

    private Engine() {
        colorClear = new Color();
        colorClear.r = 0;
        colorClear.g = 0;
        colorClear.b = 1;
        colorClear.a = 1;
    }

    public static Engine getInstance() {
        if (instance == null) instance = new Engine();
        return instance;
    }

    public void setColorClear(Color colorClear) {
        this.colorClear = colorClear;
    }

    public void create(IScreen screen) {
        batch = new SpriteBatch();
        load();
        ControllerMain.getInstance().navigateScreen(screen);
    }


    private void load() {
        ControllerMain.getInstance().setListener(this);
        ControllerCamera.getInstance().load();
        onLoadResources();
    }

    private void input() {
        if (ControllerMain.getInstance().getCurrentScreen() == null) return;
        ControllerMain.getInstance().getCurrentScreen().input();
    }

    private void draw() {
        Gdx.gl.glClearColor(colorClear.r, colorClear.g, colorClear.b, colorClear.a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if (ControllerMain.IS_DEBUG)
            DebugDraw.getInstance().drawStart(ControllerCamera.getInstance().getCameraProjection());

        batch.setProjectionMatrix(ControllerCamera.getInstance().getCameraProjection());
        batch.begin();
        if (ControllerMain.getInstance().getCurrentScreen() != null)
            ControllerMain.getInstance().getCurrentScreen().draw(batch);
        batch.end();

        if (ControllerMain.IS_DEBUG) DebugDraw.getInstance().drawEnd();
    }

    private void update(float delta) {
        if (ControllerMain.getInstance().getCurrentScreen() == null) return;
        ControllerMain.getInstance().getCurrentScreen().update();
    }

    public void onLoadResources() {
        if (ControllerMain.getInstance().getCurrentScreen() == null) return;
        ControllerMain.getInstance().getCurrentScreen().load(batch);
    }

    public void onDisposeResources() {
        if (ControllerMain.getInstance().getCurrentScreen() == null) return;
        ControllerMain.getInstance().getCurrentScreen().dispose();
    }

    public void dispose() {
        batch.dispose();
        onDisposeResources();
    }

    public void render() {
        float delta = Gdx.graphics.getDeltaTime();
        update(delta);
        input();
        draw();
    }

    public void resize(int width, int height) {
        ControllerCamera.getInstance().resize(width, height);
    }
}
