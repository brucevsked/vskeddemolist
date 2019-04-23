package com.vsked.pattern3;

import org.junit.Test;

public class FactoryTest {
	
	@Test
	public void createHuman(){
		Factory factory=new ManFactory();
		Human man=factory.createHuman();
		man.say();
		Factory womanFactory=new WomanFactory();
		Human woman=womanFactory.createHuman();
		woman.say();
	}

}
