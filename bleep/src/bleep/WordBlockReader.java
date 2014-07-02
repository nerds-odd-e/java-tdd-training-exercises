package bleep;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordBlockReader {
	public Pattern pattern = Pattern.compile("\\w+");
	public String cached = "";
	public int savedStart;
	public Matcher matcher;

	public WordBlockReader(String content) {
		matcher = pattern.matcher(content);
	}

	private boolean nextBlock() {
		if (!matcher.find())
			return false;
		if (cached.isEmpty()) {
			cached = matcher.group();
			savedStart = matcher.start();
		} else {
			cached += " " + matcher.group();
		}
	
		return true;
	}

	protected boolean nextMatch(String word) {
		while (nextBlock()) {
			if (!word.startsWith(cached))
				cached = "";
			if (cached.equals(word)) {
				cached = "";
				return true;
			}
		}
		return false;
	}

	public int currentPosition() {
		return savedStart;
	}
}