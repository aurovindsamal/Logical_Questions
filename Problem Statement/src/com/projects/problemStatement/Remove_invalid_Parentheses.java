package com.projects.problemStatement;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author aurovind.samal
 * Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.
Examples:
"()())()" -> ["()()()", "(())()"]
"(a)())()" -> ["(a)()()", "(a())()"]
")(" -> [""]

 */
public class Remove_invalid_Parentheses {
	
	    ArrayList<String> result = new ArrayList<String>();
	    int max=0; 
	 
	    public List<String> removeInvalidParentheses(String s) {
	        if(s==null)
	            return result;
	 
	        dfs(s, "", 0, 0);
	        if(result.size()==0){
	            result.add("");
	        }
	 
	        return result;
	    }
	 
	    public void dfs(String left, String right, int countLeft, int maxLeft){
	        if(left.length()==0){
	            if(countLeft==0 && right.length()!=0){
	                if(maxLeft > max){
	                    max = maxLeft;
	                }
	 
	                if(maxLeft==max && !result.contains(right)){
	                    result.add(right);
	                }
	            }
	 
	            return;
	        }
	 
	        if(left.charAt(0)=='('){
	            dfs(left.substring(1), right+"(", countLeft+1, maxLeft+1);//keep (
	            dfs(left.substring(1), right, countLeft, maxLeft);//drop (
	        }else if(left.charAt(0)==')'){
	            if(countLeft>0){
	                dfs(left.substring(1), right+")", countLeft-1, maxLeft);
	            }
	 
	            dfs(left.substring(1), right, countLeft, maxLeft);
	 
	        }else{
	            dfs(left.substring(1), right+String.valueOf(left.charAt(0)), countLeft, maxLeft);
	        }
	    }
	    
	    public static void main(String[] args) {
			
	    	String str = "(a)())()";
	    	List<String> removeInvalidParentheses = new Remove_invalid_Parentheses().removeInvalidParentheses(str);
	    	System.out.println("The list is :");
	    	for(int i=0;i<removeInvalidParentheses.size();i++) {
	    		System.out.println(removeInvalidParentheses.get(i));
	    	}
		}

}
