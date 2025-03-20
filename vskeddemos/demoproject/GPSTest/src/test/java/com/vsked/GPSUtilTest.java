package com.vsked;

import com.vsked.utils.GPSUtil;
import org.openimaj.hardware.gps.NMEAMessage;
import org.openimaj.hardware.gps.NMEAParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import java.util.List;

public class GPSUtilTest {

    private static final Logger log = LoggerFactory.getLogger(GPSUtilTest.class);

    @Test
    private void wgs84ToGcj02(){
        log.debug("{}","开始执行wsg84坐标系转GCJ02坐标系...");
        double latitude = 36.651474;//纬度
        double longitude = 116.997777;//经度
        log.debug("纬度{},经度{}",latitude,longitude);
        double[] gcj02Array = GPSUtil.wgs84ToGcj02(latitude, longitude);
        log.debug("坐标转换完成{}",gcj02Array);//[纬度,经度] [36.65172009453364，117.0036078124296]
    }

    @Test
    private void gcj02ToWGS84(){
        log.debug("{}","开始执行GCJ02坐标系转wsg84坐标系...");
        double latitude = 36.524754440045804;//纬度
        double longitude = 116.75486532806397;//经度
        log.debug("纬度{},经度{}",latitude,longitude);
        double[] wgs84Array = GPSUtil.gcj02ToWgs84(latitude, longitude);
        log.debug("坐标转换完成{}",wgs84Array);//[纬度,经度] [36.52457675331124 116.74917521706618]
    }


    @Test
    private void wgs84TempMinToTemp(){
        double latitude=3639.49809; //纬度
        double longitude = 11706.00498;//经度
        double[] result=GPSUtil.wgs84TempMinToTemp(latitude,longitude);
        log.debug("转换前{},{}",latitude,longitude);
        log.debug("转换后{},{}",result[0],result[1]);
    }

    @Test
    public void calcGcj02PointMove(){
        double latitude=36.524754440045804; //纬度
        double longitude = 116.75486532806397;//经度
        double degree=30.23;//角度
        double speed=98.12; //速度
        double time=1;//时间，单位秒
        double distince=speed*time;//距离计算完成后是否要除以2
        log.debug("距离:{}",distince);
        distince=distince/2; //这一步是否必须，多测试几个数据看下
        double[] result=GPSUtil.calcGcj02PointMove(latitude,longitude,degree,distince);
        log.debug("运动前{},{}",latitude,longitude);
        log.debug("计算后{},{}",result[0],result[1]);
    }

    @Test
    public void wgs84TempMinToTempOld(){
        String gpsString ="$GPGGA,020202.00,3639.49809,N,11706.00498,E,1,04,3.53,45.3,M,-2.7,M,,*76";
        NMEAParser nmeaParser =new NMEAParser();
        List<NMEAMessage> messages = nmeaParser.parseString(gpsString);
        Double longitude = (Double) messages.get(0).get("lng");
        Double latitude = (Double) messages.get(0).get("lat");
        Double altitude = (Double) messages.get(0).get("altitude");
        System.out.printf("经度：%f，纬度：%f，海拔高度：%f", longitude, latitude, altitude);
    }

}
