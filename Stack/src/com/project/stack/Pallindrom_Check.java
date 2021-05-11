package com.project.stack;

import java.util.Stack;
public class Pallindrom_Check {
	
	public static boolean isPallindrome(String str)
	{
		char[] input = str.toCharArray();
		Stack<Character> stack = new Stack<>();
		int i=0;
		while(input[i] != 'X') {
			stack.push(input[i]);
			i++;
		}
		i++;
		while(i<input.length) {
			if(stack.isEmpty()) return false;
			if(input[i]!=stack.pop().charValue()) return false;;
			i++;
		}
		return true;
	}
	
	public static void main(String[] args) {
		String str = "malayalamXmalayalam";
		boolean result = isPallindrome(str);
		System.out.println("The answer is : "+result);
	}

}
