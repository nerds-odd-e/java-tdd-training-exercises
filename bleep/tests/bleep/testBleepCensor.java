package bleep;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class testBleepCensor {

	CensoredClipboard clipboard = new CensoredClipboard();
	@Test
	public void shouldNotChangeClipboardContentIfNoForbiddenWord() {
		clipboard.copy("good");
		assertEquals("good", clipboard.paste());
	}
	
	@Test
	public void shouldChangeClipboardWhenContainsForbiddenWord() {
		clipboard.setForbiddenWord("bad");
		clipboard.copy("bad");
		assertEquals("b*d", clipboard.paste());
	}

}
