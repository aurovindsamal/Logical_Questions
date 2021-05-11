package com.project.stack;

/**
 Input : a[] = [1, 1, 2, 3, 4, 2, 1] 
Output : [-1, -1, 1, 2, 2, 1, -1]
Explanation:
Given array a[] = [1, 1, 2, 3, 4, 2, 1] 
Frequency of each element is: 3, 3, 2, 1, 1, 2, 3

1) Create a list to use values as index to store frequency of each element. 
2) Push the position of first element to stack. 
3) Pick rest of the position of elements one by one and follow following steps in loop. 
…….a) Mark the position of current element as ‘i’ . 
……. b) If the frequency of the element which is pointed by the top of stack is greater than frequency of the current element, push the current position i to the stack 
……. c) If the frequency of the element which is pointed by the top of stack is less than frequency of the current element and the stack is not empty then follow these steps: 
…….i) continue popping the stack 
…….ii) if the condition in step c fails then push the current position i to the stack 
4) After the loop in step 3 is over, pop all the elements from stack and print -1 as next greater frequency element for them does not exist.
 */
//Java program of Next Greater Frequency Element
import java.util.Stack;

public class Next_Greater_Frequency_Element {

	/*NFG function to find the next greater frequency
	element for each element in the array*/
	static void NFG(int a[], int n, int freq[])
	{

		// stack data structure to store the position
		// of array element
		Stack<Integer> s = new Stack<Integer>();
		s.push(0);

		// res to store the value of next greater
		// frequency element for each element
		int res[] = new int[n];
		for (int i = 0; i < n; i++)
			res[i] = 0;

		for (int i = 1; i < n; i++)
		{
			/* If the frequency of the element which is
				pointed by the top of stack is greater
				than frequency of the current element
				then push the current position i in stack*/

			if (freq[a[s.peek()]] > freq[a[i]])
				s.push(i);
			else
			{
				/*If the frequency of the element which
				is pointed by the top of stack is less
				than frequency of the current element, then
				pop the stack and continuing popping until
				the above condition is true while the stack
				is not empty*/

				while (freq[a[s.peek()]] < freq[a[i]]
					&& s.size() > 0)
				{
					res[s.peek()] = a[i];
					s.pop();
				}

				// now push the current element
				s.push(i);
			}
		}

		while (s.size() > 0)
		{
			res[s.peek()] = -1;
			s.pop();
		}

		for (int i = 0; i < n; i++)
		{
			// Print the res list containing next
			// greater frequency element
			System.out.print(res[i] + " ");
		}
	}

	// Driver code
	public static void main(String args[])
	{

		int a[] = { 1, 1, 2, 3, 4, 2, 1 };
		int len = 7;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < len; i++)
		{
			// Getting the max element of the array
			if (a[i] > max)
			{
				max = a[i];
			}
		}
		int freq[] = new int[max + 1];

		for (int i = 0; i < max + 1; i++)
			freq[i] = 0;

		// Calculating frequency of each element
		for (int i = 0; i < len; i++)
		{
			freq[a[i]]++;
		}
		// Function call
		NFG(a, len, freq);
	}
}


