package org.byters.engine.view;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class DebugDraw {

    private boolean isDebug = false;
    private ShapeRenderer renderer;

    public DebugDraw() {
    }

    public boolean isDebug() {
        return isDebug;
    }

    public void setDebug(boolean isDebug) {
        this.isDebug = isDebug;
    }

    public void load() {
        renderer = new ShapeRenderer();
        renderer.setAutoShapeType(true);
    }

    public void dispose() {
        renderer.dispose();
    }

    public void draw(Polygon polygon) {
        renderer.polygon(polygon.getTransformedVertices());
    }

    public void drawStart(Matrix4 projection) {
        renderer.setProjectionMatrix(projection);
        renderer.begin();
        renderer.setColor(Color.RED);
    }

    public void drawEnd() {
        renderer.end();
    }

    public void drawDot(Vector3 position) {
        renderer.circle(position.x, position.y, 3);
    }

    public void drawDot(Vector2 position) {
        renderer.circle(position.x, position.y, 3);
    }

    public void drawLine(int x1, int y1, int x2, int y2) {
        renderer.line(x1, y1, x2, y2);
    }
}
