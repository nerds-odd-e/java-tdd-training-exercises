package bleep;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class CensoredClipboard {
	private Zapper zapper = new Zapper();
	private ClipboardWrapper clipboard;

	public CensoredClipboard(String[] badWords, ClipboardWrapper clipboard) {
		for(String word : badWords)
			zapper.addForbiddenWord(word);
		this.clipboard = clipboard;
	}

	public void censor() {
		try {
			clipboard.copy(zapper.zap(clipboard.paste()));
		} catch (UnsupportedFlavorException e) {
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void serve() throws InterruptedException {
		while (true) {
			censor();
			sleep();
		}
	}

	public void sleep() throws InterruptedException {
		Thread.sleep(1000);
	}
}
