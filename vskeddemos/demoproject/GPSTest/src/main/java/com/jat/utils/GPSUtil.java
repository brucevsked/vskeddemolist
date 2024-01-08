package com.jat.utils;

import org.openimaj.hardware.gps.NMEAMessage;
import org.openimaj.hardware.gps.NMEAParser;
import java.util.List;

/**
 *
 * 坐标系转换工具类
 */
public class GPSUtil {
    public static double pi = 3.1415926535897932384626;
    public static double x_pi = 3.14159265358979324 * 3000.0 / 180.0;
    public static double a = 6378245.0;
    public static double ee = 0.00669342162296594323;

    public static NMEAParser nmeaParser =new NMEAParser();

    public static double transformLat(double x, double y) {
        double ret = -100.0 + 2.0 * x + 3.0 * y + 0.2 * y * y + 0.1 * x * y
                + 0.2 * Math.sqrt(Math.abs(x));
        ret += (20.0 * Math.sin(6.0 * x * pi) + 20.0 * Math.sin(2.0 * x * pi)) * 2.0 / 3.0;
        ret += (20.0 * Math.sin(y * pi) + 40.0 * Math.sin(y / 3.0 * pi)) * 2.0 / 3.0;
        ret += (160.0 * Math.sin(y / 12.0 * pi) + 320 * Math.sin(y * pi / 30.0)) * 2.0 / 3.0;
        return ret;
    }

    public static double transformLon(double x, double y) {
        double ret = 300.0 + x + 2.0 * y + 0.1 * x * x + 0.1 * x * y + 0.1
                * Math.sqrt(Math.abs(x));
        ret += (20.0 * Math.sin(6.0 * x * pi) + 20.0 * Math.sin(2.0 * x * pi)) * 2.0 / 3.0;
        ret += (20.0 * Math.sin(x * pi) + 40.0 * Math.sin(x / 3.0 * pi)) * 2.0 / 3.0;
        ret += (150.0 * Math.sin(x / 12.0 * pi) + 300.0 * Math.sin(x / 30.0
                * pi)) * 2.0 / 3.0;
        return ret;
    }

    public static double[] transform(double lat, double lon) {
        if (outOfChina(lat, lon)) {
            return new double[] { lat, lon };
        }
        double dLat = transformLat(lon - 105.0, lat - 35.0);
        double dLon = transformLon(lon - 105.0, lat - 35.0);
        double radLat = lat / 180.0 * pi;
        double magic = Math.sin(radLat);
        magic = 1 - ee * magic * magic;
        double sqrtMagic = Math.sqrt(magic);
        dLat = (dLat * 180.0) / ((a * (1 - ee)) / (magic * sqrtMagic) * pi);
        dLon = (dLon * 180.0) / (a / sqrtMagic * Math.cos(radLat) * pi);
        double mgLat = lat + dLat;
        double mgLon = lon + dLon;
        return new double[] { mgLat, mgLon };
    }

    public static boolean outOfChina(double lat, double lon) {
        if (lon < 72.004 || lon > 137.8347)
            return true;
        if (lat < 0.8293 || lat > 55.8271)
            return true;
        return false;
    }

    /**
     * 84 to 火星坐标系 (GCJ-02) World Geodetic System ==> Mars Geodetic System
     *
     * @param lat
     * @param lon
     * @return
     */
    public static double[] wgs84ToGcj02(double lat, double lon) {
        if (outOfChina(lat, lon)) {
            return new double[] { lat, lon };
        }
        double dLat = transformLat(lon - 105.0, lat - 35.0);
        double dLon = transformLon(lon - 105.0, lat - 35.0);
        double radLat = lat / 180.0 * pi;
        double magic = Math.sin(radLat);
        magic = 1 - ee * magic * magic;
        double sqrtMagic = Math.sqrt(magic);
        dLat = (dLat * 180.0) / ((a * (1 - ee)) / (magic * sqrtMagic) * pi);
        dLon = (dLon * 180.0) / (a / sqrtMagic * Math.cos(radLat) * pi);
        double mgLat = lat + dLat;
        double mgLon = lon + dLon;
        return new double[] { mgLat, mgLon };
    }

    /**
     * * 火星坐标系 (GCJ-02) to 84 * * @param lon * @param lat * @return
     * */
    public static double[] gcj02ToWgs84(double lat, double lon) {
        double[] gps = transform(lat, lon);
        double lontitude = lon * 2 - gps[1];
        double latitude = lat * 2 - gps[0];
        return new double[] { latitude, lontitude };
    }

