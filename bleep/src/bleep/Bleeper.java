package bleep;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class Bleeper {

	String censoredText;

	public String censor(Censor censor, String sentence) {
		List<String> tokens = censor.bleeper.tokenize(sentence);
		return censor.bleeper.replace(censor, tokens);
	
	}

	List<String> tokenize(String sentence) {
		List<String> tokens = new ArrayList<String>();
		boolean first = true;
		for (String word : sentence.split(" ")) {
			if (word.startsWith("\"")) {
				tokens.add("\"");
				word = word.substring(1);
			}
			String suffix = "";
			if (word.endsWith("\"")) {
				suffix = "\"";
				word = word.substring(0, word.length() - 1);
			}
			if (!first ) {
				tokens.add(" ");
			}
			first = false;
			tokens.add(word);
			tokens.add(suffix);
		}
		return tokens;
	}

	String replace(Censor censor, List<String> tokens) {
		String result = "";
		for (String token : tokens)
			result += replaceCensoredWord(censor, token);
		return result;
	}

	String replaceCensoredWord(Censor censor, String source) {
		if (source.toLowerCase().equals(censor.bleeper.getSmallCaseForbiddenWord(censor, null))) {
			return StringUtils.replacePattern(source, "(?i)"
					+ censor.bleeper.getSmallCaseForbiddenWord(censor, null) + "",
					replaceForSmallCase(censor, source));
		}
	
		return source;
	}

	String replaceForSmallCase(Censor censor, String source) {
		String tmp = "";
		for (int i = 0; i < getCensorLength(censor) - 2; i++) {
			tmp += "*";
		}
		return source.replace(source.substring(1, source.length() - 1), tmp);
	}

	int getCensorLength(Censor censor) {
		return censor.censoredText.length();
	}

	String getSmallCaseForbiddenWord(Censor censor, String censoredText) {
		return censor.censoredText.toLowerCase();
	}

}
