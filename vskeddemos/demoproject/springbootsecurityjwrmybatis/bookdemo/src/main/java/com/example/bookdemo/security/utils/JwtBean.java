package com.example.bookdemo.security.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtBean {
    private long code;
    private String message;
    private Object object;

    /**
     * 成功返回结果
     * @param message
     * @return
     */
    public static JwtBean success(String message) {
        return new JwtBean(200, message, null);
    }

    /**
     * 成功返回结果
     *
     * @param message
     * @param object
     * @return
     */
    public static JwtBean success(String message, Object object) {
        return new JwtBean(200, message, object);
    }

    /**
     * 失败返回结果
     *
     * @param message
     * @return
     */
    public static JwtBean error(String message) {
        return new JwtBean(500, message, null);
    }

    /**
     * 失败返回结果
     * @param message
     * @param object
     * @return
     */
    public static JwtBean error(String message, Object object) {
        return new JwtBean(200, message, object);
    }
}
