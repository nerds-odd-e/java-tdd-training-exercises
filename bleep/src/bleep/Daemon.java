package bleep;

public class Daemon {

	public static void main(String[] atgs) throws InterruptedException
	{
		
		Clipboard cb = new OSClipboard();
		BleepCensor censor = new BleepCensor(cb);
		
		while(true)
		{
			censor.censor("frank");
			Thread.sleep(1000);
		}	
	}
}
