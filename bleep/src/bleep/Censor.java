package bleep;


public class Censor {

	private Clipboard clipboard;
	Bleeper bleeper = new Bleeper();

	public Censor(Clipboard clipboard) {
		this.clipboard = clipboard;
	}

	public void censor() {

		clipboard.copy(bleeper.censor(this, clipboard.paste()));
	}

	public void setCensoredText(String censoredText) {
		this.censoredText = censoredText;
	}
}
