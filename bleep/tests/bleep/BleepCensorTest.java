package bleep;

import static org.junit.Assert.*;

import java.awt.HeadlessException;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

@SuppressWarnings("serial")
public class BleepCensorTest {
	Clipboard clipboard = new MockClipboard();
	CensorScanner censorScanner = new CensorScanner(clipboard);

	@Test
	public void clipboardHasNothingDoNothing() throws HeadlessException, UnsupportedFlavorException, IOException {
		clipboard.copy("");
		censorScanner.censor.setCensorStringList(new ArrayList<String>() {{add("Frank");}});
		censorScanner.censor();
		assertEquals("",clipboard.paste());
	}
	
	
	@Test
	public void clipboardHasFrankReturnFK() throws HeadlessException, UnsupportedFlavorException, IOException {
		clipboard.copy("Frank");
		censorScanner.censor.setCensorStringList(new ArrayList<String>() {{add("Frank");}});
		censorScanner.censor();
		assertEquals("F***k",clipboard.paste());
	}
	
	@Test
	public void frankFordShouldReturnFK() throws HeadlessException, UnsupportedFlavorException, IOException{
		
		clipboard.copy("Frank ford");
		censorScanner.censor.setCensorStringList(new ArrayList<String>() {{add("Frank");}});
		censorScanner.censor();
		assertEquals("F***k ford",clipboard.paste());
	}
	
	@Test
	public void toBeFrankShouldReturnFK() throws HeadlessException, UnsupportedFlavorException, IOException {
		clipboard.copy("to be frank");
		censorScanner.censor.setCensorStringList(new ArrayList<String>() {{add("frank");}});
		censorScanner.censor();
		assertEquals("to be f***k", clipboard.paste());
		
	}
	
	@Test
	public void badShouldReturnBD() throws HeadlessException, UnsupportedFlavorException, IOException {
		clipboard.copy("bad");
		censorScanner.censor.setCensorStringList(new ArrayList<String>() {{add("bad");}});
		censorScanner.censor();
		assertEquals("b*d", clipboard.paste());
	}
	

	public void dadShouldReturnbd() throws HeadlessException, UnsupportedFlavorException, IOException {
		clipboard.copy("bad");
		censorScanner.censor.setCensorStringList(new ArrayList<String>() {{add("Bad");}});
		censorScanner.censor();
		assertEquals("b*d", clipboard.paste());
	}

	
	
	
	
	
	
}
