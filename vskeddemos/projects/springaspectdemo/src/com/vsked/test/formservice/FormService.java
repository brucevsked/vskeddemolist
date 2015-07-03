package com.vsked.test.formservice;

public class FormService {
	
	@NeedTest(valuey=false)
	public void deleteForm(int fid){
		System.out.println("del form the :"+fid);
	}
	
	@NeedTest(valuey=false)
	public void deleteTopic(int tid){
		System.out.println("del top :"+tid);
	}

}
