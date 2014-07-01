package bleep;

import java.awt.HeadlessException;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class App {

	public static void main(String[] args) throws HeadlessException, UnsupportedFlavorException, IOException {
		List<String> censorStringList;
		System.out.println("Enter a comma separated list of censor words: ");
		Scanner scanner = new Scanner(System.in);
		censorStringList = Arrays.asList(scanner.nextLine().split(","));
		scanner.close();
		Clipboard realClipboard = new RealClipboard();
		CensorScanner censorScanner = new CensorScanner(realClipboard);
		censorScanner.censor.setCensorStringList(censorStringList);
		censorScanner.censor();
		System.out.println("Result: " + realClipboard.paste());
	}
}
