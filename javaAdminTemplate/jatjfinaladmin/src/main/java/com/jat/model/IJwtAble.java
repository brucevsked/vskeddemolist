package com.jat.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * JKhaled created by yunqisong@foxmail.com 2017/7/23
 * FOR : 普通JavaBean或者是Model变为可以使用插件的JwtUser
 */
public interface IJwtAble extends Serializable {
    /**
     * 获取角色集合
     *
     * @return
     */
    List<String> getRoles();

    /**
     * 获取权限集合
     *
     * @return
     */
    List<String> getForces();

    /**
     * 上次修改密码时间
     *
     * @return
     */
    Date getLastModifyPasswordTime();

    String getUserId();

}

