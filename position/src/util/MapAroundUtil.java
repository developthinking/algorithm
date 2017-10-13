package util;

import entity.MapAroundBean;
import entity.Point;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Administrator on 2017/10/12.
 */
public class MapAroundUtil {

    private static final double CONST_RADII = 100 * 100; //默认值

    /**
     * 获取圆形边界
     * @param centerPoint 中心位置
     * @param radii 半径（米）
     * @return
     */
    public static MapAroundBean getCircleAround(Point centerPoint, double radii) {
        MapAroundBean mapAround = new MapAroundBean();
        double cRad = getRadiiToLongLat(radii);
        mapAround.setLngMin(centerPoint.getX()-cRad);
        mapAround.setLngMax(centerPoint.getX()+cRad);
        mapAround.setLatMin(centerPoint.getY()-cRad);
        mapAround.setLatMax(centerPoint.getY()+cRad);
        return mapAround;
    }

    public static double getRadiiToLongLat(double radii){
        return radii/CONST_RADII;
    }

    /**
     * 获取经度边界和纬度边界
     * @param points 经纬度集合
     * @return 边界实体
     */
    public static MapAroundBean getMapAround(List<Point> points) {
        ArrayList<Double> lngs = new ArrayList<>(); //经度
        ArrayList<Double> lats = new ArrayList<>(); //纬度

        MapAroundBean mapAround = null;
        // 正常的点位至少为三个
        if (null != points && points.size() > 2) {
            // 经纬度集合分离添加到经度和纬度集合
            for (Point point : points) {
                lngs.add(point.getX());
                lats.add(point.getY());
            }
            // 正常经度集合和纬度集合都至少存在一个值
            if (lngs.size()>0 && lats.size()>0) {
                // 排序
                Collections.sort(lngs);
                Collections.sort(lats);
                // 实例化
                mapAround = new MapAroundBean();
                mapAround.setLngMin(lngs.get(0));
                mapAround.setLngMax(lngs.get(lngs.size()-1));
                mapAround.setLatMin(lats.get(0));
                mapAround.setLatMax(lats.get(lats.size()-1));
            }
        }
        return mapAround;
    }
}
