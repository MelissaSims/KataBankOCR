package com.bank.ocr;

import java.util.Arrays;

/*
 * This class will hold the Account Number as a whole, including the entire original strings as read in from the scanner class.
 * It will be used to break down the account number into individual digits that it will feed to the number class for identification.
 * It will call on the Validator class to verify that the account number is a legitimate account number.
 * It will act as the go between for the Validator and Number classes when trying to correct account numbers for validation.
 */

public class AccountNumber {
	public String accountNumber;
	public String scan;
	private String lineOne, lineTwo, lineThree;
	private Number[] numbers = new Number[9];
	private Number[] originalNumbers = new Number[9];
	private Validator validator;
	private String[] possibleAccountNumbers = new String[0];
	private int amountOfPossibleNumbers = 0;
	private String originalAccountNumber;
	
	public AccountNumber(String l1, String l2, String l3) {
		lineOne = l1;
		lineTwo = l2;
		lineThree = l3;
		setup();
		this.validator = new Validator(this, numbers);
		validator.determineAccountNumberStatus();
	}
	
	private void setup() {

		if (lineOne.length() < 27) {
			lineOne = correctLength(lineOne);
		}
		if (lineTwo.length() < 27) {
			lineTwo = correctLength(lineTwo);
		}
		if (lineThree.length() < 27) {
			lineThree = correctLength(lineThree);
		}
		
		readAccountNumber();
	}
	
	private String correctLength(String badLength) {
		char[] charScan = new char[27];
		String correctedScan = "";
		for (int i = 0; i < 27; i++) {
			if (badLength.length() > i) {
				charScan[i] = badLength.charAt(i);
			} else {
				charScan[i] = ' ';
			}
		}
		correctedScan = stringCharArray(charScan);
		return correctedScan;
	}
	
	private String stringCharArray(char[] charScan) {
		String newNumber = "";
		for (int i = 0; i < charScan.length; i++) {
			newNumber += charScan[i];
		}
		return newNumber;
	}
	
	public void readAccountNumber() {
		String[] digitsInStringFormat = new String[9];
		int digitLocation = 0;
		
		for (int i = 0; i < 27; i += 3) {
			digitsInStringFormat[digitLocation] = lineOne.substring(i, i+3);
			digitsInStringFormat[digitLocation] += lineTwo.substring(i, i+3);
			digitsInStringFormat[digitLocation] += lineThree.substring(i, i+3);
			digitLocation++;
		}
		
		setArrayOfNumbers(digitsInStringFormat);
	}
	
	public void setArrayOfNumbers(String[] digitsInStringFormat) {
		for (int i = 0; i < 9; i++) {
			numbers[i] = new Number(digitsInStringFormat[i]);
		}
		originalNumbers = numbers;
	}
	
	public String getAccountNumber() {
		for (int i = 0; i < 9; i++) {
			if (i == 0) {
				accountNumber = numbers[i].toString();
			} else {
				accountNumber += numbers[i].toString();
			}
		}
		
		if (amountOfPossibleNumbers > 1) {
			getMultipleAccountNumbers();
		} if (possibleAccountNumbers.length == 1) {
			accountNumber = possibleAccountNumbers[0];
		}
		
		return accountNumber;
	}
	
	public void correctAccountNumberError() {
		originalAccountNumber = getAccountNumber();
		if (findIllegibleNumbers() < 9) {
			changeDigits(findIllegibleNumbers(), numbers[findIllegibleNumbers()]);
		} else {
			for (int i = 0; i < 9; i++) {
				changeDigits(i, numbers[i]);
			}
		}
	}
	
	private void changeDigits(int k, Number originalNumber) {
			for (int i = 0; i < 9; i++) {
				numbers[k] = new Number(numbers[k].changeNumber(i));
				if (validator.validateAccountNumber()) {
					String possibleAccountNumber = "";
					for (int j = 0; j < 9; j++) {
						if (j == 0) {
							possibleAccountNumber = numbers[j].toString();
						} else {
							possibleAccountNumber += numbers[j].toString();
						}
					}
					amountOfPossibleNumbers++;
					accountNumber = getAccountNumber();
					addToArrayOfPossibleNumbers(possibleAccountNumber);
					
				}
				numbers[k] = originalNumber;
			}
	}
	
	private void addToArrayOfPossibleNumbers(String possibleAccountNumber) {
		String[] tempPossibleNumbers = possibleAccountNumbers;
		possibleAccountNumbers = new String[amountOfPossibleNumbers];
		possibleAccountNumbers[0] = possibleAccountNumber;
		if (amountOfPossibleNumbers > 1) {
			for (int i = 0; i < tempPossibleNumbers.length; i++) {
				possibleAccountNumbers[i+1] = tempPossibleNumbers[i];
			}
		}
	}
	
	private void getMultipleAccountNumbers() {
		int[] sortedPossibleNumbers = new int[possibleAccountNumbers.length];
		for (int i = 0; i < sortedPossibleNumbers.length; i++) {
			sortedPossibleNumbers[i] = Integer.parseInt(possibleAccountNumbers[i]);
		}
		Arrays.sort(sortedPossibleNumbers);
		
		String allPossibleAccountNumbers = originalAccountNumber + " AMB [";
		
		for (int i = 0; i < sortedPossibleNumbers.length; i++) {
			allPossibleAccountNumbers += "'" + sortedPossibleNumbers[i] + "'";
			if (i < sortedPossibleNumbers.length-1) {
				allPossibleAccountNumbers += ", ";
			}
		}
		
		allPossibleAccountNumbers += "]";
		
		accountNumber = allPossibleAccountNumbers;
	}
	
	private int findIllegibleNumbers() {
		int positionOfIllegibleNumber = 9;
		for (int i = 0; i < originalNumbers.length; i++) {
			if (originalNumbers[i].wasNotARealNumber()) {
				return i;
			}
		}
		
		return positionOfIllegibleNumber;
	}
}
