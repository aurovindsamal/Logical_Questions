package com.projects.strings;

//Java program to count number of substrings
//of a string
import java.io.*;

public class Number_of_substrings_of_string {
	
	static int countNonEmptySubstr(String str)
	{
		int n = str.length();
		return n * (n + 1) / 2;
	}
	
	// Driver code
	public static void main(String args[])
	{
		String s = "abcde";
		System.out.println(
				countNonEmptySubstr(s));
	}
}

