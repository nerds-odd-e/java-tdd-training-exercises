package bleep;

import static org.junit.Assert.*;

import org.junit.Test;

public class zapperTests {

	Zapper zapper = new Zapper();
	@Test
	public void shouldChangeForbiddenWord() {
		zapper.setForbiddenWord("cat");
		assertEquals("c*t", zapper.zap("cat"));
	}
	
	@Test
	public void shouldChangeLongerWord() throws Exception {
		zapper.setForbiddenWord("cost");
		assertEquals("c**t", zapper.zap("cost"));
	}

	@Test
	public void shouldChangeTheForbiddenWordWhenItsPartOfTheSentence() throws Exception {
		zapper.setForbiddenWord("bad");
		assertEquals("b*d ", zapper.zap("bad "));
	}
	
	@Test
	public void shouldChangeWordWhenItsLeadByNonwordChars() throws Exception {
		zapper.setForbiddenWord("bad");
		assertEquals("''b*d", zapper.zap("''bad"));
	}

	@Test
	public void shouldChangeWordWhenItsFolowedByNonwordChars() throws Exception {
		zapper.setForbiddenWord("bad");
		assertEquals("b*d'", zapper.zap("bad'"));
	}
	
	@Test
	public void shouldChangeMultipleWords() throws Exception {
		zapper.setForbiddenWord("bad");
		assertEquals("b*d b*d", zapper.zap("bad bad"));
	}
	
	@Test
	public void shouldNoChangeIfPartOfTheWordIsForbidden() throws Exception {
		zapper.setForbiddenWord("bad");
		assertEquals("badly", zapper.zap("badly"));
	}
	
}
