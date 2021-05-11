package com.project.stack;

/**
 Input : "a-(b+c)"
Output : "a-b-c"

Input : "a-(b-c-(d+e))-f"
Output : "a-b+c+d+e-f"
 */
//Java program to simplify algebraic string
import java.util.Stack;
public class Evaluate_Expression {

//Function to simplify the string
static String simplify(String str)
{
	int len = str.length();

	// resultant string of max length equal
	// to length of input string
	char res[] = new char[len];
	int index = 0, i = 0;

	// create empty stack
	Stack<Integer> s = new Stack<Integer> ();
	s.push(0);

	while (i < len) {
		if (str.charAt(i) == '+') {

			// If top is 1, flip the operator
			if (s.peek() == 1)
				res[index++] = '-';

			// If top is 0, append the same operator
			if (s.peek() == 0)
				res[index++] = '+';

		} else if (str.charAt(i) == '-') {
			if (s.peek() == 1)
				res[index++] = '+';
			else if (s.peek() == 0)
				res[index++] = '-';
		} else if (str.charAt(i) == '(' && i > 0) {
			if (str.charAt(i - 1) == '-') {

				// x is opposite to the top of stack
				int x = (s.peek() == 1) ? 0 : 1;
				s.push(x);
			}

			// push value equal to top of the stack
			else if (str.charAt(i - 1) == '+')
				s.push(s.peek());
		}

		// If closing parentheses pop the stack once
		else if (str.charAt(i) == ')')
			s.pop();

		// copy the character to the result
		else
			res[index++] = str.charAt(i);
		i++;
	}
	return new String(res);
}

//Driver program
public static void main(String[] args)
{
	String s1 = "a-(b+c)";
	String s2 = "a-(b-c-(d+e))-f";
	System.out.println(simplify(s1));
	System.out.println(simplify(s2));
}
}

