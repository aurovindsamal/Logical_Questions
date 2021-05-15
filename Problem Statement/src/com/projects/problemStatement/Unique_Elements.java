package com.projects.problemStatement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
 Find all unique triplets in the array which gives the sum of zero.
 *
 */
public class Unique_Elements {

	public List<List<Integer>> threeSum(int[] nums) {
	    Arrays.sort(nums);
	 
	    ArrayList<List<Integer>> result = new ArrayList<>();
	 
	    for (int i = 0; i < nums.length; i++) {
	        int j = i + 1;
	        int k = nums.length - 1;
	 
	        if (i > 0 && nums[i] == nums[i - 1]) {
	            continue;
	        }
	 
	        while (j < k) {
	            if (k < nums.length - 1 && nums[k] == nums[k + 1]) {
	                k--;
	                continue;
	            }
	 
	            if (nums[i] + nums[j] + nums[k] > 0) {
	                k--;
	            } else if (nums[i] + nums[j] + nums[k] < 0) {
	                j++;
	            } else {
	                ArrayList<Integer> l = new ArrayList<>();
	                l.add(nums[i]);
	                l.add(nums[j]);
	                l.add(nums[k]);
	                result.add(l);
	                j++;
	                k--;
	            }
	        }
	    }
	 
	    return result;
	}
	
	public static void main(String[] args) {
		
		Unique_Elements uq = new Unique_Elements();
		int array[] = {1,2,5,6,8,3,-2,-3};
		List<List<Integer>> threeSum = uq.threeSum(array);
		System.out.println("the elements are: ");
		System.out.println("[");
		for (List<Integer> list : threeSum) {
            System.out.print("  [");
            for (Integer item : list) {
                System.out.print("  " + item + ", ");
            }
            System.out.println("], ");
        }
        System.out.println("]");

	}

}
