package com.vsked.test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

public class TestR {

	/**
	 * @param args
	 * @throws AWTException 
	 */
	public static void main(String[] args) throws AWTException {
		Robot r=new Robot();
		r.mouseMove(500, 500);
		r.mousePress(InputEvent.BUTTON1_MASK);
		r.mouseMove(100, 200);
		r.mouseRelease(InputEvent.BUTTON1_MASK);
	}

}
