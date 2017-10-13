package util;

import entity.Point;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/12.
 */
public class PointEditUtil {

    /**
     * 读多边形坐标文件转化为坐标集合（文件中坐标按逆时针排列）
     * @param fileName
     * @return
     */
    public static List<Point> getPointListFromFile(String fileName) {
        List<Point> points = new ArrayList<>();
        try {
            BufferedReader in = new BufferedReader(new FileReader(new File(fileName).getAbsoluteFile()));
            try {
                String s;
                while ((s = in.readLine()) != null) {
                    String[] info = s.split(PolygonConstant.SPLIT_SEMICOLON);
                    for (String pointStr : info) {
                        String[] pointStrArr = pointStr.split(PolygonConstant.SPLIT_COMMMA);
                        Point point = new Point(Double.parseDouble(pointStrArr[0]),Double.parseDouble(pointStrArr[1]));
                        points.add(point);
                    }
                }
            } finally {
                in.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return points;
    }
}
