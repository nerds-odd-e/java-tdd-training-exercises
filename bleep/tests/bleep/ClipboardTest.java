package bleep;

import static org.junit.Assert.*;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import static org.mockito.Mockito.*;

public class ClipboardTest {
	final Clipboard sysClipboard = mock(Clipboard.class);
	ClipboardWrapper clipboard = new ClipboardWrapper() {
		@Override
		protected Clipboard getSystemClipboard() {
			return sysClipboard;
		}
	};

	@Test
	public void testClipboardCopy() throws UnsupportedFlavorException, IOException {
		clipboard.copy("abc");
		ArgumentCaptor<StringSelection> argument = ArgumentCaptor.forClass(StringSelection.class);
		verify(sysClipboard).setContents(argument.capture(), eq(clipboard));
		assertEquals("abc", argument.getValue().getTransferData(DataFlavor.stringFlavor));
	}

	@Test
	public void testClipboardPaste() throws UnsupportedFlavorException, IOException {
		Transferable content = mock(Transferable.class);
		when(sysClipboard.getContents(null)).thenReturn(content);
		when(content.getTransferData(DataFlavor.stringFlavor)).thenReturn("expected");
		assertEquals("expected", clipboard.paste());
	}

	@SuppressWarnings("unchecked")
	@Test(expected = UnsupportedFlavorException.class)
	public void testClipboardPasteError() throws UnsupportedFlavorException, IOException {
		when(sysClipboard.getContents(null)).thenThrow(UnsupportedFlavorException.class);
		clipboard.paste();
		fail();
	}

}
