package com.projects.problemStatement;

/**
 * 
 * @author aurovind.samal
 * given n = 4,
[
[1,   2,  3, 4], 
[12, 13, 14, 5], 
[11, 16, 15, 6], 
[10,  9,  8, 7]
]

 */
public class Generate_Spiral_Matrix {
	
	public static int[][] generateMatrix(int n) {
	    int total = n*n;
	    int[][] result= new int[n][n];
	 
	    int x=0;
	    int y=0;
	    int step = 0;
	 
	    for(int i=0;i<total;){
	        while(y+step<n){
	            i++;
	            result[x][y]=i; 
	            y++;
	 
	        }    
	        y--;
	        x++;
	 
	        while(x+step<n){
	            i++;
	            result[x][y]=i;
	            x++;
	        }
	        x--;
	        y--;
	 
	        while(y>=0+step){
	            i++;
	            result[x][y]=i;
	            y--;
	        }
	        y++;
	        x--;
	        step++;
	 
	        while(x>=0+step){
	            i++;
	            result[x][y]=i;
	            x--;
	        }
	        x++;
	        y++;
	    }
	 
	    return result;
	}
	
	public static void main(String[] args) {
		int result[][] = generateMatrix(6);
		System.out.println("The elemensts are :");
		for (int countOne = 0; countOne < result.length; countOne++) {
		      for (int countTwo = 0; countTwo < result[countOne].length; countTwo++) {
		        System.out.print(result[countOne][countTwo]+" ");
		      }
		      System.out.println("\n");
		    }
		
	}


}
