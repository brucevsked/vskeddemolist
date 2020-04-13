package com.vsked.pattern7a;

public class Adapter extends UDisk implements Ps2{

	@Override
	public void isPs2() {
		isUsb3();		
	}

}
