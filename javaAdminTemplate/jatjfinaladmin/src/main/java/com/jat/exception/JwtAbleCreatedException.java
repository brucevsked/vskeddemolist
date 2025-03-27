package com.jat.exception;

public class JwtAbleCreatedException extends RuntimeException {

    private static String messagePrefix = "构建 IJwtAble 的对象中的 对应的 ";

    private static String messageEnd = "属性不可以为 ";

    /**
     * 组合异常产生原因
     *
     * @param keyWord
     * @param status
     */
    public JwtAbleCreatedException(String keyWord, String status) {
        super(messagePrefix + keyWord + messageEnd + status);
    }
}
