package bleep;

import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordBlockReader implements Iterable<Integer>, Iterator<Integer> {

	@Override
	public Iterator<Integer> iterator() {
		return this;
	}

	public Pattern pattern = Pattern.compile("\\w+");
	public String cached = "";
	public int savedStart;
	public Matcher matcher;
	private String target;

	public WordBlockReader(String content, String word) {
		this.target = word;
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

	public boolean nextMatch(String word) {
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

	@Override
	public boolean hasNext() {
		return nextMatch(target);
	}

	@Override
	public Integer next() {
		return savedStart;
	}

	@Override
	public void remove() {
	}

}
