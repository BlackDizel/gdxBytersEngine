package org.byters.engine.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Json;

public class ControllerJsonBase {
    private static ControllerJsonBase instance;
    private Json json;

    public static ControllerJsonBase getInstance() {
        if (instance == null) instance = new ControllerJsonBase();
        return instance;
    }

    public <T> T readFile(Class<T> type, String filename) {
        String json = Gdx.files.internal(filename).readString();
        return getJson().fromJson(type, json);
    }

    public Json getJson() {
        if (json == null) json = new Json();
        return json;
    }
}
