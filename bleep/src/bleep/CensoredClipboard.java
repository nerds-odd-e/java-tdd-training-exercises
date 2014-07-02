package bleep;

public class CensoredClipboard {
	private String content;
	private Zapper zapper = new Zapper();

	public void copy(String content) {
		this.content = zapper.zap(content);
	}

	public Object paste() {
		return this.content;
	}

	public void setForbiddenWord(String forbiddenWord) {
		zapper.setForbiddenWord(forbiddenWord);
		
	}

}
