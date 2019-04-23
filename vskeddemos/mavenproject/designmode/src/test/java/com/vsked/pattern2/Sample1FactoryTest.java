package com.vsked.pattern2;

import org.junit.Test;


public class Sample1FactoryTest {
	
	@Test
	public void createHuman(){
		Human man=Sample1Factory.createHuman(Man.class);
		man.say();
		Human woman=Sample1Factory.createHuman(Woman.class);
		woman.say();
	}

}
