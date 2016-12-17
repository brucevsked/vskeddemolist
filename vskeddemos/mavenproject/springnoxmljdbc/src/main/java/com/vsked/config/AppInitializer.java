package com.vsked.config;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

public class AppInitializer implements WebApplicationInitializer {

    public void onStartup(ServletContext servletContext) throws ServletException {
        WebApplicationContext context = getContext();
        servletContext.addListener(new ContextLoaderListener(context));
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("DispatcherServlet", new DispatcherServlet(context));
        
        dispatcher.setLoadOnStartup(1);
        
        dispatcher.addMapping("/*");
        
    	// Set whether this servlet should dispatch an HTTP OPTIONS request to the #doService method.
		dispatcher.setInitParameter("dispatchOptionsRequest", "true");
		// Set whether this servlet should dispatch an HTTP TRACE request to the #doService method.
		dispatcher.setInitParameter("dispatchTraceRequest", "true");
		dispatcher.setAsyncSupported(true);
		
		// 设置编码
		CharacterEncodingFilter encodingfilter = new CharacterEncodingFilter();
		encodingfilter.setEncoding("UTF-8");
		encodingfilter.setForceEncoding(true);
		FilterRegistration.Dynamic encodingfilterDynamic = servletContext.addFilter("encodingfilter", encodingfilter);
		encodingfilterDynamic.addMappingForServletNames(EnumSet.of(DispatcherType.REQUEST), true, "dispatcher");
    }

    private AnnotationConfigWebApplicationContext getContext() {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.setConfigLocation("com.vsked.config");
        return context;
    }

}
