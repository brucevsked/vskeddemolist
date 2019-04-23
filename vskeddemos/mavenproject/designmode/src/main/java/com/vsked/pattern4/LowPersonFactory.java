package com.vsked.pattern4;

public class LowPersonFactory implements IAbstractFactory{

	@Override
	public Car getCar() {
		return new Bike();
	}

	@Override
	public IBreakFast getBreakFast() {
		return new Apple();
	}

}
