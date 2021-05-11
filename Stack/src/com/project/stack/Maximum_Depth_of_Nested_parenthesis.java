package com.project.stack;

//Java program to find the maximum depth of nested
//parenthesis in a given expression

/**
 1) Take two variables max and current_max, initialize both of them as 0.
2) Traverse the string, do following for every character
    a) If current character is ‘(’, increment current_max and 
       update max value if required.
    b) If character is ‘)’. Check if current_max is positive or
       not (this condition ensure that parenthesis are balanced). 
       If positive that means we previously had a ‘(’ character 
       so decrement current_max without worry. 
       If not positive then the parenthesis are not balanced. 
       Thus return -1. 
3) If current_max is not 0, then return -1 to ensure that the parenthesis
   are balanced. Else return max
 */
public class Maximum_Depth_of_Nested_parenthesis {
//function takes a string and returns the
//maximum depth nested parenthesis

	static int maxDepth(String S) {
		int current_max = 0; // current count
		int max = 0; // overall maximum count
		int n = S.length();

		// Traverse the input string
		for (int i = 0; i < n; i++) {
			if (S.charAt(i) == '(') {
				current_max++;

				// update max if required
				if (current_max > max) {
					max = current_max;
				}
			} else if (S.charAt(i) == ')') {
				if (current_max > 0) {
					current_max--;
				} else {
					return -1;
				}
			}
		}

		// finally check for unbalanced string
		if (current_max != 0) {
			return -1;
		}

		return max;
	}

//Driver program
	public static void main(String[] args) {
		String s = "( ((X)) (((Y))) )";
		System.out.println(maxDepth(s));
	}
}

