package com.projects.problemStatement;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author aurovind.samal
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Ensure that numbers within the set are sorted in ascending order.


Example 1: Input: k = 3, n = 7 Output: [[1,2,4]]
Example 2: Input: k = 3, n = 9 Output: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class Combination_Sum_II {
	
	public List<List<Integer>> combinationSum3(int k, int n) {
	    List<List<Integer>> result = new ArrayList<List<Integer>>();
	    List<Integer> curr = new ArrayList<Integer>();
	    helper(result, curr, k, 1, n);
	    return result;
	}
	 
	public void helper(List<List<Integer>> result, List<Integer> curr, int k, int start, int sum){
	    if(sum<0){
	        return;
	    }
	 
	    if(sum==0 && curr.size()==k){
	        result.add(new ArrayList<Integer>(curr));
	        return;
	    }
	 
	    for(int i=start; i<=9; i++){
	        curr.add(i);
	        helper(result, curr, k, i+1, sum-i);
	        curr.remove(curr.size()-1);
	    }
	}

}
