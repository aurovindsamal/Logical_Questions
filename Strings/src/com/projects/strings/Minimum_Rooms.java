package com.projects.strings;

/**
 There are n student groups at the school. On each day in school, there are m time slots. A student group may or may not be free during a time slot. We are given n binary string where each binary string is of length m. A character at j-th position in i-th string is 0 if i-th group is free in j-th slot and 1 if i-th group is busy.

Our task is to determine the minimum number of rooms needed to hold classes for all groups on a single study day. Note that one room can hold at most one group class in a single time slot.

Examples:

Input : n = 2, m = 7, slots[] = {“0101010”, “1010101”}
Output : 1
Explanation : Both group can hold their classes in a single room as they have alternative classes.

Input : n = 3, m = 7, slots[] = {“0101011”, “0011001”, “0110111”}
Output : 3
 */
//java program to find the minimum number
//of rooms required
public class Minimum_Rooms {

	// Returns minimum number of rooms required
	// to perform classes of n groups in m slots
	// with given schedule.
	static int findMinRooms(String slots[],
								int n, int m)
	{
		
		// Store number of class happening in
		//empty slot
		int counts[] = new int[m];
		
		//initilize all values to zero
		for (int i = 0; i < m; i++)
			counts[i] = 0;
		
		for (int i = 0; i < n; i++)	
			for (int j = 0; j < m; j++)		
				if (slots[i].charAt(j) == '1')
					counts[j]++;
		
		// Number of rooms required is equal to
		// maximum classes happening in a
		// particular slot.
		
		int max = -1;
		// find the max element
		for (int i = 0; i < m; i++)
			if(max < counts[i])
				max = counts[i];
		
		return max;
	}
	
	// Driver Code
	public static void main(String args[])
	{
		int n = 3, m = 7;
		String slots[] = { "0101011",
						"0011001",
						"0110111" };
		System.out.println( findMinRooms(slots, n, m));
	}
}

