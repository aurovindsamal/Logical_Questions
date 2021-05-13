package com.projects.strings;

/**
 * Input : 89101113 Output : 12
 * 
 * Input : 9899101102 Output : 100
 * 
 * Input : 596597598600601602: Output : 599
 * 
 * Input : 909192939495969798100101 Output : 99
 * 
 * Input : 11111211311411511 Output : -1
 */
//Java program to find a missing number in a
//string of consecutive numbers without any
//separator.

public class missing_number {

	static final int MAX_DIGITS = 6;

//gets the integer at position i with length m,
//returns it or -1, if none
	static int getValue(String str, int i, int m) {
		if (i + m > str.length()) {
			return -1;
		}

		// Find value at index i and length m.
		int value = 0;
		for (int j = 0; j < m; j++) {
			int c = str.charAt(i + j) - '0';
			if (c < 0 || c > 9) {
				return -1;
			}
			value = value * 10 + c;
		}
		return value;
	}

//Returns value of missing number
	static int findMissingNumber(String str) {
		// Try all lengths for first number
		for (int m = 1; m <= MAX_DIGITS; ++m) {
			// Get value of first number with current
			// length/
			int n = getValue(str, 0, m);
			if (n == -1) {
				break;
			}

			// To store missing number of current length
			int missingNo = -1;

			// To indicate whether the sequence failed
			// anywhere for current length.
			boolean fail = false;

			// Find subsequent numbers with previous number as n
			for (int i = m; i != str.length(); i += 1 + Math.log10(n)) {
				// If we haven't yet found the missing number
				// for current length. Next number is n+2. Note
				// that we use Log10 as (n+2) may have more
				// length than n.
				if ((missingNo == -1) && (getValue(str, i, (int) (1 + Math.log10(n + 2))) == n + 2)) {
					missingNo = n + 1;
					n += 2;
				} // If next value is (n+1)
				else if (getValue(str, i, (int) (1 + Math.log10(n + 1))) == n + 1) {
					n++;
				} else {
					fail = true;
					break;
				}
			}

			if (!fail) {
				return missingNo;
			}
		}
		return -1; // not found or no missing number
	}
//Driver code

	public static void main(String[] args) {
		System.out.println(findMissingNumber("99101102"));
	}
}
