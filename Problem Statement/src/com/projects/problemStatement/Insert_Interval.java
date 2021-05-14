package com.projects.problemStatement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 Input: Set : [1, 3], [6, 9]
        New Interval : [2, 5] 
Output: [1, 5], [6, 9]
The correct position to insert new interval 
[2, 5] is between the two given intervals. 
The resulting set would have been 
[1, 3], [2, 5], [6, 9], but the intervals 
[1, 3], [2, 5] are overlapping. So, they are 
merged together in one interval [1, 5]. 

Input: Set : [1, 2], [3, 5], [6, 7], [8, 10], [12, 16]
        New Interval : [4, 9]
Output: [1, 2], [3, 10], [12, 16]
First the interval is inserted between intervals 
[3, 5] and [6, 7]. Then overlapping intervals are 
merged together in one interval.
 */
public class Insert_Interval {
	
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
	    List<Interval> result = new ArrayList<>();
	 
	    if (intervals.size() == 0) {
	        result.add(newInterval);
	        return result;
	    }
	 
	    int p = helper(intervals, newInterval);
	    result.addAll(intervals.subList(0, p));
	 
	    for (int i = p; i < intervals.size(); i++) {
	        Interval interval = intervals.get(i);
	        if (interval.end < newInterval.start) {
	            result.add(interval);
	        } else if (interval.start > newInterval.end) {
	            result.add(newInterval);
	            newInterval = interval;
	        } else if (interval.end >= newInterval.start || interval.start <= newInterval.end) {
	            newInterval = new Interval(Math.min(interval.start, newInterval.start), Math.max(newInterval.end, interval.end));
	        }
	    }
	 
	    result.add(newInterval);
	return result;
	}
	 
	public int helper(List<Interval> intervals, Interval newInterval) {
	    int low = 0;
	    int high = intervals.size() - 1;
	 
	    while (low < high) {
	        int mid = low + (high - low) / 2;
	 
	        if (newInterval.start <= intervals.get(mid).start) {
	            high = mid;
	        } else {
	            low = mid + 1;
	        }
	    }
	 
	    return high == 0 ? 0 : high - 1;
	}
	
	public static void main(String[] args) {
		Interval arrnew[]=new Interval[5];
		arrnew[0]=new Interval(1, 2);
		arrnew[1]=new Interval(3,5);
		arrnew[2]=new Interval(6,7);
		arrnew[3]=new Interval(8,10);
		arrnew[3]=new Interval(12,16);
		Insert_Interval ih = new Insert_Interval();
		Interval newInterval = new Interval(4, 9);
		ih.insert(Arrays.asList(arrnew), newInterval);
		
	}


}
