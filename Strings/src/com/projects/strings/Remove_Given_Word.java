package com.projects.strings;

//Java Program to Remove a Given Word From a String
//using searching techniques

//Importing input output classes
import java.io.*;

//main class
public class Remove_Given_Word {

	// Method 1
	// To remove the word
	static void remove(String str, String word)
	{
		// Split the string using split() method
		String msg[] = str.split(" ");
		String new_str = "";

		// Itearating the string using for each loop
		for (String words : msg) {

			// If desired word is found
			if (!words.equals(word)) {

				// Concate the word not equal to the given
				// word
				new_str += words + " ";
			}
		}

		// Print the new String
		System.out.print(new_str);
	}

	// Method 2
	// Main driver method
	public static void main(String[] args)
	{
		// Custom string as input
		String str = "This is the Geeks For Geeks";

		// Word to be removed from above string
		String word = "the";

		// Calling the method 1 by passing both strings to
		// it
		remove(str, word);
	}
}
