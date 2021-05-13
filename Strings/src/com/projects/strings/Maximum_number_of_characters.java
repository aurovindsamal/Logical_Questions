package com.projects.strings;

/**
 Input : str = "abba"
Output : 2
The maximum number of characters are
between two occurrences of 'a'.

Input : str = "baaabcddc"
Output : 3
The maximum number of characters are
between two occurrences of 'b'.
 */
//Efficient java program to find maximum
//number of characters between two
//occurrences of same character
import java.io.*;

public class Maximum_number_of_characters {

	static int MAX_CHAR = 256;

	static int maximumChars(String str) {
		int n = str.length();
		int res = -1;

		// Initialize all indexes as -1.
		int[] firstInd = new int[MAX_CHAR];

		for (int i = 0; i < MAX_CHAR; i++)
			firstInd[i] = -1;

		for (int i = 0; i < n; i++) {
			int first_ind = firstInd[str.charAt(i)];

			// If this is first occurrence
			if (first_ind == -1)
				firstInd[str.charAt(i)] = i;

			// Else find distance from previous
			// occurrence and update result (if
			// required).
			else
				res = Math.max(res, Math.abs(i - first_ind - 1));
		}

		return res;
	}

	// Driver code

	static public void main(String[] args) {
		String str = "abba";

		System.out.println(maximumChars(str));
	}
}
