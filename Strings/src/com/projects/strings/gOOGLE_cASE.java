package com.projects.strings;

/**
 Input : gEEks fOr GeeKs
Output : gEEKS fOR gEEKS 

Input : I got intern at geeksforgeeks
Output : i gOT iNTERN aT gEEKSFORGEEKS 
 */
//Java program to convert given
//sentence to camel case.
import java.io.*;

public class gOOGLE_cASE
{
	// Function to remove spaces
	// and convert into camel case
	static String convert(String s)
	{
		int n = s.length();
		String s1 = "";
		s1 = s1 + Character.toLowerCase(s.charAt(0));

		for (int i = 1; i < n; i++)
		{
			// check for spaces in the sentence
			if (s.charAt(i) == ' ' && i < n)
			{
				// conversion into upper case
				s1 = s1 + " " + Character.toLowerCase
								(s.charAt(i + 1));
				i++;
				
			}
		
			// If not space, copy character
			else
			s1= s1 + Character.toUpperCase(s.charAt(i));
			
		}

		// return string to main
		return s1;
		
	}
	
	// Driver code
	public static void main (String[] args)
	{
		String str = "I get intern at geeksforgeeks";
		System.out.println(convert(str));
	}
}

