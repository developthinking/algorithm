package entity;

/**
 * Created by Administrator on 2017/10/12.
 */
public class MapAroundBean {

    private double lngMax; //最大经度
    private double lngMin; //最小经度
    private double latMax; //最大纬度
    private double latMin; //最小纬度

    public double getLngMax() {
        return lngMax;
    }

    public void setLngMax(double lngMax) {
        this.lngMax = lngMax;
    }

    public double getLngMin() {
        return lngMin;
    }

    public void setLngMin(double lngMin) {
        this.lngMin = lngMin;
    }

    public double getLatMax() {
        return latMax;
    }

    public void setLatMax(double latMax) {
        this.latMax = latMax;
    }

    public double getLatMin() {
        return latMin;
    }

    public void setLatMin(double latMin) {
        this.latMin = latMin;
    }
}
