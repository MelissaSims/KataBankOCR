package com.bank.ocr;

/*
 * This class will be used to run checksum formulas and direct the AccountNumber class if changes need to be made.
 */

public class Validator {
	int checksum = 0;
	private Number[] digits = new Number[9];
	private AccountNumber accountNumber;
	
	public Validator(AccountNumber accountNumber, Number[] digits) {
		this.accountNumber = accountNumber;
		this.digits = digits;
	}
	
	public void determineAccountNumberStatus() {
		if (!validateAccountNumber()) {
			accountNumber.correctAccountNumberError();
		}
		
		for (int i = 0; i < 9; i++) {
			if (accountNumber.toString().charAt(i) == '?') {
				break;
			}
		}
	}

	private int checksum() {
		int checksum = 0;
		int multiplier = 9;
		
		for (int d = 0; d < digits.length; d++) {
			checksum += Integer.parseInt(digits[d].toString()) * multiplier;
			multiplier--;
		}
		checksum = checksum % 11;
		
		return checksum;
	}

	public boolean validateAccountNumber() {
		boolean validity = true;
		
		if (checksum() != 0) {
			validity = false;
		}
		
		return validity;
	}

}
