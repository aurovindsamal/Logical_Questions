package com.projects.strings;
/**
 Input : s = carbohydrates
Output : hsoebtraarcdy

Input : s = sunshine
Output : sennuish
 */
//Java program for creating a string
//by alternately combining the
//characters of two halves
//in reverse
import java.io.*;

public class combining_the_characters {
	
	// Function performing calculations
	public static void solve(String s)
	{
		int l = s.length();
		int x = l / 2;
		int y = l;
	
		// Calculating the two halves of
		// string s as first and second
		// The final string p
		String p = "";
		while (x > 0 && y > l / 2) {
		
			// It joins the characters to
			// final string in reverse order
			char ch = s.charAt(x - 1);
			p += ch;
			x--;
			
			// It joins the characters to
			// final string in reverse order
			ch = s.charAt(y - 1);
			p += ch;
			y--;
		}
		
		if (y > l / 2) {
			char ch = s.charAt(x - 1);
			p += ch;
			y--;
		}
		System.out.println(p);
	}
	
	// Driver method
	public static void main(String args[])
	{
		String s = "sunshine";
		
		// Calling function
		solve(s);
	}
}

