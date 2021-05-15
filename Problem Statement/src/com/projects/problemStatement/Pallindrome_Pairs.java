package com.projects.problemStatement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 
 * @author aurovind.samal
 * Given a list of unique words. Find all pairs of distinct indices (i, j) in the given list, so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.
   Example 1:
   Given words = ["bat", "tab", "cat"]
   Return [[0, 1], [1, 0]]
   The palindromes are ["battab", "tabbat"]
 */
public class Pallindrome_Pairs {
	
	public List<List<Integer>> palindromePairs(String[] words) {
	    List<List<Integer>> result = new ArrayList<>();
	    if(words == null || words.length < 2){
	        return result;
	    }
	 
	    HashMap<String, Integer> map = new HashMap<>();
	    for(int i=0; i<words.length; i++){
	        map.put(words[i], i);
	    }
	 
	    for(int i=0; i<words.length; i++){
	        String s = words[i];
	 
	        for(int k=0; k<=s.length(); k++){
	            String left = s.substring(0, k);
	            String right= s.substring(k);
	 
	            //if left part is palindrome, find reversed right part
	            if(isPalindrome(left)){
	                String reversedRight = new StringBuilder(right).reverse().toString();
	                if(map.containsKey(reversedRight) && map.get(reversedRight) != i){
	                    ArrayList<Integer> l = new ArrayList<>();
	                    l.add(map.get(reversedRight));
	                    l.add(i);
	                    result.add(l);
	                }
	            }
	 
	            //if right part is a palindrome, find reversed left part
	            if(isPalindrome(right)){
	                String reversedLeft = new StringBuilder(left).reverse().toString();
	                if(map.containsKey(reversedLeft) 
	                        && map.get(reversedLeft) != i 
	                        && right.length() != 0){ 
	                        //make sure right is not "", already handled in the if above
	                    ArrayList<Integer> l = new ArrayList<>();
	                    l.add(i);
	                    l.add(map.get(reversedLeft));
	                    result.add(l);
	                }
	            }
	        }
	    }
	 
	    return result;
	}
	 
	public boolean isPalindrome(String s){
	    int i=0;
	    int j=s.length()-1;
	 
	    while(i<=j){
	        if(s.charAt(i)!=s.charAt(j)){
	            return false;
	        }
	        i++;
	        j--;
	    }
	 
	    return true;
	}


}
