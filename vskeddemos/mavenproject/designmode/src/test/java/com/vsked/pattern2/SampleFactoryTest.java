package com.vsked.pattern2;


import org.testng.annotations.Test;

public class SampleFactoryTest {
	
	@Test
	public void createHuman(){
		Human man=SampleFactory.createHuman("man");
		man.say();
		Human woman=SampleFactory.createHuman("woman");
		woman.say();
	}

}