    /**
     * 火星坐标系 (GCJ-02) 与百度坐标系 (BD-09) 的转换算法 将 GCJ-02 坐标转换成 BD-09 坐标
     *
     * @param lat
     * @param lon
     */
    public static double[] gcj02ToBd09(double lat, double lon) {
        double x = lon, y = lat;
        double z = Math.sqrt(x * x + y * y) + 0.00002 * Math.sin(y * x_pi);
        double theta = Math.atan2(y, x) + 0.000003 * Math.cos(x * x_pi);
        double tempLon = z * Math.cos(theta) + 0.0065;
        double tempLat = z * Math.sin(theta) + 0.006;
        double[] gps = { tempLat, tempLon };
        return gps;
    }

    /**
     * * 火星坐标系 (GCJ-02) 与百度坐标系 (BD-09) 的转换算法 * * 将 BD-09 坐标转换成GCJ-02 坐标 * * @param
     * bd_lat * @param bd_lon * @return
     */
    public static double[] bd09ToGcj02(double lat, double lon) {
        double x = lon - 0.0065, y = lat - 0.006;
        double z = Math.sqrt(x * x + y * y) - 0.00002 * Math.sin(y * x_pi);
        double theta = Math.atan2(y, x) - 0.000003 * Math.cos(x * x_pi);
        double tempLon = z * Math.cos(theta);
        double tempLat = z * Math.sin(theta);
        double[] gps = { tempLat, tempLon };
        return gps;
    }

    /**
     * 将gps84转为bd09
     *
     * @param lat
     * @param lon
     * @return
     */
    public static double[] wgs84ToBd09(double lat, double lon) {
        double[] gcj02 = wgs84ToGcj02(lat, lon);
        double[] bd09 = gcj02ToBd09(gcj02[0], gcj02[1]);
        return bd09;
    }

    /**
     * 度分转度
     * @param lat 纬度
     * @param lon 经度
     * @return [纬度,经度]
     */
    public static double[] wgs84TempMinToTemp(double lat,double lon){
        String gpsString ="$GPGGA,020202.00,"+lat+",N,"+lon+",E,1,04,3.53,45.3,M,-2.7,M,,*76";
        NMEAParser nmeaParser =new NMEAParser();
        List<NMEAMessage> messages = nmeaParser.parseString(gpsString);
        Double longitude = (Double) messages.get(0).get("lng");
        Double latitude = (Double) messages.get(0).get("lat");
//        System.out.printf("经度：%f，纬度：%f，海拔高度：%f", longitude, latitude, altitude);

        double[] gps = { latitude, longitude };
        return gps;
    }

    public static double[] bd09ToWgs84(double lat, double lon) {
        double[] gcj02 = bd09ToGcj02(lat, lon);
        double[] gps84 = gcj02ToWgs84(gcj02[0], gcj02[1]);
        // 保留小数点后六位
        gps84[0] = retain6(gps84[0]);
        gps84[1] = retain6(gps84[1]);
        return gps84;
    }

    /**
     * 根据当前经纬度，距离，方向角，计算
     * @param lat1 纬度
     * @param lon1 经度
     * @param deg1 方向角
     * @param dis1 距离=速度X时间(1秒)
     * @return [纬度,经度]
     */
    public static double[] calcGcj02PointMove(double lat1,double lon1,double deg1,double dis1){
        double arc=6371.393*1000;
        double lon2=lon1+dis1*Math.sin(deg1)/(arc*Math.cos(lat1)*2*pi/360);
        double lat2=lat1+dis1*Math.cos(deg1)/(arc*2*pi/360);
        double[] gps = { lat2, lon2 };
        return gps;
    }

    /**
     * 保留小数点后六位
     *
     * @param num
     * @return
     */
    private static double retain6(double num) {
        String result = String.format("%.6f", num);
        return Double.valueOf(result);
    }

    public static void main(String[] args) {
        String str = "113.2362898,21.9053547;113.2353993,21.9076491;113.2352312,21.9079071;113.2345464,21.9086146;113.2342782,21.9089879;113.2341989,21.9093424;113.2342173,21.9101219;113.2345064,21.9118989";
        String[] arr = str.split(";");
        String res = "";
        for(String s : arr) {
            String[] lntlat = s.split(",");
            Double lnt = Double.parseDouble(lntlat[0]);
            Double lat = Double.parseDouble(lntlat[1]);

            double[] bd09 = wgs84ToBd09(lnt, lat);
            res += bd09[0] + "," + bd09[1] + ";";
        }
        res = res.substring(0, res.lastIndexOf(";"));
        System.out.println(res);

    }



}