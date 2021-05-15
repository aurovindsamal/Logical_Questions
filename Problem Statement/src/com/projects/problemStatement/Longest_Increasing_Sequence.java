package com.projects.problemStatement;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * @author aurovind.samal
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 * For example, given [10, 9, 2, 5, 3, 7, 101, 18], the longest increasing subsequence is [2, 3, 7, 101]. Therefore the length is 4.
 */
public class Longest_Increasing_Sequence {
	
	//Approach 1
	public int lengthOfLIS(int[] nums) {
	    if(nums==null || nums.length==0)
	        return 0;
	 
	    ArrayList<Integer> list = new ArrayList<>(); 
	 
	    for(int num: nums){
	        if(list.size()==0 || num>list.get(list.size()-1)){
	            list.add(num);
	        }else{
	            int i=0; 
	            int j=list.size()-1;
	 
	            while(i<j){
	                int mid = (i+j)/2;
	                if(list.get(mid) < num){
	                    i=mid+1;
	                }else{
	                    j=mid;
	                }
	            }
	 
	            list.set(j, num);
	        }
	    }
	 
	    return list.size();
	}
	
	//Approach 2
	public int lengthOfLIS2(int[] nums) {
	    if(nums==null || nums.length==0)
	        return 0;
	 
	    int[] max = new int[nums.length];
	    Arrays.fill(max, 1);
	 
	    int result = 1;
	    for(int i=0; i<nums.length; i++){
	        for(int j=0; j<i; j++){
	            if(nums[i]>nums[j]){
	                max[i]= Math.max(max[i], max[j]+1);
	 
	            }
	        }
	        result = Math.max(max[i], result);
	    }
	 
	   return result;
	}
	
	//dynamic Programming
	public int lengthOfLISDP(int[] nums) {
	    int[] dp = new int[nums.length];
	    int len = 0; // len of sequence
	 
	    for(int num: nums){
	        int idx = Arrays.binarySearch(dp, 0, len, num);
	 
	        //if not found, return binarySearch return -insertPosition-1
	        if(idx < 0){
	            idx = - (idx + 1);
	        }
	 
	        dp[idx] = num;
	 
	        //update len when insert position is at the end
	        if(idx==len){
	            len++;
	        }
	    }
	 
	    return len;
	}

}
