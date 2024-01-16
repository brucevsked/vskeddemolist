package com.jat;

import static org.testng.Assert.assertEquals;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class ApplicationTest {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	@Test
	public void shouldAnswerWithTrue() {
		log.info("AppTest start");
		Application a = new Application();
		String nameString = a.hello("HelloWorld");
		assertEquals("HelloWorld", nameString);
		log.info("AppTest ena");
	}
	
}
