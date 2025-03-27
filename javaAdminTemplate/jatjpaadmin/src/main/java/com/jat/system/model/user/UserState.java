package com.jat.system.model.user;

/**
 * 用户状态0正常1停用
 */
public class UserState {
    private Integer state;

    public UserState(Integer state) {
        this.state = state;
    }

    public Integer getState() {
        return state;
    }

    @Override
    public String toString() {
        return state+"";
    }
}
