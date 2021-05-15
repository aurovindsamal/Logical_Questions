package com.projects.problemStatement;

import java.util.ArrayList;
import java.util.List;

public class Majority_Element {

	// Given an array of size n, find the majority element. The majority element is
	// the element that appears more than ⌊ n/2 ⌋ times.
	// (assume that the array is non-empty and the majority element always exist in
	// the array.)
	public int majorityElementhalf(int[] nums) {
		int result = 0, count = 0;

		for (int i = 0; i < nums.length; i++) {
			if (count == 0) {
				result = nums[i];
				count = 1;
			} else if (result == nums[i]) {
				count++;
			} else {
				count--;
			}
		}

		return result;
	}
	
	//Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. 
	//The algorithm should run in linear time and in O(1) space.
	public List<Integer> majorityElement(int[] nums) {
	    List<Integer> result = new ArrayList<>();
	 
	    Integer n1 = null, n2 = null;
	    int c1 = 0, c2 = 0;
	 
	    for (int i : nums) {
	        if (n1 != null && i == n1.intValue()) {
	            c1++;
	        } else if (n2 != null && i == n2.intValue()) {
	            c2++;
	        } else if (c1 == 0) {
	            c1 = 1;
	            n1 = i;
	        } else if (c2 == 0) {
	            c2 = 1;
	            n2 = i;
	        } else {
	            c1--;
	            c2--;
	        }
	    }
	 
	    c1 = c2 = 0;
	 
	    for (int i : nums) {
	        if (i == n1.intValue()) {
	            c1++;
	        } else if (i == n2.intValue()) {
	            c2++;
	        }
	    }
	 
	    if (c1 > nums.length / 3)
	        result.add(n1);
	    if (c2 > nums.length / 3)
	        result.add(n2);
	 
	    return result;
	}

}
