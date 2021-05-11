package com.project.stack;

/**
 * Given an expression, find and mark matched and unmatched parenthesis in it. We need to replace all balanced opening parenthesis with 0, balanced closing parenthesis with 1, and all unbalanced with -1.
Examples:  

Input : ((a) 
Output : -10a1

Input : (a))
Output : 0a1-1

Input  : (((abc))((d)))))
Output : 000abc1100d111-1-1
 * @author aurovind.samal
 *
 */
//Java program to mark balanced and
//unbalanced parenthesis.
import java.util.Stack;

public class Identify_and_mark_unmatched_parenthesis_in_an_expression
{
static void identifyParenthesis(StringBuffer a)
{
	Stack<Integer> st = new Stack<Integer>();

	// run the loop upto end of the string
	for (int i = 0; i < a.length(); i++)
	{

		// if a[i] is opening bracket then push
		// into stack
		if (a.charAt(i) == '(')
			st.push(i);
		
		// if a[i] is closing bracket ')'
		else if (a.charAt(i) == ')')
		{

			// If this closing bracket is unmatched
			if (st.empty())
				a.replace(i, i + 1, "-1");
			
			else
			{

				// replace all opening brackets with 0
				// and closing brackets with 1
				a.replace(i, i + 1, "1");
				a.replace(st.peek(), st.peek() + 1, "0");
				st.pop();
			}
		}
	}

	// if stack is not empty then pop out all
	// elements from it and replace -1 at that
	// index of the string
	while (!st.empty())
	{
		a.replace(st.peek(), 1, "-1");
		st.pop();
	}

	// print final string
	System.out.println(a);
}

//Driver code
public static void main(String[] args)
{
	StringBuffer str = new StringBuffer("(a))");
	identifyParenthesis(str);
}
}

//This code is contributed by Princi Singh

