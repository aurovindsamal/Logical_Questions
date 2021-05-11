package com.project.stack;

/**
 Given two expressions in the form of strings. The task is to compare them and check if they are similar. Expressions consist of lowercase alphabets, ‘+’, ‘-‘ and ‘( )’.
Examples: 
 

Input  : exp1 = "-(a+b+c)"
         exp2 = "-a-b-c"
Output : Yes

Input  : exp1 = "-(c+b+a)"
         exp2 = "-c-b-a"
Output : Yes

Input  : exp1 = "a-b-(c-d)"
         exp2 = "a-b-c-d"
Output : No
 */
//Java program to check if two expressions
//evaluate to same.
import java.io.*;
import java.util.Stack;

public class Check_if_two_expressions_with_brackets_are_same
{

	static final int MAX_CHAR = 26;

	// Return local sign of the operand. For example,
	// in the expr a-b-(c), local signs of the operands
	// are +a, -b, +c
	static boolean adjSign(String s, int i)
	{
		if (i == 0)
			return true;
		if (s.charAt(i - 1) == '-')
			return false;
		return true;
	};

	// Evaluate expressions into the count vector of
	// the 26 alphabets.If add is true, then add count
	// to the count vector of the alphabets, else remove
	// count from the count vector.
	static void eval(String s, int[] v, boolean add)
	{

		// stack stores the global sign
		// for operands.
		Stack<Boolean> stk = new Stack<>();
		stk.push(true);

		// + means true
		// global sign is positive initially

		int i = 0;
		while (i < s.length())
		{
			if (s.charAt(i) == '+' || s.charAt(i) == '-')
			{
				i++;
				continue;
			}
			if (s.charAt(i) == '(')
			{

				// global sign for the bracket is
				// pushed to the stack
				if (adjSign(s, i))
					stk.push(stk.peek());
				else
					stk.push(!stk.peek());
			}

			// global sign is popped out which
			// was pushed in for the last bracket
			else if (s.charAt(i) == ')')
				stk.pop();

			else
			{

				// global sign is positive (we use different
				// values in two calls of functions so that
				// we finally check if all vector elements
				// are 0.
				if (stk.peek())
					v[s.charAt(i) - 'a'] += (adjSign(s, i) ?
							add ? 1 : -1 : add ? -1 : 1);

				// global sign is negative here
				else
					v[s.charAt(i) - 'a'] += (adjSign(s, i) ?
								add ? -1 : 1 : add ? 1 : -1);
			}
			i++;
		}
	};

	// Returns true if expr1 and expr2 represent
	// same expressions
	static boolean areSame(String expr1, String expr2)
	{

		// Create a vector for all operands and
		// initialize the vector as 0.
		int[] v = new int[MAX_CHAR];

		// Put signs of all operands in expr1
		eval(expr1, v, true);

		// Subtract signs of operands in expr2
		eval(expr2, v, false);

		// If expressions are same, vector must
		// be 0.
		for (int i = 0; i < MAX_CHAR; i++)
			if (v[i] != 0)
				return false;

		return true;
	}

	// Driver Code
	public static void main(String[] args)
	{

		String expr1 = "a-b-(c-d)", expr2 = "a-b-c+d";
		if (areSame(expr1, expr2))
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}

//This code is contributed by
//sanjeev2552
