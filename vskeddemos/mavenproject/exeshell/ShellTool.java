package com.jcdz.hcommon;

import java.io.InputStreamReader;
import java.io.LineNumberReader;

public class ShellTool {

    public static void main(String[] args) {
        try {
            String cmd = "sh /tmp/vskedtest/shptodb.sh v1";
            String result = exeCentos(cmd);
            System.out.println(result);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 执行windows命令并返回结果
     * @param cmd
     * @return
     * @throws Exception
     */
    public static String exeWin(String cmd) throws Exception {
        String result="";
        String[] command = { "cmd", "/c", cmd };
        Process process = Runtime.getRuntime().exec(command);
        InputStreamReader ir = new InputStreamReader(process.getInputStream());
        LineNumberReader input = new LineNumberReader(ir);
        String line;
        while ((line = input.readLine()) != null) {
            result+= line;
        }
        return result;
    }

    /**
     * 调用centos命令或脚本
     * shell调用时请以sh 然后脚本路径 参数1 参数2
     * @param cmd
     * @return
     * @throws Exception
     */
    public static String exeCentos(String cmd) throws Exception {
        String result="";
        String[] command = { "/bin/sh", "-c", cmd };
        Process process = Runtime.getRuntime().exec(command);
        InputStreamReader ir = new InputStreamReader(process.getInputStream());
        LineNumberReader input = new LineNumberReader(ir);
        String line;
        while ((line = input.readLine()) != null) {
            result+= line;
        }
        return result;
    }
}
