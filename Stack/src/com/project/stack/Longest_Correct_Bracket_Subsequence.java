package com.project.stack;

//Java code to answer the query in constant time
import java.util.Stack;

public class Longest_Correct_Bracket_Subsequence{

/*
BOP[] stands for "Balanced open parentheses"
BCP[] stands for "Balanced close parentheses"

*/

//Function for precomputation
static void constructBlanceArray(int BOP[], int BCP[],
								String str, int n)
{
	
	// Create a stack and push -1
	// as initial index to it.
	Stack<Integer> stk = new Stack<>();;

	// Traverse all characters of given String
	for(int i = 0; i < n; i++)
	{
		
		// If opening bracket, push index of it
		if (str.charAt(i) == '(')
			stk.add(i);
			
		// If closing bracket, i.e., str[i] = ')'
		else
		{
			
			// If closing bracket, i.e., str[i] = ')'
			// && stack is not empty then mark both
			// "open & close" bracket indexs as 1 .
			// Pop the previous opening bracket's index
			if (!stk.isEmpty())
			{
				BCP[i] = 1;
				BOP[stk.peek()] = 1;
				stk.pop();
			}

			// If stack is empty.
			else
				BCP[i] = 0;
		}
	}

	for(int i = 1; i < n; i++)
	{
		BCP[i] += BCP[i - 1];
		BOP[i] += BOP[i - 1];
	}
}

//Function return output of each query in O(1)
static int query(int BOP[], int BCP[],
				int s, int e)
{
	if (BOP[s - 1] == BOP[s])
	{
		return (BCP[e] - BOP[s]) * 2;
	}
	else
	{
		return (BCP[e] - BOP[s] + 1) * 2;
	}
}

//Driver code
public static void main(String[] args)
{

	String str = "())(())(())(";
	int n = str.length();

	int BCP[] = new int[n + 1];
	int BOP[] = new int[n + 1];

	constructBlanceArray(BOP, BCP, str, n);

	int startIndex = 5, endIndex = 11;
	System.out.print("Maximum Length Correct " +
					"Bracket Subsequence between " +
					startIndex + " and " + endIndex +
					" = " + query(BOP, BCP, startIndex,
								endIndex) + "\n");

	startIndex = 4;
	endIndex = 5;
	System.out.print("Maximum Length Correct " +
					"Bracket Subsequence between " +
					startIndex + " and " + endIndex +
					" = " + query(BOP, BCP, startIndex,
								endIndex) + "\n");

	startIndex = 1;
	endIndex = 5;
	System.out.print("Maximum Length Correct " +
					"Bracket Subsequence between " +
					startIndex + " and " + endIndex +
					" = " + query(BOP, BCP, startIndex,
								endIndex) + "\n");
}
}

//This code is contributed by 29AjayKumar

