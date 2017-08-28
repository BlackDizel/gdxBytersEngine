package org.byters.engine.model;

import com.badlogic.gdx.math.Vector2;

/**
 * only left to right bezier curve supported
 */
public class ModelBezierCurve {

    private BezierCubic[] curve;
    private Vector2 tmp;

    public ModelBezierCurve() {
        tmp = new Vector2();
    }

    public void set(BezierCubic[] curve) {
        checkCurve(curve);
        this.curve = curve;
    }

    private void checkCurve(BezierCubic[] curve) {
        if (curve == null)
            throw new IllegalArgumentException("not legal points num for cubic bezier curve");
        for (BezierCubic item : curve)
            if (!item.isValid())
                throw new IllegalArgumentException("not legal points num for cubic bezier curve");
    }

    /**
     * @param posPercent 0..1 position
     * @param out        for result
     */
    public void valueAt(float posPercent, Vector2 out) {
        checkCurve(curve);
        float len = (curve[curve.length - 1].getEnd().x - curve[0].getStart().x);
        int pos = (int) (curve[0].getStart().x + posPercent * len);
        valueAt(pos, out);
    }

    /**
     * @param xPos X position
     * @param out  for result
     */
    public void valueAt(int xPos, Vector2 out) {
        checkCurve(curve);

        for (BezierCubic item : curve) {
            if (!item.isContains(xPos))
                continue;
            item.valueAt(xPos, out, tmp);
            return;
        }

        out.x = 0;
        out.y = 0;
    }


}
