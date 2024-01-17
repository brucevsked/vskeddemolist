package com.jat.interceptor;

import javax.servlet.http.HttpServletRequest;
import com.jat.util.JwtKit;
import com.jat.model.IJwtAble;
import com.jat.util.Response;
import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.plugin.redis.Redis;

public class JwtTokenInterceptor implements Interceptor {

    String[] whiteList={"/manager/user/login"};

    @Override
    public void intercept(Invocation inv) {
        HttpServletRequest req=inv.getController().getRequest();
        Integer code = recoverAuthFromRequest(req);

        for(String whiteUrl:whiteList){
            if(whiteUrl.equals(req.getRequestURI())){
                code=200;//如果在白名单里放过
            }
        }


        switch (code) {
            case 200: {
                inv.invoke();
                break;
            }
            default: {
                Response response=new Response(401,"无权限访问，请检查是否登录。");
                inv.getController().renderJson(response);
            }
        }
    }

    /**
     * 读取Token从请求中 判断是否允许访问
     *
     * @param request 请求
     * @return 状态码
     */
    private Integer recoverAuthFromRequest(HttpServletRequest request) {
        //没有权限用户
        try {
            IJwtAble jwtBean = getMe(request);
            if (jwtBean == null) return 404;
            return 200;
        } catch (Exception e) {
            e.printStackTrace();
            return 404;
        }
    }

    /**
     * 从请求头解析出me
     *
     * @param request 请求
     * @return IJwtAble
     */
    protected static IJwtAble getMe(HttpServletRequest request) {
        String userId=JwtKit.getJwtUserIdBy(request);
        IJwtAble me = Redis.use(JwtKit.prop.get("cacheName")).get(JwtKit.userIdKey+":"+userId);
        return me;
    }
}
