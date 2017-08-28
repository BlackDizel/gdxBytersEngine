package org.byters.engine.model;

import com.badlogic.gdx.math.Bezier;
import com.badlogic.gdx.math.Vector2;

public class BezierCubic {
    private Vector2[] points;

    public BezierCubic(Vector2[] points) {
        this.points = points;
    }

    public boolean isValid() {
        return points != null && (points.length - 1) % 3 == 0; //4 for 1 curve, 7 for 2 bezier curve, 10 for 3,..
    }

    public Vector2 getEnd() {
        return points[points.length - 1];
    }

    public Vector2 getStart() {
        return points[0];
    }

    public boolean isContains(int xPos) {
        return getStart().x <= xPos && xPos <= getEnd().x;
    }

    public void valueAt(int xPos, Vector2 out, Vector2 tmp) {
        for (int i = 0; i < points.length - 3; i += 3) {
            if (xPos >= points[i].x && xPos <= points[i + 3].x) {
                float len = points[i + 3].x - points[i].x;
                float posPercent = (xPos - points[i].x) / len;
                Bezier.cubic(out, posPercent, points[i], points[i + 1], points[i + 2], points[i + 3], tmp);
                return;
            }
        }
    }
}
