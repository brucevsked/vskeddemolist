package com.vsked.config;

import com.vsked.auth.service.SelfUserDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    private static final Logger log = LoggerFactory.getLogger(SpringSecurityConfig.class);

    @Autowired
    AjaxAuthenticationEntryPoint authenticationEntryPoint;  //  未登陆时返回 JSON 格式的数据给前端（否则为 html）

    @Autowired
    AjaxAuthenticationSuccessHandler authenticationSuccessHandler;  // 登录成功返回的 JSON 格式数据给前端（否则为 html）

    @Autowired
    AjaxAuthenticationFailureHandler authenticationFailureHandler;  //  登录失败返回的 JSON 格式数据给前端（否则为 html）

    @Autowired
    AjaxLogoutSuccessHandler logoutSuccessHandler;  // 注销成功返回的 JSON 格式数据给前端（否则为 登录时的 html）

    @Autowired
    AjaxAccessDeniedHandler accessDeniedHandler;    // 无权访问返回的 JSON 格式数据给前端（否则为 403 html 页面）

    @Autowired
    SelfUserDetailsService userDetailsService; // 自定义user

    @Autowired
    JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter; // JWT 拦截器

    @Autowired
    MyLoginUrlAuthenticationEntryPoint myLoginUrlAuthenticationEntryPoint;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 加入自定义的安全认证
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // 去掉 CSRF
        http.csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // 使用 JWT，关闭token
                .and()

                .httpBasic().authenticationEntryPoint(authenticationEntryPoint)

                .and()
                .authorizeRequests()


                .anyRequest()
                .access("@rbacauthorityservice.hasPermission(request,authentication)") // RBAC 动态 url 认证

                .and()
                .formLogin().usernameParameter("username").passwordParameter("password")  //开启登录
                .successHandler(authenticationSuccessHandler) // 登录成功
                .failureHandler(authenticationFailureHandler) // 登录失败
                .permitAll()

                .and()
                .logout()
                .logoutSuccessHandler(logoutSuccessHandler)
                .permitAll();

        // 记住我
        http.rememberMe().rememberMeParameter("remember-me")
                .userDetailsService(userDetailsService).tokenValiditySeconds(300);

        http.exceptionHandling().accessDeniedHandler(accessDeniedHandler)   // 无权访问 JSON 格式的数据
        .authenticationEntryPoint(myLoginUrlAuthenticationEntryPoint)       //没授权不返回html返回json
        ;
        http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class); // JWT Filter

    }

    public void configure(WebSecurity web) throws Exception {
        //对这个地址不进行拦截
        web.ignoring().antMatchers("/test");//测试连通
        web.ignoring().antMatchers( HttpMethod.POST,"/login");//登录
        web.ignoring().antMatchers("/logout");//注销
        //可以仿照上面一句忽略静态资源
    }

}