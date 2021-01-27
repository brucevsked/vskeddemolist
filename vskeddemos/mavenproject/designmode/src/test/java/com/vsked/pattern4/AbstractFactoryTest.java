package com.vsked.pattern4;


import org.testng.annotations.Test;

public class AbstractFactoryTest {
	
	@Test
	public void testFactory(){
		IAbstractFactory f1=new LowPersonFactory();
		Car car=f1.getCar();
		car.toWork();
		IBreakFast breakFast=f1.getBreakFast();
		breakFast.eat();
		System.out.println("------------------------");
		IAbstractFactory f2=new HighPersonFactory();
		Car car2=f2.getCar();
		car2.toWork();
		IBreakFast breakFast2=f2.getBreakFast();
		breakFast2.eat();
	}

}
