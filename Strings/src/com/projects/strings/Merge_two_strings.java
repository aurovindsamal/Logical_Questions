package com.projects.strings;

//Java program to merge
//n number of strings
import java.io.*;
public class Merge_two_strings {
	// Function performing calcuations
	public static void solve(String a,
							String b, int k)
	{
		String s = "";

		// Length of string a
		int la = a.length();

		// Length f string b
		int lb = b.length();
		int l = la + lb;

		// Pointers for string a and string b
		int indexa = 0, indexb = 0;
		while (l > 0) {

			// pa and pb denote the number
			// of characters of both
			// a and b extracted
			int pa = 0, pb = 0;

			// If entire substring of
			// length k can be extracted
			if (la - indexa >= k) {
				s = s + a.substring(indexa, indexa + k);
				indexa = indexa + k;
				pa = k;
			}

			// If the remaining string is
			// of length less than k
			else if (la - indexa < k && la - indexa > 0) {
				s = s + a.substring(indexa, la);
				pa = la - indexa;
				indexa = la;
			}

			// If the string has been
			// traversed
			else if (indexa >= la)
				pa = 0;

			// If entire substring of
			// length k can be extracted
			if (lb - indexb >= k) {
				s = s + b.substring(indexb, indexb + k);
				pb = k;
				indexb = indexb + k;
			}

			// If the remaining string
			// is of length less than k
			else if (lb - indexb < k && lb - indexb > 0) {
				s = s + b.substring(indexb, lb);
				pb = lb - indexb;
				indexb = lb;
			}

			// If the string has been
			// traversed
			else if (indexb >= lb)
				pb = 0;
			l = l - pa - pb;
		}
		System.out.println(s);
	}

	// Driver function
	public static void main(String args[])
		throws IOException
	{
		String a = "determination", b = "stance";
		int k = 3;
		solve(a, b, k);
	}
}
