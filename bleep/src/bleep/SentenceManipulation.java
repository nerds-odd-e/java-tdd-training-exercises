package bleep;

import java.util.ArrayList;
import java.util.List;

public class SentenceManipulation {

	private static final String QUOTE = "\"";
	private String censoredText;
	private WordManipulator wordManipulator = new WordManipulator();

	public String censor(String sentence) {
		List<String> tokens = tokenize(sentence);
		return replace(tokens);
	}

	private List<String> tokenize(String sentence) {
		List<String> tokens = new ArrayList<String>();
		wordManipulator.setCensoredText(this.censoredText);
		boolean first = true;
		for (String word : sentence.split(" ")) {
			if (word.startsWith(QUOTE)) {
				tokens.add(QUOTE);
				word = wordManipulator.removeFirstCharacter(word);
			}
			String suffix = "";
			if (word.endsWith(QUOTE)) {
				suffix = QUOTE;
				word = wordManipulator.removeLastCharacter(word);
			}
			addSpaceIfNotFirst(tokens, first);
			first = false;
			tokens.add(word);
			tokens.add(suffix);
		}
		return tokens;
	}

	private void addSpaceIfNotFirst(List<String> tokens, boolean first) {
		if (!first ) {
			tokens.add(" ");
		}
	}

	private String replace(List<String> tokens) {
		String result = "";
		for (String token : tokens)
			result += wordManipulator.replaceWordIfCensored(token);
		return result;
	}

	public void setCensoredText(String censoredText) {
		this.censoredText = censoredText;
	}

}
