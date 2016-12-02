package com.vsked.test;

import org.junit.Test;
import static org.junit.Assert.*;

public class HelloTest {
	
	@Test
	public void t1(){
		boolean flag=true;
		System.out.println("t1"+flag);
		assertEquals(flag,true);
	}
	

}
