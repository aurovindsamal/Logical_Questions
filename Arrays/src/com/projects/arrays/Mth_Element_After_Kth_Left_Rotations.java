package com.projects.arrays;

/**
Input: arr[] = {3, 4, 5, 23}, K = 2, M = 1
Output: 5
Explanation: 
The array after first left rotation a1[ ] = {4, 5, 23, 3}
The array after second left rotation a2[ ] = {5, 23, 3, 4}
st element after 2 left rotations is 5.

Input: arr[] = {1, 2, 3, 4, 5}, K = 3, M = 2
Output: 5 
Explanation: 
The array after 3 left rotation has 5 at its second position.
 */
//Java program for the above approach
import java.util.*;

public class Mth_Element_After_Kth_Left_Rotations {

//Function to return Mth element of
//array after k left rotations
	public static int getFirstElement(int[] a, int N, int K, int M) {

		// The array comes to original state
		// after N rotations
		K %= N;

		// Mth element after k left rotations
		// is (K+M-1)%N th element of the
		// original array
		int index = (K + M - 1) % N;

		int result = a[index];

		// Return the result
		return result;
	}

//Driver code
	public static void main(String[] args) {

		// Array initialization
		int a[] = { 3, 4, 5, 23 };

		// Size of the array
		int N = a.length;

		// Given K rotation and Mth element
		// to be found after K rotation
		int K = 2, M = 1;

		// Function call
		System.out.println(getFirstElement(a, N, K, M));
	}
}
