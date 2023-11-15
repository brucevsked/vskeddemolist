package com.vsked.common;

import java.sql.Timestamp;

public class DateTimeTool {

    public static void main(String[] args) {
        Timestamp curTime=new Timestamp(System.currentTimeMillis());
        Timestamp expireTime = new Timestamp(System.currentTimeMillis()+10);
        if (expireTime.after(curTime)) {
            System.out.println("过期了");
        }else{
            System.out.println("还没过期");
        }

    }

}
