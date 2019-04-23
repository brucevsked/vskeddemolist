package com.vsked.pattern3;

public class WomanFactory implements Factory{

	@Override
	public Human createHuman() {
		return new Woman();
	}

}
