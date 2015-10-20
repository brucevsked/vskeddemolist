package com.sinovoice.example.sys;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
public class AccountInfo {

    String sPath = System.getProperty("user.dir");
	
    private static AccountInfo mInstance;

    private Map<String, String> mAccountMap;

    private AccountInfo() {
        mAccountMap = new HashMap<String, String>();
    }

    public static AccountInfo getInstance() {
        if (mInstance == null) {
            mInstance = new AccountInfo();
        }
        return mInstance;
    }

    public String getCapKey(){
        return mAccountMap.get("capKey");
    }
    public String getDeveloperKey(){
        return mAccountMap.get("developerKey");
    }
    public String getAppKey(){
        return mAccountMap.get("appKey");
    }
    public String getCloudUrl(){
        return mAccountMap.get("cloudUrl");
    }
    
    /**
     * 加载用户的注册信息
     * 
     * @param fileName
     */
    public boolean loadAccountInfo() {
        boolean isSuccess = true;
        String accountInfoPath = sPath + "\\testdata\\AccountInfo.txt";
        try {
    		FileReader filereader = new FileReader(accountInfoPath);
    		BufferedReader br = new BufferedReader(filereader);
            String temp = null;
            String[] sInfo = new String[2];
            temp = br.readLine();
            while (temp != null) {
                if (!temp.startsWith("#") && !temp.equalsIgnoreCase("")) {
                    sInfo = temp.split("=");
                    if (sInfo.length == 2){
                        if(sInfo[1] == null || sInfo[1].length() <= 0){
                            isSuccess = false;
                            System.out.println("AccountInfo" + sInfo[0] + "is null");
                            break;
                        }
                        mAccountMap.put(sInfo[0], sInfo[1]);
                    }
                }
                temp = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            isSuccess = false;
        }       
        return isSuccess;
    }

}
