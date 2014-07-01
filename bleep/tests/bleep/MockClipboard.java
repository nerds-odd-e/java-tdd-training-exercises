package bleep;

public class MockClipboard implements Clipboard{

	private String copiedText;

	/* (non-Javadoc)
	 * @see bleep.Clipboard#paste()
	 */
	@Override
	public String paste() {
		if (copiedText == null) {
			return "";
		}
		return copiedText;
	}

	/* (non-Javadoc)
	 * @see bleep.Clipboard#copy(java.lang.String)
	 */
	@Override
	public void copy(String copiedText) {
		this.copiedText = copiedText;
	}

}
