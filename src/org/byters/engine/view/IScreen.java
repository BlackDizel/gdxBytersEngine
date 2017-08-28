package org.byters.engine.view;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface IScreen {
    void draw(SpriteBatch batch);

    void load(SpriteBatch batch);

    void update();

    void input();

    void dispose();
}
