package com.projects.problemStatement;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 
 * @author aurovind.samal
 * For example, given three people living at (0,0), (0,4), and (2,2):
1 - 0 - 0 - 0 - 1
|   |   |   |   |
0 - 0 - 0 - 0 - 0
|   |   |   |   |
0 - 0 - 1 - 0 - 0
The point (0,2) is an ideal meeting point, as the total travel distance of 2+2+2=6 is minimal. So return 6.

 */
public class Best_Meeting_Point {
	
	public int minTotalDistance(int[][] grid) {
	    int m=grid.length;
	    int n=grid[0].length;
	 
	    ArrayList<Integer> cols = new ArrayList<Integer>();
	    ArrayList<Integer> rows = new ArrayList<Integer>();
	    for(int i=0; i<m; i++){
	        for(int j=0; j<n; j++){
	           if(grid[i][j]==1){
	               cols.add(j);
	               rows.add(i);
	           }
	        }
	    }
	    int sum=0;
	    for(Integer i: rows){
	        sum += Math.abs(i - rows.get(rows.size()/2));    
	    }
	 
	    Collections.sort(cols);
	 
	    for(Integer i: cols){
	        sum+= Math.abs(i-cols.get(cols.size()/2));
	    }
	   return sum;
	}


}
