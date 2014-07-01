package bleep;

public class MockClipboard implements Clipboard {

	private String copiedText;

	public String paste() {
		if (copiedText == null) {
			return "";
		}
		return copiedText;
	}

	public void copy(String copiedText) {
		//os.clipboard.copy()
		this.copiedText = copiedText;
	}

}
