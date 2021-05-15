package com.projects.problemStatement;

/**
 * 
 Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order. You may assume no duplicates in the array.
[1,3,5,6], 5 -> 2
[1,3,5,6], 2 -> 1
[1,3,5,6], 7 -> 4

 *
 */
public class Search_Insert_Position {
	
	public int searchInsert(int[] nums, int target) {
	    if(target>nums[nums.length-1]){
	        return nums.length;
	    }
	 
	    int l=0;
	    int r=nums.length-1;
	 
	    while(l<r){
	        int m = l+(r-l)/2;
	        if(target>nums[m]){
	            l=m+1;
	        }else{
	            r=m;
	        }
	    }
	 
	    return l;
	}


}
