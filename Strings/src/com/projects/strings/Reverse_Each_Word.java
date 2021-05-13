package com.projects.strings;

import java.util.regex.Pattern;

public class Reverse_Each_Word {
	static void reverseEachWordOfString(String inputString) {
		String[] words = inputString.split(" ");

		String reverseString = "";

		for (int i = 0; i < words.length; i++) {
			String word = words[i];

			String reverseWord = "";

			for (int j = word.length() - 1; j >= 0; j--) {
				reverseWord = reverseWord + word.charAt(j);
			}

			reverseString = reverseString + reverseWord + " ";
		}

		System.out.println(inputString);

		System.out.println(reverseString);

		System.out.println("-------------------------");
	}
	
	static String reverseWords(String str)
    {
  
        // Specifying the pattern to be searched
        Pattern pattern = Pattern.compile("\\s");
  
        // splitting String str with a pattern
        // (i.e )splitting the string whenever their
        //  is whitespace and store in temp array.
        String[] temp = pattern.split(str);
        String result = "";
  
        // Iterate over the temp array and store
        // the string in reverse order.
        for (int i = 0; i < temp.length; i++) {
            if (i == temp.length - 1)
                result = temp[i] + result;
            else
                result = " " + temp[i] + result;
        }
        return result;
    }

	public static void main(String[] args) {
		reverseEachWordOfString("Java Concept Of The Day");

		reverseEachWordOfString("Java J2EE JSP Servlets Hibernate Struts");

		reverseEachWordOfString("I am string not reversed");

		reverseEachWordOfString("Reverse Me");
		
		String reverseWords = reverseWords("Reverse Me");
		System.out.println("Using New Function : "+reverseWords);
	}
}
