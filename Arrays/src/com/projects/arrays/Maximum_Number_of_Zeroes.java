package com.projects.arrays;

//Java program for the above approach
import java.util.*;

/**
 Input: S = “1001”
Output: 2
Explanation:
All possible rotations of the string are:
“1001”: Count of 0s at the start = 0, at the end = 0. Sum= 0 + 0 = 0.
“0011”: Count of 0s at the start = 2, at the end = 0. Sum = 2 + 0=2
“0110”: Count of 0s at the start = 1, at the end = 1. Sum= 1 + 1 = 2.
“1100”: Count of 0s at the start = 0, at the end = 2. Sum = 0 + 2 = 2
Therefore, maximum sum possible = 2.
 */
public class Maximum_Number_of_Zeroes {

//Function to find the maximum sum of
//consecutive 0s present at the start
//and end of a string present in any
//of the rotations of the given string
	static void findMaximumZeros(String str, int n) {

		// Check if all the characters
		// in the string are 0
		int c0 = 0;

		// Iterate over characters
		// of the string
		for (int i = 0; i < n; ++i) {
			if (str.charAt(i) == '0')
				c0++;
		}

		// If the frequency of '1' is 0
		if (c0 == n) {

			// Print n as the result
			System.out.print(n);
			return;
		}

		// Concatenate the string
		// with itself
		String s = str + str;

		// Stores the required result
		int mx = 0;

		// Generate all rotations of the string
		for (int i = 0; i < n; ++i) {

			// Store the number of consecutive 0s
			// at the start and end of the string
			int cs = 0;
			int ce = 0;

			// Count 0s present at the start
			for (int j = i; j < i + n; ++j) {
				if (s.charAt(j) == '0')
					cs++;
				else
					break;
			}

			// Count 0s present at the end
			for (int j = i + n - 1; j >= i; --j) {
				if (s.charAt(j) == '0')
					ce++;
				else
					break;
			}

			// Calculate the sum
			int val = cs + ce;

			// Update the overall
			// maximum sum
			mx = Math.max(val, mx);
		}

		// Print the result
		System.out.print(mx);
	}

//Driver Code
	public static void main(String[] args) {

		// Given string
		String s = "1001";

		// Store the size of the string
		int n = s.length();

		findMaximumZeros(s, n);
	}
}
