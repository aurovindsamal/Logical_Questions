package com.projects.linkedlist;

/**
 Given a linked list handling string data, check to see whether data is palindrome or not?
For example,

Input  : a -> bc -> d -> dcb -> a -> NULL
Output : True
String "abcddcba" is palindrome.

Output : a -> bc -> d -> ba -> NULL
Output : False
String "abcdba" is not palindrome. 
 */
//Java Program to check if a given linked list of strings
//form a palindrome

import java.util.Scanner;

//Linked List node
public class linked_list_strings_forms_palindrome
{
	String data;
	linked_list_strings_forms_palindrome next;

	linked_list_strings_forms_palindrome(String d)
	{
		data = d;
		next = null;
	}
}

class LinkedList_Palindrome
{
	linked_list_strings_forms_palindrome head;

	// A utility function to check if str is palindrome
	// or not
	boolean isPalidromeUtil(String str)
	{
		int length = str.length();

		// Match characters from beginning and
		// end.
		for (int i=0; i<length/2; i++)
			if (str.charAt(i) != str.charAt(length-i-1))
				return false;

		return true;
	}

	// Returns true if string formed by linked
	// list is palindrome
	boolean isPalindrome()
	{
		linked_list_strings_forms_palindrome node = head;

		// Append all nodes to form a string
		String str = "";
		while (node != null)
		{
			str = str.concat(node.data);
			node = node.next;
		}

		// Check if the formed string is palindrome
		return isPalidromeUtil(str);
	}

	/* Driver program to test above function*/
	public static void main(String[] args)
	{
		LinkedList_Palindrome list = new LinkedList_Palindrome();
		list.head = new linked_list_strings_forms_palindrome("a");
		list.head.next = new linked_list_strings_forms_palindrome("bc");
		list.head.next.next = new linked_list_strings_forms_palindrome("d");
		list.head.next.next.next = new linked_list_strings_forms_palindrome("dcb");
		list.head.next.next.next.next = new linked_list_strings_forms_palindrome("a");

		System.out.println(list.isPalindrome());

	}
}

