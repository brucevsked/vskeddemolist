package com.vsked.test;


public class MyBean {
	
	public static String bname="";
	
	public static int bage=1;
	
	private String nickName="";
	
	private int bf=1;
	
	
	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public int getBf() {
		return bf;
	}

	public void setBf(int bf) {
		this.bf = bf;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		MyBean m1=new MyBean();
		m1.bname="111";
		m1.bage=11;
		m1.setNickName("myname is 111");
		m1.setBf(11);
		
		System.out.println(m1.bname+"|"+m1.bage+"|"+m1.getNickName()+"|"+m1.getBf());
		
		MyBean m2=new MyBean();
		m2.bname="222";
		m2.bage=22;
		m2.setNickName("myname is 222");
		m2.setBf(22);
		
		System.out.println(m2.bname+"|"+m2.bage+"|"+m2.getNickName()+"|"+m2.getBf());
		
		System.out.println(m1.bname+"|"+m1.bage+"|"+m1.getNickName()+"|"+m1.getBf());

	}

}
