package com.project.stack;

import java.util.Stack;

/**
 * Algorithm a) Create a stack. b) while (end of input is not reached) 1) If the
 * character read is not a symbol to be balanced, ignore it. 2) If the character
 * is an opening symbol like (, [, {, push it onto the stack 3) If it is a
 * closing symbol like ),],}, then if the stack is empty report an error.
 * Otherwise pop the stack. 4) If the symbol popped is not the corresponding
 * opening symbol, report an error. c) At end of input, if the stack is not
 * empty report an error
 */
public class Balanced_Paranthesis {

	public static boolean isValidParenthesis(String str) {
		Stack<Character> stack = new Stack<>();
		if (str == null || str.length() == 0)
			return true;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ')') {
				if (!stack.isEmpty() && stack.peek() == '(') {
					stack.pop();
				} else
					return false;
			} else if (str.charAt(i) == '}') {
				if (!stack.isEmpty() && stack.peek() == '{') {
					stack.pop();
				} else
					return false;
			} else if (str.charAt(i) == ']') {
				if (!stack.isEmpty() && stack.peek() == '[') {
					stack.pop();
				} else
					return false;
			} else {
				stack.push(str.charAt(i));
			}
		}
		if (stack.isEmpty())
			return true;
		else
			return false;

	}

	public static void main(String[] args) {
		String str = "[()]{}{[()()]()}";
		System.out.println("The string is a valid parenthesis : "+isValidParenthesis(str));

	}

}
