package com.projects.strings;

/**
 Input  : ABCXYZACCD
Output : ABC
         XYZ
         A
         C
         CD

Input : ABCZYXACCD
Output: ABC
        ZYX
        A
        C
        CD
 */
//Java program to print consecutive characters
//together in a line.
public class Consecutive_characters {

	static void print(String str1) {
		char str[] = str1.toCharArray();
		System.out.print(str[0]);
		for (int i = 1; i < str.length; i++) {
			if ((str[i] == str[i - 1] + 1)
					|| (str[i] == str[i - 1] - 1)) {
				System.out.print(str[i]);
			} else {
				System.out.print("\n" + str[i]);
			}
		}
	}

//Driver code
	public static void main(String[] args) {
		String str = "ABCXYZACCD";
		print(str);
	}
}

