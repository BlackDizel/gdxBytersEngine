package org.byters.engine;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import org.byters.engine.controller.Injector;
import org.byters.engine.view.IScreen;

public class Engine {

    //fixme now data stored with logic in controllers.
    //fixme need to split controllers to data and presenter classes

    private Injector injector;

    public Engine() {
        injector = new Injector();
    }

    public Engine(boolean isDebug) {
        this();
        injector.getDebugDraw().setDebug(isDebug);
    }

    public Injector getInjector() {
        return injector;
    }

    public void setColorClear(Color colorClear) {
        injector.getControllerResources().setColorClear(colorClear);
    }

    public void load() {
        injector.load();
    }

    public void dispose() {
        injector.dispose();
    }

    private void input() {
        IScreen screen = injector.getNavigator().getCurrentScreen();
        if (screen == null) return;
        screen.input();
    }

    private void draw() {
        injector.getControllerResources().clearColor(Gdx.gl);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if (injector.getDebugDraw().isDebug())
            injector.getDebugDraw().drawStart(injector.getControllerCamera().getCameraProjection());

        injector.getControllerResources().drawBegin(injector.getControllerCamera().getCameraProjection());

        IScreen screen = injector.getNavigator().getCurrentScreen();
        if (screen != null)
            screen.draw();

        injector.getControllerResources().drawEnd();

        if (injector.getDebugDraw().isDebug()) injector.getDebugDraw().drawEnd();
    }

    private void update(float delta) {
        IScreen screen = injector.getNavigator().getCurrentScreen();
        if (screen == null) return;
        screen.update();
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