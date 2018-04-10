package org.byters.engine.view;

public interface IScreen {

    void draw();

    void load();

    void update(float delta);

    void input();

    void dispose();
}
