package com.vsked.pattern3;

public class ManFactory implements Factory{

	@Override
	public Human createHuman() {
		return new Man();
	}

}
