package com.vsked.log;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import org.apache.log4j.PropertyConfigurator;

public class Log4jInit extends HttpServlet{
	
	private static final long serialVersionUID = 7344700712439384227L;

	public void init(ServletConfig config) throws ServletException {  
	    String prefix = config.getServletContext().getRealPath("/");
	    //see web.xml log4jConfigPath
	    String log4jFile = config.getInitParameter("log4jConfigPath");  
	    String log4jConfigPath = prefix + log4jFile;  
	    PropertyConfigurator.configure(log4jConfigPath);  
	} 

}
