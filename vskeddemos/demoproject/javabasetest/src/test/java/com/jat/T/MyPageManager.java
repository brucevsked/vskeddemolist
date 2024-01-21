package com.jat.T;

/**
 * 泛型测试2，只在方法内用
 */
public class MyPageManager {

    public MyPageManager() {
    }

    public <T> MyPage<T> create(int index, int size){
        return new MyPage<>(index, size);
    }
}
