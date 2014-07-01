package bleep;


public class Bleep {
	
	
	public static void main(String[] args){
		
		Bleep b = new Bleep();
		
		
		while(true){
			try {
				Thread.sleep(1000);
				
				b.filter("test");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	OSClipboard osClipboard = new OSClipboard();
	
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
			String result = new StringBleeper(stringToCensor, src).censor();
			
			if (!isFirst) {
				stBuff.append(split_token);
			}
			stBuff.append(result);
			isFirst = false;
		}
		osClipboard.SetToClipboard(stBuff.toString());
	}

}
