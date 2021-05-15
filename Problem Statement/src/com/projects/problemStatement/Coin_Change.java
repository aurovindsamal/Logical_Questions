package com.projects.problemStatement;

import java.util.Arrays;

/**
 * 
 * @author aurovind.samal
 * Given a set of coins and a total money amount. Write a method to compute the smallest number of coins to make up the given amount. If the amount cannot be made up by any combination of the given coins, return -1.

For example:
Given [2, 5, 10] and amount=6, the method should return -1.
Given [1, 2, 5] and amount=7, the method should return 2.
 */
public class Coin_Change {
	
	/**
	 * Java Solution 1 - Dynamic Programming (Looking Backward)

The solution one use a 2-D array for DP. If we look at the previous amount column value that is used in later amount column, the later column only cares about the minimum value of the previous column. Therefore, we can use a 1-D array instead of the 2-D array.

Given an amount of 6 and coins [1,2,5], we can look backward in the dp array.
	 */
	public int coinChange(int[] coins, int amount) {
	    if(amount==0){
	        return 0;
	    }
	 
	    int[] dp = new int[amount+1];
	 
	    Arrays.fill(dp, Integer.MAX_VALUE);
	    dp[0]=0;
	 
	    for(int i=1; i<=amount; i++){
	        for(int coin: coins){
	            if(i==coin){
	                dp[i]=1;
	            }else if(i>coin){
	                if(dp[i-coin]==Integer.MAX_VALUE){
	                    continue;
	                }
	                dp[i]=Math.min(dp[i-coin]+1, dp[i]);
	            }
	        }
	    }
	 
	    if(dp[amount]==Integer.MAX_VALUE){
	        return -1;
	    }
	 
	    return dp[amount];
	}
	
	//Dynamic Programming (Looking Forward)
	public int coinChangeForward(int[] coins, int amount) {
	    if(amount==0){
	        return 0;
	    }
	 
	    int[] dp = new int[amount+1];
	 
	    Arrays.fill(dp, Integer.MAX_VALUE);
	    dp[0]=0;
	 
	    for(int i=0; i<=amount; i++){
	        if(dp[i]==Integer.MAX_VALUE){
	            continue;
	        }
	 
	        for(int coin: coins){
	            if(i<=amount-coin){ //handle case when coin is Integer.MAX_VALUE
	                dp[i+coin] = Math.min(dp[i]+1, dp[i+coin]);
	            }
	        }
	    }
	 
	    if(dp[amount]==Integer.MAX_VALUE){
	        return -1;
	    }
	 
	    return dp[amount];
	}

}
