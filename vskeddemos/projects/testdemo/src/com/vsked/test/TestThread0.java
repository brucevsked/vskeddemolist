package com.vsked.test;

public class TestThread0 {

	
	
	public static void main(String[] args) {
		
		new Thread(new Runnable() {
			
			public void run() {
				while(true){
						try {
							System.out.println("one man comming......");
							Thread.sleep(3000);
							System.out.println(1/0);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
		}).start();
	}

}
