package com.bank.ocr;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
 * This class reads in the text file and corrects the length of the scanned lines by adding any missing spaces to the end of lines.
 */

public class ScanReader {
	private String filePath;
	
	public ScanReader(String p) {
		filePath = p;
	}

	public String[][] readScan() throws IOException {
		FileReader file = new FileReader(filePath);
		BufferedReader lineReader = new BufferedReader(file);
		
		int numberOfLines = countLines();
		String[] scannedLines = new String[numberOfLines];
		
		for(int j = 0; j < numberOfLines; j++) {
			scannedLines[j] = lineReader.readLine();
			int lineLength = scannedLines[j].length();
			if (lineLength < 27) {
				for (int k = lineLength; k < 27; k++) {
					scannedLines[j] += " ";
				}
			}
		}
		
		lineReader.close();
		String[][] accountNumbers = parseAccountNumbers(scannedLines);
		
		return accountNumbers;
	}
	
	private int countLines() throws IOException {
		FileReader file = new FileReader(filePath);
		BufferedReader br = new BufferedReader(file);
		int numberOfLines = 0;
		String line;
		
		while ((line = br.readLine()) != null) {
			numberOfLines++;
		}
		
		br.close();
		return numberOfLines;
	}
	
	public String[][] parseAccountNumbers(String[] scan) {
		int numberOfAccounts = scan.length / 4;
		String[][] accountNumbers = new String[numberOfAccounts][3];

		int scanLocation = 0;
		
		for (int k = 0; k < scan.length; k+=4) {
			accountNumbers[scanLocation][0] = scan[k];
			accountNumbers[scanLocation][1] = scan[k+1];
			accountNumbers[scanLocation][2] = scan[k+2];
			scanLocation++;
		}
		
		return accountNumbers;
	}
}
