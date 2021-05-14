package com.projects.arrays;

/**
 * 
 * @author aurovind.samal 
 * 		   Input: arr[] = {4, 5, 1, 2, 3} Output: 2 Explanation:
 *         Sorted array {1, 2, 3, 4, 5} after 2 anti-clockwise rotations.
 * 
 *         Input: arr[] = {2, 1, 2, 2, 2} Output: 1 Explanation: Sorted array
 *         {1, 2, 2, 2, 2} after 1 anti-clockwise rotations.
 *
 */
//Java Program to find the
//count of rotations
public class Count_of_rotations_required_to_generate_sorted_array {

	// Function to return the count of
	// rotations
	public static int countRotation(int[] arr,
									int n)
	{
		for (int i = 1; i < n; i++) {
			// Find the smallest element
			if (arr[i] < arr[i - 1]) {
				// Return its index
				return i;
			}
		}
		// If array is not
		// rotated at all
		return 0;
	}

	// Driver Code
	public static void main(String[] args)
	{
		int[] arr1 = { 4, 5, 1, 2, 3 };

		System.out.println(
			countRotation(
				arr1,
				arr1.length));
	}
}
