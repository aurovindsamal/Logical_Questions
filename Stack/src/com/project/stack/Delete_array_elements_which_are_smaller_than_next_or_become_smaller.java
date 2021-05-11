package com.project.stack;

/**
 Input       : arr[] = { 3, 100, 1 }
              k = 1
Output      : 100, 1
Explanation : arr[0] < arr[1] means 3 is less than
              100, so delete 3

Input       : arr[] = {20, 10, 25, 30, 40}
              k = 2
Output      : 25 30 40
Explanation : First we delete 10 because it follows
              arr[i] < arr[i+1]. Then we delete 20
              because 25 is moved next to it and it
              also starts following the condition.

Input       : arr[] = { 23, 45, 11, 77, 18}
              k = 3
Output      : 77, 18
Explanation : We delete 23, 45 and 11 as they follow  
              the condition arr[i] < arr[i+1]
 */
import java.util.Stack;

//Java program to delete elements from array.
public class Delete_array_elements_which_are_smaller_than_next_or_become_smaller {

//Function for deleting k elements
	static void deleteElements(int arr[], int n, int k) {
		// Create a stack and push arr[0]
		Stack<Integer> s = new Stack<>();
		s.push(arr[0]);

		int count = 0;

		// traversing a loop from i = 1 to n
		for (int i = 1; i < n; i++) {

			// condition for deleting an element
			while (!s.empty() && s.peek() < arr[i]
					&& count < k) {
				s.pop();
				count++;
			}

			s.push(arr[i]);
		}

		// Putting elements of stack in a vector
		// from end to begin.
		int m = s.size();
		Integer[] v = new Integer[m]; // Size of vector is m
		while (!s.empty()) {

			// push element from stack to vector v
			v[--m] = s.peek();
			s.pop();
		}

		// printing result
		for (Integer x : v) {
			System.out.print(x + " ");
		};

		System.out.println("");
	}

//Driver code
	public static void main(String[] args) {
		int n = 5, k = 2;
		int arr[] = {20, 10, 25, 30, 40};
		deleteElements(arr, n, k);
	}
}

