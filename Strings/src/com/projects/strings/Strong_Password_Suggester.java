package com.projects.strings;

/**
 Input : keshav123
Output : Suggested Password
k(eshav12G3
keshav1@A23
kesh!Aav123
ke(shav12V3
keGshav1$23
kesXhav@123
keAshav12$3
kesKhav@123
kes$hav12N3
$kesRhav123
 */
//Java code to suggest strong password
import java.io.*;
import java.util.*;
import java.util.Random;

public class Strong_Password_Suggester {

	// adding more characters to suggest
	// strong password
	static StringBuilder add_more_char(
						StringBuilder str, int need)
	{
		int pos = 0;
		Random randm = new Random();
		
		// all 26 letters
		String low_case = "abcdefghijklmnopqrstuvwxyz";

		for (int i = 0; i < need; i++) {
			pos = randm.nextInt(1000) % str.length();
			str.setCharAt(pos,low_case.charAt(
							randm.nextInt(1000) % 26));
		}
		return str;
	}

	// make powerfull String
	static StringBuilder suggester(int l, int u, int d,
							int s, StringBuilder str)
	{
		Random randm = new Random();
		
		// all digits
		String num = "0123456789";

		// all lower case, uppercase and special
		// characters
		String low_case = "abcdefghijklmnopqrstuvwxyz";
		String up_case = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String spl_char = "@#$_()!";

		// position at which place a character
		int pos = 0;

		// if there is no lowercase char in input
		// String, add it
		if (l == 0) {
			
			// generate random integer under
			// String length()
			pos = randm.nextInt(1000) % str.length();

			// generate random integer under 26 for
			// indexing of a to z
			str.setCharAt(pos,low_case.charAt(randm.nextInt(1000)
										% 26));
		}

		// if there is no upper case char in input
		// String, add it
		if (u == 0) {
			pos = randm.nextInt(1000) % str.length();
			str.setCharAt(pos,low_case.charAt(randm.nextInt(1000)
										% 26));
		}

		// if there is no digit in input String, add it
		if (d == 0) {
			pos = randm.nextInt(1000) % str.length();
			str.setCharAt(pos,low_case.charAt(randm.nextInt(1000)
										% 10));
		}

		// if there is no special character in input
		// String, add it
		if (s == 0) {
			pos = randm.nextInt(1000) % str.length();
			str.setCharAt(pos,low_case.charAt(randm.nextInt(1000)
										% 7));
		}

		return str;
	}

	/* make_password function :This function is used
	to check strongness and if input String is not
	strong, it will suggest*/
	static void generate_password(int n, StringBuilder p)
	{
		
		// flag for lower case, upper case, special
		// characters and need of more characters
		int l = 0, u = 0, d = 0, s = 0, need = 0;

		// password suggestions.
		StringBuilder suggest;

		for (int i = 0; i < n; i++) {
			
			// password suggestions.
			if (p.charAt(i) >= 97 && p.charAt(i) <= 122)
				l = 1;
			else if (p.charAt(i) >= 65 && p.charAt(i) <= 90)
				u = 1;
			else if (p.charAt(i) >= 48 && p.charAt(i) <= 57)
				d = 1;
			else
				s = 1;
		}

		// Check if input String is strong that
		// means all flag are active.
		if ((l + u + d + s) == 4) {
			System.out.println("Your Password is Strong");
			return;
		}
		else
			System.out.println("Suggested password ");

		/*suggest 10 strong Strings */
		for (int i = 0; i < 10; i++) {
			suggest = suggester(l, u, d, s, p);
			need = 8 - suggest.length();
			if (need > 0)
				suggest = add_more_char(suggest, need);
			System.out.println(suggest);;
		}
	}

	// Driver code
	public static void main(String[] args)
	{
		StringBuilder input_String = new StringBuilder("geek@2018");
		generate_password(input_String.length(), input_String);
	}
}

