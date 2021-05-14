package com.projects.arrays;

/**
 Input: N = 6, 
mat[][] = {{3, 4, 5, 1, 5, 9, 5}, 
               {6, 9, 8, 7, 2, 5, 2},  
               {1, 5, 9, 7, 5, 3, 2}, 
               {4, 7, 8, 9, 3, 5, 2}, 
               {4, 5, 2, 9, 5, 6, 2}, 
               {4, 5, 7, 2, 9, 8, 3}}
Output:
        3
      6 4
    1 9 5
   4 5 8 1
  4 7 9 7 5
4 5 8 7 2 9
  5 2 9 5 5
   7 9 3 3
    2 5 5
     9 6
      8
 */
//Java program for
//the above approach
import java.util.*;

public class Rotate_matrix_by_45_degrees {

//Function to rotate
//matrix by 45 degree
	static void matrix(int n, int m, int[][] li) {
//Counter Variable
		int ctr = 0;

		while (ctr < 2 * n - 1) {
			for (int i = 0; i < Math.abs(n - ctr - 1); i++) {
				System.out.print(" ");
			}

			Vector<Integer> lst = new Vector<Integer>();

			// Iterate [0, m]
			for (int i = 0; i < m; i++) {
				// Iterate [0, n]
				for (int j = 0; j < n; j++) {
					// Diagonal Elements
					// Condition
					if (i + j == ctr) {
						// Appending the
						// Diagonal Elements
						lst.add(li[i][j]);
					}
				}
			}

			// Printing reversed Diagonal
			// Elements
			for (int i = lst.size() - 1; i >= 0; i--) {
				System.out.print(lst.get(i) + " ");
			}

			System.out.println();
			ctr += 1;
		}
	}

//Driver code
	public static void main(String[] args) {
//Dimensions of Matrix
		int n = 8;
		int m = n;

//Given matrix
		int[][] li = { { 4, 5, 6, 9, 8, 7, 1, 4 }, { 1, 5, 9, 7, 5, 3, 1, 6 }, { 7, 5, 3, 1, 5, 9, 8, 0 },
				{ 6, 5, 4, 7, 8, 9, 3, 7 }, { 3, 5, 6, 4, 8, 9, 2, 1 }, { 3, 1, 6, 4, 7, 9, 5, 0 },
				{ 8, 0, 7, 2, 3, 1, 0, 8 }, { 7, 5, 3, 1, 5, 9, 8, 5 } };

//Function call
		matrix(n, m, li);
	}
}
