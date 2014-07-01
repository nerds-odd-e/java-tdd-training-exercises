package bleep;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class testBleepCensor {
	
	Bleep bleep = new Bleep();
	OSClipboard osClipboard = new OSClipboard();
	
	@Test
	public void testFrankAndFrankly() {
		
		osClipboard.SetToClipboard("frank is not frankly");
		bleep.filter("frank");
		assertEquals("f***k is not frankly", osClipboard.GetFromClipboard());
	}
	
	@Test
	public void testFrankAndQuoteFrank() {
		
		osClipboard.SetToClipboard("\"frank is not frankly");
		bleep.filter("frank");
		assertEquals("\"f***k is not frankly", osClipboard.GetFromClipboard());
	}
	
	@Test
	public void testFrankAndQuotedFrank() {
		
		osClipboard.SetToClipboard("\"frank\" is not frankly");
		bleep.filter("frank");
		assertEquals("\"f***k\" is not frankly", osClipboard.GetFromClipboard());
	}
	
	@Test
	public void testFrankAndLastFrank() {
		
		osClipboard.SetToClipboard("\"frank\" is not frank");
		bleep.filter("frank");
		assertEquals("\"f***k\" is not f***k", osClipboard.GetFromClipboard());
	}
	
	@Test
	public void testFrankAndLastCamelFrank() {
		
		osClipboard.SetToClipboard("\"frank\" is not Frank and that fRanK,");
		bleep.filter("frank");
		assertEquals("\"f***k\" is not F***k and that f***K,", osClipboard.GetFromClipboard());
	}
	
}
