package com.jat;

public class TestNickName {
    public static void main(String[] args) {
        String nickName="123456";
        if(nickName.length()>1){
            if(nickName.length()==2){
                nickName=nickName.substring(0,1)+"*";
            } else if (nickName.length()==3) {
                nickName=nickName.substring(0,1)+"*"+nickName.substring(2);
            }else if(nickName.length()>3){
//                boolean isOdd=nickName.length()%2==1;//奇数 true为奇数 false偶数
                int s1=nickName.length()-2;
                int s2=s1/2;
//                System.out.println(s1);
//                System.out.println(s2);
                int b1start=0;
                int b1end=s2;
                int b2start=s2;
                int b2end=s2+1;
                int b3=b2end+1;
                String str1=nickName.substring(b1start,b1end);
                String str2="**";
                String str3=nickName.substring(b3);
                String result=str1+str2+str3;
                System.out.println(result);

            }
        }
        System.out.println(nickName);

    }
}
