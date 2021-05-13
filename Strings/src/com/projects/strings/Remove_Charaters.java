package com.projects.strings;

//Java program to remove all the characters
//other then alphabets

public class Remove_Charaters
{
	
	// function to remove characters and
	// print new string
	static void removeSpecialCharacter(String s)
	{
		for (int i = 0; i < s.length(); i++)
		{

			// Finding the character whose
			// ASCII value fall under this
			// range
			if (s.charAt(i) < 'A' || s.charAt(i) > 'Z' &&
					s.charAt(i) < 'a' || s.charAt(i) > 'z')
			{
				
				// erase function to erase
				// the character
				s = s.substring(0, i) + s.substring(i + 1);
				i--;
			}
		}
		System.out.print(s);
	}
	
	// Driver code
	public static void main(String[] args)
	{
		String s = "$Gee*k;s..fo, r'Ge^eks?";
		removeSpecialCharacter(s);
	}
}

