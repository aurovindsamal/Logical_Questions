package com.projects.problemStatement;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 * @author aurovind.samal
 * Given two arrays, write a function to compute their intersection.
   Example:
   Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
 */
public class Intersection_of_two_Arrays {
	
	public int[] intersect(int[] nums1, int[] nums2) {
	    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	    for(int i: nums1){
	        if(map.containsKey(i)){
	            map.put(i, map.get(i)+1);
	        }else{
	            map.put(i, 1);
	        }
	    }
	 
	    ArrayList<Integer> list = new ArrayList<Integer>();
	    for(int i: nums2){
	        if(map.containsKey(i)){
	            if(map.get(i)>1){
	                map.put(i, map.get(i)-1);
	            }else{
	                map.remove(i);
	            }
	            list.add(i);
	        }
	    }
	 
	    int[] result = new int[list.size()];
	    int i =0;
	    while(i<list.size()){
	        result[i]=list.get(i);
	        i++;
	    }
	 
	    return result;
	}


}
