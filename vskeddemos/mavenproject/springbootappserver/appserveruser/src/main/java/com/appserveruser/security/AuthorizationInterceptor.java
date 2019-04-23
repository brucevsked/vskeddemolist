package com.appserveruser.security;

import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import com.appservercommon.token.ConstantKit;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AuthorizationInterceptor implements HandlerInterceptor {
	
    //存放鉴权信息的Header名称，默认是Authorization
    private String httpHeaderName = "Authorization";

    //鉴权失败后返回的错误信息，默认为401 unauthorized
    private String unauthorizedErrorMessage = "401 unauthorized";

    //鉴权失败后返回的HTTP错误码，默认为401
    private int unauthorizedErrorCode = HttpServletResponse.SC_UNAUTHORIZED;
    
    @Resource
    private RedisTemplate<String, Object> redisTemplate;

	//存放登录用户模型Key的Request Key
    public static final String REQUEST_CURRENT_KEY = "REQUEST_CURRENT_KEY";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();

        // 如果打上了AuthToken注解则需要验证token
        if (method.getAnnotation(AuthToken.class) != null || handlerMethod.getBeanType().getAnnotation(AuthToken.class) != null) {
        	

            String token = request.getParameter(httpHeaderName);
            log.info("Get token from request is {} ", token);
            String username = "";
            if (token != null && token.length() != 0) {
                username = (String) redisTemplate.opsForValue().get(token);
                log.info("Get username from Redis is {}", username);
            }
            if (username != null && !username.trim().equals("")) {
            	
                Long tokeBirthTime = redisTemplate.getExpire(token);
                log.info("token Birth time is: {}", tokeBirthTime);
                Long diff = System.currentTimeMillis() - tokeBirthTime;
                log.info("token is exist : {} ms", diff);
                if (diff > ConstantKit.TOKEN_RESET_TIME) {
                	redisTemplate.expire(username, ConstantKit.TOKEN_EXPIRE_TIME,TimeUnit.SECONDS);
                	redisTemplate.expire(token, ConstantKit.TOKEN_EXPIRE_TIME,TimeUnit.SECONDS);
                    log.info("Reset expire time success!");
                }

                request.setAttribute(REQUEST_CURRENT_KEY, username);
                return true;
            } else {
                JSONObject jsonObject = new JSONObject();

                PrintWriter out = null;
                try {
                    response.setStatus(unauthorizedErrorCode);
                    response.setContentType(MediaType.APPLICATION_JSON_VALUE);

                    jsonObject.put("code", ((HttpServletResponse) response).getStatus()+"");
                    jsonObject.put("msg", HttpStatus.UNAUTHORIZED);
                    out = response.getWriter();
                    out.println(jsonObject);

                    return false;
                } catch (Exception e) {
                    e.printStackTrace();
                    log.error("authorization Exception ",e);
                    out.println("{\"code\":\"900002\",\"msg\":\"权限验证异常请联系管理员"+e.getMessage()+"\"}");
                } finally {
                    if (null != out) {
                        out.flush();
                        out.close();
                    }
                }

            }

        }

        request.setAttribute(REQUEST_CURRENT_KEY, null);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}

