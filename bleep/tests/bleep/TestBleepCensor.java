package bleep;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestBleepCensor {


	Clipboard clipboard = new MockClipboard();
	SentenceManipulation bleeper = new SentenceManipulation();
	Censor censor = new Censor(clipboard, bleeper);
	
	@Test
	public void frankShouldReturnCensoredWord() {
		clipboard.copy("Frank");
		bleeper.setCensoredText("frAnk");
		censor.censor();
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
		bleeper.setCensoredText(censoredText);
		censor.censor();
		String paste = clipboard.paste();
		return paste;
	}
	
	@Test
	public void quotedFrankShouldReturnQuoteF___k() {
		clipboard.copy("\"Frank");
		bleeper.setCensoredText("frAnk");
		censor.censor();
		assertEquals("\"F***k", clipboard.paste());
	}

	@Test
	public void quotlklmkkledFrankShouldReturnQuoteF___k() {
		clipboard.copy("Frank\"");
		bleeper.setCensoredText("frAnk");
		censor.censor();
		assertEquals("F***k\"", clipboard.paste());
	}
	
	//@Test
	public void brilliantNewLineJobShouldBeCensored() {
		clipboard.copy("brilliant \njob");
		bleeper.setCensoredText("brilliant \njob");
		censor.censor();
		assertEquals("b******* \n**b", clipboard.paste());
	}	
}
