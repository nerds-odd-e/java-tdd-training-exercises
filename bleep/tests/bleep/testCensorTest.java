package bleep;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class testCensorTest {

	
	Censor censor = new Censor();
	@Test
	public void test() {
		assertEquals("f***k", censor.censor("frank", "frank"));
	}
	
	
	@Test
	public void TestBleep() {
		assertEquals("b***p", censor.censor("bleep","bleep"));
	}
	
	@Test
	public void TestQuoteBleep() {
		assertEquals("\"b***p\"", censor.censor("bleep","\"bleep\""));
	}
	
	@Test
	public void TestFilterFrankly() {
		
		assertEquals("frankly",censor.censor("frank", "frankly"));
	}

	@Test
	public void TestFilterSeeking() {
		
		assertEquals("seeking", censor.censor("seek", "seeking"));
	}
	
	@Test 
	public void TestFilterFrankWithQuotesIsCensored() {
		assertEquals("\"F***k\"", censor.censor("Frank","\"Frank\""));
		
	}
	
	@Test 
	public void TestFilterFrankWithQuotesIsCensoredUpper() {
		assertEquals("\"F***k\"", censor.censor("frank","\"Frank\""));
		
	}
	
	@Test 
	public void TestFilterFrankWithQuotesIsCensoredLower() {
		assertEquals("\"f***k\"", censor.censor("Frank","\"frank\""));
		
	}
	
	@Test 
	public void TestFilterFrankWithQuotesIsCensoredLUCameral() {
		assertEquals("\"f***K\"", censor.censor("Frank","\"fRanK\""));
		
	}
	
	@Test 
	public void TestFilterFrankWithQuotesIsCensoredULCameral() {
		assertEquals("\"f***K\"", censor.censor("frank","\"frAnK\""));
		
	}
	
	@Test 
	public void TestFilterFrankWithMoreQuotesIsCensored() {
		
		assertEquals("\"Frank,?????\"", censor.censor("Frank", "\"Frank,?????\""));
		
	}

}
