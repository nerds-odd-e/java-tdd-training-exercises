package bleep;

public class Application {

	public static void main(String[] args) throws InterruptedException {
		if (args.length == 0)
			args = new String[] {"bad"};
		new CensoredClipboard(args, new ClipboardWrapper()).serve();
	}

}
