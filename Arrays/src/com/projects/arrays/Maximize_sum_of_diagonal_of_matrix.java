package com.projects.arrays;

/**
Input: mat[][] = { { 1, 1, 2 }, { 2, 1, 2 }, { 1, 2, 2 } }
Output: 6 
Explanation: 
Rotating all the columns of matrix by 1 modifies mat[][] to { {2, 1, 2}, {1, 2, 2}, {1, 1, 2} }. 
Therefore, the sum of diagonal elements of the matrix = 2 + 2 + 2 = 6 which is the maximum possible.

Input: A[][] = { { -1, 2 }, { -1, 3 } }
Output: 2
 */
//Java program to implement
//the above approach
import java.util.*;

public class Maximize_sum_of_diagonal_of_matrix {

	static int N = 3;

//Function to find maximum sum of
//diagonal elements of matrix by
//rotating either rows or columns
	static int findMaximumDiagonalSumOMatrixf(int A[][]) {

		// Stores maximum diagonal sum of elements
		// of matrix by rotating rows or columns
		int maxDiagonalSum = Integer.MIN_VALUE;

		// Rotate all the columns by an integer
		// in the range [0, N - 1]
		for (int i = 0; i < N; i++) {

			// Stores sum of diagonal elements
			// of the matrix
			int curr = 0;

			// Calculate sum of diagonal
			// elements of the matrix
			for (int j = 0; j < N; j++) {

				// Update curr
				curr += A[j][(i + j) % N];
			}

			// Update maxDiagonalSum
			maxDiagonalSum = Math.max(maxDiagonalSum, curr);
		}

		// Rotate all the rows by an integer
		// in the range [0, N - 1]
		for (int i = 0; i < N; i++) {

			// Stores sum of diagonal elements
			// of the matrix
			int curr = 0;

			// Calculate sum of diagonal
			// elements of the matrix
			for (int j = 0; j < N; j++) {

				// Update curr
				curr += A[(i + j) % N][j];
			}

			// Update maxDiagonalSum
			maxDiagonalSum = Math.max(maxDiagonalSum, curr);
		}
		return maxDiagonalSum;
	}

//Driver Code
	public static void main(String[] args) {
		int[][] mat = { { 1, 1, 2 }, { 2, 1, 2 }, { 1, 2, 2 } };

		System.out.println(findMaximumDiagonalSumOMatrixf(mat));
	}
}
