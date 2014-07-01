package bleep;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Censor {
	private List<String> censorStringList = new ArrayList<String>();

	public String censor(String clipboardText) {
		String filtered = clipboardText;
		for (String censorVar:censorStringList) {
			String regexWithCensorString = "\\b" + censorVar + "\\b";
			
			Pattern p = Pattern.compile("(?i)("+regexWithCensorString+")");
		    Matcher m = p.matcher(filtered);
		    StringBuffer s = new StringBuffer();
		    while (m.find()){		
		        for (int i=0; i<m.groupCount(); i++) {
		        	filtered = filtered.replaceAll(m.group(i), getFilterStars(m.group(i)));
		        }
		        System.out.print(filtered);
		    }
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

	public void setCensorStringList(List<String> censoredString) {
		censorStringList = censoredString;
	}
}
