package util;

import entity.Point;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/12.
 */
public class PolygonJudge {

    private List<Point> points = new ArrayList<>();

    public static String editKey(double keyDouble) {
        return ""+keyDouble;
    }

    public PolygonJudge(List<Point> points) {
        this.points = points;
    }

    /**
     * 判断坐标点是否在多边形内
     * @param point
     * @return
     */
    public boolean pointInPolygon(Point point) {
        int i,j = points.size()-1;
        double y = point.getY();
        double x = point.getX();
        int leftCrossCount = 0;
        int rightCrossCount = 0;
        for (i=0; i<points.size(); i++) {
            boolean oddNodes = false;
            if (points.get(i).getX()<x || points.get(j).getX()<x) {
                if (points.get(i).getY()<y && points.get(j).getY()>=y || points.get(i).getY()>=y && points.get(j).getY()<y) {
                    if (points.get(i).getX()+(y-points.get(i).getY())/(points.get(j).getY()-points.get(i).getY())*(points.get(j).getX()-points.get(i).getX())<x) {
                        oddNodes = true;
                    }
                }
                if (oddNodes) {
                    leftCrossCount++;
                }
            }
            if (points.get(i).getX()>x || points.get(j).getX()>x) {
                if (points.get(i).getY()<y && points.get(j).getY()>=y || points.get(i).getY()>=y && points.get(j).getY()<y) {
                    if (points.get(i).getX()+(y-points.get(i).getY())/(points.get(j).getY()-points.get(i).getY())*(points.get(j).getX()-points.get(i).getX())<x) {
                        oddNodes = true;
                    }
                }
                if (oddNodes) {
                    rightCrossCount++;
                }
            }
        }
        if (leftCrossCount%2==0 || rightCrossCount%2==0) {
            return false;
        } else {
            return true;
        }
    }
}
