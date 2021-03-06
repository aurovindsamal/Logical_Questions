package com.projects.strings;

//Java Program to Move All Uppercase Characters to the End

//Importing input output classes
import java.io.*;

//Mai class
public class Move_All_Uppercase_Characters_to_End {

	// Method 1
	// To shift uppercase characters
	static void shiftuppercase(String m, int length)
	{

		// Taking an empty string
		String temp = "";

		for (int i = 0; i < length; ++i) {

			// Condition check
			// If the character is uppercase via
			// the ASCII values of the character
			if (m.charAt(i) >= 65 && m.charAt(i) <= 90) {
				temp += m.charAt(i);
			}

			// The character is already lowercase
			else
				System.out.print(m.charAt(i));
		}

		// Now, Printing the uppercase string
		System.out.print(temp);
	}

	// Method 2
	// Main driver method
	public static void main(String[] args)
	{
		// Custom input string
		String m = "heLLGFg";

		// Computing the length of the string
		// using length() method
		int length = m.length();

		// Calling the method 1 over the custom string taken
		// above to move all uppercase char to the end
		shiftuppercase(m, length);
	}
}

