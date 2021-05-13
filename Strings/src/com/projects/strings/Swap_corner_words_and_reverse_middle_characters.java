package com.projects.strings;

/**
 Input : Hello World GFG Welcomes You
Output :You semocleW GFG dlroW Hello
 */
//Java Program to illustrate the solution of above problem
public class Swap_corner_words_and_reverse_middle_characters {
	static void print(String s)
	{
		// Taking an Empty String
		String fst = "";
		int i = 0;
		for (i = 0; i < s.length();) {

			// Iterating from starting index
			// When we get space, loop terminates
			while (s.charAt(i) != ' ') {
				fst = fst + s.charAt(i);
				i++;
			}

			// After getting one Word
			break;
		}

		// Taking an Empty String
		String last = "";
		int j = 0;
		for (j = s.length() - 1; j >= i;) {

			// Iterating from last index
			// When we get space, loop terminates
			while (s.charAt(j) != ' ') {
				last = s.charAt(j) + last;
				j--;
			}

			// After getting one Word
			break;
		}

		// Printing last word
		System.out.print(last);
		for (int m = j; m >= i; m--) {

			// Reversing the left characters
			System.out.print(s.charAt(m));
		}

		// Printing the first word
		System.out.println(fst);
	}

	public static void main(String[] args)
	{
		String s = "Hello World GFG Welcomes You";
		print(s);
	}
}

