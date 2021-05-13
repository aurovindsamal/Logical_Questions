package com.projects.strings;

/**
 Starting from the rightmost digit, double the value of every second digit (e.g., 7 becomes 14).
If doubling of a number results in a two digits number i.e greater than 9(e.g., 7 × 2 = 14), then add the digits of the product (e.g., 14: 1 + 4 = 5), to get a single digit number.
Now take the sum of all the digits.
Check if the sum is divisible by 10 i.e.(total modulo 10 is equal to 0) then the IMEI number is valid; else it is not valid.
 */
//Java program to check whether the
//given EMEI number is valid or not.
import java.io.*;
public class Valid_IMEI_Number
{
	// Function for finding and returning
	// sum of digits of a number
	static int sumDig(int n)
	{
		int a = 0;
		while (n > 0)
		{
			a = a + n % 10;
			n = n / 10;
		}
		return a;
	}

	static boolean isValidIMEI(long n)
	{
		// Converting the number into String
		// for finding length
		String s = Long.toString(n);
		int len = s.length();

		if (len != 15)
			return false;

		int sum = 0;
		for (int i = len; i >= 1; i--)
		{
			int d = (int)(n % 10);

			// Doubling every alternate digit
			if (i % 2 == 0)
				d = 2 * d;

			// Finding sum of the digits
			sum += sumDig(d);
			n = n / 10;
		}

		return (sum % 10 == 0);
	}

	// Driver code
	public static void main(String args[]) throws IOException
	{
		// 15 digits cannot be stored in 'int' data type
		long n = 490154203237518L;

		if (isValidIMEI(n))
			System.out.println("Valid IMEI Code");
		else
			System.out.println("Invalid IMEI Code");

	}
}

