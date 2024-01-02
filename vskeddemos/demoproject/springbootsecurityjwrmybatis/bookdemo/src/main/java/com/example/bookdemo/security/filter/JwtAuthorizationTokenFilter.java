package com.example.bookdemo.security.filter;

import com.example.bookdemo.security.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthorizationTokenFilter extends OncePerRequestFilter {

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Resource
    private JwtTokenUtil jwtTokenUtil;
    @Resource
    private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException, NumberFormatException {
        // 获取Header
        String authHeader = request.getHeader(tokenHeader);
        // 存在token但不是tokenHead开头
        if (null != authHeader && authHeader.startsWith(tokenHead)) {
            // 字段截取authToken
            String authToken = authHeader.substring(tokenHead.length());
            // 根据authToken获取username
            String username = jwtTokenUtil.getUsernameFromToken(authToken);
            // token存在用户名但未登录
            if (null != username && null == SecurityContextHolder.getContext().getAuthentication()) {
                // 登录
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                // 验证token是否有效，如果有效，将他重新放到用户对象里。
                if (jwtTokenUtil.validateToken(authToken, userDetails)) {
                    UsernamePasswordAuthenticationToken authenticationToken =
                            new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    // 重新设置到用户对象里
                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }
            }
        }
        // 放行
        chain.doFilter(request, response);
    }


}

