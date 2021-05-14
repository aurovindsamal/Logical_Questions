package com.projects.arrays;

/**
Input: S = “100210601” 
Output: 4 
Explanation: 
The subsequence “0000” satisfies the necessary condition. 
The subsequence “1010” generates the string “0101” on left rotation and string “0101” on right rotation. Since both the rotations are same. Therefore, “1010” satisfies the condition as well. 
Therefore, the maximum length of such subsequence is 4.
Input: S = “252525” 
Output: 6 
Explanation: 
The subsequence “252525” generates the string “525252” on left rotation and string “525252” on right rotation. Since both the rotations are same. Therefore, the “252525” satisfies the required condition.
 */
//Java Program to implement
//the above approach
import java.util.*;

public class Longest_subsequence_of_a_number_having_same_left_and_right_rotation {

//Function to find the longest subsequence
//having equal left and right rotation
	static int findAltSubSeq(String s) {
		// Length of the String
		int n = s.length(), ans = Integer.MIN_VALUE;

		// Iterate for all possible combinations
		// of a two-digit numbers
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				int cur = 0, f = 0;

				// Check for alternate occurrence
				// of current combination
				for (int k = 0; k < n; k++) {
					if (f == 0 && s.charAt(k) - '0' == i) {
						f = 1;

						// Increment the current value
						cur++;
					} else if (f == 1 && s.charAt(k) - '0' == j) {
						f = 0;

						// Increment the current value
						cur++;
					}
				}

				// If alternating sequence is
				// obtained of odd length
				if (i != j && cur % 2 == 1)

					// Reduce to even length
					cur--;

				// Update answer to store
				// the maximum
				ans = Math.max(cur, ans);
			}
		}

		// Return the answer
		return ans;
	}

//Driver Code
	public static void main(String[] args) {
		String s = "100210601";
		System.out.print(findAltSubSeq(s));
	}
}
