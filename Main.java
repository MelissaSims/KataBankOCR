package com.bank.ocr;

import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Main {

	public static void main(String[] args) throws IOException {		
		String scanFilePath = "C:/Users/Melissa/documents/scan.txt";
		String accountListFilePath = "C:/Users/Melissa/documents/account list.txt";
		
		try {
			ScanReader file = new ScanReader(scanFilePath);
			String[][] accountNumbers = file.readScan();
			Writer accountList = new Writer(accountListFilePath, false);
			
			for (int j = 0; j < accountNumbers.length; j++) {
				AccountNumber a = new AccountNumber(accountNumbers[j][0], accountNumbers[j][1], accountNumbers[j][2]);
				accountList.writeToFile(a.getAccountNumber());
				accountList = new Writer(accountListFilePath, true);
			}
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
