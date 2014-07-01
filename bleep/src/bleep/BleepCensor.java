package bleep;


public class BleepCensor {

	StringFilter filter;
	public Clipboard clipboard;
	public BleepCensor(Clipboard clipboard) {
		this.clipboard = clipboard;
		 filter = new StringFilter();
	}
	
	public void censor(String forbiddenWord) {
		String input = clipboard.getContent();
		String output = filter.getFilteredString(input, forbiddenWord);
		clipboard.copy(output);
	}
}
