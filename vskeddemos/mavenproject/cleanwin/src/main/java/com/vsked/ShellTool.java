package com.vsked;

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
     * @return result
     * @throws Exception
     */
    public static String exeWin(String cmd) throws Exception {
        StringBuilder result= new StringBuilder();
        String[] command = { "cmd", "/c", cmd };
        Process process = Runtime.getRuntime().exec(command);
        InputStreamReader ir = new InputStreamReader(process.getInputStream());
        LineNumberReader input = new LineNumberReader(ir);
        String line;
        while ((line = input.readLine()) != null) {
            result.append(line);
        }
        return result.toString();
    }

    /**
     * 调用centos命令或脚本
     * shell调用时请以sh 然后脚本路径 参数1 参数2
     * @param cmd
     * @return result
     * @throws Exception
     */
    public static String exeCentos(String cmd) throws Exception {
        StringBuilder result= new StringBuilder();
        String[] command = { "/bin/sh", "-c", cmd };
        Process process = Runtime.getRuntime().exec(command);
        InputStreamReader ir = new InputStreamReader(process.getInputStream());
        LineNumberReader input = new LineNumberReader(ir);
        String line;
        while ((line = input.readLine()) != null) {
            result.append(line);
        }
        return result.toString();
    }
}
