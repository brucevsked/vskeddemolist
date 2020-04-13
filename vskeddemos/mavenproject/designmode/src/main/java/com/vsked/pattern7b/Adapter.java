package com.vsked.pattern7b;

public class Adapter implements Ps2{
	
	private Usb3 usb3;
	
	public Adapter(Usb3 usb3) {
		this.usb3=usb3;
	}

	@Override
	public void isPs2() {
		usb3.isUsb3();
	}

}
