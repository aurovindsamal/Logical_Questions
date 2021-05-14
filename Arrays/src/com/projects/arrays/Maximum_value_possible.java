package com.projects.arrays;

/**
 Input: N = 657
Output: 765
Explanation: All rotations of 657 are {657, 576, 765}. The maximum value among all these rotations is 765.
 */
//Java program for the above approach
import java.util.*;

public class Maximum_value_possible {

//Function to find the maximum value
//possible by rotations of digits of N
	static void findLargestRotation(int num) {

		// Store the required result
		int ans = num;

		// Store the number of digits
		int len = (int) Math.floor(((int) Math.log10(num)) + 1);
		int x = (int) Math.pow(10, len - 1);

		// Iterate over the range[1, len-1]
		for (int i = 1; i < len; i++) {

			// Store the unit's digit
			int lastDigit = num % 10;

			// Store the remaining number
			num = num / 10;

			// Find the next rotation
			num += (lastDigit * x);

			// If the current rotation is
			// greater than the overall
			// answer, then update answer
			if (num > ans) {
				ans = num;
			}
		}

		// Print the result
		System.out.print(ans);
	}

//Driver Code
	public static void main(String[] args) {
		int N = 657;
		findLargestRotation(N);
	}
}