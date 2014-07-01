package fizzbuzz;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FizzBuzzTest {
	
	@Before
	public void setUp() throws Exception {
		// will run before each test
	}

	@After
	public void tearDown() throws Exception {
		// will run after each test.
		// even when the test fails.
	}

	@Test
	public void test() {
		assertEquals(1, 2);
	}
	

	

}
