package com.example.bookdemo.service.impl;

import com.example.bookdemo.mapper.AdminMapper;
import com.example.bookdemo.pojo.Admin;
import com.example.bookdemo.security.utils.JwtBean;
import com.example.bookdemo.security.utils.JwtTokenUtil;
import com.example.bookdemo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminMapper adminMapper;
    @Resource
    private UserDetailsService userDetailsService;
    @Resource
    private PasswordEncoder passwordEncoder;
    @Resource
    private JwtTokenUtil jwtTokenUtil;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    @Override
    public Admin login(String username, String password) {
        Admin login = adminMapper.login(username, password);
        return login;
    }

    @Override
    public Admin selectByName(String username) {
        Admin admin = adminMapper.selectByName(username);
        return admin;
    }

    @Override
    public JwtBean login(String username, String password, HttpServletRequest request) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        Admin admin = adminMapper.selectByName(username);
        String oldPassword = encodePassword(admin.getPassword());
        // 判断用户是否被禁用
        if (userDetails.isEnabled()) {
            // 前端获取的密码通过passwordEncoder与数据库中的密码对比
            if (userDetails != null && passwordEncoder.matches(password, oldPassword)) {
                // 更新security登录用户对象
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                // 将authenticationToken放入spring security全局中
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                // 生成Token
                String token = jwtTokenUtil.generateToken(userDetails);
                // 将token和头部信息存入map中，登录成功后带给前端。
                HashMap<String, String> tokenMap = new HashMap<>();
                tokenMap.put("token", token);
                tokenMap.put("tokenHead", tokenHead);
                return JwtBean.success("登录成功", tokenMap);
            }
            return JwtBean.error("用户名或密码错误");
        }
        return JwtBean.error("该账号也被禁用,请联系管理员!");
    }
    public static String encodePassword(String password){
        return bCryptPasswordEncoder.encode(password);
    }
}
