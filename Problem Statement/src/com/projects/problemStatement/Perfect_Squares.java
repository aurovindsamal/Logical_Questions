package com.projects.problemStatement;

import java.util.Arrays;

/**
 * 
 * @author aurovind.samal
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
   For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
 */
public class Perfect_Squares {
	
	public int numSquares(int n) {
	    int max = (int) Math.sqrt(n);
	 
	    int[] dp = new int[n+1];
	    Arrays.fill(dp, Integer.MAX_VALUE);
	 
	    for(int i=1; i<=n; i++){
	        for(int j=1; j<=max; j++){
	            if(i==j*j){
	                dp[i]=1;
	            }else if(i>j*j){
	                dp[i]=Math.min(dp[i], dp[i-j*j] + 1);
	            }
	        }
	    }
	 
	    return dp[n];
	}

}
