package com.projects.problemStatement;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author aurovind.samal
 * Given a collection of numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 */
public class Permutations_Of_Arrays {
	
	public ArrayList<ArrayList<Integer>> permute(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	 
		//start from an empty list
		result.add(new ArrayList<Integer>());
	 
		for (int i = 0; i < num.length; i++) {
			//list of list in current iteration of the array num
			ArrayList<ArrayList<Integer>> current = new ArrayList<ArrayList<Integer>>();
	 
			for (ArrayList<Integer> l : result) {
				// # of locations to insert is largest index + 1
				for (int j = 0; j < l.size()+1; j++) {
					// + add num[i] to different locations
					l.add(j, num[i]);
	 
					ArrayList<Integer> temp = new ArrayList<Integer>(l);
					current.add(temp);
	 
					//System.out.println(temp);
	 
					// - remove num[i] add
					l.remove(j);
				}
			}
	 
			result = new ArrayList<ArrayList<Integer>>(current);
		}
	 
		return result;
	}
	
	//RECURSION
	public List<List<Integer>> permuteRecursion(int[] nums) {
	    List<List<Integer>> result = new ArrayList<>();
	    helper(0, nums, result);
	    return result;
	}
	 
	private void helper(int start, int[] nums, List<List<Integer>> result){
	    if(start==nums.length-1){
	        ArrayList<Integer> list = new ArrayList<>();
	        for(int num: nums){
	            list.add(num);
	        }
	        result.add(list);
	        return;
	    }
	 
	    for(int i=start; i<nums.length; i++){
	        swap(nums, i, start);
	        helper(start+1, nums, result);
	        swap(nums, i, start);
	    }
	}
	 
	private void swap(int[] nums, int i, int j){
	    int temp = nums[i];
	    nums[i] = nums[j];
	    nums[j] = temp;
	}

}
