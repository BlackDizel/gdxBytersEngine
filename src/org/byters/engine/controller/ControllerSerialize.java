package org.byters.engine.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.Json;

public class ControllerSerialize {
    private Json json;

    public <T> T readFileInternal(Class<T> type, String filename) {
        String json = Gdx.files.internal(filename).readString();
        return getJson().fromJson(type, json);
    }

    private Json getJson() {
        if (json == null) json = new Json();
        return json;
    }

    public String toString(Object object) {
        return getJson().toJson(object);
    }

    public <T> T fromString(String data, Class<T> result) {
        return getJson().fromJson(result, data);
    }

    public <T> T readFileLocal(Class<T> type, String filename) {

        String json = null;
        try {
            json = Gdx.files.local(filename).readString();
        } catch (GdxRuntimeException e) {
            return null;
        }
        return getJson().fromJson(type, json);
    }

    public void writeDataLocal(Object obj, String file) {
        Gdx.files.local(file).writeString(toString(obj), false);
    }
}
