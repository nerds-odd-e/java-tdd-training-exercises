package bleep;

import java.util.ArrayList;
import java.util.List;

public class Zapper {
	private List<ForbiddenWord> forbiddenWordList = new ArrayList<ForbiddenWord>();

	String zap(String content) {
		for (ForbiddenWord forbiddenWord : forbiddenWordList) 
			content = forbiddenWord.replaceForbiddenWord(content);
		return content;
	}

	void addForbiddenWord(String forbiddenWord) {
		forbiddenWordList.add(new ForbiddenWord(forbiddenWord));
	}
}