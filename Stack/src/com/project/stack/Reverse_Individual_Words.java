package com.project.stack;

//Java program to reverse individual
//words in a given string using STL list
import java.io.*;
import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

public class Reverse_Individual_Words {

//reverses individual words of a string
	static void reverseWords(String str) {
		Stack<Character> st = new Stack<Character>();

		// Traverse given string and push all
		// characters to stack until we see a space.
		for (int i = 0; i < str.length(); ++i) {
			if (str.charAt(i) != ' ')
				st.push(str.charAt(i));

			// When we see a space, we print
			// contents of stack.
			else {
				while (st.empty() == false) {
					System.out.print(st.pop());

				}
				System.out.print(" ");
			}
		}

		// Since there may not be space after
		// last word.
		while (st.empty() == false) {
			System.out.print(st.pop());

		}
	}
	
	

//Driver program to test above function
	public static void main(String[] args) {
		String str = "Geeks for Geeks";
		reverseWords(str);
		
		String result = Arrays.asList(str.split(" "))
                .stream()
                .map(s -> new StringBuilder(s).reverse())
                .collect(Collectors.joining(" "));
		System.out.println(result);
	}
}
