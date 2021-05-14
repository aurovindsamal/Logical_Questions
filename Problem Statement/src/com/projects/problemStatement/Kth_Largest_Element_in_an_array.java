package com.projects.problemStatement;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Kth_Largest_Element_in_an_array {
	
	public static int findKthLargest(int[] nums, int k) {
	    PriorityQueue<Integer> q = new PriorityQueue<Integer>(k);
	    for(int i: nums){
	        q.offer(i);
	 
	        if(q.size()>k){
	            q.poll();
	        }
	    }
	 
	    return q.peek();
	}
	
	public static int findKthLargestSorting(int[] nums, int k) {
	    Arrays.sort(nums);
	    return nums[nums.length-k];
	}
	
	public static void main(String[] args) {
		int arr[] = {2,6,3,1,9,5,8,7};
		
		
		int findKthLargest = findKthLargest(arr, 5);	
		System.out.println("The 5th Largest Element is "+findKthLargest);
		
		int findKthLargestSorting = findKthLargestSorting(arr, 3);	
		System.out.println("The 3th Largest Element is "+findKthLargestSorting);
		
		Arrays.sort(arr);
		System.out.println("The elements in the array are ");
		for(int i =0 ; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}



}
