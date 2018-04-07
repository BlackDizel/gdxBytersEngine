package org.byters.engine.view;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface IScreen {

    void draw();

    void load();

    void update();

    void input();

    void dispose();
}
