package com.projects.strings;

/**
 Input : bAwutndekWEdkd
Output :AbEdWddekkntuw
Explanation:
Here we can see that letter ‘A’, ’E’, ’W’ are sorted 
as well as letters “b, d, d, d, e, k, k, n, t, u, w” are sorted 
but both appears alternately in the string as far as possible.

Input :abbfDDhGFBvdFDGBNDasZVDFjkb
Output :BaBaDbDbDbDdDfFhFjFkGsGvNVZ
 */
//Java program for
//unusual string sorting
import java.util.*;
import java.lang.*;

public class Alternate_Lower_Upper_String_Sort {

	private final static int MAX = 100;

//Function for alternate
//sorting of string
	public static String alternateSort(String s1) {
		int n = s1.length();

		char[] s = s1.toCharArray();

		// Count occurrences of
		// individual lower case and
		// upper case characters
		int[] lCount = new int[MAX];
		int[] uCount = new int[MAX];

		for (int i = 0; i < n; i++) {

			if (Character.isUpperCase(s[i]))
				uCount[s[i] - 'A']++;
			else
				lCount[s[i] - 'a']++;
		}

		// Traverse through count
		// arrays and one by one
		// pick characters.
		// Below loop takes O(n) time
		// considering the MAX is constant.
		int i = 0, j = 0, k = 0;
		while (k < n) {

			while (i < MAX && uCount[i] == 0)
				i++;

			if (i < MAX) {
				s[k++] = (char) ('A' + i);
				uCount[i]--;
			}

			while (j < MAX && lCount[j] == 0)
				j++;

			if (j < MAX) {
				s[k++] = (char) ('a' + j);
				lCount[j]--;
			}
		}

		return (new String(s));
	}

//Driver function
	public static void main(String argc[]) {

		String str = "bAwutndekWEdkd";
		System.out.println(alternateSort(str));
	}

}
