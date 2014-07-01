package bleep;

public class CensorScanner {
	private Clipboard clipboard;
	public Censor censor;
	public CensorScanner(Clipboard clipboard) {
		this.clipboard = clipboard;
		this.censor = new Censor();
	}
	
	public void censor()
	{
		clipboard.copy(censor.censor(clipboard.paste()));
	}
}
