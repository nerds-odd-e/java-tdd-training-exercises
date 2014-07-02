package bleep;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ForbiddenWord {
	private String forbiddenWord;
	Pattern pattern = Pattern.compile("\\w+");

	public ForbiddenWord(String forbiddenWord2) {
		forbiddenWord = forbiddenWord2;
	}

	protected String replaceForbiddenWord(String content) {
		StringBuffer sb = new StringBuffer(content);
		Matcher matcher = pattern.matcher(content);
		while (matcher.find()) {
			if (matcher.group().equals(forbiddenWord)) {
				starize(sb, matcher.start());
			}
		}
		return sb.toString();
	}

	protected void starize(StringBuffer sb, int start) {
		for (int i = 1; i < forbiddenWord.length() - 1; i++)
			sb.setCharAt(start + i, '*');
	}
}