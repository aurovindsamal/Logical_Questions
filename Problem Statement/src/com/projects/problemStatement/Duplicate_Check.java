package com.projects.problemStatement;

import java.util.HashSet;

public class Duplicate_Check {
	
	public static boolean containsDuplicate(int[] nums) {
	    if(nums==null || nums.length==0)
	        return false;
	 
	    HashSet<Integer> set = new HashSet<Integer>();
	    for(int i: nums){
	        if(!set.add(i)){
	            return true;
	        }
	    }
	 
	    return false;
	}
	
	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5,6,6};
		Boolean result = containsDuplicate(arr);
		System.out.println(result);
	}


}
