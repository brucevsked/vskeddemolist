package com.jat.object;

public class UserId {

    private Long id;

    public UserId(Long id) {
        if(id==null){
            throw new IllegalArgumentException("用户编号不能为空！");
        }
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    
    //更新用户时判断传入的用户id不存在
    public static void checkNotExist(Boolean isExistUserId) {
		if (!isExistUserId) {
			throw new IllegalArgumentException("用户不存在！");
		}
    }

    public String toString() {
        return "" + id;
    }
}
