package com.project.stack;

/**
 Below expressions have duplicate parenthesis - 
((a+b)+((c+d)))
The subexpression "c+d" is surrounded by two
pairs of brackets.

(((a+(b)))+(c+d))
The subexpression "a+(b)" is surrounded by two 
pairs of brackets.

(((a+(b))+c+d))
The whole expression is surrounded by two 
pairs of brackets.

Below expressions don't have any duplicate parenthesis -
((a+b)+(c+d)) 
No subsexpression is surrounded by duplicate
brackets.

((a+(b))+(c+d))
No subsexpression is surrounded by duplicate
brackets.
 */
import java.util.Stack;

//Java program to find duplicate parenthesis in a
//balanced expression
public class Find_if_an_expression_has_duplicate_parenthesis_or_not {

//Function to find duplicate parenthesis in a
//balanced expression
	static boolean findDuplicateparenthesis(String s) {
		// create a stack of characters
		Stack<Character> Stack = new Stack<>();

		// Iterate through the given expression
		char[] str = s.toCharArray();
		for (char ch : str) {
			// if current character is close parenthesis ')'
			if (ch == ')') {
				// pop character from the stack
				char top = Stack.peek();
				Stack.pop();

				// stores the number of characters between a
				// closing and opening parenthesis
				// if this count is less than or equal to 1
				// then the brackets are redundant else not
				int elementsInside = 0;
				while (top != '(') {
					elementsInside++;
					top = Stack.peek();
					Stack.pop();
				}
				if (elementsInside < 1) {
					return true;
				}
			} // push open parenthesis '(', operators and
			// operands to stack
			else {
				Stack.push(ch);
			}
		}

		// No duplicates found
		return false;
	}

//Driver code
public static void main(String[] args) {

		// input balanced expression
		String str = "(((a+(b))+(c+d)))";

		if (findDuplicateparenthesis(str)) {
			System.out.println("Duplicate Found ");
		} else {
			System.out.println("No Duplicates Found ");
		}

	}
}

