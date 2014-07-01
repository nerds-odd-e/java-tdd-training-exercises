package bleep;


public class Censor {

	private Clipboard clipboard;
	private SentenceManipulation bleeper;

	public Censor(Clipboard clipboard, SentenceManipulation bleeper) {
		this.clipboard = clipboard;
		this.bleeper = bleeper;
	}

	public void censor() {
		clipboard.copy(bleeper.censor(clipboard.paste()));
	}
}
