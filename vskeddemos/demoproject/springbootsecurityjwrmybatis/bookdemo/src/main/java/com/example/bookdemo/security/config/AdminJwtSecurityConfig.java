package com.example.bookdemo.security.config;

import com.example.bookdemo.pojo.Admin;
import com.example.bookdemo.security.filter.JwtAuthorizationTokenFilter;
import com.example.bookdemo.security.filter.RestAuthorizationEntryPoint;
import com.example.bookdemo.security.filter.RestfulAccessDeniedHandler;
import com.example.bookdemo.service.AdminService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import javax.annotation.Resource;
import javax.servlet.Filter;

@Configuration
public class AdminJwtSecurityConfig extends WebSecurityConfigurerAdapter {
    @Resource
    private AdminService adminService;
    @Resource
    private RestAuthorizationEntryPoint restAuthorizationEntryPoint;
    @Resource
    private RestfulAccessDeniedHandler restfulAccessDeniedHandler;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
    }
    /**
     * 放行路径
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(
                "/login"
                );
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 使用JWT,不需要csrf
        http.csrf().disable()
                // 使用JWT,不需要session
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                // 所有请求都要认证
                //.antMatchers("/admin/login").anonymous()
                .anyRequest().authenticated()
                .and()
                // 禁用缓存
                .headers()
                .cacheControl();
        // 添加JWT 登录授权过滤器
        http.addFilterBefore(jwtAuthorizationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        // 添加自定义未授权和未登录结果返回
        http.exceptionHandling()
                .accessDeniedHandler(restfulAccessDeniedHandler)
                .authenticationEntryPoint(restAuthorizationEntryPoint);
    }

    @Override
    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            Admin admin = adminService.selectByName(username);
            if (admin != null) {
                return admin;
            }
            return null;
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public Filter jwtAuthorizationTokenFilter() {
        return new JwtAuthorizationTokenFilter();
    }

}
