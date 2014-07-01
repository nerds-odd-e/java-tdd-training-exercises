package bleep;

public class MockClipboard implements Clipboard {
	
	private String contents;

	@Override
	public String getContent() {
		return contents;
	}

	@Override
	public void copy(String contents) {
		this.contents = contents;
	}

}
