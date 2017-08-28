package org.byters.engine.view;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import org.byters.engine.model.IDrawableObject;

import java.util.ArrayList;
import java.util.HashMap;

public class DrawerDrawableObjectList {
    private HashMap<Integer, TextureRegion> textures;

    public void draw(SpriteBatch batch, ArrayList<IDrawableObject> items) {
        if (items == null) return;
        for (IDrawableObject item : items) {
            if (item == null
                    || !textures.containsKey(item.getID())
                    || textures.get(item.getID()) == null)
                continue;

            batch.draw(textures.get(item.getID()), item.getX(), item.getY());
        }
    }

    public void setTexture(TextureRegion texture, int id) {
        if (textures == null) textures = new HashMap<Integer, TextureRegion>();
        textures.put(id, texture);
    }

    public void clear() {
        textures = null;
    }

    public void removeTexture(int id) {
        if (textures == null) return;
        textures.remove(id);
    }
}
