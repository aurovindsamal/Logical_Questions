package com.projects.problemStatement;

import java.util.HashMap;

public class Longest_Substring_with_Atmost_K_distinct_Characters {
	
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
	    int result = 0;
	    int i=0;
	    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	 
	    for(int j=0; j<s.length(); j++){
	        char c = s.charAt(j);
	        if(map.containsKey(c)){
	            map.put(c, map.get(c)+1);
	        }else{
	            map.put(c, 1);
	        }
	 
	        if(map.size()<=k){
	            result = Math.max(result, j-i+1);
	        }else{
	            while(map.size()>k){
	                char l = s.charAt(i);
	                int count = map.get(l);
	                if(count==1){
	                    map.remove(l);
	                }else{
	                    map.put(l, map.get(l)-1);
	                }
	                i++;
	            }
	        }
	 
	    }
	 
	    return result;
	}
	
	//Longest Substring Which Contains 2 Unique Characters
	public int lengthOfLongestSubstringTwoDistinct(String s) {
	    int max=0;
	    HashMap<Character,Integer> map = new HashMap<Character, Integer>();
	    int start=0;
	 
	    for(int i=0; i<s.length(); i++){
	        char c = s.charAt(i);
	        if(map.containsKey(c)){
	            map.put(c, map.get(c)+1);
	        }else{
	            map.put(c,1);
	        }
	 
	        if(map.size()>2){
	            max = Math.max(max, i-start);
	 
	            while(map.size()>2){
	                char t = s.charAt(start);
	                int count = map.get(t);
	                if(count>1){
	                    map.put(t, count-1);
	                }else{
	                    map.remove(t);
	                }
	                start++;
	            }
	        }
	    }
	 
	    max = Math.max(max, s.length()-start);
	 
	    return max;
	}

}
