package bleep;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		String censorStringList;
		Scanner scanner = new Scanner(System.in);
		censorStringList = scanner.nextLine();
		MockClipboard mockClipboard = new MockClipboard();
		scanner.close();
	}
}
