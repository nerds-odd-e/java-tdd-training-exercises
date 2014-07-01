package bleep;

import static org.junit.Assert.*;

import org.junit.Test;

public class testBleepCensor {

	Clipboard clipboard = new MockClipboard();
	BleepCensor bleep = new BleepCensor(clipboard);
	
	@Test
	public void frankShouldBeCensored(){
		clipboard.copy("frank");
		bleep.censor("frank");	
		assertEquals("f***k", clipboard.getContent());
	}

	@Test
	public void franklyGivesSameWord() {
		clipboard.copy("frankly");
		bleep.censor("frank");
		assertEquals("frankly", clipboard.getContent());
	}

	@Test
	public void nonFrankinSentenceShouldNotBeCensored() {
		clipboard.copy("Fk ford");
		bleep.censor("frank");
		assertEquals("Fk ford", clipboard.getContent());
	}
	
	@Test
	public void frankinSentenceShouldBeCensored() {
		clipboard.copy("Frank ford");
		bleep.censor("frank");
		assertEquals("F***k ford", clipboard.getContent());
	}
	
	@Test
	public void frankInQuotesShouldBeCensored() {
		clipboard.copy("\"Frank\"");
		bleep.censor("frank");
		assertEquals("\"F***k\"", clipboard.getContent());
	}
	
	@Test
	public void frankInSingleQuotesShouldBeCensored() {
		clipboard.copy("'Frank'");
		bleep.censor("frank");
		assertEquals("'F***k'", clipboard.getContent());
	}
	

	@Test
	public void frankAsLastWordShouldBeCensored() {
		clipboard.copy("Hello Frank");
		bleep.censor("frank");
		assertEquals("Hello F***k", clipboard.getContent());
	}

	@Test
	public void fRAnkShouldBeCensored() {
		clipboard.copy("fRAnk");
		bleep.censor("Frank");
		assertEquals("f***k", clipboard.getContent());
	}
	
	@Test
	public void birdShouldBeCensored() {
		clipboard.copy("bird");
		bleep.censor("bird");
		assertEquals("b**d", clipboard.getContent());
	}
	
	@Test
	public void airdShouldBeNotCensored() {
		clipboard.copy("aird");
		bleep.censor("bird");
		assertEquals("aird", clipboard.getContent());
	}
	
	@Test
	public void simiColonSeparatorShouldBeCensored() {
		clipboard.copy("bird;bird");
		bleep.censor("bird");
		assertEquals("b**d;b**d", clipboard.getContent());
	}
	
	@Test
	public void simiColonAndSpaceSeparatorShouldBeCensored() {
		clipboard.copy("bird;bird bird");
		bleep.censor("bird");
		assertEquals("b**d;b**d b**d", clipboard.getContent());
	}
	
	@Test
	public void multiSimiColonAndSpaceSeparatorShouldBeCensored() {
		clipboard.copy("bird;;bird _bird");
		bleep.censor("bird");
		assertEquals("b**d;;b**d _b**d", clipboard.getContent());
	}
	
	@Test
	public void fullStopSeparatorShouldBeCensored() {
		clipboard.copy("bird;;bird _bird.bird");
		bleep.censor("bird");
		assertEquals("b**d;;b**d _b**d.b**d", clipboard.getContent());
	}
	
	@Test
	public void semiColonAtEndSeparatorShouldNotBeCensored() {
		clipboard.copy("dog;");
		bleep.censor("bird");
		assertEquals("dog;", clipboard.getContent());
	}
	
	@Test
	public void semiColonAtBeginSeparatorShouldBeCensored() {
		clipboard.copy(";dog");
		bleep.censor("dog");
		assertEquals(";d*g", clipboard.getContent());
	}
	
	@Test
	public void oneQuoteShouldBeCensored() {
		clipboard.copy("\";dog");
		bleep.censor("dog");
		assertEquals("\";d*g", clipboard.getContent());
	}
}

