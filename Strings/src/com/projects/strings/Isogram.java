package com.projects.strings;

/**
 * Input : Machine Output : True "Machine" does not have any character
 * repeating, it is an Isogram
 * 
 * Input : Geek Output : False "Geek" has 'e' as repeating character, it is not
 * an Isogram
 * 
 */
//Java code to check string is isogram or not
//Java program to check
//if a given string is isogram or not
import java.io.*;
import java.util.*;

public class Isogram {
	// Function to check
	// if a given string is isogram or not
	static boolean is_isogram(String str)
	{
		// Convert the string in lower case letters
		str = str.toLowerCase();
		int len = str.length();

		char arr[] = str.toCharArray();

		Arrays.sort(arr);
		for (int i = 0; i < len - 1; i++) {
			if (arr[i] == arr[i + 1])
				return false;
		}
		return true;
	}

	// driver program
	public static void main(String[] args)
	{
		String str1 = "Machine";
		System.out.println(is_isogram(str1));

		String str2 = "isogram";
		System.out.println(is_isogram(str2));

		String str3 = "GeeksforGeeks";
		System.out.println(is_isogram(str3));

		String str4 = "Alphabet";
		System.out.println(is_isogram(str4));
	}
}
