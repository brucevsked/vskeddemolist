package com.vsked.common;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XmlToolsTest {
	
	private static final Logger log=LoggerFactory.getLogger(XmlToolsTest.class);
	
	@Test
	public void xmlToMap1(){
		try{
            String testFileBody = "";
            testFileBody += "<?xml version=\"1.0\" encoding=\"utf-8\"?>";
            testFileBody += "<root code=\"DB14/T 671.1-2012\">";
            testFileBody += "<head cs_mine_code=\"1xx000002\" cs_data_time=\"2010-06-03 15:23:30\" />";
            testFileBody += "<data ss_system_model=\"KJxxN\" ss_system_name=\"煤矿安全监控系统\" ss_system_maker=\"XX设备制造公司\" ss_system_prodate=\"2006-06-03\" ss_system_manum=\" MEB120xxx \" ss_system_maeffec=\"2014-06-03\" ss_system_instime=\"2010-03-03\" >";
            testFileBody +="    <point ps_station_code=\"020202\" ps_station_entertime=\"2010-06-06 08:10:28\"/>\n";
            testFileBody +="    <point ps_station_code=\"020203\" ps_station_entertime=\"2010-06-06 08:10:28\"/>\n";
            testFileBody +="</data>";
            testFileBody += "<data ss_system_model=\"KJxxN\" ss_system_name=\"煤矿安全监控系统\" ss_system_maker=\"XX设备制造公司\" ss_system_prodate=\"2006-06-03\" ss_system_manum=\" MEB120xxx \" ss_system_maeffec=\"2014-06-03\" ss_system_instime=\"2010-03-03\" />";
            testFileBody += "<data ss_system_model=\"KJxxN\" ss_system_name=\"煤矿安全监控系统\" ss_system_maker=\"XX设备制造公司\" ss_system_prodate=\"2006-06-03\" ss_system_manum=\" MEB120xxx \" ss_system_maeffec=\"2014-06-03\" ss_system_instime=\"2010-03-03\" />";
            testFileBody += "</root>";
            ShanXiDB14Handler test=new ShanXiDB14Handler();
            List<Map<String,Object>> dataList=test.getResult(testFileBody);
            System.out.println(dataList);
		}catch(Exception e){
			log.error(e.getMessage(),e);
		}
	}
	

}
