package bleep;

public class StringFilter {
	


	public String getFilteredString(String sentence, String fobidden) {
		
		StringBuffer newSentence = new StringBuffer();
		String[] words = sentence.split(";| |_|\\.|\"|\'");
	
		for(String word : words) {
			newSentence.append(replaceCensoredWord(word, fobidden));		
		}
		
		return restore(sentence,removeLastChar(sentence, newSentence.toString()));
	}
	
	private String getMiddle(String word) {
		return word.substring(1, word.length()-1);
	}

	private String restore(String originalString, String filteredString) {
		
		String output = "";
		for(int i=0; i<filteredString.length(); i++) {
			if (filteredString.charAt(i) == '\u200C') {
				output += originalString.charAt(i);
			} else {
				output += filteredString.charAt(i);	
			}
		}
		
		return output;
	}

	

	private String removeLastChar(String sentence, String newSentence) {
		if (newSentence.length() != sentence.length()) {
			return newSentence.substring(0, newSentence.length()-1);
		}
		return newSentence;
	}

	private String replaceCensoredWord(String word, String forbidden) {
		String result = word;
		if(forbidden.equalsIgnoreCase(word)) {
			result = word.replaceAll("(?i)" + getMiddle(forbidden), getStars(forbidden));
		}
		return result+"\u200C";
	}

	private String getStars(String forbiden) {
		String output = "";
		for (int i=0; i<getMiddle(forbiden).length(); i++) output += '*';
		
		return output;
	}
}