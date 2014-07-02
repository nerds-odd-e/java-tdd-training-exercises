package bleep;

public class ForbiddenWord {
	public String forbiddenWord;

	public ForbiddenWord() {
	}

	public ForbiddenWord(String forbiddenWord2) {
		forbiddenWord = forbiddenWord2;
	}

	String censorWord() {
		StringBuffer sBuffer = new StringBuffer(forbiddenWord);
		sBuffer.replace(1, forbiddenWord.length() - 1, getStars(forbiddenWord));
		return sBuffer.toString();
	}

	String getStars(String content) {
		String star = "";
		for (int i = 0; i < content.length() - 2; i++)
			star += "*";
		return star;
	}

	boolean isForbidden(String word) {
		return word.equals(forbiddenWord);
	}

	String censor(String word) {
		if (isForbidden(word)) {
			word  = censorWord();
		}
		return word;
	}
}