package bleep;

import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class RealClipboard implements Clipboard {

	@Override
	public String paste() throws HeadlessException, UnsupportedFlavorException, IOException {
		String data = (String) Toolkit.getDefaultToolkit()
                .getSystemClipboard().getData(DataFlavor.stringFlavor);
		return data;
	}

	@Override
	public void copy(String copiedText) {
	    StringSelection stringSelection = new StringSelection(copiedText);
	    java.awt.datatransfer.Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	    clipboard.setContents(stringSelection, stringSelection);
	}

}
