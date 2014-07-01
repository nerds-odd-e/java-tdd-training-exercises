package bleep;

public class Censor {

	String censor(String stringToCensor, String dataFromClipboard) {
		int offset = dataFromClipboard.length();
		int starCount = 0;
		
		if(dataFromClipboard.toLowerCase().matches("(\\b|\\.)" + stringToCensor.toLowerCase() + "(\\b|\\W?)")) {
		 offset = 1;
		 starCount = stringToCensor.length()-2;
		}
	
		if(dataFromClipboard.toLowerCase().matches("(\")" + stringToCensor.toLowerCase() +"(\\b|\\W?)")) {
			 offset = 2;
			 starCount = stringToCensor.length()-2;
		}
		
		String newString = replaceMiddleWithStar(offset,starCount,dataFromClipboard);
		dataFromClipboard = dataFromClipboard.replace(dataFromClipboard, newString);
		return dataFromClipboard;
	}

	public String replaceMiddleWithStar (int offset, int starCount, String oldString) {
		String newString = oldString.substring(0, offset);
		
		for (int i =0; i<starCount; i++)
			newString += "*";
		
		newString += oldString.substring(offset+starCount, oldString.length());
	
		return newString;
			
	}

}
