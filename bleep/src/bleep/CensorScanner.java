package bleep;

import java.awt.HeadlessException;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class CensorScanner {
	private Clipboard clipboard;
	public Censor censor;

	public CensorScanner(Clipboard clipboard) {
		this.clipboard = clipboard;
		this.censor = new Censor();
	}
	
	public void censor()
	{
		try {
			clipboard.copy(censor.censor(clipboard.paste()));
		} catch (HeadlessException e) {
			e.printStackTrace();
		} catch (UnsupportedFlavorException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
