package com.projects.strings;

/**
 nput: s = “geeks quiz practice code” 
Output: s = “code practice quiz geeks”

Input: s = “getting good at coding needs a lot of practice” 
Output: s = “practice of lot a needs coding at good getting” 
 */
//Java program to
//reverse a String
import java.util.*;

public class Reverse_words {

//Reverse the letters
//of the word
	static void reverse(char str[], int start, int end) {
//Temporary variable
//to store character
		char temp;

		while (start <= end) {
			// Swapping the first
			// and last character
			temp = str[start];
			str[start] = str[end];
			str[end] = temp;
			start++;
			end--;
		}
	}

//Function to reverse words
	static char[] reverseWords(char[] s) {
//Reversing individual words as
//explained in the first step

		int start = 0;
		for (int end = 0; end < s.length; end++) {
			// If we see a space, we
			// reverse the previous
			// word (word between
			// the indexes start and end-1
			// i.e., s[start..end-1]
			if (s[end] == ' ') {
				reverse(s, start, end);
				start = end + 1;
			}
		}

//Reverse the last word
		reverse(s, start, s.length - 1);

//Reverse the entire String
		reverse(s, 0, s.length - 1);
		return s;
	}

	public void reverseAnother() {
		String s[] = "i like this program very much".split(" ");
		String ans = "";
		for (int i = s.length - 1; i >= 0; i--) {
			ans += s[i] + " ";
		}
		System.out.println("Reversed String:");
		System.out.println(ans.substring(0, ans.length() - 1));
	}

//Driver Code
	public static void main(String[] args) {
		String s = "i like this program very much ";
		char[] p = reverseWords(s.toCharArray());
		System.out.print(p);
	}
}
