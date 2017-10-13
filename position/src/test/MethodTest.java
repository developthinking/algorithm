package test;

import entity.Point;
import util.PointEditUtil;
import util.PolygonConstant;
import util.PolygonJudge;
import util.PropertiesUtil;

import java.io.*;
import java.util.List;
import java.util.Properties;

/**
 * Created by Administrator on 2017/10/12.
 */
public class MethodTest {

    /**
     * 读源文件，对坐标进行范围判断，删除不在范围内的坐标
     * @param sourceFile 源文件
     * @param rangeFile 范围文件
     * @return
     */
    public static String read(String sourceFile, String rangeFile) {
        StringBuilder sb = new StringBuilder();
        List<Point> points = PointEditUtil.getPointListFromFile(rangeFile);
        PolygonJudge pj = new PolygonJudge(points);
        try {
            BufferedReader in = new BufferedReader(new FileReader(new File(sourceFile).getAbsoluteFile()));
            try {
                String s;
                while ((s = in.readLine()) != null) {
                    String[] ar = s.split(PolygonConstant.SPLIT_COMMMA);
                    Point pt = new Point(Double.parseDouble(ar[0]), Double.parseDouble(ar[1]));
                    if (pj.pointInPolygon(pt)) {
                		System.out.println(pt.getX()+","+pt.getY());
                        sb.append(s);
                        sb.append("\n");
                    }
                }
            } finally {
                in.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }

    public static void writeBigFile(String fileName, String text) {
        try {
            FileWriter out = new FileWriter(new File(fileName).getAbsoluteFile());
            try {
                out.write(text);
            } finally {
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Properties properties = PropertiesUtil.getProperties("fileConfig.properties");
        String sourceFile = properties.getProperty("path") + properties.getProperty("sourceFile");
        String targetFile = properties.getProperty("path") + properties.getProperty("targetFile");
        String rangeFile = properties.getProperty("path") + properties.getProperty("rangeFile");
        String file = read(sourceFile, rangeFile);
        writeBigFile(targetFile, file);
    }
}
