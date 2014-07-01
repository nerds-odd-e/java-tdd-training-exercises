package bleep;

import static org.junit.Assert.*;

import org.junit.Test;

public class BleepCensorTest {
	MockClipboard clipboard = new MockClipboard();
	CensorScanner censorScanner = new CensorScanner(clipboard);

	@Test
	public void clipboardHasNothingDoNothing() {
		clipboard.copy("");
		censorScanner.censor.setCensorStringList(new String[] {"Frank"});
		censorScanner.censor();
		assertEquals("",clipboard.paste());
	}
	
	
	@Test
	public void clipboardHasFrankReturnFK() {
		clipboard.copy("Frank");
		censorScanner.censor.setCensorStringList(new String[] {"Frank"});
		censorScanner.censor();
		assertEquals("F***k",clipboard.paste());
	}
	
	@Test
	public void frankFordShouldReturnFK(){
		
		clipboard.copy("Frank ford");
		censorScanner.censor.setCensorStringList(new String[] {"Frank"});
		censorScanner.censor();
		assertEquals("F***k ford",clipboard.paste());
	}
	
	@Test
	public void toBeFrankShouldReturnFK() {
		clipboard.copy("to be frank");
		censorScanner.censor.setCensorStringList(new String[] {"frank"});
		censorScanner.censor();
		assertEquals("to be f***k", clipboard.paste());
		
	}
	
	@Test
	public void badShouldReturnBD() {
		clipboard.copy("bad");
		censorScanner.censor.setCensorStringList(new String[] {"bad"});
		censorScanner.censor();
		assertEquals("b*d", clipboard.paste());
	}
	

	public void dadShouldReturnbd() {
		clipboard.copy("bad");
		censorScanner.censor.setCensorStringList(new String[] {"Bad"});
		censorScanner.censor();
		assertEquals("b*d", clipboard.paste());
	}

	
	
	
	
	
	
}
