package bleep;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestClipboardWrapper {
	
	@Test
	public void whenCopyTextPasteShouldReturnText() {
		Clipboard clipboardWrapper = new ClipboardWrapper();
		String copiedText = "Frank";
		clipboardWrapper.copy(copiedText);
		assertEquals(copiedText , clipboardWrapper.paste());
	}
}
