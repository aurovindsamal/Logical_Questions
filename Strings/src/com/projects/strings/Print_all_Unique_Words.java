package com.projects.strings;

// Java Program to Print all Unique Words
// Using Map

// Importing utility classes from java.util package
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

// Main class
public class Print_all_Unique_Words {

	// Method 1
	// To print all unique words in the string
	static void printUniqueWords(String str)
	{
		// Create a new Map ny creating object of HashhMap
		// class
		HashMap<String, Integer> map
			= new LinkedHashMap<String, Integer>();

		// Extract words from string
		// using split() method
		String[] words = str.split("\\W");

		// Iterating over the words array
		// using for each loop
		for (String word : words) {

			// If the word is present in array then
			//
			if (map.containsKey(word)) {

				// Increment its value by one
				// using map.get() method
				map.put(word, map.get(word) + 1);
			}

			// Else store the word inside map
			// with value one
			else
				map.put(word, 1);
		}

		// Iterate over the map using for each loop
		for (Map.Entry<String, Integer> entry :
			map.entrySet()) {

			// If value of words equals unity
			if (entry.getValue() == 1)

				// Print all those words
				System.out.println(entry.getKey());
		}
	}

	// Method 2
	// Main driver method
	public static void main(String[] args)
	{
		// Custom input string
		String str = "Welcome to geeks for geeks";

		// Calling the Method1 to
		// print all unique words in above string
		printUniqueWords(str);
	}
}

