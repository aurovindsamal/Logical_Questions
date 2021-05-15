package com.projects.problemStatement;

/**
 * 
 * @author aurovind.samal
 * For example, given sorted array A = [1,1,1,2,2,3], your function should return length = 5, and A is now [1,1,2,2,3].
 */
public class Remove_Duplicates_max_two_allowed {

	public static int removeDuplicates(int[] nums) {
	    if(nums==null){
	        return 0;
	    }
	 
	    if (nums.length <= 2){
	        return nums.length;
	    }
	/*
	1,1,1,2,2,3
	  i j
	*/
	    int i = 1; // point to previous
	    int j = 2; // point to current
	 
	    while (j < nums.length) {
	        if (nums[j] == nums[i] && nums[j] == nums[i - 1]) {
	            j++;
	        } else {
	            i++;
	            nums[i] = nums[j];
	            j++;
	        }
	    }
	 
	    return i + 1;
	}
	
	public static void main(String[] args) {
		int arr[] = {1,2,2,2,3,3,3,4,4,5,5,6,6,7,8};
		int result = removeDuplicates(arr);
		System.out.println(result);
	}

}
