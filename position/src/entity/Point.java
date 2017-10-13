package entity;

/**
 * 坐标点类
 * Created by Administrator on 2017/10/12.
 */
public class Point {

    private double x; //水平坐标
    private double y; //垂直坐标

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
