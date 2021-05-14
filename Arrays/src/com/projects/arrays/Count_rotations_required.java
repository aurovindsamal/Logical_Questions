package com.projects.arrays;

/**
Input: arr[] = {2, 1, 5, 4, 3}
Output: 2
Explanation: Two anti-clockwise rotations are required to sort the array in decreasing order, i.e. {5, 4, 3, 2, 1}

Input: arr[] = {2, 3, 1}
Output: -1
 */
//Java program for the above approach
import java.util.*;

public class Count_rotations_required {

//Function to count minimum anti-
//clockwise rotations required to
//sort the array in non-increasing order
	static void minMovesToSort(int arr[], int N) {

		// Stores count of arr[i + 1] > arr[i]
		int count = 0;

		// Store last index of arr[i+1] > arr[i]
		int index = 0;

		// Traverse the given array
		for (int i = 0; i < N - 1; i++) {

			// If the adjacent elements are
			// in increasing order
			if (arr[i] < arr[i + 1]) {

				// Increment count
				count++;

				// Update index
				index = i;
			}
		}

		// Print the result according
		// to the following conditions
		if (count == 0) {
			System.out.print("0");
		} else if (count == N - 1) {
			System.out.print(N - 1);
		} else if (count == 1 && arr[0] <= arr[N - 1]) {
			System.out.print(index + 1);
		}

		// Otherwise, it is not
		// possible to sort the array
		else {
			System.out.print("-1");
		}
	}

//Driver Code
	public static void main(String[] args) {

		// Given array
		int[] arr = { 2, 1, 5, 4, 2 };
		int N = arr.length;

		// Function Call
		minMovesToSort(arr, N);
	}
}
