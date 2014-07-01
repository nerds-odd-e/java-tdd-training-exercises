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
		assertEquals(1, 1);
	}
	
	@Test
	public void testThree()
	{
		FizzBuzz fizzBuzz = new FizzBuzz();
		assertEquals(fizzBuzz.check(3),"Fizz");
	}
	
	@Test
	public void testFive() {
		FizzBuzz fizzBuzz = new FizzBuzz();
		assertEquals(fizzBuzz.check(5), "Buzz");
	}
	
	@Test
	public void oneShouldReturnOne() {
		FizzBuzz fizzBuzz = new FizzBuzz();
		assertEquals(fizzBuzz.check(1), "1");
	}
	
	public void timesOfThreeReturnFizz(){
		FizzBuzz fizzBuzz = new FizzBuzz();
		
		assertEquals(fizzBuzz.check(timesThreegenertor()), "Fizz");
	}
	
   private int timesThreegenertor(){
	   return 15;
   }
}