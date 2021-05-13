package com.projects.strings;
/**
 Input : sample string
Output : Largest = t, Smallest = a

Input : Geeks
Output : Largest = s, Smallest = G
Explanation: According to alphabetical order 
largest alphabet in this string is 's' 
and smallest alphabet in this string is
'G'( not 'e' according to the ASCII value)

Input : geEks
Output : Largest = s, Smallest = E
 */
//Java program to find largest and
//smallest characters in a string.
public class find_the_largest_and_smallest_ASCII {	
	
	// function that return the largest alphabet.
	static char largest_alphabet(String a, int n)
	{
		// initializing max alphabet to 'a'
		char max = 'A';
	
		// find largest alphabet
		for (int i=0; i<n; i++)	
			if (a.charAt(i) > max)
				max = a.charAt(i);	
	
		// returning largest element
		return max;
	}
	
	// function that return the smallest alphabet
	static char smallest_alphabet(String a, int n)
	{
		// initializing smallest alphabet to 'z'
		char min = 'z';
	
		// find smallest alphabet
		for (int i=0; i<n-1; i++)	
			if (a.charAt(i) < min)
				min = a.charAt(i);	
	
		// returning smallest alphabet
		return min;
	}
	
	// Driver Code
	public static void main(String args[])
	{
		// Input String
		String a= "GeEksforGeeks";
	
		// Calculating size of the string
		int size = a.length();
	
		// calling functions and print returned value
		System.out.print("Largest and smallest alphabet is : ");
	
		System.out.print(largest_alphabet(a,size) + " and ");
		System.out.println(smallest_alphabet(a,size));
	}
}

