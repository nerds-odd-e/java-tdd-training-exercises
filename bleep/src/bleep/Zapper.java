package bleep;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Zapper {
	public ForbiddenWord forbiddenWord = new ForbiddenWord();
	Pattern pattern = Pattern.compile("\\w+");

	String zap(String content) {
		StringBuffer sb = new StringBuffer(content);
		Matcher matcher = pattern.matcher(content);
		while (matcher.find()) {
			sb.replace(matcher.start(), matcher.end(),
					forbiddenWord.censor(matcher.group()));
		}

		return sb.toString();
	}

	void setForbiddenWord(String forbiddenWord) {
		this.forbiddenWord = new ForbiddenWord(forbiddenWord);
	}
}