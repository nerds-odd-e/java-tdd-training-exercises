package bleep;

import static org.junit.Assert.*;

import org.junit.Test;

public class CensorTest {
	Censor censor = new Censor();

	@Test
	public void testBlankString() {
		censor.setCensorStringList(new String[] {"Frank"});
		assertEquals("", censor.censor(""));
	}
	
	@Test
	public void testFrank() {
		censor.setCensorStringList(new String[] {"Frank"});
		assertEquals("F***k", censor.censor("Frank"));
	}
	
	@Test
	public void testFrankIgnoreCase() {
		censor.setCensorStringList(new String[] {"Frank"});
		assertEquals("F***k", censor.censor("frank"));
	}
	
	@Test
	public void testFrankWithFrankNotInList() {
		censor.setCensorStringList(new String[] {"Prank"});
		assertEquals("Frank", censor.censor("Frank"));
	}
	
	@Test
	public void testFrankly() {
		censor.setCensorStringList(new String[] {"Frank"});
		assertEquals("F***kly", censor.censor("Frankly"));
	}

	@Test
	public void testFrankWithQuotes() {
		censor.setCensorStringList(new String[] {"Frank"});
		assertEquals("\"F***k", censor.censor("\"Frank"));
	}

	@Test
	public void testFrankWithPeriod() {
		censor.setCensorStringList(new String[] {"Frank"});
		assertEquals("F***k.", censor.censor("Frank."));
	}
	
	@Test
	public void testToBeFrankWithQuotes() {
		censor.setCensorStringList(new String[] {"Frank"});
		assertEquals("To be F***k", censor.censor("To be Frank"));
	}
	
	@Test
	public void testToBeFrankWithSpecialCharacter() {
		censor.setCensorStringList(new String[] {"Frank"});
		assertEquals("F***k\n", censor.censor("Frank\n"));
	}
	
	@Test
	public void testToBeFrankWithTwoWordsAndQuotes() {
		censor.setCensorStringList(new String[] {"Frank"});
		assertEquals("\"F***k ford\"", censor.censor("\"Frank ford\""));
	}
	
	@Test
	public void testMultipleCensorWords() {
		censor.setCensorStringList(new String[] {"Frank", "seek"});
		assertEquals("F***k s**k", censor.censor("Frank seek"));
	}
	
	@Test
	public void testMultiwordCensor() {
		censor.setCensorStringList(new String[] {"brilliant job"});
		assertEquals("Mike b******** **b", censor.censor("Mike brilliant job"));
	}
	
	@Test
	public void testMultiwordCensorWithNewline() {
		censor.setCensorStringList(new String[] {"brilliant\njob"});
		assertEquals("Mike b********\n**b", censor.censor("Mike brilliant\njob"));
	}

	@Test
	public void testNounsAndVerbs() {
		censor.setCensorStringList(new String[] {"frank"});
		assertEquals("f***kked", censor.censor("frankked"));
	}
}
