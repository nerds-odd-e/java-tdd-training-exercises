package bleep;

import org.apache.commons.lang3.StringUtils;

public class WordManipulator {

	private static final int FIRST_CHARACTER = 1;
	private String censoredText;

	public WordManipulator() {
	}

	String removeLastCharacter(String word) {
		return word.substring(0, word.length() - 1);
	}

	String removeFirstCharacter(String word) {
		return word.substring(FIRST_CHARACTER);
	}

	private String replaceWithStars(String word) {
		String tmp = generateStarsBasedOnCountedCharacters();
		return replaceEverythingBetweenFirstAndLastCharacter(word, tmp);
	}

	private String replaceEverythingBetweenFirstAndLastCharacter(String source,
			String tmp) {
		return source.replace(source.substring(1, source.length() - 1), tmp);
	}

	private String generateStarsBasedOnCountedCharacters() {
		String tmp = "";
		for (int i = 0; i < this.censoredText.length() - 2; i++) {
			tmp += "*";
		}
		return tmp;
	}

	public void setCensoredText(String censoredText) {
		this.censoredText = censoredText;
	}

	String replaceWordIfCensored(String word) {
		if (StringUtils.equalsIgnoreCase(word, censoredText)) {
			return replaceWithStars(word);
		}
	
		return word;
	}

}
