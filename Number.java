package com.bank.ocr;

/*
 * This class will take in numbers as broken down by the AccountNumber class and translate them into valid digits.
 */

public class Number {
	private String numberAsLines;
	private String numberAsString;
	private boolean wasNotARealNumber = false;

	public Number(String s) {
		this.numberAsLines = s;
	}
	
	private static String stringZero = 
			" _ " +
			"| |" +
			"|_|";
	
	private static String stringOne =
			"   " +
			"  |" +
			"  |";
	
	private static String stringTwo =
			" _ " +
			" _|" +
			"|_ ";
				
	private static String stringThree =
			" _ " +
			" _|" +
			" _|";
	
	private static String stringFour =
			"   " +
			"|_|" +
			"  |";
	
	private static String stringFive =
			" _ " +
			"|_ " +
			" _|";
	
	private static String stringSix =
			" _ " +
			"|_ " +
			"|_|";
	
	private static String stringSeven =
			" _ " +
			"  |" +
			"  |";
	
	private static String stringEight =
			" _ " +
			"|_|" +
			"|_|";
	
	private static String stringNine =
			" _ " +
			"|_|" +
			" _|";
	
	public String toString() {
		numberAsString = newNumberToString(numberAsLines);
		
		if (numberAsString == "?") {
			numberAsString = makeARealNumber(numberAsLines);
			this.wasNotARealNumber = true;
		}
		
		return numberAsString;
	}
	
	public String newNumberToString(String t) {
		String tempSNumber = "?";
		
		if (t.equals(stringZero)) {
			tempSNumber = "0";
		} else if (t.equals(stringOne)) {
			tempSNumber = "1";
		} else if (t.equals(stringTwo)) {
			tempSNumber = "2";
		} else if (t.equals(stringThree)) {
			tempSNumber = "3";
		} else if (t.equals(stringFour)) {
			tempSNumber = "4";
		} else if (t.equals(stringFive)) {
			tempSNumber = "5";
		} else if (t.equals(stringSix)) {
			tempSNumber = "6";
		} else if (t.equals(stringSeven)) {
			tempSNumber = "7";
		} else if (t.equals(stringEight)) {
			tempSNumber = "8";
		} else if (t.equals(stringNine)) {
			tempSNumber = "9";
		}
		
		return tempSNumber;
	}
	
	public String makeARealNumber(String newNumber) {
		char[] charScan = new char[9];
		charScan = newNumber.toCharArray();
		
		for (int m = 0; m < 9; m++) {
			char originalChar = charScan[m];
			if (m == 0 || m == 2) {
				if (charScan[m] != ' ') {
					charScan[m] = ' ';
				}
			} else if (m == 1 || m == 4 || m == 7) {
				if (charScan[m] != '_') {
					charScan[m] = '_';
				} else if (charScan[m] != ' ') {
					charScan[m] = ' ';
				}
			} else if (m == 3 || m == 5 || m == 6 || m == 8) {
				if (charScan[m] != '|') {
					charScan[m] = '|';
				} else if (charScan[m] != ' ') {
					charScan[m] = ' ';
				}
			}
			
			if (stringCharArray(charScan) != "?") {
				break;
			} else {
				charScan[m] = originalChar;
			}
		}
		
		if (stringCharArray(charScan) != "?") {
			newNumber = stringCharArray(charScan);
			return newNumber;
		} else {
			return numberAsString;
		}
	}
	
	private String stringCharArray(char[] charScan) {
		String newNumber = "";
		for (int i = 0; i < charScan.length; i++) {
			newNumber += charScan[i];
		}
		newNumber = newNumberToString(newNumber);
		return newNumber;
	}
	
	public String changeNumber(int positionOfChange) {
		String newNumber = "";
		char[] charScan = new char[9];
		charScan = numberAsLines.toCharArray();
		String oldNumber = toString();
		char originalChar = charScan[positionOfChange];
		
		if (positionOfChange == 1 || positionOfChange == 4 || positionOfChange == 7) {
			if (charScan[positionOfChange] != '_') {
				charScan[positionOfChange] = '_';
			} else if (charScan[positionOfChange] != ' ') {
				charScan[positionOfChange] = ' ';
			}
		} else if (positionOfChange == 3 || positionOfChange == 5 || positionOfChange == 6 || positionOfChange == 8) {
			if (charScan[positionOfChange] != '|') {
				charScan[positionOfChange] = '|';
			} else if (charScan[positionOfChange] != ' ') {
				charScan[positionOfChange] = ' ';
			}
		}
		
		if (stringCharArray(charScan) == "?" || stringCharArray(charScan) == oldNumber) {
			charScan[positionOfChange] = originalChar;
		}
		
		for (int i = 0; i < charScan.length; i++) {
			newNumber += charScan[i];
		}
		
		return newNumber;
	}

	public boolean wasNotARealNumber() {
		return wasNotARealNumber;
	}
}
