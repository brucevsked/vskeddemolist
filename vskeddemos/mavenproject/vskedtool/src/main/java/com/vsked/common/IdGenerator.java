package com.vsked.common;


/**
 * 编号生成器单节点版本
 */
public class IdGenerator {

    /**
     * 构造方法设置机器码：第1个机房的第1台机器<br>
     *     机房取值0-31,机器取值0-31
     */
    final static Snowflake snowflake = new Snowflake(1, 1);

    /**
     * 1机房1号机器生成的编号
     * @return
     */
    public static long getId(){
        return snowflake.nextId();
    }
}
