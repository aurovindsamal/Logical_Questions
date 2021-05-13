package com.projects.strings;

/**
 A password is said to be strong if it satisfies the following criteria: 

It contains at least one lowercase English character.
It contains at least one uppercase English character.
It contains at least one special character. The special characters are: !@#$%^&*()-+
Its length is at least 8.
It contains at least one digit.
Given a string, find its strength. Let a strong password is one that satisfies all above conditions. A moderate password is one that satisfies first three conditions and has length at least 6. Otherwise password is week.

Examples : 

Input : “GeeksforGeeks!@12”
Output : Strong

Input : “gfg!@12”
Output : Moderate
 */
//Java implementation fo the above approach
import java.io.*;
import java.util.*;

public class StrengthOf_Password {


	public static void printStrongNess(String input)
	{
		// Checking lower alphabet in string
		int n = input.length();
		boolean hasLower = false, hasUpper = false,
				hasDigit = false, specialChar = false;
		Set<Character> set = new HashSet<Character>(
			Arrays.asList('!', '@', '#', '$', '%', '^', '&',
						'*', '(', ')', '-', '+'));
		for (char i : input.toCharArray())
		{
			if (Character.isLowerCase(i))
				hasLower = true;
			if (Character.isUpperCase(i))
				hasUpper = true;
			if (Character.isDigit(i))
				hasDigit = true;
			if (set.contains(i))
				specialChar = true;
		}
	
		// Strength of password
		System.out.print("Strength of password:- ");
		if (hasDigit && hasLower && hasUpper && specialChar
			&& (n >= 8))
			System.out.print(" Strong");
		else if ((hasLower || hasUpper || specialChar)
				&& (n >= 6))
			System.out.print(" Moderate");
		else
			System.out.print(" Weak");
	}

	// Driver Code
	public static void main(String[] args)
	{
		String input = "GeeksforGeeks!@12";
		printStrongNess(input);
	}

	
}

