package com.gl.credentialservice;

import java.util.Random;

import com.gl.employee.Employee;

public final class CredentialService {

	private static int PASSWORD_LEN = 8;
	private static String SPECIAL_CHARACTERS = "~!@#$%^&*()?|:;<>.,{}[]-_=+/\\";

	private static int getRandomNo(int lowerBound, int upperBound, boolean upperBoundInclusive) {
		Random random = new Random();
		int no = upperBoundInclusive ? random.nextInt(upperBound + 1 - lowerBound) + lowerBound
				: random.nextInt(upperBound - lowerBound) + lowerBound;
		return no;
	}

	private static char getAlphabet(boolean getCapitalAlphabet) {
		char alphabet = getCapitalAlphabet ? (char) getRandomNo(65, 90, true) : (char) getRandomNo(97, 122, true);
		return alphabet;
	}

	public static String generatePassword() {
		String generatedPassword = "";
		int passwordLen = PASSWORD_LEN;

		while (passwordLen > 0) {

			// get capital alphabet
			generatedPassword += getAlphabet(true);
			passwordLen--;

			// get small alphabet
			if (passwordLen > 0) {
				generatedPassword += getAlphabet(true);
				passwordLen--;
			}

			// get special character
			if (passwordLen > 0) {
				int specialCharIndex = getRandomNo(0, SPECIAL_CHARACTERS.length(), false);
				generatedPassword += SPECIAL_CHARACTERS.charAt(specialCharIndex);
				passwordLen--;
			}

			// get number
			if (passwordLen > 0) {
				generatedPassword += getRandomNo(0, 9, true);
				passwordLen--;
			}

		}

		return generatedPassword;
	}

	public static String generateEmailAddress(Employee employee, String department, String companyName) {
		return (employee.getFirstName() + employee.getLastName() + "@" + department + "." + companyName + ".com")
				.toLowerCase();
	}

	public static void showCredentials(Employee employee) {
		System.out.println("\nDear " + employee.getFirstName() + " your generated credentials are as follows");
		System.out.println("Email    --->  " + employee.getEmail());
		System.out.println("Password ---> " + employee.getPassword());
	}

}
