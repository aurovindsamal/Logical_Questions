package com.project.stack;

/**
 Input : 4 19 7 14 20
Output : Max Values in stack are 
         4 19 19 19 20

Input : 40 19 7 14 20 5
Output :  Max Values in stack are 
         40 40 40 40 40 40
 */
//Java program to keep track of maximum
//element in a stack
import java.util.Stack;

public class Tracking_current_Maximum_Element_in_a_Stack {

	static class StackWithMax {
		// main stack
		static Stack<Integer> mainStack = new Stack<Integer>();

		// tack to keep track of max element
		static Stack<Integer> trackStack = new Stack<Integer>();

		static void push(int x) {
			mainStack.push(x);
			if (mainStack.size() == 1) {
				trackStack.push(x);
				return;
			}

			// If current element is greater than
			// the top element of track stack, push
			// the current element to track stack
			// otherwise push the element at top of
			// track stack again into it.
			if (x > trackStack.peek())
				trackStack.push(x);
			else
				trackStack.push(trackStack.peek());
		}

		static int getMax() {
			return trackStack.peek();
		}

		static void pop() {
			mainStack.pop();
			trackStack.pop();
		}
	};

//Driver program to test above functions
	public static void main(String[] args) {
		StackWithMax s = new StackWithMax();
		s.push(20);
		System.out.println(s.getMax());
		s.push(10);
		System.out.println(s.getMax());
		s.push(50);
		System.out.println(s.getMax());
	}
}
