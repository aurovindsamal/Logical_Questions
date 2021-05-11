package com.project.stack;

/**
 Input : ab aa aa bcd ab
Output : 3
As aa, aa destroys each other so, ab bcd ab is the
new sequence.

Input :  tom jerry jerry tom
Output : 0
As first both jerry will destroy each other.
Then sequence will be tom, tom they will also destroy
each other. So, the final sequence doesn't contain any
word.
 */
//Java implementation of above method

import java.util.Stack;
import java.util.Vector;

public class Delete_consecutive_same_words_in_a_sequence
{
	// Method to find the size of manipulated sequence
	static int removeConsecutiveSame(Vector <String> v)
	{
		Stack<String> st = new Stack<>();
	
		// Start traversing the sequence
		for (int i=0; i<v.size(); i++)
		{
			// Push the current string if the stack
			// is empty
			if (st.empty())
				st.push(v.get(i));
			else
			{
				String str = st.peek();
	
				// compare the current string with stack top
				// if equal, pop the top
				if (str.equals(v.get(i)))	
					st.pop();
	
				// Otherwise push the current string
				else
					st.push(v.get(i));
			}
		}
	
		// Return stack size
		return st.size();
	}
	
	// Driver method
	public static void main(String[] args)
	{
		Vector<String> v = new Vector<>();
		
		v.addElement("ab"); v.addElement("aa");
		v.addElement("aa");v.addElement("bcd");
		v.addElement("ab");
		
		System.out.println(removeConsecutiveSame(v));
	}
}
