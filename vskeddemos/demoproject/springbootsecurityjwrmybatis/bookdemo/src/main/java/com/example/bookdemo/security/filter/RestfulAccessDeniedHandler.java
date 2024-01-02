package com.example.bookdemo.security.filter;

import com.example.bookdemo.security.utils.JwtBean;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.lang.System.out;

@Component
public class RestfulAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e)
            throws IOException, ServletException {
        // 通过response设置编码格式
        response.setCharacterEncoding("UTF-8");
        // 设置ContentType
        response.setContentType("application/json");
        // 输出流
        JwtBean bean = JwtBean.error("权限不足，请联系管理员！");
        bean.setCode(403);
        out.write(Integer.parseInt(new ObjectMapper().writeValueAsString(bean)));
        out.flush();
        out.close();
    }
}

