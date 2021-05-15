package com.projects.problemStatement;

public class Find_Duplicate {
	
	public int findDuplicate(int[] nums) {
	    int slow = 0;
	    int fast = 0;
	 
	    do{
	        slow = nums[slow];
	        fast = nums[nums[fast]];
	    } while(slow != fast);
	 
	    int find = 0;
	 
	    while(find != slow){
	        slow = nums[slow];
	        find = nums[find];
	    }
	    return find;
	}
	
	public int findDuplicateOnlyOne(int[] nums) {
	    int sum = 0;
	    for(int i: nums){
	        sum+=i;
	    }
	 
	    int n=nums.length;
	    return sum - ((n-1)*n)/2;
	}

}
