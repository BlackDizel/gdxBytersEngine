package org.byters.engine.model;

public class PointInt {
    public int x;
    public int y;

    public PointInt() {
    }

    public PointInt(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static double distance(double x1, double y1,
                                  double x2, double y2) {
        x1 -= x2;
        y1 -= y2;
        return Math.sqrt(x1 * x1 + y1 * y1);
    }
}
