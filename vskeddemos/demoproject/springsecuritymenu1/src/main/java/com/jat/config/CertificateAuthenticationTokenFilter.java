package com.jat.config;

import com.jat.system.model.Certificate;
import com.jat.system.model.User;
import com.jat.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Component
public class CertificateAuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    UserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        String token = request.getHeader("Bearer");
        if (token != null) {
            User user = userService.findByCertificateId(new Long(token));

            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

            if (user != null && authentication == null) {
                //验证token有效性
                Certificate certificate = user.getCertificate();
                if (certificate == null) {
                    String msg = "请求访问："+request.getRequestURI()+"，认证失败，用户未登录或证书已失效！";
                    msg="{\"code\":\"401\",\"msg\":\""+msg+"\"}";

                    response.setStatus(401);
                    response.setContentType("application/json");
                    response.setCharacterEncoding("utf-8");
                    response.getWriter().print(msg);
                    return;
                }

                if (certificate.isExpire()) {
                    String msg = "请求访问："+request.getRequestURI()+"，认证失败，登录证书已经过期，请重新登录！";
                    msg="{\"code\":\"401\",\"msg\":\""+msg+"\"}";

                    response.setStatus(401);
                    response.setContentType("application/json");
                    response.setCharacterEncoding("utf-8");
                    response.getWriter().print(msg);
                    return;
                } else if (certificate.isNeedRefresh()) {
                    certificate = new Certificate(certificate.getId(), new Date());
                    user.setCertificate(certificate);
                    userService.save(user);
                }

                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);

            }
        }

        chain.doFilter(request, response);
    }
}
