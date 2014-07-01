package bleep;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestBleepCensor {


	Clipboard clipboard = new MockClipboard();
	Censor bleep = new Censor(clipboard);
	
	@Test
	public void frankShouldReturnCensoredWord() {
		clipboard.copy("Frank");
		bleep.setCensoredText("frAnk");
		bleep.censor();
		assertEquals("F***k", clipboard.paste());
	}
	
	@Test
	public void franklyshouldReturnFrankly() {
		assertEquals("Frankly", censorClipboard("Frankly", "frAnk"));
	}
	
	@Test
	public void frankFordshouldReturnF___KFord() {
		assertEquals("F***k Ford", censorClipboard("Frank Ford", "frAnk"));
	}

	private String censorClipboard(String contents, String censoredText) {
		clipboard.copy(contents);
		bleep.setCensoredText(censoredText);
		bleep.censor();
		String paste = clipboard.paste();
		return paste;
	}
	
	@Test
	public void quotedFrankShouldReturnQuoteF___k() {
		clipboard.copy("\"Frank");
		bleep.setCensoredText("frAnk");
		bleep.censor();
		assertEquals("\"F***k", clipboard.paste());
	}

	@Test
	public void quotlklmkkledFrankShouldReturnQuoteF___k() {
		clipboard.copy("Frank\"");
		bleep.setCensoredText("frAnk");
		bleep.censor();
		assertEquals("F***k\"", clipboard.paste());
	}
	
	//@Test
	public void brilliantJobShouldBeCensored() {
		clipboard.copy("brilliant job");
		bleep.setCensoredText("brilliant job");
		bleep.censor();
		assertEquals("b******* **b", clipboard.paste());
	}	
}
