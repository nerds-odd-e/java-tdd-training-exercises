package bleep;


public class Censorship {

	public static void main(String[] args) {
		Censor censor = new Censor(new ClipboardWrapper(), new SentenceManipulation());
		censor.censor();
	}

}
