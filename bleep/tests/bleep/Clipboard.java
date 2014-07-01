package bleep;

import java.awt.HeadlessException;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public interface Clipboard {

	public abstract String paste() throws HeadlessException, UnsupportedFlavorException, IOException;

	public abstract void copy(String copiedText);

}