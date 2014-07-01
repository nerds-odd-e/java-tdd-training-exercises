package bleep;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Censor {
	private List<String> censorStringList = new ArrayList<String>();

	public String censor(String clipboardText) {
		String filtered = clipboardText;
		for (String censorVar:censorStringList) {
			String regexWithCensorString = "\\b" + censorVar + "\\b";
//			String regexWithCensorString = censorVar;
			filtered = filtered.replaceAll("(?i)" + regexWithCensorString, getFilterStars(censorVar));
		}
		return filtered;
	}

	public String getFilterStars(String censorVar) {
		String stars = censorVar.substring(0, 1);
		for(int i = 1;i<censorVar.length() -1;i++)
		{
			if (censorVar.charAt(i) == ' ' || censorVar.charAt(i) == '\n' )
				stars += censorVar.charAt(i);
			else
				stars += "*";
		}
		
		return stars + censorVar.substring(censorVar.length() - 1);
	}

	public void setCensorStringList(String[] censoredString) {
		Collections.addAll(censorStringList, censoredString);
	}
}
