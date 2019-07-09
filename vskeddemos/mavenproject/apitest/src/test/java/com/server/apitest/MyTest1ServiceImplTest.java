package com.server.apitest;


public class MyTest1ServiceImplTest {
	
	public static void main(String[] args) {
		
		int userCount=1880;
		
		for(int i=0;i<userCount;i++){
			int c=i;
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					MyTest1ServiceImpl myTest1Service=new MyTest1ServiceImpl();
//					myTest1Service.appmodulelist();
					myTest1Service.appnotice();
					System.out.println("|"+c+"|");
				}
			}).start();
		}
		
	}

}
