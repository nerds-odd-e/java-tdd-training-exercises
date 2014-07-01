package bleep;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class testCensorTest {

	//String censor(String censorString, String originalString) {

	//Censor censor = new Censor();
	@Test
	public void test() {
		assertEquals("f***k", new StringBleeper("frank", "frank").censor());
	}
	
	
	@Test
	public void TestBleep() {
		assertEquals("b***p", new StringBleeper("bleep","bleep").censor());
	}
	
	@Test
	public void TestQuoteBleep() {
		
		assertEquals("\"b***p\"", new StringBleeper("bleep","\"bleep\"").censor());
	}
	
	@Test
	public void TestFilterFrankly() {
		
		assertEquals("frankly",new StringBleeper("frank", "frankly").censor());
	}

	@Test
	public void TestFilterSeeking() {
		
		assertEquals("seeking", new StringBleeper("seek", "seeking").censor());
	}
	
	@Test
	public void TestFilterSaekingVerb() {
		
		assertEquals("s**kes", new StringBleeper("saek", "saekes").censor());
	}         
	
	@Test 
	public void TestFilterFrankWithQuotesIsCensored() {
		assertEquals("\"F***k\"", new StringBleeper("Frank","\"Frank\"").censor());
		
	}
	
	@Test 
	public void TestFilterFrankWithQuotesIsCensoredUpper() {
		assertEquals("\"F***k\"", new StringBleeper("frank","\"Frank\"").censor());
		
	}
	
	@Test 
	public void TestFilterFrankWithQuotesIsCensoredLower() {
		assertEquals("\"f***k\"", new StringBleeper("Frank","\"frank\"").censor());
		
	}
	
	@Test 
	public void TestFilterFrankWithQuotesIsCensoredLUCameral() {
		assertEquals("\"f***K\"", new StringBleeper("Frank","\"fRanK\"").censor());
		
	}
	
	@Test 
	public void TestFilterFrankWithQuotesIsCensoredULCameral() {
		assertEquals("\"f***K\"", new StringBleeper("frank","\"frAnK\"").censor());
		
	}
	
	@Test 
	public void TestFilterFrankWithMoreQuotesIsCensored() {
		
		assertEquals("\"Frank,?????\"", new StringBleeper("Frank", "\"Frank,?????\"").censor());
		
	}

}
