package com.project.stack;

import java.util.Stack;

/**
 * Algorithm 1. Scan the infix expression from left to right. 2. If the scanned
 * character is an operand, output it. 3. Else, 1 If the precedence of the
 * scanned operator is greater than the precedence of the operator in the
 * stack(or the stack is empty or the stack contains a ‘(‘ ), push it. 2 Else,
 * Pop all the operators from the stack which are greater than or equal to in
 * precedence than that of the scanned operator. After doing that Push the
 * scanned operator to the stack. (If you encounter parenthesis while popping
 * then stop there and push the scanned operator in the stack.) 4. If the
 * scanned character is an ‘(‘, push it to the stack. 5. If the scanned
 * character is an ‘)’, pop the stack and output it until a ‘(‘ is encountered,
 * and discard both the parenthesis. 6. Repeat steps 2-6 until infix expression
 * is scanned. 7. Print the output 8. Pop and output from the stack until it is
 * not empty.
 **/
public class Infix_To_Postfix {

	static int precedence(char c) {
		switch (c) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '^':
			return 3;
		}
		return -1;
	}

	static String infixToPostFix(String expression) {

		String result = "";
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < expression.length(); i++) {
			char c = expression.charAt(i);

			// check if char is operator
			if (precedence(c) > 0) {
				while (stack.isEmpty() == false && precedence(stack.peek()) >= precedence(c)) {
					result += stack.pop();
				}
				stack.push(c);
			} else if (c == ')') {
				char x = stack.pop();
				while (x != '(') {
					result += x;
					x = stack.pop();
				}
			} else if (c == '(') {
				stack.push(c);
			} else {
				// character is neither operator nor (
				result += c;
			}
		}
		for (int i = 0; i <= stack.size(); i++) {
			result += stack.pop();
		}
		return result;
	}

	public static void main(String[] args) {
		String exp = "a+b*(c^d-e)^(f+g*h)-i";
		System.out.println("Infix Expression: " + exp);
		System.out.println("Postfix Expression: " + infixToPostFix(exp));
	}
}