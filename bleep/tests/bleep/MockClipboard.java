package bleep;

public class MockClipboard implements Clipboard {
	
	private String contents;

	@Override
	public String paste() {
		return contents;
	}

	@Override
	public void copy(String contents) {
		this.contents = contents;
	}

}
