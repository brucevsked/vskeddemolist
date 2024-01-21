package com.jat.java.lang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class ByteTest {
    private static final Logger log = LoggerFactory.getLogger(ByteTest.class);

    @Test
    public void comapre1(){
        Byte b1=Byte.valueOf("0");
        Assert.assertTrue(0==b1);
        Byte b2=Byte.valueOf("1");
        Assert.assertTrue(1==b2);
        Byte b3=Byte.valueOf("2");
        Assert.assertTrue(2==b3);
    }

    @Test
    public void byteToHexTest(){
        byte b=95;
        log.debug("{}",b);
        String hexStr=byteToHex(b);
        log.debug("{}",hexStr);
    }

    @Test
    public void bytesToHexTest(){
        byte[] bArray=new byte[20];
        Random random=new Random();
        for(int i=0;i<20;i++){
            bArray[i]= (byte) random.nextInt(127);
        }
        log.debug("{}",bArray);
        String hexStr=bytesToHex(bArray);
        log.debug("{}",hexStr);
    }

    @Test
    public void byteToCharTest(){
        byte[] bArray=new byte[2];
        Random random=new Random();
        for(int i=0;i<2;i++){
            bArray[i]= (byte) random.nextInt(127);
        }
        log.debug("{}",bArray);
        char c=byteToChar(bArray);
        log.debug("{}",c);
    }

    @Test
    public void charToByteTest(){
        char c='V';
        log.debug("{}",c);
        byte[] bArray=charToByte(c);
        log.debug("{}",bArray);
    }

    /**
     * Byte字节转Hex
     *
     * @param b 字节
     * @return Hex
     */
    public static String byteToHex(byte b) {
        String hexString = Integer.toHexString(b & 0xFF);
        //由于十六进制是由0~9、A~F来表示1~16，所以如果Byte转换成Hex后如果是<16,就会是一个字符（比如A=10），通常是使用两个字符来表示16进制位的,
        //假如一个字符的话，遇到字符串11，这到底是1个字节，还是1和1两个字节，容易混淆，如果是补0，那么1和1补充后就是0101，11就表示纯粹的11
        if (hexString.length() < 2) {
            hexString = new StringBuilder(String.valueOf(0)).append(hexString).toString();
        }
        return hexString.toUpperCase();
    }

    public static String bytesToHex(byte[] bytes) {
        StringBuffer sb = new StringBuffer();
        if (bytes != null && bytes.length > 0) {
            for (int i = 0; i < bytes.length; i++) {
                String hex = byteToHex(bytes[i]);
                sb.append(hex);
            }
        }
        return sb.toString();
    }

    public static byte[] charToByte(char c) {
        byte[] b = new byte[2];
        b[0] = (byte) ((c & 0xFF00) >> 8);
        b[1] = (byte) (c & 0xFF);
        return b;
    }

    public static char byteToChar(byte[] b) {
        int hi = (b[0] & 0xFF) << 8;
        int lo = b[1] & 0xFF;
        return (char) (hi | lo);
    }
    
}
