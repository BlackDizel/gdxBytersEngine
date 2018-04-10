package org.byters.engine.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Json;

public class ControllerJsonBase {
    private Json json;

    public <T> T readFile(Class<T> type, String filename) {
        String json = Gdx.files.internal(filename).readString();
        return getJson().fromJson(type, json);
    }

    private Json getJson() {
        if (json == null) json = new Json();
        return json;
    }
}
