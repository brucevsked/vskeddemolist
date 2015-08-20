package com.vsked.test.string;

public class TestString {

	public static void main(String[] args) {
		testStringIndexOfAndSubString();
	}
	
	public static void testStringIndexOfAndSubString(){
		String s="";
		s+="Aug 5, 2015 10:51:07 PM org.apache.catalina.core.AprLifecycleListener init";
		s+="INFO: The APR based Apache Tomcat Native library which allows optimal performance in production environments was not found on the java.library.path: /opt/jdk1.6.0_45/jre/lib/amd64/server:/opt/jdk1.6.0_45/jre/lib/amd64:/opt/jdk1.6.0_45/jre/../lib/amd64:/usr/java/packages/lib/amd64:/usr/lib64:/lib64:/lib:/usr/lib";
		s+="Aug 5, 2015 10:51:08 PM org.apache.coyote.http11.Http11Protocol init";
		s+="INFO: Initializing Coyote HTTP/1.1 on http-8080";
		s+="Aug 5, 2015 10:51:08 PM org.apache.catalina.startup.Catalina load";
		s+="INFO: Initialization processed in 748 ms";
		s+="Aug 5, 2015 10:51:08 PM org.apache.catalina.core.StandardService start";
		s+="INFO: Starting service Catalina";
		s+="Aug 5, 2015 10:51:08 PM org.apache.catalina.core.StandardEngine start";
		s+="INFO: Starting Servlet Engine: Apache Tomcat/6.0.44";
		s+="Aug 5, 2015 10:51:08 PM org.apache.catalina.startup.HostConfig deployDescriptor";
		s+="INFO: Deploying configuration descriptor manager.xml";
		s+="Aug 5, 2015 10:51:08 PM org.apache.catalina.startup.HostConfig deployDescriptor";
		s+="INFO: Deploying configuration descriptor host-manager.xml";

		String filterFlag="Aug 5";
		boolean runFlag=true;
		String str="";
		while(runFlag){
		//System.out.println(s.substring(0,s.indexOf(filterFlag,filterFlag.length()+2)));
			if(s.length()<=0) runFlag=false;
			if(s.indexOf(filterFlag,filterFlag.length()+2)>0){
			str=s.substring(0,s.indexOf(filterFlag,filterFlag.length()+2));
			System.out.println(str);
		    s=s.substring(s.indexOf(filterFlag,filterFlag.length()+2));
			}else{
				str=s.substring(0);
				System.out.println(str);
				runFlag=false;
			}
		}
	}

}
