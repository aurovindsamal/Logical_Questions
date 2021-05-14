package com.projects.arrays;

/**
 * 
 * @author aurovind.samal 
 *         Input: Array[] = {1, 3, 5, 7, 9}, K = 2. Output: 7 9 1
 *         3 5 Explanation: After 1st rotation - {9, 1, 3, 5, 7} After 2nd
 *         rotation - {7, 9, 1, 3, 5}
 * 
 *         Input: Array[] = {1, 2, 3, 4, 5}, K = 4. Output: 2 3 4 5 1
 *
 */
//Java Implementation of Right Rotation
//of an Array K number of times
import java.util.*;
import java.lang.*;
import java.io.*;

public class Array_after_k_rotated_Times {

//Function to rightRotate array
	static void RightRotate(int a[], int n, int k) {

		// If rotation is greater
		// than size of array
		k = k % n;

		for (int i = 0; i < n; i++) {
			if (i < k) {
				// Printing rightmost
				// kth elements
				System.out.print(a[n + i - k] + " ");
			} else {
				// Prints array after
				// 'k' elements
				System.out.print(a[i - k] + " ");
			}
		}
		System.out.println();
	}

//Driver program
	public static void main(String args[]) {
		int Array[] = { 1, 2, 3, 4, 5 };
		int N = Array.length;

		int K = 2;
		RightRotate(Array, N, K);

	}
}
//This code is contributed by M Vamshi Krishna
