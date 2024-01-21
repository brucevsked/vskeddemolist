package com.jat.java.util.regex;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherTest {

    private static final Logger log = LoggerFactory.getLogger(MatcherTest.class);

    @Test
    public void notStartNumber(){
        String s="c199";
        Pattern pattern = Pattern.compile("^[a-zA-Z].*");
        boolean b=pattern.matcher(s).matches();
        log.info("匹配结果:{}",b);
    }

    @Test
    public void number(){
        String s="90";
        Pattern pattern = Pattern.compile("[0-9]*");
        boolean b=pattern.matcher(s).matches();
        log.info("匹配结果:{}",b);
    }

    @Test
    public void numberinStr(){
        String s="test666ok";
        String regx="\\d+";
        Pattern pattern = Pattern.compile(regx);
        Matcher m = pattern.matcher(s);
        if(m.find()){
            log.info("当前找到了:{}",m.group());
        }
    }

    @Test
    public void mutiNumberinStr(){
        String s="test666ok777good888very,9999,123,girl";
        String regx="\\d+";
        Pattern pattern = Pattern.compile(regx);
        Matcher m = pattern.matcher(s);
        while(m.find()){
            log.info("当前找到了:{}",m.group());
        }
    }

    @Test
    public void rever1(){
        log.trace("反向引用测试1");
        /**
         * 反向引用的使用是基于分组的，所以得先理解清楚正则中分组的概念。
         * 什么是分组？个人理解的分组是正则匹配的一个或者多个字符，
         * 通常像元字符\w，\d，\s只能匹配一个字符，或者 [ ] 范围的匹配也只是匹配一个字符。
         * 但是当需要匹配重复的组的时候，例字符串：“asd123asd123”，不使用分组的正则写法是
         */
        String s="asd123asd123abc999ddd666";
        String regx="[a-z]{3}[1-9]{3}";
        Pattern pattern = Pattern.compile(regx);
        Matcher m = pattern.matcher(s);
        while(m.find()){
            log.info("当前找到了:{}",m.group());
        }

        /**
         * 这种写法不但违反计算机科学原理，
         * 程序猿看上去还觉得别扭（众所周知，重复的代码都习惯了封装），
         * 所以我所理解的分组，其实就是正则表达式中的一种 “封装” 而已。
         * 那么经过封装后，上面的写法可以改写为
         */
        String s1="123123789789654654";
        String regx1="(\\d{3})\\1";
        Pattern pattern1 = Pattern.compile(regx1);
        Matcher m1 = pattern1.matcher(s1);
        while(m1.find()){
            log.info("当前找到了1:{}",m1.group());
        }

    }
}
