package bleep;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class testBleepCensor {
	ClipboardWrapper clipboard = mock(ClipboardWrapper.class);
	String[] badWords = {"bad"};
	CensoredClipboard app = new CensoredClipboard(badWords, clipboard);
	
	@Test
	public void shouldNotChangeClipboardContentIfNoForbiddenWord() throws UnsupportedFlavorException, IOException {
		when(clipboard.paste()).thenReturn("good");
		app.censor();
		verify(clipboard).copy("good");
	}
	
	@Test
	public void shouldChangeClipboardWhenContainsForbiddenWord() throws UnsupportedFlavorException, IOException {
		when(clipboard.paste()).thenReturn("bad");
		app.censor();
		verify(clipboard).copy("b*d");
	}

	@SuppressWarnings("unchecked")
	@Test
	public void shouldNotChangeClipboardWhenGettingContentFails() throws UnsupportedFlavorException, IOException {
		when(clipboard.paste()).thenThrow(UnsupportedFlavorException.class);
		app.censor();
		verify(clipboard, never()).copy(anyString());
	}
	
	@Test(expected = InterruptedException.class)
	public void serviceShouldWatchTheClipboardUntilInterupted() throws UnsupportedFlavorException, IOException, InterruptedException {
		CensoredClipboard app = new CensoredClipboard(badWords, clipboard){
			int counter = 5;
			@Override
			public void sleep() throws InterruptedException {
				if(counter-- == 0)
					throw new InterruptedException();
			}
		};
		when(clipboard.paste()).thenReturn("");
		app.serve();
	}		
}
