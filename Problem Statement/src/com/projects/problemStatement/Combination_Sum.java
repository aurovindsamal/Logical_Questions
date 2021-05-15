package com.projects.problemStatement;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author aurovind.samal
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T. The same repeated number may be chosen from C unlimited number of times.

Note: All numbers (including target) will be positive integers. Elements in a combination (a1, a2, ... , ak) must be in non-descending order. (ie, a1 <= a2 <= ... <= ak). The solution set must not contain duplicate combinations. For example, given candidate set 2,3,6,7 and target 7, A solution set is:


[7] 
[2, 2, 3] 
 */
public class Combination_Sum {
	
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
	    List<List<Integer>> result = new ArrayList<>();
	    List<Integer> temp = new ArrayList<>();
	    helper(candidates, 0, target, 0, temp, result);
	    return result;
	}
	 
	private void helper(int[] candidates, int start, int target, int sum,
	                    List<Integer> list, List<List<Integer>> result){
	    if(sum>target){
	        return;
	    }
	 
	    if(sum==target){
	        result.add(new ArrayList<>(list));
	        return;
	    }
	 
	    for(int i=start; i<candidates.length; i++){
	        list.add(candidates[i]);
	        helper(candidates, i, target, sum+candidates[i], list, result);
	        list.remove(list.size()-1);
	    }
	}

}
