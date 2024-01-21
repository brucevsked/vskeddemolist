package com.jat.auth.template2;

import static org.testng.Assert.assertEquals;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

	private static final Logger log = LoggerFactory.getLogger(App.class);

	@Test
	public void shouldAnswerWithTrue() {
		log.info("AppTest start");
		App a = new App();
		String nameString = a.hello("HelloWorld");
		assertEquals("HelloWorld", nameString);
		log.info("AppTest ena");
	}
	
}
