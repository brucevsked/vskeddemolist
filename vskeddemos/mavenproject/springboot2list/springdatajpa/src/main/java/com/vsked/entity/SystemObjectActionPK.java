package com.vsked.entity;

import java.io.Serializable;

/**
 * 注意：
 * 复合主键类必须满足：
 * 1. 实现Serializable接口;
 * 2. 有默认的public无参数的构造方法;
 * 3. 重写equals和hashCode方法。equals方法用于判断两个对象是否相同，EntityManger通过find方法来查找Entity时，是根据equals的返回值来判断的。hashCode方法返回当前对象的哈希码;
 * ————————————————
 * 版权声明：本文为CSDN博主「y4ung」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/qq_35056292/article/details/77892012
 */
public class SystemObjectActionPK implements Serializable {

    private Long systemObjectId;
    private Long objectActionId;

    public SystemObjectActionPK() {
    }

    public SystemObjectActionPK(Long systemObjectId, Long objectActionId) {
        this.systemObjectId = systemObjectId;
        this.objectActionId = objectActionId;
    }

    public Long getSystemObjectId() {
        return systemObjectId;
    }

    public void setSystemObjectId(Long systemObjectId) {
        this.systemObjectId = systemObjectId;
    }

    public Long getObjectActionId() {
        return objectActionId;
    }

    public void setObjectActionId(Long objectActionId) {
        this.objectActionId = objectActionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SystemObjectActionPK that = (SystemObjectActionPK) o;
        return systemObjectId == that.systemObjectId &&
                objectActionId == that.objectActionId;
    }

    //重点!
    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + ((systemObjectId == null) ? 0 : systemObjectId.hashCode());
        result = PRIME * result + ((objectActionId == null) ? 0 : objectActionId.hashCode());
        return result;
    }
}
