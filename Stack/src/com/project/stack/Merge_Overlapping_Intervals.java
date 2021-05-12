package com.project.stack;

/**
 * For example, let the given set of intervals be {{1,3}, {2,4}, {5,7}, {6,8}}.
 * The intervals {1,3} and {2,4} overlap with each other, so they should be
 * merged and become {1, 4}. Similarly, {5, 7} and {6, 8} should be merged and
 * become {5, 8}
 * 
 * 1) Sort all intervals in increasing order of start time.
2) Traverse sorted intervals starting from first interval, 
   do following for every interval.
      a) If current interval is not first interval and it 
         overlaps with previous interval, then merge it with
         previous interval. Keep doing it while the interval
         overlaps with the previous one.         
      b) Else add current interval to output list of intervals.
 */
//Java program to merge overlapping Intervals in
//O(n Log n) time and O(1) extra space

import java.util.Arrays;
import java.util.Comparator;

//An Interval
class Interval
{
	int start,end;
	
	Interval(int start, int end)
	{
		this.start=start;
		this.end=end;
	}
}

public class Merge_Overlapping_Intervals {
	
	// Function that takes a set of intervals, merges
	// overlapping intervals and prints the result
	public static void mergeIntervals(Interval arr[])
	{
		// Sort Intervals in decreasing order of
		// start time
		Arrays.sort(arr,new Comparator<Interval>(){
			public int compare(Interval i1,Interval i2)
			{
				return i2.start - i1.start;
			}
		});

		int index = 0; // Stores index of last element
		// in output array (modified arr[])

		// Traverse all input Intervals
		for (int i=1; i<arr.length; i++)
		{
			// If this is not first Interval and overlaps
			// with the previous one
			if (arr[index].end >= arr[i].start)
			{
				// Merge previous and current Intervals
				arr[index].end = Math.max(arr[index].end, arr[i].end);
				arr[index].start = Math.min(arr[index].start, arr[i].start);
			}
			else {
				index++;
				arr[index] = arr[i];
			}
		}
		
		// Now arr[0..index-1] stores the merged Intervals
		System.out.print("The Merged Intervals are: ");
		for (int i = 0; i <= index; i++)
		{
			System.out.print("[" + arr[i].start + ","
										+ arr[i].end + "]");
		}
	}

	// Driver Code
	public static void main(String args[]) {
		Interval arr[]=new Interval[4];
		arr[0]=new Interval(6,8);
		arr[1]=new Interval(1,9);
		arr[2]=new Interval(2,4);
		arr[3]=new Interval(4,7);
		mergeIntervals(arr);
	}
}
