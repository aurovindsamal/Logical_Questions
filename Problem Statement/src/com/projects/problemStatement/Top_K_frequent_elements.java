package com.projects.problemStatement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author aurovind.samal
 * Given an array of integers, write a method to return the k most frequent elements.
 */
public class Top_K_frequent_elements {
	
	public static List<Integer> topKFrequent(int[] nums, int k) {
	    //count the frequency for each element
	    HashMap<Integer, Integer> map = new HashMap<>();
	    for(int num: nums){
	        map.put(num, map.getOrDefault(num, 0) + 1);
	    }
	 
	    //get the max frequency
	    int max = 0;
	    for(Map.Entry<Integer, Integer> entry: map.entrySet()){
	        max = Math.max(max, entry.getValue());
	    }
	 
	    //initialize an array of ArrayList. index is frequency, value is list of numbers
	    ArrayList<Integer>[] arr = (ArrayList<Integer>[]) new ArrayList[max+1];
	    for(int i=1; i<=max; i++){
	        arr[i]=new ArrayList<Integer>();
	    }
	 
	    for(Map.Entry<Integer, Integer> entry: map.entrySet()){
	        int count = entry.getValue();
	        int number = entry.getKey();
	        arr[count].add(number);
	    }
	 
	    List<Integer> result = new ArrayList<Integer>();
	 
	    //add most frequent numbers to result
	    for(int j=max; j>=1; j--){
	        if(arr[j].size()>0){
	            for(int a: arr[j]){
	                result.add(a);
	                //if size==k, stop
	                if(result.size()==k){
	                    return result;
	                }
	            }
	        }
	    }
	 
	    return result;
	}
	
	public static void main(String[] args) {
		int arr[] = {1,1,2,2,2,3,3,3,3,3,4,4,4,5,5,55,5,5,5,56,6,6,6,6,6,66,6,66,6,6,6,6,6};
		List<Integer> topKFrequent = topKFrequent(arr, 3);
		System.out.println("The element is:");
		for(int i=0;i<topKFrequent.size();i++) {
			System.out.println(topKFrequent.get(i));
		}
	}


}
