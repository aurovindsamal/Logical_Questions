package com.projects.problemStatement;

import java.util.HashMap;

public class Two_Sum {
	
	public static int[] twoSum(int[] nums, int target) {
	    if(nums==null || nums.length<2)
	        return new int[]{0,0};
	 
	    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	    for(int i=0; i<nums.length; i++){
	        if(map.containsKey(nums[i])){
	            return new int[]{map.get(nums[i]), i};
	        }else{
	            map.put(target-nums[i], i);
	        }
	    }
	 
	    return new int[]{0,0};
	}
	
	public static int[] twoSumSorted(int[] numbers, int target) {
		if (numbers == null || numbers.length == 0)
			return null;
	 
		int i = 0;
		int j = numbers.length - 1;
	 
		while (i < j) {
			int x = numbers[i] + numbers[j];
			if (x < target) {
				++i;
			} else if (x > target) {
				j--;
			} else {
				return new int[] { i , j  };
			}
		}
	 
		return null;
	}

	public static void main(String[] args) {
		int[] numbers={2, 7, 11, 15};
		
		int[] twoSum = twoSum(numbers,9);
		for(int i=0;i<twoSum.length;i++) {
			System.out.print(twoSum[i]+" ");
		}
		
		int[] twoSumSorted = twoSumSorted(numbers,9);
		for(int i=0;i<twoSumSorted.length;i++) {
			System.out.print(twoSumSorted[i]+" ");
		}
	}
}
