package bleep;


public class Bleep {
	OSClipboard osClipboard = new OSClipboard();
	public Censor cen = new Censor();
	
	private String split_token = " ";

	public String[] splitInput(String dataFromClipboard) {
		return dataFromClipboard.split(split_token);
	}

	public void filter(String stringToCensor) {
		
		String rawString = osClipboard.GetFromClipboard();
		String[] arrayString = this.splitInput(rawString);
		StringBuffer stBuff = new StringBuffer();
		
		boolean isFirst = true;
		for (String src : arrayString) {
			String result = cen.censor(stringToCensor, src);
			if (!isFirst) {
				stBuff.append(split_token);
			}
			stBuff.append(result);
			isFirst = false;
		}
		osClipboard.SetToClipboard(stBuff.toString());
	}

}
