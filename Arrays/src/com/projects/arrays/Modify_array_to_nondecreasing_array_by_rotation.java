package com.projects.arrays;

/**
 Input: arr[] = {3, 4, 5, 1, 2}
Output: Yes
Explanation: After 2 right rotations, the array arr[] modifies to {1, 2, 3, 4, 5}

Input: arr[] = {1, 2, 4, 3}
Output: No
 */
//Java program for the above approach
import java.util.*;

public class Modify_array_to_nondecreasing_array_by_rotation {

//Function to check if a
//non-decreasing array can be obtained
//by rotating the original array
	static void rotateArray(int[] arr, int N) {
		// Stores copy of original array
		int[] v = arr;

		// Sort the given vector
		Arrays.sort(v);

		// Traverse the array
		for (int i = 1; i <= N; ++i) {

			// Rotate the array by 1
			int x = arr[N - 1];
			i = N - 1;
			while (i > 0) {
				arr[i] = arr[i - 1];
				arr[0] = x;
				i -= 1;
			}

			// If array is sorted
			if (arr == v) {

				System.out.print("YES");
				return;
			}
		}

		// If it is not possible to
		// sort the array
		System.out.print("NO");
	}

//Driver Code
	public static void main(String[] args) {

		// Given array
		int[] arr = { 3, 4, 5, 1, 2 };

		// Size of the array
		int N = arr.length;

		// Function call to check if it is possible
		// to make array non-decreasing by rotating
		rotateArray(arr, N);
	}
}
