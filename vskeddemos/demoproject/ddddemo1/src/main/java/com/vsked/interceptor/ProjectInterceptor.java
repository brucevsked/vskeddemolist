package com.vsked.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 项目拦截器   <br />
 * 用来对      <br />
 * 是否登录    <br />
 * 登录权限    <br />
 * 进行验证操作 <br />
 *
 */
public class ProjectInterceptor implements HandlerInterceptor {

    private static final Logger log = LoggerFactory.getLogger(ProjectInterceptor.class);
    /**
     * 在请求处理之前进行调用（Controller方法调用之前）
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        String[] excludePathPatterns= {
                "/favicon.ico",
                "/**/*.html"
        };

        String[] excludeExtensionPatterns= {
                ".ico",
                ".css",
                ".js",
                ".map",
                ".html"
        };

        //自定义排除扩展名
        for(String excludeExtension:excludeExtensionPatterns){
            if(request.getRequestURI().toLowerCase().endsWith(excludeExtension)){
                return true;
            }
        }

        //自定义排除路径
        for(String excludePath:excludePathPatterns){
            if(excludePath.equals(request.getRequestURI())){
                return true;
            }
        }

        if(log.isTraceEnabled()){
            log.trace("进入拦截器");
        }

        if(log.isDebugEnabled()){
            log.debug(request.getRequestURI());
        }
//        System.out.println("执行了TestInterceptor的preHandle方法");
        /*
        try {
            //统一拦截（查询当前session是否存在user）(这里user会在每次登陆成功后，写入session)
            User user=(User)request.getSession().getAttribute("USER");
            if(user!=null){
                return true;
            }
            response.sendRedirect(request.getContextPath()+"你的登陆页地址");
        } catch (IOException e) {
            e.printStackTrace();
        }
        */

        return false;//如果设置为false时，被请求时，拦截器执行到此处将不会继续操作
        //如果设置为true时，请求将会继续执行后面的操作
    }

    /**
     * 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
//         System.out.println("执行了TestInterceptor的postHandle方法");
    }

    /**
     * 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
//        System.out.println("执行了TestInterceptor的afterCompletion方法");
    }
}
