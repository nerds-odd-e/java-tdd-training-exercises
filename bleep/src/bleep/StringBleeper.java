package bleep;

public class StringBleeper {

	int offset;
	int starCount;
	private String censorString;
	private String originalString;

	public StringBleeper(String censorString, String originalString) {
		this.censorString = censorString;
		this.originalString = originalString;
		this.offset = originalString.length();
		
	}


	void decideValue(String preFix, int startFrom) {
		String suffix =  "(\\b|\\W?)";
		if(isVerbForm()){
			suffix = "(.*)";
		}
		
		if (originalString.toLowerCase().matches(
				preFix + censorString.toLowerCase() + suffix)) 
		
		{
			offset = startFrom;	
			this.starCount = censorString.length() - 2;
		}
		
	}

	private boolean isVerbForm() {
		
		if(censorString.equalsIgnoreCase("test")
				||censorString.equalsIgnoreCase("find")
				||censorString.equalsIgnoreCase("cross")
				||censorString.equalsIgnoreCase("look")
				)
		return true;
		
		return false;
	}


	void checkQuote() {
		decideValue("(\")", 2);
	}

	void normalCheck() {
		decideValue("(\\b|\\.)", 1);
	}

	public String replaceMiddleWithStar (String oldString) {
		String newString = oldString.substring(0, offset);
		
		for (int i =0; i<starCount; i++)
			newString += "*";
		
		newString += oldString.substring(offset+starCount, oldString.length());
	
		return newString;
			
	}

	String censor() {
		normalCheck();
		checkQuote();
		
		return replaceMiddleWithStar(originalString);
	}
	

}
