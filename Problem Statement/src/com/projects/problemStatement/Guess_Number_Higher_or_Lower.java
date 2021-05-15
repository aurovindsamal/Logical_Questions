package com.projects.problemStatement;

/**
 * 
 * @author aurovind.samal
 * I pick a number from 1 to n. You have to guess which number I picked.
Every time you guess wrong, I'll tell you whether the number is higher or lower.
You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):
-1 : My number is lower
1 : My number is higher
0 : Congrats! You got it!
 */
public class Guess_Number_Higher_or_Lower {
	
	public int guessNumber(int n) {
	    int low=1;
	    int high=n;
	 
	    while(low <= high){
	        int mid = low+((high-low)/2);
	        int result = guessNumber(mid);
	        if(result==0){
	            return mid;
	        }else if(result==1){
	            low = mid+1;
	        }else{
	            high=mid-1;
	        }
	    }
	 
	    return -1;
	}


}
