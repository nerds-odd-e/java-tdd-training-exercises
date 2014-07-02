package bleep;

public class ForbiddenWord {
	
	private String forbiddenWord;

	public ForbiddenWord(String forbiddenWord) {
		this.forbiddenWord = forbiddenWord;
	}

	public String replace(String content) {
		StringBuffer sb = new StringBuffer(content);
		WordBlockReader reader = new WordBlockReader(content);
		while (reader.nextMatch(forbiddenWord))
			starize(sb, reader.currentPosition());
		return sb.toString();
	}

	protected void starize(StringBuffer sb, int start) {
		for (int i = start + 1; i < start + forbiddenWord.length() - 1; i++)
			if (sb.charAt(i) != ' ' && sb.charAt(i) != '\n')
				sb.setCharAt(i, '*');
	}
	
}