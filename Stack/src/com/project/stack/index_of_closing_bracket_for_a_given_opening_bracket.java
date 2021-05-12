package com.project.stack;

/**
 Given a string with brackets. If the start index of the open bracket is given, find the index of the closing bracket.

Examples:

Input : string = [ABC[23]][89]
        index = 0
Output : 8
The opening bracket at index 0 corresponds
to closing bracket at index 8.
 */
//Java program to find index of closing
//bracket for given opening bracket.
import java.util.Stack;

public class index_of_closing_bracket_for_a_given_opening_bracket {

//Function to find index of closing
//bracket for given opening bracket.
	static void test(String expression, int index) {
		int i;

		// If index given is invalid and is
		// not an opening bracket.
		if (expression.charAt(index) != '[') {
			System.out.print(expression + ", " + index + ": -1\n");
			return;
		}

		// Stack to store opening brackets.
		Stack<Integer> st = new Stack<>();

		// Traverse through string starting from
		// given index.
		for (i = index; i < expression.length(); i++) {

			// If current character is an
			// opening bracket push it in stack.
			if (expression.charAt(i) == '[') {
				st.push((int) expression.charAt(i));
			} // If current character is a closing
				// bracket, pop from stack. If stack
				// is empty, then this closing
				// bracket is required bracket.
			else if (expression.charAt(i) == ']') {
				st.pop();
				if (st.empty()) {
					System.out.print(expression + ", " + index + ": " + i + "\n");
					return;
				}
			}
		}

		// If no matching closing bracket
		// is found.
		System.out.print(expression + ", " + index + ": -1\n");
	}

//Driver Code
	public static void main(String[] args) {
		test("[ABC[23]][89]", 0); // should be 8
		test("[ABC[23]][89]", 4); // should be 7
		test("[ABC[23]][89]", 9); // should be 12
		test("[ABC[23]][89]", 1); // No matching bracket
	}
}
