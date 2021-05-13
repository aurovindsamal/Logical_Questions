package com.projects.strings;

/**
 Input : 007462542X
Output : Valid
007462542X = 10*0 + 9*0 + 8*7 + 7*4 + 6*6 + 
        5*2 + 4*5 + 3*4 + 2*2 + 1*10 = 176
Since 55 leaves no remainder when divided 
by 11, hence it is a valid ISBN.

Input : 0112112425
Output : Invalid
0112112425 = 10*0 + 9*1 + 8*1 + 7*2 + 6*1 +
           5*1 + 4*1 + 3*4 + 2*2 + 1*5 = 71
Since 71 is not divisible by 11, given number
is not a valid ISBN.
 */
//Java program to check if
//a given ISBN isvalid or not

public class Valid_ISBN
{
	static boolean isValidISBN(String isbn)
	{
		// length must be 10
		int n = isbn.length();
		if (n != 10)
			return false;

		// Computing weighted sum
		// of first 9 digits
		int sum = 0;
		for (int i = 0; i < 9; i++)
		{
			int digit = isbn.charAt(i) - '0';
			if (0 > digit || 9 < digit)
				return false;
			sum += (digit * (10 - i));
		}

		// Checking last digit.
		char last = isbn.charAt(9);
		if (last != 'X' && (last < '0' ||
							last > '9'))
			return false;

		// If last digit is 'X', add 10
		// to sum, else add its value
		sum += ((last == 'X') ? 10 : (last - '0'));

		// Return true if weighted sum
		// of digits is divisible by 11.
		return (sum % 11 == 0);
	}

	// Driver code
	public static void main(String[] args)
	{
		String isbn = "007462542X";
		if (isValidISBN(isbn))
			System.out.print("Valid");
		else
			System.out.print("Invalid");
	}
}

