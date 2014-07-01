package bleep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.RestoreAction;

public class BleepCensor {

	private Clipboard clipboard;
	
	private String spectialWord = "";
	
	public BleepCensor(Clipboard clipboard) {
		// TODO Auto-generated constructor stub
		this.clipboard = clipboard;
	}
	
	public void censor(String word) {
		List<String> filterWordList = censor2(word);
		spectialWord = word.substring(1, word.length()-1);
		String output = findAndReplaceFrank(clipboard.paste(), filterWordList);

		clipboard.copy(restore(output));
	}
	
	private String restore(String s) {
		
		String output = "";
		for(int i=0; i<s.length(); i++) {
			if (s.charAt(i) == '\u200C') {
				output += clipboard.paste().charAt(i);
			} else {
				output += s.charAt(i);	
			}
		}
		
		return output;
	}
	
	private String getStars() {
		String output = "";
		for (int i=0; i<spectialWord.length(); i++) output += '*';
		
		return output;
	}

	private List<String> censor2(String s) {
		List<String> replaceMap1 = new ArrayList<String>();
		replaceMap1.add(s.toLowerCase());
		replaceMap1.add("\""+ s.toLowerCase() +"\"");
		replaceMap1.add("'"+ s.toLowerCase() +"'");
		return replaceMap1 ;
	}

	private String findAndReplaceFrank(String sentence, List<String> filterWordList) {
		StringBuffer newSentence = new StringBuffer();
		String[] words = sentence.split(";| |_|\\.");
		
		
		for(int i =0; i <words.length; i++) {
			String word = words[i];
			ReplaceCensoredWord(filterWordList, newSentence, word);		
		}
		
		if (newSentence.length() != sentence.length()) {
			return newSentence.toString().substring(0, newSentence.toString().length()-1);
		}
		
		return newSentence.toString();
	}

	private void ReplaceCensoredWord(List<String> filterWordList,
		StringBuffer newSentence, String word) {
		
		
		if(filterWordList.contains(word.toLowerCase())) {
			newSentence.append(word.replaceAll("(?i)" + spectialWord, getStars()));
		} else{ 
			newSentence.append(word);
		}
		newSentence.append("\u200C");
	}

}
