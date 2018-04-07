package org.byters.engine;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import org.byters.engine.controller.ControllerMain;
import org.byters.engine.controller.Injector;
import org.byters.engine.view.DebugDraw;
import org.byters.engine.view.IScreen;

public class Engine {

    private Injector injector;

    public Engine() {
        injector = new Injector();
    }

    public Injector getInjector() {
        return injector;
    }

    public void setColorClear(Color colorClear) {
        injector.getControllerResources().setColorClear(colorClear);
    }

    public void create(IScreen screen) {
        injector.getControllerResources().init();
        injector.getControllerCamera().load();
        injector.getNavigator().navigateScreen(screen);
    }

    private void input() {
        IScreen screen = injector.getNavigator().getCurrentScreen();
        if (screen == null) return;
        screen.input();
    }

    private void draw() {
        injector.getControllerResources().clearColor(Gdx.gl);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if (ControllerMain.IS_DEBUG)
            DebugDraw.getInstance().drawStart(injector.getControllerCamera().getCameraProjection());

        injector.getControllerResources().drawBegin(injector.getControllerCamera().getCameraProjection());

        IScreen screen = injector.getNavigator().getCurrentScreen();
        if (screen != null)
            screen.draw();

        injector.getControllerResources().drawEnd();

        if (ControllerMain.IS_DEBUG) DebugDraw.getInstance().drawEnd();
    }

    private void update(float delta) {
        IScreen screen = injector.getNavigator().getCurrentScreen();
        if (screen == null) return;
        screen.update();
    }

    public void dispose() {
        injector.getControllerResources().dispose();
    }

    public void render() {
        float delta = Gdx.graphics.getDeltaTime();
        update(delta);
        input();
        draw();
    }

    public void resize(int width, int height) {
        injector.getControllerCamera().resize(width, height);
    }
}