package bleep;

import static org.junit.Assert.*;

import org.junit.Test;

public class zapperTests {

	Zapper zapper = new Zapper();
	@Test
	public void shouldChangeForbiddenWord() {
		zapper.addForbiddenWord("cat");
		assertEquals("c*t", zapper.zap("cat"));
	}
	
	@Test
	public void shouldChangeLongerWord() throws Exception {
		zapper.addForbiddenWord("cost");
		assertEquals("c**t", zapper.zap("cost"));
	}

	@Test
	public void shouldChangeWordWhenItsLeadByNonwordChars() throws Exception {
		zapper.addForbiddenWord("bad");
		assertEquals("''b*d", zapper.zap("''bad"));
	}

	@Test
	public void shouldChangeWordWhenItsFolowedByNonwordChars() throws Exception {
		zapper.addForbiddenWord("bad");
		assertEquals("b*d'", zapper.zap("bad'"));
	}
	
	@Test
	public void shouldChangeMultipleWords() throws Exception {
		zapper.addForbiddenWord("bad");
		assertEquals("b*d b*d", zapper.zap("bad bad"));
	}
	
	@Test
	public void shouldNoChangeIfPartOfTheWordIsForbidden() throws Exception {
		zapper.addForbiddenWord("bad");
		assertEquals("badly", zapper.zap("badly"));
	}

	@Test
	public void shouldChangeAllWhenMultipleCensorWords() throws Exception {
		zapper.addForbiddenWord("bad");
		zapper.addForbiddenWord("cat");
		assertEquals("b*d c*t", zapper.zap("bad cat"));
	}
		
}
