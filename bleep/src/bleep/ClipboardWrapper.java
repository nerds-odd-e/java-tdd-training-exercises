package bleep;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class ClipboardWrapper implements ClipboardOwner {

	public void copy(String string) {
		StringSelection stringSelection = new StringSelection(string);
		Clipboard clipboard = getSystemClipboard();
		clipboard.setContents(stringSelection, this);
	}

	protected Clipboard getSystemClipboard() {
		return Toolkit.getDefaultToolkit().getSystemClipboard();
	}

	public String paste() throws UnsupportedFlavorException, IOException {
		String result = "";
		Clipboard clipboard = getSystemClipboard();
		Transferable contents = clipboard.getContents(null);
		result = (String) contents.getTransferData(DataFlavor.stringFlavor);
		return result;
	}

	@Override
	public void lostOwnership(Clipboard clipboard, Transferable contents) {

	}

}
