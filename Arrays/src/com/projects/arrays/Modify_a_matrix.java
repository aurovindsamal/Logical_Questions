package com.projects.arrays;

/**
 Input: mat[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}
Output:
1 2 3
6 4 5
8 9 7
Explanation:
The 0th row is rotated 0 times. Therefore, the 0th row remains the same as {1, 2, 3}.
The 1st row is rotated 1 times. Therefore, the 1st row modifies to {6, 4, 5}.
The 2nd row is rotated 2 times. Therefore, the 2nd row modifies to {8, 9, 7}.
After completing the above operations, the given matrix modifies to {{1, 2, 3}, {6, 4, 5}, {8, 9, 7}}.
 */
//java program for the above approach
import java.io.*;
import java.lang.*;
import java.util.*;

public class Modify_a_matrix {

//Function to reverse arr[] from start to end
	static void reverse(int arr[], int start, int end) {
		while (start < end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}

//Function to rotate every i-th
//row of the matrix i times
	static void rotateMatrix(int mat[][]) {
		int i = 0;

		// Traverse the matrix row-wise
		for (int rows[] : mat) {

			// Reverse the current row
			reverse(rows, 0, rows.length - 1);

			// Reverse the first i elements
			reverse(rows, 0, i - 1);

			// Reverse the last (N - i) elements
			reverse(rows, i, rows.length - 1);

			// Increment count
			i++;
		}

		// Print final matrix
		for (int rows[] : mat) {
			for (int cols : rows) {
				System.out.print(cols + " ");
			}
			System.out.println();
		}
	}

//Driver Code
	public static void main(String[] args) {

		int mat[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		rotateMatrix(mat);
	}
}
